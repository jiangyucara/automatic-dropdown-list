package webApp.DAO;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import webApp.config.HibernateConfigUtil;
import webApp.domain.studentInfo;

import java.util.ArrayList;
import java.util.List;


public class studentDAO {

   // private Session session;
    public studentDAO() {
        //session = HibernateConfigUtil.openSession();
    }

    public List<studentInfo> firstNameList(String keyword){
        Session session = HibernateConfigUtil.openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from studentInfo where firstName like concat('%', :keyword, '%') ");
        query.setParameter("keyword", keyword);
        List<studentInfo> studentInfoList = query.getResultList();
        transaction.commit();
        session.close();

        return studentInfoList;
    }

    public List<studentInfo> lastNameList(String keyword){
        Session session = HibernateConfigUtil.openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from studentInfo where lastName like concat('%', :keyword, '%') ");
        query.setParameter("keyword", keyword);
        List<studentInfo> studentInfoList = query.getResultList();
        transaction.commit();
        session.close();

        return studentInfoList;
    }

    public List<studentInfo> phoneNumberList(String keyword){
        Session session = HibernateConfigUtil.openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from studentInfo where phoneNumber like concat('%', :keyword, '%') ");
        query.setParameter("keyword", keyword);
        List<studentInfo> studentInfoList = query.getResultList();
        transaction.commit();
        session.close();

        return studentInfoList;
    }

    public List<studentInfo> idList(String keyword){
        Session session = HibernateConfigUtil.openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from studentInfo where studentID like concat('%', :keyword, '%') ");
        query.setParameter("keyword", keyword);
        List<studentInfo> studentInfoList = query.getResultList();
        transaction.commit();
        session.close();

        return studentInfoList;
    }

    public void studentInfoToString() {
        Session session = HibernateConfigUtil.openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from studentInfo");
        List<studentInfo> studentInfo = query.list();
        System.out.println(studentInfo);
    }
}