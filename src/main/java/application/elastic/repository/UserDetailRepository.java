package application.elastic.repository;

import application.elastic.base.CustomElasticsearchRepository;
import application.fetch.UserDetail;

/**
 * Created by huangzebin on 2017/3/3.
 */
public interface UserDetailRepository extends CustomElasticsearchRepository<UserDetail, String> {
}
