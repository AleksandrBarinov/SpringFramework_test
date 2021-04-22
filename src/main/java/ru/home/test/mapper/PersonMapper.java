package ru.home.test.mapper;

import org.mapstruct.Mapper;
import ru.home.test.domain.model.Person;
import ru.home.test.service.dto.PersonDto;

@Mapper
public interface PersonMapper {

    Person toModel(PersonDto dto);

    PersonDto toDto(Person destination);
}
