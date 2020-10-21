package org.per.hospital5.model;

/**
 * Version：1.0.0
 * Package:org.per.hospital5.modle
 * Author:Riel
 */

/**
 * 病人类
 */
public class PatientM {
    int id;

    public PatientM() {}

    public PatientM(int id, String name, String sex, int age, String password) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.password=password;
    }

    String name;
    String sex;
    int age;
    String password;



    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSex() {
        return sex;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }




}
