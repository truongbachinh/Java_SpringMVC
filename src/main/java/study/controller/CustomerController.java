package study.controller;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import study.dao.CustomerRepository;
import study.model.Customer;
import study.service.CustomerService;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/customer")
public class CustomerController {


    @Autowired(required = false)
    private CustomerService customerService;

    @Autowired(required = false)
    private SessionFactory factory;

    @RequestMapping(value = "/list", method = RequestMethod.GET, produces ="application/json")
    @ResponseBody
    public  List<Customer>  home(ModelMap model) {
        Session session = factory.openSession();
        List<Customer> list1 = new ArrayList<>();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            List<Customer> list = session.createQuery("FROM Customer").list();

            for (Iterator iterator = list.iterator(); iterator.hasNext();){
                Customer customer = (Customer) iterator.next();
                System.out.print("Name : " + customer.getName());
                System.out.print("Address : " + customer.getAddress());
                System.out.println("Email : " + customer.getEmail());
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

    @RequestMapping("/new")
    public String newCustomerForm(Map<String, Object> model) {
        Customer customer = new Customer();
        model.put("customer", customer);
        return "new_customer";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveCustomer(@ModelAttribute("customer") Customer customer) {
        customerService.save(customer);
        return "redirect:/";
    }
}
