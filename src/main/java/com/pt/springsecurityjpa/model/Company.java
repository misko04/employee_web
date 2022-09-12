package com.pt.springsecurityjpa.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="company")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="name")
    private String name;
    @OneToMany(
            mappedBy="company", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL
    )
    private List<Employee> employees;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
}
