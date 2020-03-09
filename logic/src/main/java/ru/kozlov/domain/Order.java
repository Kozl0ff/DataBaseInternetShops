package ru.kozlov.domain;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "zakaz")
public class Order {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToMany(mappedBy = "order")
    private List<ThinkInOrder> thinkInOrders;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<ThinkInOrder> getThinkInOrders() {
        return thinkInOrders;
    }

    public void setThinkInOrders(List<ThinkInOrder> thinkInOrders) {
        this.thinkInOrders = thinkInOrders;
    }
}
