package priv.ys.mapper;

import priv.ys.bean.Menu;

import java.util.List;

public interface MenuMapper extends BaseMapper<Menu> {
    List<Menu> getAllMenu();
}