package com.example.authsample.common.model;


import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Pendekar Koding on 2/3/2023
 **/
@MappedSuperclass
public class    EntityBase implements Serializable {
    private static final long serialVersionUID = 2025317384448593285L;
    private Long id;
    private String description;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", length = 50)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "description", length = 500)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "EntityBase{" +
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }
}
