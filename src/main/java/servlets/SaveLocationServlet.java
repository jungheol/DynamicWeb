package servlets;

import Dao.HistoryDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/location")
public class SaveLocationServlet extends HttpServlet {

    HistoryDao historyDao = new HistoryDao();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        Double lat = Double.valueOf(req.getParameter("lat"));
        Double lnt = Double.valueOf(req.getParameter("lnt"));

        try {
            historyDao.saveHistory(lat, lnt);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}