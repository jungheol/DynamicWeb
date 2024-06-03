package servlets;

import Dao.BookmarkDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/saveBookmark")
public class SaveBookmark extends HttpServlet {

    BookmarkDao bookmarkDao = new BookmarkDao();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        int bookmarkId = Integer.parseInt(req.getParameter("bookmarkId"));
        String mgrNo = req.getParameter("mgrNo");

        try {
            bookmarkDao.saveBookmark(bookmarkId, mgrNo);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("/bookmark-add-submit.jsp");
        dispatcher.forward(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

    }
}