package priv.ys.service;

import priv.ys.entity.UserInfo;

public interface UserInfoService {
    UserInfo findByUsername(String username);
}
