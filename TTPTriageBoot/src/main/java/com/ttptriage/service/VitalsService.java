package com.ttptriage.service;

import com.ttptriage.dao.VitalsDao;
import com.ttptriage.entities.Vitals;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class VitalsService {

    private final VitalsDao vitalsDao;

    @Autowired
    public VitalsService(@Qualifier("vitalsDao") VitalsDao vitalsDao) {
        this.vitalsDao = vitalsDao;
    }

    public Integer addVitals(Vitals vitals) {
        return vitalsDao.insertVitals(vitals);
    }

}
