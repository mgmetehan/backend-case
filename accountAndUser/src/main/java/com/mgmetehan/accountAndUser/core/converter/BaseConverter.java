package com.mgmetehan.accountAndUser.core.converter;

import com.mgmetehan.accountAndUser.core.model.BaseModel;
import com.mgmetehan.accountAndUser.core.model.dto.BaseModelDto;
import com.mgmetehan.accountAndUser.core.model.resource.BaseModelResource;

public interface BaseConverter<D extends BaseModelDto, E extends BaseModel, R extends BaseModelResource> {
    R toResource(E entity);

    E toEntity(D dto);
}