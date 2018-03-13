package com.bonade.cloud.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "role")
public class Role {
    @Id
    @Column(name = "role_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "role_name")
    private String name;
    @OneToOne
    @JoinColumn(name = "role_super_id")
    private Role superRole;
}
