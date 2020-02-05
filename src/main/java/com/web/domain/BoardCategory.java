package com.web.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "S_BOARD_CATEGORY")
public class BoardCategory {

    @Id
    @Column
    @NotNull
    private String code;

    @Column
    private String name;

    @Column
    private String status;

}
