package com.web.domain;

import lombok.*;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "S_BOARD")
public class Board {

    @Id
    @Column
    @GeneratedValue
    private String id;

    @Column
    private String category;

    @Column
    private String title;

    @Column
    private String contents;

    @Column
    private String reg_user;

    private String reg_user_name;

    @Column
    private String reg_date;

}
