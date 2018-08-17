package priv.ys.service.imp;

import org.springframework.stereotype.Service;
import priv.ys.dao.UserInfoDao;
import priv.ys.entity.UserInfo;
import priv.ys.service.UserInfoService;

import javax.annotation.Resource;

@Service
public class UserInfoServiceImp implements UserInfoService {

    @Resource
    private UserInfoDao userInfoDao;

    @Override
    public UserInfo findByUsername(String username) {
        return userInfoDao.findByUsername(username);
    }
}
