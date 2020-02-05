package com.web.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Setter
@Getter
@NoArgsConstructor
//@RequiredArgsConstructor
@Builder
@AllArgsConstructor
@Entity
@Table(name = "S_USER")
public class User {

    @Id
    @Column
    @NotNull
    private String id;

    @Column
    private String login_id;

    @Column
    private String password;

    @Column
    private String name;
/*
    //RequiredArgsConstructor
    public User(@NotNull String id) {
        if(id == null) {
            throw new NullPointerException("id is marked not-null but is null");
        } else {
            this.id = id;
        }
    }

    @Builder
    public User(String id, String login_id) {
        this.id = id;
        this.login_id = login_id;
    }
*/
}
