package ru.kozlov.ejb;


import ru.kozlov.domain.Things;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
@LocalBean
public class ThingsManagerBean {
    @PersistenceContext(unitName = "exampleDU")
    private EntityManager entityManager;


    public Things createThings(String name, int quantity){
        Things things = new Things();
        things.setName(name);
        things.setquantity(quantity);
        entityManager.persist(things);

        return things;
    }

    public List<Things> getThing(){
        TypedQuery<Things> query =entityManager.createQuery("select c from Things c",Things.class);
        return query.getResultList();
    }

}
