package com.bonade.cloud.service;

import com.bonade.cloud.model.Role;
import com.bonade.cloud.repository.RoleRepository;
import com.bonade.cloud.service.dto.RoleDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("role")
public class RoleService {
    @Autowired
    RoleRepository roleRepository;
    @PostMapping("addRole")
    public Long addRole(@RequestBody RoleDTO roleDTO){
        Role role = dto2Role(roleDTO);
        role.setId(null);
        Role role1 = roleRepository.save(role);
        return role1.getId();
    }

    public Long updateRole(RoleDTO roleDTO){
        Role role = dto2Role(roleDTO);
        Role role1 = roleRepository.saveAndFlush(role);
        return role1.getId();
    }
    RoleDTO role2DTO(Role role){
        RoleDTO dto = new RoleDTO();
        dto.setId(role.getId());
        dto.setName(role.getName());
        if(role.getSuperRole()!=null) {
            dto.setSuperId(role.getSuperRole().getId());
        }
        return dto;
    }

    Role dto2Role(RoleDTO dto){
        Role role = new Role();
        role.setId(dto.getId());
        role.setName(dto.getName());
        if(dto.getSuperId()!=null) {
            role.setSuperRole(roleRepository.findOne(dto.getSuperId()));
        }
        return role;
    }
}
