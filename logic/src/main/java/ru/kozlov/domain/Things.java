package ru.kozlov.domain;


import javax.persistence.*;
import java.util.List;

@Entity
public class Things {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private int quantity;

    @OneToMany(mappedBy = "things")
    private List<ThinkInOrder> thinkInOrders;



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getquantity() {
        return quantity;
    }

    public void setquantity(int quantity) {
        this.quantity = quantity;
    }

    public List<ThinkInOrder> getThinkInOrders() {
        return thinkInOrders;
    }

    public void setThinkInOrders(List<ThinkInOrder> thinkInOrders) {
        this.thinkInOrders = thinkInOrders;
    }
}
