package ru.home.test.domain.revision;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.envers.DefaultRevisionEntity;
import org.hibernate.envers.RevisionEntity;

import javax.persistence.Entity;

/**
 * Custom revision entity.
 */
@Entity
@RevisionEntity(UserRevisionListener.class)
class Revision extends DefaultRevisionEntity {

    /**
     * Additional field.
     */
    @Getter
    @Setter
    private String username;
}
