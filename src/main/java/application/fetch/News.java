package application.fetch;

import application.fetch.Tag.Tag;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by huangzebin on 2017/3/2.
 */
@Document(indexName = "news", type = "1")
public class News {

    @Id
    String id;

    String webId;

    String title;

    String source;

    String time;

    String url;

    List<Tag> tags;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getWebId() {
        return webId;
    }

    public void setWebId(String webId) {
        this.webId = webId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public void addTag(Tag tag){
        if (this.tags == null){
            this.tags = new ArrayList<>();
        }
        this.tags.add(tag);
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
