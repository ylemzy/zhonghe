package application.fetch;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * Created by Administrator on 2017/5/3.
 */
@Document(indexName = "user1", type = "1")
public class User1 {
    @Id
    String id;
    String text;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    /*  String name;
    String serveNumber;
    String brand;
    String userStatus;
    String area;
    String consumerType;
    String serveLevel;
    String serveWay;
    String inNetTime;
    String statusTime;
    String deviceType;
    String certType;
    String orgKeyMan;
    String lockStop;*/
}
