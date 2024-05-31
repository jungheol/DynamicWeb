package servlets;

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

@WebServlet("/detail")
public class LoadDetailWifiServlet extends HttpServlet {
    WifiDao wifiDao = new WifiDao();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String mgrNo = req.getParameter("mgrNo");

        List<WifiVo> wifiDetail = wifiDao.detailWifi(mgrNo);
        req.setAttribute("wifiDetail", wifiDetail);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/DetailWifi.jsp");
        requestDispatcher.forward(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

    }
}