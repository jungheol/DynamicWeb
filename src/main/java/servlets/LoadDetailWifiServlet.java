package servlets;

import Dao.BookmarkDao;
import Dao.WifiDao;
import Vo.BookmarkGroupVo;
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
    BookmarkDao bookmarkDao = new BookmarkDao();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String mgrNo = req.getParameter("mgrNo");

        List<WifiVo> wifiDetail = wifiDao.detailWifi(mgrNo);
        List<BookmarkGroupVo> bookmarkList;
        try {
            bookmarkList = bookmarkDao.selectBookmarkGroupAll();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        req.setAttribute("wifiDetail", wifiDetail);
        req.setAttribute("bookmarkGroupList", bookmarkList);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/detailWifi.jsp");
        dispatcher.forward(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

    }
}