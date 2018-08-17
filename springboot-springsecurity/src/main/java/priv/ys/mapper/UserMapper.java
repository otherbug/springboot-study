package priv.ys.mapper;

import priv.ys.bean.User;

public interface UserMapper extends BaseMapper<User>{
    User loadUserByUsername(String username);
}