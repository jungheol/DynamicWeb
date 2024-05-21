package servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        int num1 = 0;
        int num2 = 0;
        String name = "";

        req.setCharacterEncoding("utf-8");
        num1 = Integer.parseInt(req.getParameter("num1"));
        num2 = Integer.parseInt(req.getParameter("num2"));
        name = req.getParameter("userName");

        int result = num1 + num2;
        req.setAttribute("result", result);
        req.setAttribute("userName", name);

        //1. Dispatcher
        RequestDispatcher re =
                req.getRequestDispatcher("/basic/result_dispatcher.jsp");
        re.forward(req, res);
    }
}