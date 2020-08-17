package alexey.com;

import alexey.com.repository.PersonRepository;
import alexey.com.repository.Repository;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        PersonRepository repository = new PersonRepository();
        Person person = repository.read(1);
        List<Person> people = repository.getPeopleWithSalaryLess(30000);
        System.out.println(people);
    }
}
