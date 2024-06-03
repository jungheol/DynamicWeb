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
        String groupName = req.getParameter("bookmarkGroup");
        String wifiName = req.getParameter("wifiName");

        try {
            bookmarkDao.saveBookmark(groupName, wifiName);
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