package com.dgarg20.dropwizardcrud.entities;
import lombok.Data;


import javax.persistence.*;


@Entity
@Table(name = "user")
@NamedQueries({
        @NamedQuery(name = "user.find.all" , query = "select u from User u"),
        @NamedQuery(name = "user.find.name", query = "select u from User u where u.name = :name")

})


@Data
public class User extends BaseEntity{

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String userId;

    @Column
    private String name;

    @Column
    private String sex;

    @Column(name = "phone_number")
    private String mobileNo;

    @Column(name = "e_mail")
    private String emailId;

    @Column
    private int age;
}
