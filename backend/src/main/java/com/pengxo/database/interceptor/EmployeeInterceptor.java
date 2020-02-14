package com.pengxo.database.interceptor;

import org.hibernate.EmptyInterceptor;
import org.hibernate.type.Type;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

public class EmployeeInterceptor extends EmptyInterceptor {

    private static final long serialVersionUID = -1143511895912847754L;

    private static final Logger logger = LoggerFactory.getLogger(EmployeeInterceptor.class);

    @Override
    public boolean onFlushDirty(final Object entity, final Serializable id, final Object[] currentState, final Object[] previousState, final String[] propertyNames, final Type[] types) {
        logger.debug("The entity {} on flush dirty", entity);
        return super.onFlushDirty(entity, id, currentState, previousState, propertyNames, types);
    }

    @Override
    public boolean onLoad(final Object entity, final Serializable id, final Object[] state, final String[] propertyNames, final Type[] types) {
        logger.debug("The entity {} on load", entity);
        return super.onLoad(entity, id, state, propertyNames, types);
    }

    @Override
    public boolean onSave(final Object entity, final Serializable id, final Object[] state, final String[] propertyNames, final Type[] types) {
        logger.debug("The entity {} on save", entity);
        return super.onSave(entity, id, state, propertyNames, types);
    }

    @Override
    public void onDelete(final Object entity, final Serializable id, final Object[] state, final String[] propertyNames, final Type[] types) {
        logger.debug("The entity {} on delete", entity);
        super.onDelete(entity, id, state, propertyNames, types);
    }
}
