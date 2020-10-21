package org.per.hospital5.model;


/**
 * Version：1.0.0
 * Package:org.per.hospital5.modle
 * Author:Riel
 */

/**
 * 医生类
 */
public class doctorM {
    String password;
    String name;
    String sex;
    int dept_id;
    int id;


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getDept_id() {
        return dept_id;
    }

    public void setDept_id(int dept_id) {
        this.dept_id = dept_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}
