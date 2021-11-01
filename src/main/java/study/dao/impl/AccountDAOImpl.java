package study.dao.impl;


import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import study.dao.AccountDAO;
import study.entity.Account;

// Transactional for Hibernate
@Transactional
public class AccountDAOImpl implements AccountDAO {

    @Autowired(required = false)
    private SessionFactory sessionFactory;
    @Override
    public Account findAccount(String userName) {
        // lap trinh truy van data

        Session session = sessionFactory.getCurrentSession();
        Criteria crit = session.createCriteria(Account.class);
        crit.add(Restrictions.eq("userName", userName));

        return (Account) crit.uniqueResult();
    }
}
