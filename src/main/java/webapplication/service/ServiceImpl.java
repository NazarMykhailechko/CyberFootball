package webapplication.service;

import webapplication.dao.Dao;
import webapplication.model.Result;
import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service
public class ServiceImpl implements Service {

    @Autowired
    Dao dao;

    public ServiceImpl() {
    }

    @Override
    public void saveResult(Result result) {
        dao.save(result);
    }
}
