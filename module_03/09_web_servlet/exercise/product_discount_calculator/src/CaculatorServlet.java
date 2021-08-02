import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CaculatorServlet", urlPatterns = "/display-discount")
public class CaculatorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String descript = request.getParameter("description");
        int price = Integer.parseInt(request.getParameter("price"));
        int discountPer = Integer.parseInt(request.getParameter("discount"));
        double discountResult = price * discountPer * 0.01;
        double priceAfterDiscount = price - discountResult;

        request.setAttribute("desServlet", descript);
        request.setAttribute("discountServlet", discountResult);
        request.setAttribute("priceServlet", priceAfterDiscount);
        request.getRequestDispatcher("result.jsp").forward(request, response);
    }




    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
