package servlets;

import Dto.RowInfoDto;
import api.GetApi;
import Dao.WifiDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/load-wifi")  // localhost:8080 뒤에 붙는 주소 넣어주기
public class LoadWifiServlet extends HttpServlet {
    GetApi getApi = new GetApi();
    WifiDao wifiDao = new WifiDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        try {
            int count = getApi.getTotalPageCount();
            int start = 0;
            int end = 999;

            wifiDao.removeAllWifi();

            for (int i = 0; i < count; i++) {
                List<RowInfoDto> rowInfoDtoList = getApi.getApiDto(start, end).getWifiDetails();
                wifiDao.saveAllWifiDetailList(rowInfoDtoList);

                start += 1000;
                end += 1000;
            }
            req.setAttribute("count", getApi.getTotalCount());

            RequestDispatcher dispatcher = req.getRequestDispatcher("load-wifi.jsp");  // 실제로 열릴 페이지 열어주기
            dispatcher.forward(req, res);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

    }
}