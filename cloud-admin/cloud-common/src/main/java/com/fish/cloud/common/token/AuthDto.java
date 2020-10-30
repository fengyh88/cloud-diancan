package com.fish.cloud.common.token;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthDto implements Serializable {
    private String empId;
    private String shopId;
}
