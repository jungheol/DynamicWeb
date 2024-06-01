package Vo;

import lombok.*;

@Data
@AllArgsConstructor
public class BookmarkVo {

    private int id;
    private String name;
    private int order;
    private String addDate;
    private String modifyDate;

}
