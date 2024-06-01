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
import java.util.ArrayList;
import java.util.List;

@WebServlet("/bookmark-group")
public class LoadBookmarkGroup extends HttpServlet {

    BookmarkDao bookmarkDao = new BookmarkDao();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        List<BookmarkVo> group = new ArrayList<>();
        try {
            group = bookmarkDao.selectbookmarkAll();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        req.setAttribute("group", group);

        RequestDispatcher dispatcher = req.getRequestDispatcher("bookmark-group.jsp");  // 실제로 열릴 페이지 열어주기
        dispatcher.forward(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

    }
}