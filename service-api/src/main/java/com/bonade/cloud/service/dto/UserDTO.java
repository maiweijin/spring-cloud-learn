package com.bonade.cloud.service.dto;

import lombok.Data;

@Data
public class UserDTO {
    private Long id;
    private String name;
    private Integer age;
    private String mobile;
    private Long roleId;
}
