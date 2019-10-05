//package com.techtoprotect.triage.service;
//
//import com.techtoprotect.triage.dao.VitalsDao;
//import com.techtoprotect.triage.model.Vitals;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.stereotype.Service;
//
//public class VitalsService {
//
//    private final VitalsDao vitalsDao;
//
//    @Autowired
//    public VitalsService(@Qualifier("vitalsDao") VitalsDao vitalsDao) {
//        this.vitalsDao = vitalsDao;
//    }
//
//    public Integer addVitals(Vitals vitals) {
//        return vitalsDao.insertVitals(vitals);
//    }
//
//}
