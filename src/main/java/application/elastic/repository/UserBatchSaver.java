package application.elastic.repository;

import application.bean.ExecuteResult;
import application.elastic.base.BatchSaver;
import application.fetch.News;
import application.fetch.User;
import org.springframework.stereotype.Service;

/**
 * Created by huangzebin on 2017/3/3.
 */
@Service
public class UserBatchSaver extends BatchSaver<UserRepository, ExecuteResult> {

}
