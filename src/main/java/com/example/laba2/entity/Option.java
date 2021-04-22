package com.example.laba2.entity;

import javax.persistence.*;

@Entity
@Table(name = "Options")
public class Option {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name_option", nullable = false)
    private String nameOfOption;

    @Column(name = "price_option", nullable = false)
    private Integer price;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameOfOption() {
        return nameOfOption;
    }

    public void setNameOfOption(String nameOfOption) {
        this.nameOfOption = nameOfOption;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Option{" +
                "id=" + id +
                ", nameOfOption='" + nameOfOption + '\'' +
                ", price=" + price +
                '}';
    }
}

