package com.pengxo.database.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;

/**
 * This class is used as listener for different database operations.
 */
public class EntityListener {

    private static final Logger logger = LoggerFactory.getLogger(EntityListener.class);

    @PrePersist
    void prePersist(final Object object) {
        logger.debug("The entity {} will be pre persisted", object);
    }

    @PostPersist
    void postPersist(final Object object) {
        logger.debug("The entity {} will be post persisted", object);
    }

    @PreUpdate
    void preUpdate(final Object object) {
        logger.debug("The entity {} will be pre updated", object);
    }

    @PostUpdate
    void postUpdate(final Object object) {
        logger.debug("The entity {} will be post updated", object);
    }

    @PreRemove
    void preDelete(final Object object) {
        logger.debug("The entity {} will be pre removed", object);
    }

    @PostRemove
    void postDelete(final Object object) {
        logger.debug("The entity {} will be post removed", object);
    }
}
