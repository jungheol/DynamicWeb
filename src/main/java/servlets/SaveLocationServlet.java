package servlets;

import Dao.HistoryDao;
import Dao.WifiDao;
import Vo.WifiVo;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/location")
public class SaveLocationServlet extends HttpServlet {

    HistoryDao historyDao = new HistoryDao();
    WifiDao wifiDao = new WifiDao();
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

        List<WifiVo> searchList = wifiDao.searchNearWifi(lat, lnt);
        req.setAttribute("searchList", searchList);
        req.setAttribute("lat", lat);
        req.setAttribute("lnt", lnt);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/LoadNearWifi.jsp");
        requestDispatcher.forward(req, res);
    }
}