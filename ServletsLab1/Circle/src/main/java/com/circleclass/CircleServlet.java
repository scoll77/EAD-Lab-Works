package com.circleclass;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/circle")
public class CircleServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        PrintWriter pw = res.getWriter();
        res.setContentType("text/html");

        String radiusParam = req.getParameter("radius");
        String unit = req.getParameter("unit");

        if (radiusParam == null || unit == null) {
            pw.println("<!DOCTYPE html>");
            pw.println("<html>");
            pw.println("<body>");
            pw.println("<h1>Error: Missing parameters</h1>");
            pw.println("<p>Please provide both radius and unit parameters.</p>");
            pw.println("</body>");
            pw.println("</html>");
            return;
        }

        try {
            int radius = Integer.parseInt(radiusParam);

            // Calculate Area
            double area = Math.PI * Math.pow(radius, 2);

            pw.println("<!DOCTYPE html>");
            pw.println("<html>");
            pw.println("<body>");
            pw.println("<h1>Circle Area Calculator</h1>");
            pw.printf("<p>Radius: %d %s</p>\n", radius, unit);
            pw.printf("<p>Area: %.2f squared %s</p>\n", area, unit);
            pw.println("</body>");
            pw.println("</html>");
        } catch (NumberFormatException e) {
            pw.println("<!DOCTYPE html>");
            pw.println("<html>");
            pw.println("<body>");
            pw.println("<h1>Error: Invalid radius</h1>");
            pw.println("<p>Please provide a valid integer for the radius.</p>");
            pw.println("</body>");
            pw.println("</html>");
        }
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        doGet(req, res);
    }
}