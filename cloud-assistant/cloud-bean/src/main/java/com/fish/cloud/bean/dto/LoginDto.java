package com.fish.cloud.bean.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "登录出参", description = "登录出参")
public class LoginDto implements Serializable {

    @ApiModelProperty(value = "token")
    private String token;

    @ApiModelProperty(value = "姓名")
    private String userName;

}
