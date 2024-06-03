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

@WebServlet("/bookmark-list")
public class LoadBookmark extends HttpServlet {

    BookmarkDao bookmarkDao = new BookmarkDao();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        List<BookmarkVo> list;
        try {
            list = bookmarkDao.selectBookmark();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        req.setAttribute("list", list);

        RequestDispatcher dispatcher = req.getRequestDispatcher("bookmark-list.jsp");  // 실제로 열릴 페이지 열어주기
        dispatcher.forward(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

    }
}