package com.fish.cloud.common.util;

import com.fish.cloud.common.ret.TupleRet;
import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import lombok.extern.slf4j.Slf4j;

import java.io.FileInputStream;

@Slf4j
public class QiniuUtil {

    // 设置需要操作的账号的AK和SK
    private static final String ACCESS_KEY = "y76SpYCCA6J2zsYqydeJMXZfJjLfBARewBdL5A5g";
    private static final String SECRET_KEY = "YS3NIOnnlPjp0kzsAD-yI2ifubUlBOrTG685W4yz";
    // 要上传的空间名称
    private static final String BUCKETNAME = "cloudsg";

    // 外链默认域名
    private static final String DOMAIN = "www-linkeo-cloud-idvbz3h.qiniudns.com";

    /**
     * 将图片上传到七牛云
     */
    public static TupleRet<String> uploadQnImg(FileInputStream file, String fileName) {
        try {
            // 构造一个带指定Zone对象的配置类, 注意这里的Zone.zone0需要根据主机选择
            Configuration cfg = new Configuration(Zone.zone2());
            // 其他参数参考类注释
            UploadManager uploadManager = new UploadManager(cfg);

            // 密钥
            Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
            String upToken = auth.uploadToken(BUCKETNAME);

            // 上传
            Response response = uploadManager.put(file, fileName, upToken, null, null);
            // 解析上传成功的结果
            DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);

            // 这个returnPath是获得到的外链地址,通过这个地址可以直接打开图片
            String returnPath = DOMAIN + "/" + putRet.key;
            return TupleRet.success(returnPath);
        } catch (QiniuException ex) {
            log.error(ex.response.toString());
            return TupleRet.failed(ex.response.toString());
        } catch (Exception e) {
            log.error(e.getMessage());
            return TupleRet.failed(e.getMessage());
        }
    }

}
