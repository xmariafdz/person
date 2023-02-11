import org.example.InvalidAgeException;
import org.example.InvalidGenderException;
import org.example.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class PersonTest {
    Person person;
    @BeforeEach
    void setup(){
        person = new Person();
    }
    @Test
    void meanAgeForZeroPersons(){
        double[] obtainedValue = person.averageAgePerGender(new ArrayList<>());
        double[] expectedValue = {0,0};

        assertArrayEquals(obtainedValue,expectedValue);
    }

    @Test
    void meanAgeForOnePerson(){
        List<Person> personList = new ArrayList<>(1);
        personList.add(new Person("María",20,"Female"));

        double[] obtainedValue = person.averageAgePerGender(personList);
        double[] expectedValue = {0,20};

        assertArrayEquals(obtainedValue,expectedValue);
    }

    @Test
    void meanAgeForFivePersons(){
        List<Person> personList = new ArrayList<>(5);
        personList.add(new Person("María",20,"Female"));
        personList.add(new Person("John", 25, "Male"));
        personList.add(new Person("Jane", 30, "Female"));
        personList.add(new Person("Jim", 35, "Male"));
        personList.add(new Person("Joan", 40, "Female"));

        double[] obtainedValue = person.averageAgePerGender(personList);
        double[] expectedValue = {30,30};

        assertArrayEquals(obtainedValue,expectedValue);
    }

    //Las siguientes pruebas han sido realizadas con la ayuda de la herramienta chatGpt
    @Test
    public void testInvalidAge() {
        int age = -1;

        // Act & Assert
        Throwable exception = Assertions.assertThrows(InvalidAgeException.class, () -> {
            new Person("John Doe", age, "Male");
        });
        Assertions.assertEquals("No es posible tener " + age + "años.", exception.getMessage());
    }

    @Test
    public void testInvalidGender() {
        String gender = "Other";

        // Act & Assert
        Throwable exception = Assertions.assertThrows(InvalidGenderException.class, () -> {
            new Person("John Doe", 30, gender);
        });
        Assertions.assertEquals("El género " + gender + " no se contempla en este programa", exception.getMessage());
    }

}
