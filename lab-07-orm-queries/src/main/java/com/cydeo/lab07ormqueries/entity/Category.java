package com.cydeo.lab07ormqueries.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;


@Entity
@NoArgsConstructor
@Getter
@Setter
public class Category extends BaseEntity {
    private String name;
}
