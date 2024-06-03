package servlets;

import Dao.BookmarkDao;
import Vo.BookmarkGroupVo;
import Vo.BookmarkVo;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/bookmark-select")
public class SelectBookmark extends HttpServlet {

    BookmarkDao bookmarkDao = new BookmarkDao();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        List<BookmarkVo> list;
        try {
            list = bookmarkDao.selectBookmarkOnedata(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        req.setAttribute("id", list.get(0).getId());
        req.setAttribute("bookmark_name", list.get(0).getGroupName());
        req.setAttribute("wifi_name", list.get(0).getWifiName());
        req.setAttribute("date", list.get(0).getDate());

        RequestDispatcher dispatcher = req.getRequestDispatcher("/bookmark-delete.jsp");
        dispatcher.forward(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

    }
}