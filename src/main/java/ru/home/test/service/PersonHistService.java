package ru.home.test.service;

import org.hibernate.envers.AuditReaderFactory;
import org.hibernate.envers.RevisionType;
import org.hibernate.envers.query.AuditEntity;
import org.hibernate.envers.query.AuditQuery;
import ru.home.test.domain.revision.Revision;
import org.springframework.stereotype.Service;
import ru.home.test.domain.model.Person;
import ru.home.test.service.api.HistService;
import ru.home.test.service.dto.HistStateDto;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

/**
 * Service for getting historical states of Person entity {@link Person}.
 *
 * @author Aleksandr Barinov
 */
@Service
public class PersonHistService implements HistService<Person, Revision> {

    @PersistenceContext
    private EntityManager entityManager;

    /**
     * Getting Hibernate AuditQuery.
     *
     * @param id Entity id
     * @param selectOnlyEntities states as list of Person or full information, include {@link Revision}
     * @return Hibernate AuditQuery
     */
    private AuditQuery getAuditQuery(Integer id, boolean selectOnlyEntities) {
        return AuditReaderFactory.get(entityManager).createQuery()
                .forRevisionsOfEntity(Person.class, selectOnlyEntities, true)
                .add(AuditEntity.property("id").eq(id));
    }

    /**
     * Getting entity states.
     *
     * @param id Entity id
     * @return List of entity states
     */
    @Override
    public List<Person> getPersonEntitiesById(Integer id) {
        AuditQuery query = getAuditQuery(id, true);

        List<Person> resultList = new ArrayList<>();

        for (Object o: query.getResultList()) {
            if (o instanceof Person) {
                resultList.add((Person) o);
            }
        }
        return resultList;
    }

    /**
     * Getting full information of entity states.
     *
     * @param id Entity id
     * @return List of entity states as {@link HistStateDto}
     */
    @Override
    public List<HistStateDto<Person, Revision>> getRevisionsById(Integer id) {
        AuditQuery query = getAuditQuery(id, false);

        List<HistStateDto<Person, Revision>> resultList = new ArrayList<>();

        for (Object o: query.getResultList()) {
            if (o instanceof Object[] && ((Object[]) o)[0] instanceof Person) {

                Object[] revisionData = (Object[]) o;
                HistStateDto<Person, Revision> histStateDto = new HistStateDto<>();
                histStateDto.setEntity((Person) revisionData[0]);
                histStateDto.setRevisionEntity((Revision) revisionData[1]);
                histStateDto.setType((RevisionType) revisionData[2]);
                resultList.add(histStateDto);
            }
        }
        return resultList;
    }
}
