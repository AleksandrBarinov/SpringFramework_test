package ru.home.test.domain.revision;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.envers.DefaultRevisionEntity;
import org.hibernate.envers.RevisionEntity;

import javax.persistence.Entity;

/**
 * Custom revision entity.
 *
 * @author Aleksandr Barinov
 */
@Entity
@RevisionEntity(UserRevisionListener.class)
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class Revision extends DefaultRevisionEntity {

    /**
     * Username is additional column.
     */
    @Getter
    @Setter
    private String username;
}
