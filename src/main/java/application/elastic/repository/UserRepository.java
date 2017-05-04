package application.elastic.repository;

import application.bean.ExecuteResult;
import application.elastic.base.CustomElasticsearchRepository;
import application.fetch.User;

/**
 * Created by huangzebin on 2017/3/3.
 */
public interface UserRepository extends CustomElasticsearchRepository<ExecuteResult, String> {
}
