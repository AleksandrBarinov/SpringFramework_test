package ru.home.test.service.dto;

import lombok.Data;
import org.hibernate.envers.RevisionType;

/**
 * Entity historical state container.
 *
 * @param <T> Type of entity
 * @param <R> Type of Envers revision
 * @author Aleksandr Barinov
 */
@Data
public class HistStateDto<T, R> {

    T entity;

    R revisionEntity;

    RevisionType type;
}
