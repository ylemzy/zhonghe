package application.fetch.templates;

import application.fetch.AbstractTemplate;
import application.fetch.Category;
import application.fetch.News;
import application.fetch.Request;

/**
 * Created by huangzebin on 2017/3/3.
 */
public class XinlangTemplate extends AbstractTemplate {

    @Override
    public String webId() {
        return null;
    }

    @Override
    public String rootUrl() {
        return null;
    }

    @Override
    public Category category(Category root) throws Exception {
        return null;
    }

    @Override
    protected News itemRequest(Request request) throws Exception {
        return null;
    }

    @Override
    protected boolean pageRequest(Request request) throws Exception {
        return false;
    }
}
