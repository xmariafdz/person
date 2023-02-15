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
    /*
    * La edad media de 0 personas debe resultar 0 para ambos géneros.
     */
    @Test
    void meanAgeForZeroPersons(){
        double[] obtainedValue = person.averageAgePerGender(new ArrayList<>());
        double[] expectedValue = {0,0};

        assertArrayEquals(obtainedValue,expectedValue);
    }

    /*
    * La media de la edad de una sola persona debe ser su propia edad
     */
    @Test
    void meanAgeForOnePerson(){
        int age = 20;
        List<Person> personList = new ArrayList<>(1);
        personList.add(new Person("María",age,"Female"));

        double[] obtainedValue = person.averageAgePerGender(personList);
        double[] expectedValue = {0,age};

        assertArrayEquals(obtainedValue,expectedValue);
    }

    /*
    * Comprueba que se realice correctamente la media de la edad de 5 personas.
     */
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

    /*
    * Comprueba que si introducimos una edad negativa lanza la excepción correspondiente
     */
    @Test
    public void testNegativeAge() {
        int age = -1;

        // Act & Assert
        Throwable exception = Assertions.assertThrows(InvalidAgeException.class, () -> {
            new Person("John Doe", age, "Male");
        });
        Assertions.assertEquals("No es posible tener " + age + "años.", exception.getMessage());
    }

    /*
    * Comprueba que si introducimos una edad muy elevada lanza una excepción.
     */
    @Test
    public void testHighAge() {
        int age = 500;

        // Act & Assert
        Throwable exception = Assertions.assertThrows(InvalidAgeException.class, () -> {
            new Person("John Doe", age, "Male");
        });
        Assertions.assertEquals("No es posible tener " + age + "años.", exception.getMessage());
    }

    /*
    * Comprueba que, para este programa, no se puede introducir un género distinto a "Male" o "Female"
     */
    @Test
    public void testInvalidGender() {
        String gender = "Other";
        
        Throwable exception = Assertions.assertThrows(InvalidGenderException.class, () -> {
            new Person("John Doe", 30, gender);
        });
        Assertions.assertEquals("El género " + gender + " no se contempla en este programa", exception.getMessage());
    }

}
