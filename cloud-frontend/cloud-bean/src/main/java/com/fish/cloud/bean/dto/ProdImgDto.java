package com.fish.cloud.bean.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class ProdImgDto {
    private Long imgId;
    /**
     * 图片地址
     */
    private String imgUrl;
    /**
     * 上传时间
     */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date uploadTime;
    /**
     * 图片关联的表主键Id
     */
    private Long linkId;
    /**
     * 1 商品表(1 轮播图，2 详情图)
     */
    private Integer linkCate;
}
