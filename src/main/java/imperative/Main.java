package imperative;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("John", Gender.MALE),
                new Person("Maria", Gender.FEMALE),
                new Person("Alice", Gender.FEMALE),
                new Person("Amit", Gender.MALE),
                new Person("Aisha",Gender.FEMALE)
        );

        // imperative approach - we specify every detail what to do how to do
        List<Person> females = new ArrayList<>();
        for(Person person: people){
            if(Gender.FEMALE.equals(person.gender)){
                females.add(person);
            }
        }

        System.out.println(Arrays.toString(females.toArray()));

        System.out.println("-----------------------------------------------------------");
        // declarative approach - we simply tell what to do
        List<Person> females2 = people.stream().filter(person -> Gender.FEMALE.equals(person.gender))
                .collect(Collectors.toList());

        System.out.println(Arrays.toString(females2.toArray()));


    }
    static class Person{
       private final String name;
       private final Gender gender;

        Person(String name, Gender gender) {
            this.name = name;
            this.gender = gender;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", gender=" + gender +
                    '}';
        }
    }
    enum Gender{
        MALE,FEMALE
    }
}
