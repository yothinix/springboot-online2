package com.example.springbootonline2.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class LogRepository {

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void saveLog() {
        // do save into table Log
    }
}
