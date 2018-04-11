package com.alenasoft.urbanager.resources.example.dao.interfaces;

import com.alenasoft.urbanager.api.Result;

public interface ResultDao {

    long create(Result result);
    Result getById(long id);
}
