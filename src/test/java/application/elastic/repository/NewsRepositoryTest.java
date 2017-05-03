package application.elastic.repository;

import application.fetch.News;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Created by J on 5/3/2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class NewsRepositoryTest {


    @Autowired
    NewsRepository newsRepository;

    @Test
    public void testWrite(){
        News news = new News();
        news.setId("test11");
        newsRepository.save(news);
    }
}