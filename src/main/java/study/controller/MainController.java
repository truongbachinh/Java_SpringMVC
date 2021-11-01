package study.controller;


import org.hibernate.*;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import study.dao.ProductDAO;
import study.entity.Customer;
import study.entity.Product;
import study.entity.Users;
import study.model.PaginationResult;
import study.model.ProductInfo;

import javax.transaction.Transactional;
import javax.xml.bind.ValidationEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Controller
// Cần thiết cho Hibernate Transaction.
@Transactional
// Cần thiết để sử dụng RedirectAttributes
@EnableWebMvc
@RequestMapping("/shopping")
public class MainController {


    @Autowired(required = false)
    private SessionFactory factory;
    @Autowired(required = false)
    private ProductDAO productDAO;

    @RequestMapping("/products")
    public String home() {
        return "index";
    }


    // Danh sách sản phẩm.
    @RequestMapping(value = "/listProduct", method = RequestMethod.GET, produces ="application/json")
    @ResponseBody
    public List<Product> listProductHandler( Model model) {
        Session session = factory.openSession();
        List<Product> list1 = new ArrayList<>();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            List<Product> list = session.createQuery("FROM Products").list();

            for (Iterator iterator = list.iterator(); iterator.hasNext();){
                Product customer = (Product) iterator.next();
                list1.add(customer);
            }
            tx.commit();
            model.addAttribute("listCustomer", list1);
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return list1;
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<Users> getlistUsers(){
        Session session = factory.openSession();
        List<Users> users = new ArrayList<>();
        try {
            String SQL = "SELECT * from users where id = 1";
            SQLQuery cr = session.createSQLQuery(SQL);
            cr.addEntity(Users.class);
            users = cr.list();

        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return users;

    }



}
