package servlet;

import bean.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CustomerServlet", urlPatterns = "")
public class CustomerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> customerList = new ArrayList<>();

        customerList.add(new Customer("Nguyễn Văn A", "2001-02-02", "Đà Nẵng", "photos/photo_1.png"));
        customerList.add(new Customer("Nguyễn Văn B", "2002-06-12", "Hà Nội", "photos/photo_2.png"));
        customerList.add(new Customer("Nguyễn Văn C", "2003-07-13", "Vinh", "photos/photo_3.png"));
        customerList.add(new Customer("Nguyễn Văn D", "2004-08-15", "Nghệ An", "photos/photo_4.png"));
        customerList.add(new Customer("Nguyễn Văn E", "2005-09-22", "Tp. Hồ Chí Minh", "photos/photo_5.png"));

        request.setAttribute("customerListServlet", customerList);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
