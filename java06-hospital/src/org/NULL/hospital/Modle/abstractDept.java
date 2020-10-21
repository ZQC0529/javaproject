package org.NULL.hospital.Modle;

import java.lang.reflect.Type;

public class abstractDept {
    String id;
    String name;
    boolean inHospital;// true 就住院， false 就门诊
    String description;

    public abstractDept(){}

    public abstractDept(String id, String name, boolean inHospital, String description) {
        this.id = id;
        this.name = name;
        this.inHospital = inHospital;
        this.description = description;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isInHospital() {
        return inHospital;
    }

    public void setInHospital(boolean inHospital) {
        this.inHospital = inHospital;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
