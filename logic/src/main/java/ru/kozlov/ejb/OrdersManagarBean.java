package ru.kozlov.ejb;

import ru.kozlov.domain.Order;
import ru.kozlov.domain.Things;
import ru.kozlov.domain.ThinkInOrder;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Stateless
@LocalBean
public class OrdersManagarBean {

    @PersistenceContext(unitName = "exampleDU")
    private EntityManager entityManager;

    public Order createOrder(){//dto (entity)
        Order order = new Order();
        entityManager.persist(order);

        return order;
    }

    public boolean addToOrder(long thingId, long orderID, int quantity) {
        Things things = entityManager.find(Things.class, thingId);
        if (things == null) {
            return false;
        }
        Order order = entityManager.find(Order.class, orderID);
        if (order == null) {
            return false;
        }
        ThinkInOrder thinkInOrder = new ThinkInOrder();
        thinkInOrder.setOrder(order);
        thinkInOrder.setThings(things);

        return true;
    }

    public List<Things> getThingsInOrder(long orderId){
        Order order = entityManager.find(Order.class, orderId);
        if (order == null) {
            return Collections.emptyList();
        }

        List<ThinkInOrder> thinkInOrders = order.getThinkInOrders();
        List<Things> result = new ArrayList<>();
        for (ThinkInOrder thinkInOrder:thinkInOrders){
            result.add(thinkInOrder.getThings());
        }

        return result;
    }
}


