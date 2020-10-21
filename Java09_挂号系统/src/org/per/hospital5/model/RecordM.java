package org.per.hospital5.model;

/**
 * Version：1.0.0
 * Package:org.per.hospital5.model
 * Author:Riel
 */

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * 挂号记录类，里面应该有 queryBypatient，queryBydoctor
 * 还有自己的属性：挂号时间，挂号次序
 *
 */
public class RecordM {
    int id; //流水号（自动递增）
    int patient_id;
    int dept_id;
    Timestamp reg_time;
    BigDecimal price;
    String patient_name;

    public String getPatient_name() {
        return patient_name;
    }

    public void setPatient_name(String patient_name) {
        this.patient_name = patient_name;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(int patient_id) {
        this.patient_id = patient_id;
    }

    public int getDept_id() {
        return dept_id;
    }

    public void setDept_id(int dept_id) {
        this.dept_id = dept_id;
    }

    public Timestamp getReg_time() {
        return reg_time;
    }

    public void setReg_time(Timestamp reg_time) {
        this.reg_time = reg_time;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }











}
