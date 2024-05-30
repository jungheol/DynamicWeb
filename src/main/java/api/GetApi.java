package api;

import Dto.BaseDto;
import Dto.WifiDto;
import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class GetApi {
    private Gson gson = new Gson();
    public WifiDto getApiDto(int start, int end) throws Exception {
        OkHttpClient client = new OkHttpClient();

        String url = "http://openapi.seoul.go.kr:8088/6566634150727564363264436a4d79/json/TbPublicWifiInfo/"
                + start + "/" + end;

        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            BaseDto baseDto = gson.fromJson(response.body().string(), BaseDto.class);
            return baseDto.getTbPublicWifiInfo();
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    public int getTotalPageCount() throws Exception {
        WifiDto wifiDto = getApiDto(0, 1);
        int totalCount = wifiDto.getTotalCount();

        int count = (totalCount / 1000);
        if((totalCount % 1000) > 0) {
            count++;
        }
        return count;
    }

    public int getTotalCount() throws Exception {
        WifiDto wifiDto = getApiDto(0, 1);
        return wifiDto.getTotalCount();
    }
}
