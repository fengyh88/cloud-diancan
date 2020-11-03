package com.fish.cloud.api.aspect;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fish.cloud.bean.annotation.Dic;
import com.fish.cloud.bean.dto.IDtoDic;
import com.fish.cloud.common.ret.ApiResult;
import com.fish.cloud.common.util.ConvertUtil;
import com.fish.cloud.service.ISysDicKvService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 字典AOP类
 *
 * @author quanyu
 * @date 2020/10/21
 */
@Aspect
@Component
@Slf4j
public class DicAspect {
    @Autowired
    private ISysDicKvService sysDicKvService;

    @Pointcut("execution(public * com.fish.cloud.api.controller.*Controller.*(..))")
    public void excludeService() {
    }

    @Around("excludeService()")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        long time1 = System.currentTimeMillis();
        Object result = pjp.proceed();
        long time2 = System.currentTimeMillis();
        log.debug("获取JSON数据 耗时" + (time2 - time1) + "ms");
        long start = System.currentTimeMillis();
        this.parseDictText(result);
        long end = System.currentTimeMillis();
        log.debug("解析注入JSON数据  耗时" + (end - start) + "ms");
        return result;
    }

    private void parseDictText(Object result) {
        if (result instanceof ApiResult) {
            if (((ApiResult) result).getData() instanceof IPage || ((ApiResult) result).getData() instanceof List || ((ApiResult) result).getData() instanceof IDtoDic) {
                List<JSONObject> items = new ArrayList<>();
                for (Object record : ((IPage) ((ApiResult) result).getData()).getRecords()) {
                    ObjectMapper mapper = new ObjectMapper();
                    String json = "{}";
                    try {
                        //解决@JsonFormat注解解析不了的问题详见SysAnnouncement类的@JsonFormat
                        json = mapper.writeValueAsString(record);
                    } catch (JsonProcessingException e) {
                        log.error("json解析失败" + e.getMessage(), e);
                    }
                    JSONObject item = JSONObject.parseObject(json);
                    //update-begin--Author:scott -- Date:20190603 ----for：解决继承实体字段无法翻译问题------
                    //for (Field field : record.getClass().getDeclaredFields()) {
                    for (Field field : ConvertUtil.getAllFields(record)) {
                        //update-end--Author:scott  -- Date:20190603 ----for：解决继承实体字段无法翻译问题------
                        if (field.getAnnotation(Dic.class) != null) {
                            String code = field.getAnnotation(Dic.class).dicCode();
                            String text = field.getAnnotation(Dic.class).dicText();
                            String table = field.getAnnotation(Dic.class).dicTable();
                            String key = String.valueOf(item.get(field.getName()));
                            String textValue = null;
                            log.debug("key:" + key);
                            if (!StringUtils.isEmpty(table)) {
                                textValue = sysDicKvService.getTextTextByDicCodeAndKey(table, text, code, key);
                            } else {
                                textValue = sysDicKvService.getTextByTableAndCodeAndKey(code, key);
                            }
                            log.debug("字典Val:" + textValue);
                            log.debug("翻译字典字段:" + field.getName() + "_dictText： " + textValue);
                            item.put(field.getName() + "Text", textValue);
                        }
                        //date类型默认转换string格式化日期
                        if (field.getType().getName().equals("java.util.Date") && field.getAnnotation(JsonFormat.class) == null && item.get(field.getName()) != null) {
                            SimpleDateFormat aDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                            item.put(field.getName(), aDate.format(new Date((Long) item.get(field.getName()))));
                        }
                    }
                    items.add(item);
                }
                ((IPage) ((ApiResult) result).getData()).setRecords(items);
            }
        }
    }
}