package com.example.studentmanagesystem;

import java.io.Serializable;

public class Stduent implements Serializable {
    String id_class;
    String name_class;
    String code_class;
    String name_student;
    String gender_student;
    String birthday_student;
    String address_student;

    public Stduent(String id_class,String name_class,String code_class,String name_student,
            String gender_stude,String birthday_student,String address_student){

    super();
    this.id_class = id_class;

}
}
