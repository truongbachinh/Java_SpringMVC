package study.controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import study.model.Customer;

import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Controller
@RequestMapping("/hibernate/")
public class HibernateController {
    @Autowired(required = false)
    SessionFactory sessionFactory;


    @Transactional
    @RequestMapping("query")
    @ResponseBody
    public  List<Customer> query(){
        Session session = sessionFactory.getCurrentSession();
        String hql = "SELECT * FROM Customer";
        Query query =session.createQuery(hql);
        List<Customer> list = query.getResultList();
        return list;
    }
}
