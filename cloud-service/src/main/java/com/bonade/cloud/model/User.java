package com.bonade.cloud.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;
    @Column(name = "user_name",nullable = false)
    private String name;
    @Column(name = "user_age",nullable = false)
    private Integer age;
    @Column(name = "user_mobile",nullable = false)
    private String mobile;
    @ManyToOne
    @JoinColumn(name="role_id")
    private Role role;
}
