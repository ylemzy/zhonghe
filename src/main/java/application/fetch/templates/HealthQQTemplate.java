package application.fetch.templates;

import application.fetch.*;
import application.fetch.Tag.TagBuilder;
import application.uil.HashUtil;
import org.apache.logging.log4j.util.Strings;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.util.Assert;

/**
 * Created by huangzebin on 2017/3/2.
 */
public class HealthQQTemplate extends AbstractTemplate {

    @Override
    public Category category(Category root) throws Exception {
        Document document = get(root.getLink());
        Element nav_bd = document.getElementById("nav_bd");
        Elements select = nav_bd.select("ul > li > a");
        select.forEach(a->{
            Category category = new Category(a.html(), a.absUrl("href"), webId());
            root.addChild(category);

            if (category.getName().equals("疾病") ||
                    category.getName().equals("养生")){
                category.setFetchable(true);
            }
        });
        return root;
    }

    @Override
    protected News itemRequest(Request request) throws Exception {
        News news = new News();

        Document doc = get(request.getURL());
        //title
        Elements titleBlock = doc.select(".qq_article > .hd");
        news.setTitle(titleBlock.select("h1").html());
        news.setSource(titleBlock.select(".qq_bar .a_source").html());
        news.setTime(titleBlock.select(".qq_bar .a_time").html());

        //content
        Elements content = doc.select("#Cnt-Main-Article-QQ > p");
        content.forEach(c ->{
            Element first = c.children().first();
            if (first == null){
                if (Strings.isBlank(c.html())){
                    news.addTag(TagBuilder.blankTag());
                }else{
                    news.addTag(TagBuilder.textTag().content(c.html()));
                }
            }else if (first.tagName().equals("strong")){
                news.addTag(TagBuilder.hdTag().content(first.html()));
            }else if (first.tagName().equals("img")){
                news.addTag(TagBuilder.imgTag().content(first.absUrl("src")));
            }

        });

        news.setUrl(request.getURL());
        news.setId(TemplateHelper.makeNewsId(request.getURL(), request.getWebId()));
        news.setWebId(request.getWebId());
        return news;
    }

    @Override
    protected boolean pageRequest(Request request) throws Exception {
        Document document = get(request.getURL());
        if (TemplateHelper.isFirstPage(request)){
            String html = document.html();
            String pageFlag = "getString.pageCount = ";
            int i = html.indexOf(pageFlag);
            Assert.isTrue(i != -1);
            html = html.substring(i + pageFlag.length());
            int i1 = html.indexOf(";");
            Assert.isTrue(i1 != -1);
            int totalPage = Integer.valueOf(html.substring(0, i1));
            for (int j = 2; j <= totalPage; ++j){
                Request page = TemplateHelper.pageRequest("http://health.qq.com/c/jibingkepu_" + j + ".htm", request);
                addRequest(page);
            }
        }

        Elements items = document.select(".sBox > .bd > h2.yh > a");
        items.forEach(item -> {
            Request news = TemplateHelper.newsRequest(item.absUrl("href"), request);
            addRequest(news);
        });

        return true;
    }

    @Override
    public String webId() {
        return "HealthQQ";
    }

    @Override
    public String rootUrl() {
        return "http://health.qq.com/";
    }
}
