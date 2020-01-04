package com.zh.service.impl;

import com.zh.dao.TCourseEntityDao;
import com.zh.model.TCourseEntity;
import com.zh.service.TCourseEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TCourseEntityServiceImpl implements TCourseEntityService {

    @Autowired
    private TCourseEntityDao dao;

    @Override
    public List<TCourseEntity> findAll() {
        return dao.findAll();
    }
}
