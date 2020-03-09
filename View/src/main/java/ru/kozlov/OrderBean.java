package ru.kozlov;

import ru.kozlov.domain.Order;
import ru.kozlov.domain.Things;
import ru.kozlov.ejb.OrdersManagarBean;
import ru.kozlov.ejb.ThingsManagerBean;

import javax.ejb.EJB;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Named
@SessionScoped
public class OrderBean implements Serializable {
    private Order order;
    private String name;
    private int quantity;

    @EJB
    private OrdersManagarBean ordersManagarBean;

    @EJB
    private ThingsManagerBean thingsManagerBean;

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


    public void createOrder(){
        if(order == null){
            order = ordersManagarBean.createOrder();
        }
    }

    public void createThing(){
        thingsManagerBean.createThings(name,quantity);
    }

    public List<Things> getThings(){
        return thingsManagerBean.getThing();
    }

    public void addThing(Things things){
        if(order == null){
            return;
        }
        ordersManagarBean.addToOrder(things.getId(),order.getId(),1);
    }

    public List<Things> getThingsInOrder(){
        if(order == null){
            return Collections.emptyList();
        }
        return ordersManagarBean.getThingsInOrder(order.getId());
    }
}
