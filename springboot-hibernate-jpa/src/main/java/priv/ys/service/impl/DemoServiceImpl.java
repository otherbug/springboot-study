package priv.ys.service.impl;

import org.springframework.stereotype.Service;
import priv.ys.bean.Demo;
import priv.ys.dao.DemoDao;
import priv.ys.service.DemoService;

import javax.annotation.Resource;
import javax.transaction.Transactional;

@Service
public class DemoServiceImpl implements DemoService{

    @Resource
    private DemoDao demoDao;

    @Transactional
    @Override
    public void save(Demo demo) {
        demoDao.save(demo);
    }
}
