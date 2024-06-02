package servlets;

import Dao.BookmarkDao;
import Vo.BookmarkVo;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/bookmark-group-select")
public class SelectBookmarkGroup extends HttpServlet {

    BookmarkDao bookmarkDao = new BookmarkDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String name = req.getParameter("name");
        int order_idx = Integer.parseInt(req.getParameter("order"));
        List<BookmarkVo> list;
        try {
            list = bookmarkDao.selectBookmarkOnedata(name, order_idx);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        req.setAttribute("name", list.get(0).getName());
        req.setAttribute("order_idx", list.get(0).getOrder());
        RequestDispatcher dispatcher = req.getRequestDispatcher("/bookmark-group-modify.jsp");
        dispatcher.forward(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

    }
}