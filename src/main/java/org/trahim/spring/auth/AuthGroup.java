package org.trahim.spring.auth;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@Entity
@Table(name = "auth_user_group")
public class AuthGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="auth_user_group_id")
    private Long id;
    @Column(name = "username")
    private String username;

    @Column(name = "auth_group")
    private String authGroup;


}
