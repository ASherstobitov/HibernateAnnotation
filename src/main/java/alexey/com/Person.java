package alexey.com;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "date_of_birth")
    @Temporal(TemporalType.DATE)
    private Date birthDay;

    @Column(name = "email")
    private String email;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "gender")
    private String gender;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "salary")
    private int salary;
}
