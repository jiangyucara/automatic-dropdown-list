package webApp.controller;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import webApp.DAO.studentDAO;
import webApp.config.HibernateConfigUtil;
import webApp.domain.studentInfo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class displayServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String label = request.getParameter("label").trim();
        String category = request.getParameter("category").trim();
        studentDAO dao = new studentDAO();
        Session session = HibernateConfigUtil.openSession();
        Transaction transaction = session.beginTransaction();
        List<studentInfo> list = new ArrayList<>();
        switch (category) {
            case "PhoneNumber":
                list = dao.phoneNumberList(label);
                break;
            case "ID":
                list = dao.idList(label);
                break;
            case "LastName":
                list = dao.lastNameList(label);
                break;
            case "FirstName":
                list = dao.firstNameList(label);
                break;
        }
        PrintWriter out = response.getWriter();
        out.print(list);

        System.out.println(list);
    }
}
