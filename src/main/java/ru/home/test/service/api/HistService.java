package ru.home.test.service.api;

import ru.home.test.service.dto.HistStateDto;

import java.util.List;

/**
 * Service for getting historical states of entity.
 *
 * @param <T> Type of entity
 * @param <R> Type of Envers revision
 * @author Aleksandr Barinov
 */
public interface HistService<T, R> {

    /**
     * Getting entity states.
     *
     * @param id Entity id
     * @return List of entity states
     */
    List<T> getPersonEntitiesById(Integer id);

    /**
     * Getting full information of entity states.
     *
     * @param id Entity id
     * @return List of entity states as {@link HistStateDto}
     */
    List<HistStateDto<T, R>> getRevisionsById(Integer id);
}
