package servlets;

import Dao.BookmarkDao;
import Vo.BookmarkGroupVo;

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
        int id = Integer.parseInt(req.getParameter("id"));
        List<BookmarkGroupVo> list;
        try {
            list = bookmarkDao.selectBookmarkGroupOnedata(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        req.setAttribute("id", list.get(0).getId());
        req.setAttribute("name", list.get(0).getName());
        req.setAttribute("order_idx", list.get(0).getOrder());

        String action = req.getParameter("action");
        RequestDispatcher dispatcher;

        if("modify".equals(action)) {
            dispatcher = req.getRequestDispatcher("/bookmark-group-modify.jsp");
        } else {
            dispatcher = req.getRequestDispatcher("/bookmark-group-delete.jsp");
        }

        dispatcher.forward(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

    }
}