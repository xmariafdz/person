package org.example;

import java.util.List;

public class Person {

    private final String name = " ";
    private final int age ;
    private final String gender ; // Male, Female

    public Person(String name, int age, String gender) {
        if(age < 0 || age > 130){
            throw new InvalidAgeException("No es posible tener " + age + "años.");
        }
        if(!gender.equals("Female") && !gender.equals("Male")){
            throw new InvalidGenderException("El género " + gender + " no se contempla en este programa");
        }
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public Person(){
        this.name = "";
        this.age = -1;
        this.gender = "";
    }

    //Este método lo he comentado porque no se utiliza
//    public String getName() { return name; }

    public int getAge() { return age; }

    public String getGender() { return gender; }

    /**
     * Computes the average age of male ande female persons in a list and returns the result in an
     * array of two elements (the first element is the male mean age and the second one is the
     * female mean age)
     *
     * @param persons
     * @return
     */

    public double[] averageAgePerGender(List<Person> persons) {
        int numberOfMen = 0;
        int numberOfWomen = 0;
        int ageAccumulatorForMen = 0;
        int ageAccumulatorForWomen = 0;

        for(Person currentPerson : persons){
            String currentGender = currentPerson.getGender();
            if(currentGender.equals("Male")){
                numberOfMen++;
                ageAccumulatorForMen+=currentPerson.getAge();
            } else {
                numberOfWomen++;
                ageAccumulatorForWomen+=currentPerson.age;
            }
        }
        double averageForMen = (numberOfMen == 0)?0:(ageAccumulatorForMen/numberOfMen);
        double averageForWomen = (numberOfWomen == 0)?0:(ageAccumulatorForWomen/numberOfWomen);
        return new double[]{averageForMen, averageForWomen};
    }
}
