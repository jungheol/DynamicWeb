package Dto;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.util.List;
@Data
public class WifiDto {

    @SerializedName("list_total_count")
    private int totalCount;

    @SerializedName("RESULT")
    private ResultInfoDto result;

    @SerializedName("row")
    private List<RowInfoDto> wifiDetails;

}
