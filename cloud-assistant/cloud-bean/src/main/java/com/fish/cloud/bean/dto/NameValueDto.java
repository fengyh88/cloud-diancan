package com.fish.cloud.bean.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NameValueDto implements Serializable {
    private String name;
    private String value;
}
