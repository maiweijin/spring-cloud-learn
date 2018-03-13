package com.bonade.cloud.service.dto;

import lombok.Data;

@Data
public class RoleDTO {
    private Long id;
    private String name;
    private Long superId;
}
