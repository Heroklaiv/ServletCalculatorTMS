package org.example.servletcalculator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/calculator") //http://localhost:8080/calculator?num1=12&num2=14&type=sum
public class Calculator extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        double num1 = Double.parseDouble(req.getParameter("num1"));
        double num2 = Double.parseDouble(req.getParameter("num2"));
        String type = req.getParameter("type");
        Counter counter = new Counter();
        double result =counter.calculate(num1,num2,type);
        resp.getWriter().write("result (" + num1 + type + num2 +") = " );
        resp.getWriter().print(result);
        RecordOperationInFile recordOperationInFile = new RecordOperationInFile();
        recordOperationInFile.saveResult(num1,num2,type,result);

       // resp.getWriter().write("Hello " + num1 + " " + num2 + " " + type);
    }
}
