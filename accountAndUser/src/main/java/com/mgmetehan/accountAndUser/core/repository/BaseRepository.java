package com.mgmetehan.accountAndUser.core.repository;

import com.mgmetehan.accountAndUser.core.model.BaseModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

@NoRepositoryBean
public interface BaseRepository<T extends BaseModel, P extends Serializable> extends JpaRepository<T, P>, JpaSpecificationExecutor<T> {
}
