package com.zach.common.mapstruct;


import org.apache.commons.lang3.time.DateFormatUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

/**
 * @author wanqin
 * 时间: 2019-06-19.
 * 相关业务:
 * https://www.jianshu.com/p/3aefc74c7ed4
 */
public class MapStructDemo {

    public static void main(String[] args) {
        Person person = new Person(1L,"zhige","zhige.me@gmail.com",new Date(),new User(1));
        //将Person转化为PersonDTO.
        PersonDTO personDTO = PersonConverter.INSTANCE.domain2dto(person);


        assertNotNull(personDTO);
        assertEquals(personDTO.getId(), person.getId());
        assertEquals(personDTO.getName(), person.getName());
        assertEquals(personDTO.getBirth(), person.getBirthday());
        String format = DateFormatUtils.format(personDTO.getBirth(), "yyyy-MM-dd HH:mm:ss");
        assertEquals(personDTO.getBirthDateFormat(),format);
        assertEquals(personDTO.getBirthExpressionFormat(),format);


        List<Person> people = new ArrayList<>();
        people.add(person);
        List<PersonDTO> personDTOs = PersonConverter.INSTANCE.domain2dto(people);
        assertNotNull(personDTOs);
    }
}
