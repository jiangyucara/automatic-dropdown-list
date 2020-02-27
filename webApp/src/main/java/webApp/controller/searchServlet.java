package webApp.controller;

import com.google.gson.Gson;
import webApp.DAO.studentDAO;
import webApp.domain.studentInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//@WebServlet(name = "searchServlet", urlPatterns = {"/searchServlet"})
public class searchServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("test222");
        String userInput = request.getParameter("term").trim();
        List<HashMap<String, String>> list = new ArrayList<>();
        studentDAO student = new studentDAO();
        for(studentInfo i: student.firstNameList(userInput)){
            HashMap<String, String> map = new HashMap<>();
            map.put("label", i.getFirstName());
            map.put("category", "FirstName");
            list.add(map);
        }
        for(studentInfo i: student.lastNameList(userInput)){
            HashMap<String, String> map = new HashMap<>();
            map.put("label", i.getLastName());
            map.put("category", "LastName");
            list.add(map);
        }
        for(studentInfo i: student.phoneNumberList(userInput)){
            HashMap<String, String> map = new HashMap<>();
            map.put("label", i.getPhoneNumber());
            map.put("category", "PhoneNumber");
            list.add(map);
        }
        for(studentInfo i: student.idList(userInput)){
            HashMap<String, String> map = new HashMap<>();
            map.put("label", i.getStudentID());
            map.put("category", "ID");
            list.add(map);
        }

        PrintWriter out = response.getWriter();
        Gson gson = new Gson();
        String respondJson = gson.toJson(list);
        out.append(respondJson);
    }
}


