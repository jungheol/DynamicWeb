import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class OkHttpTest {
    public static void main(String[] args) {

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("http://openapi.seoul.go.kr:8088/70504579726a756e3830485756426d/xml/TbPublicWifiInfo/1/5/")
                .build();

        try (Response response = client.newCall(request).execute()) {
            System.out.println("code///////////" + response.code());
            System.out.println("headers///////////" + response.headers());
            System.out.println("body//////////////" + response.body().string());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
