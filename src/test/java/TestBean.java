import annotation.FieldName;

import java.util.Date;

/**
 * Created by Ziyuan
 * on 2017/1/23
 */
public class TestBean {
    @FieldName("123")
    private int id;
    private String name;
    private String content;
    private String longContent;
    private Date date;
}
