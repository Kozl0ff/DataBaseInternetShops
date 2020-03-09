package ru.kozlov.domain;

import javax.persistence.*;

@Entity
public class ThinkInOrder {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    private Things things;

    @ManyToOne
    private Order order;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Things getThings() {
        return things;
    }

    public void setThings(Things things) {
        this.things = things;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

}
