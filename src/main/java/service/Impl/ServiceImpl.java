package service.Impl;

import dao.Dao;
import dao.Impl.DaoImpl;
import service.Service;

public class ServiceImpl implements Service {
    private Dao dao;


    public void setDao(Dao dao) {
        this.dao = dao;
    }

    @Override
    public void save() {
        dao.save();
    }
}
