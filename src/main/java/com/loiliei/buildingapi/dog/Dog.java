package com.loiliei.buildingapi.dog;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Dog {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private int age;
    private String breed;
    @OneToOne
    private Human owner;

}
