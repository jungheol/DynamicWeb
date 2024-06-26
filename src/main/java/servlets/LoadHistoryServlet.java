package servlets;

import Dao.HistoryDao;
import Vo.HistoryVo;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/history")
public class LoadHistoryServlet extends HttpServlet {

    HistoryDao historyDao = new HistoryDao();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        // 삭제 버튼 눌렀을 때 동작
        if(req.getParameter("id") != null) {
            int id = Integer.parseInt(req.getParameter("id"));
            try {
                historyDao.deleteHistory(id);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        // db에 있는 위치 히스토리 정보 불러오기
        List<HistoryVo> list = null;
        try {
            list = historyDao.historyselectAll();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        req.setAttribute("allList", list);

        RequestDispatcher dispatcher = req.getRequestDispatcher("history.jsp");  // 실제로 열릴 페이지 열어주기
        dispatcher.forward(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

    }
}