package priv.ys.dao;

import org.springframework.data.repository.CrudRepository;
import priv.ys.bean.Demo;

public interface DemoDao extends CrudRepository<Demo,Long> {
}
