package priv.ys.dao;

import org.springframework.data.repository.CrudRepository;
import priv.ys.entity.UserInfo;

public interface UserInfoDao extends CrudRepository<UserInfo, Long> {
    UserInfo findByUsername(String username);
}
