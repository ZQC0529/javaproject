package org.NULL.hospital.Modle;

import java.util.ArrayList;
import java.util.List;

/**
 * Hospital基本属性：名称name，描述description，门诊科室集合outDepts，部门科室集合inDepts；
 * Hospital的成员方法：无参数的构造函数，重写toString方法，实现医院属性信息的控制台打印。
 * 【注：医院类的属性均为静态属性，并在构造函数中对属性进行初始化】
 */
public class Hospital {
    String name;
    String description;
    List<outpatientDept> outDepts = new ArrayList<outpatientDept>();
    List<inpatientDept> inDepts = new ArrayList<inpatientDept>();

    public Hospital() {}

    public String toString(){
        return "name:"+this.name+'\n'+"description"+this.description+'\n'
                +outDepts.get(1).name;
    }

}


