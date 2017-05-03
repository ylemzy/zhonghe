package application.fetch;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * Created by Administrator on 2017/5/4.
 */
@Document(indexName = "user2", type = "1")
public class User2 {
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
}
