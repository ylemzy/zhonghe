package application.elastic.repository;

import application.elastic.base.CustomElasticsearchRepository;
import application.fetch.News;
import application.fetch.User1;

/**
 * Created by huangzebin on 2017/3/3.
 */
public interface UserRepository extends CustomElasticsearchRepository<User1, String> {
}
