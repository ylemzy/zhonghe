package application.elastic.repository;

import application.elastic.base.CustomElasticsearchRepository;
import application.fetch.User1;
import application.fetch.User2;

/**
 * Created by huangzebin on 2017/3/3.
 */
public interface UserDetailRepository extends CustomElasticsearchRepository<User2, String> {
}
