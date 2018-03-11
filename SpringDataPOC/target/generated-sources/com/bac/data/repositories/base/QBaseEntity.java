package com.bac.data.repositories.base;


import static com.mysema.query.types.PathMetadataFactory.*;
import com.mysema.query.types.*;
import com.mysema.query.types.path.*;

import javax.annotation.Generated;


/**
 * QBaseEntity is a Querydsl query type for BaseEntity
 */
@Generated("com.mysema.query.codegen.SupertypeSerializer")
public class QBaseEntity extends EntityPathBase<BaseEntity<?>> {

    private static final long serialVersionUID = 1790618264;

    public static final QBaseEntity baseEntity = new QBaseEntity("baseEntity");

    public final NumberPath<Long> version = createNumber("version", Long.class);

    @SuppressWarnings("unchecked")
    public QBaseEntity(String variable) {
        super((Class)BaseEntity.class, forVariable(variable));
    }

    public QBaseEntity(Path<? extends BaseEntity<?>> path) {
        super(path.getType(), path.getMetadata());
    }

    @SuppressWarnings("unchecked")
    public QBaseEntity(PathMetadata<?> metadata) {
        super((Class)BaseEntity.class, metadata);
    }

}

