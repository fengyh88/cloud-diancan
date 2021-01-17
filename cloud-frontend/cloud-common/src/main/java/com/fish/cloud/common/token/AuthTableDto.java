package com.fish.cloud.common.token;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthTableDto implements Serializable {
    private Long tableId;
    private Integer people;
}
