package application.bean;

import application.fetch.User;
import application.fetch.UserDetail;
import application.http.utils.TemplateParam;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * Created by J on 5/1/2017.
 */
@Document(indexName = "result", type = "1")
public class ExecuteResult {

    @Id
    String id;

    TemplateParam templateParam;

    User user;

    UserDetail userDetail;

    public TemplateParam getTemplateParam() {
        return templateParam;
    }

    public void setTemplateParam(TemplateParam templateParam) {
        this.templateParam = templateParam;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UserDetail getUserDetail() {
        return userDetail;
    }

    public void setUserDetail(UserDetail userDetail) {
        this.userDetail = userDetail;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
