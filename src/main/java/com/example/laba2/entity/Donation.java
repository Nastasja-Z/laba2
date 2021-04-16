package com.example.laba2.entity;

import javax.persistence.*;
import java.util.Objects;


@Entity
@Table(name = "Donation")
public class Donation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "needy_id", referencedColumnName = "id")
    private Needy needy;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "option_id", referencedColumnName = "id")
    private Option option;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Needy getNeedy() {
        return needy;
    }

    public void setNeedy(Needy needy) {
        this.needy = needy;
    }

    public Option getOption() {
        return option;
    }

    public void setOption(Option option) {
        this.option = option;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Donation donation = (Donation) o;
        return Objects.equals(id, donation.id) && Objects.equals(needy, donation.needy) && Objects.equals(option, donation.option);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, needy, option);
    }

    @Override
    public String toString() {
        return "Donation{" +
                "id=" + id +
                ", donation=" + needy+": " +option+
                '}';
    }
}
