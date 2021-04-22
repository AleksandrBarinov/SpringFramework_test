import org.junit.Assert;
import org.junit.Test;
import org.mapstruct.factory.Mappers;
import org.springframework.boot.test.context.SpringBootTest;
import ru.home.test.domain.model.Person;
import ru.home.test.mapper.PersonMapper;
import ru.home.test.service.dto.PersonDto;

@SpringBootTest
public class PersonMapperTest {

    PersonMapper mapper = Mappers.getMapper(PersonMapper.class);

    @Test
    public void test() {
        Person person = new Person();
        person.setId(1);
        person.setAge(31);
        person.setName("spidey");

        PersonDto personDto = mapper.toDto(person);

        Assert.assertEquals(personDto.getAge(), person.getAge());
        Assert.assertEquals(personDto.getName(), person.getName());

        Person convertedPerson = mapper.toModel(personDto);

        Assert.assertEquals(personDto.getAge(), convertedPerson.getAge());
        Assert.assertEquals(personDto.getName(), convertedPerson.getName());
    }
}
