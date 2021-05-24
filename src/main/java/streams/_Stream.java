package streams;



import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class _Stream {
    public static void main(String[] args) {

        List<Person> people = List.of(
                new Person("John", Gender.MALE),
                new Person("Maria", Gender.FEMALE),
                new Person("Alice", Gender.FEMALE),
                new Person("Amit",Gender.MALE),
                new Person("Aisha", Gender.FEMALE)
        );

       people.stream()
                .map(person -> person.gender)
                .collect(Collectors.toSet())
               .forEach(System.out::println);


//        How everything worked in background
//        We actually don't need this syntax
//        While we pass it in function we can forget about left hand side
//        Function<Person, Gender> personGenderFunction = person -> person.gender;
//        Collector<Gender, ?, Set<Gender>> genderSetCollector = Collectors.toSet();
//        Consumer<Gender> println = x -> System.out.println(x);
//
//        people.stream()
//                .map(personGenderFunction)
//                .collect(genderSetCollector)
//                .forEach(println
//                );

        boolean doesAllHaveFemaleGender = people.stream()
                // takes a predicate
                .allMatch(person -> Gender.FEMALE.equals(person.gender));

        boolean doesAnyOneHaveFemaleGender = people.stream()
                // takes a predicate
                .anyMatch(person -> Gender.FEMALE.equals(person.gender));

        System.out.println(doesAllHaveFemaleGender);
        System.out.println(doesAnyOneHaveFemaleGender);


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
