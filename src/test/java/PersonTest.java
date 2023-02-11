import org.example.Person;
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
    void meanAgeOfZeroPersons(){
        double[] obtainedValue = person.averageAgePerGender(new ArrayList<>());
        double[] expectedValue = {0,0};

        assertArrayEquals(obtainedValue,expectedValue);
    }
}
