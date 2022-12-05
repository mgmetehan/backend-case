package com.mgmetehan.accountAndUser.core.service;

import com.mgmetehan.accountAndUser.core.model.BaseModel;

import java.io.Serializable;
import java.util.List;

public interface BaseService<T extends BaseModel, P extends Serializable> {
    T save(T entity);

    T put(P id, T forSave);

    void delete(P id);

    T getEntity(P id);

    List<T> getEntities(List<P> ids);

}