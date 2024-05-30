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
import java.util.List;

@WebServlet("/LoadNearWifi")
public class LoadNearWifiServlet extends HttpServlet {

    WifiDao wifiDao = new WifiDao();
    HistoryDao historyDao = new HistoryDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        Double[] arr;
        try {
            arr = historyDao.selectLast();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        List<WifiVo> searchList = wifiDao.searchNearWifi(arr[0], arr[1]);
        req.setAttribute("searchList", searchList);

        System.out.println(searchList);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/LoadNearWifi.jsp");
        requestDispatcher.forward(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

    }
}