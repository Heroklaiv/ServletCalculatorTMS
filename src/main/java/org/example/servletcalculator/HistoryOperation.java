package org.example.servletcalculator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@WebServlet("/history")
public class HistoryOperation extends HttpServlet {
    private String readHistory() throws IOException {
        String response = "";
        BufferedReader reader = new BufferedReader(new FileReader("container.txt"));
        String line;


        while ((line = reader.readLine()) != null) {
            response = response + line + "\n";
        }
        reader.close();


        return response;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write(readHistory());
    }
}
