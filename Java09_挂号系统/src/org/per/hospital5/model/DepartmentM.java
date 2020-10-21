package org.per.hospital5.model;

/**
 * Version：1.0.0
 * Package:org.per.hospital5.modle
 * Author:Riel
 */


/**
 * 部门类
 *
 */
public class DepartmentM {
    String name;
    int type;//0-门诊  1-住院
    String remark;
    int id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}