package model;

import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GenerationType;

@Entity
@Table(name = "persons")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "number")
    private String number;
    @Column(name = "email")
    private String email;
    @Column(name = "age")
    private int age;

    public Person(){}

    public Person(String name){
        this(name, "not_number");
    }

    public Person(String name, String number){
        this(name, number, "not_email");
    }

    public Person(String name, String number, String email){
        this(name, number, email, 0);
    }

    public Person(String name, String number, String email, int age){
        this.name = name;
        this.number = number;
        this.email = email;
        this.age = age;
    }
    public int getId(){return id;}

    public String getName(){
        return name;
    }

    public String getNumber(){
        return number;
    }

    public String getEmail(){
        return email;
    }

    public int getAge(){
        return age;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setNumber(String number){
        this.number = number;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setAge(int age){
        this.age = age;
    }
}