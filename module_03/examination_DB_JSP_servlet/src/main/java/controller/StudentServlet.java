package controller;

import model.bean.Class;
import model.bean.Student;
import model.service.IClassService;
import model.service.IStudentService;
import model.service.impl.ClassServiceImpl;
import model.service.impl.StudentServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "StudentServlet", urlPatterns = {"", "/student"})
public class StudentServlet extends HttpServlet {
    IStudentService iStudentService = new StudentServiceImpl();
    IClassService iClassService = new ClassServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        try {
            switch (action) {
//                case "create-employee":
//                    createEmployee(request, response);
//                    break;
                case "create-student":
                    createStudent(request, response);
                    break;
            }
            } catch (SQLException ex) {
                throw new ServletException(ex);
            }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        try {
            switch (action) {
                case "create-student":
                    showCreateStudentForm(request, response);
                    break;
                default:
                    listStudent(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listStudent(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Student> studentList = iStudentService.selectAll();
        request.setAttribute("studentList", studentList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("list.jsp");
        dispatcher.forward(request, response);
    }

    private void showCreateStudentForm (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        List<Class> classList = iClassService.selectAll();
        request.setAttribute("classList", classList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("create.jsp");
        dispatcher.forward(request, response);
    }

    private void createStudent(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String name = request.getParameter("name_student");
        String address = request.getParameter("address");
        int year = Integer.parseInt(request.getParameter("year"));
        Date dob = Date.valueOf(request.getParameter("day_of_birth"));
        int idClass = Integer.parseInt(request.getParameter("id_class"));
        Student student = new Student(name, address,dob, year, idClass);
        Map<String, String> mapMess = this.iStudentService.addNew(student);
        if (mapMess.isEmpty()) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("create.jsp");
            request.setAttribute("msg", "Created successfully.");
            dispatcher.forward(request, response);
        } else {
            request.setAttribute("map", mapMess);
            request.setAttribute("newCustomer", student);
            showCreateStudentForm(request, response);
        }
    }
}
