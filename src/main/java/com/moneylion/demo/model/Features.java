package com.moneylion.demo.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="features")
public class Features implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Features{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
