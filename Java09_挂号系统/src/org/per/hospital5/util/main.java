package org.per.hospital5.util;
import org.per.hospital5.Dao.*;
import org.per.hospital5.model.DoctorM;
import org.per.hospital5.model.PatientM;
import org.per.hospital5.model.RecordM;

import java.lang.reflect.Type;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;


/**
 * Version：1.0.0
 * Package:org.per.hospital5.util
 * Author:Riel
 */
public class main {


    public static void main(String[] args) throws SQLException {

        DoctorDao doc = new DoctorDao();
        List<RecordM> records = doc.query3(4);
       for(int i=0;i<records.size();i++){
            System.out.println(records.get(i).getPatient_name());
        }

    }
}















//    public static void main(String[] args) throws IOException {
//        recordM record2=new recordM();
//        recordM record1= new recordM();
//        patientM patient=new patientM();
//        patientDao pa = new patientDao();
//        recordDao re = new recordDao();
//        doctorDao doc = new doctorDao();
//        System.out.println("********************************************欢迎来到医院*************************************************\n");
//        System.out.println("**********************************************HOSPITAL*************************************************\n");
//
//        System.out.println("请选择您的身份：\n");
//        System.out.println("医生------------------------------------------------1\r");
//        System.out.println("病人------------------------------------------------2\n");
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String choice_1=br.readLine();
//        if(choice_1.equals("1")||choice_1.equals("2"))
//        {
//            switch (choice_1){
//                case "1":
//                    //医生系统，输入部门查询
//                    System.out.println("请输入想要查询的部门挂号记录:");
//                    Scanner scanner = new Scanner(System.in);
//                    int deptid1 = scanner.nextInt();
//                    doc.query2(deptid1);
//                    scanner.close();
//                     break;
//
//                case "2":
//                    //病人系统，挂号
//
//
//                    System.out.println("请输入您的基本信息：");
//
//                    System.out.println("您的ID：");
//                    Scanner scanner0 = new Scanner(System.in);
//                    int  id = scanner0.nextInt();
//
//
//                    System.out.println("您的名字：");
//                    Scanner scanner1 = new Scanner(System.in);
//                    String  name = scanner1.nextLine();
//
//                    System.out.println("您的年龄：");
//                    Scanner scanner2 = new Scanner(System.in);
//                    int age = scanner2.nextInt();
//
//                    System.out.println("您的性别：");
//                    Scanner scanner3 = new Scanner(System.in);
//                    String sex = scanner3.nextLine();
//
//                    System.out.println("您的密码：");
//                    Scanner scanner4 = new Scanner(System.in);
//                    String password = scanner4.nextLine();
//
//                    System.out.println("您想挂号的部门编号：");
//                    Scanner scanner5 = new Scanner(System.in);
//                    int dept_no = scanner5.nextInt();
//
//
//                    System.out.println("请检查您输入的信息是否无误 ， 无误请摁y\r");
//                    System.out.println("您的名字："+name+'\r');
//                    System.out.println("您的年龄："+age+'\r');
//                    System.out.println("您的性别："+sex+'\r');
//                    System.out.println("您的密码："+password+'\r');
//
//                    BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
//                    String choice_2=br2.readLine();
//                    if(choice_2.equals("y")){
//                        patient.setName(name);
//                        patient.setAge(age);
//                        patient.setSex(sex);
//                        patient.setPassword(password);
//                        patient.setId(id);
//
//                        scanner1.close();
//                        scanner2.close();
//                        scanner3.close();
//                        scanner4.close();
//                        scanner0.close();
//
//                        pa.insert(patient);//插入病人
//
//                        Timestamp now_time = new Timestamp(System.currentTimeMillis());//获取系统当前时间
//                        record2.setReg_time(now_time);
//                        record2.setPrice(BigDecimal.valueOf(20.8));
//                        record2.setPatient_id(patient.getId());
//                        record2.setDept_id(dept_no);
//                        scanner5.close();
//                        record2.setId(3);
//
//                        re.insert(record2);
//                        //插入挂号记录
//
//                        System.out.println("挂号完成！");
//
//                        break;
//                    }
//                    else{
//                        System.out.println("挂号失败！");
//                    }
//                    break;
//            }
//
//        }
//
////
////        /**
////         * 新增病人
////         */
////        patient1.setId(10);
////        patient1.setName("sedooy");
////        patient1.setAge(10);
////        patient1.setPassword("Abcc");
////        patient1.setSex("m");
////
////        patient2.setId(11);
////        patient2.setName("ooi");
////        patient2.setAge(11);
////        patient2.setPassword("Asdf");
////        patient2.setSex("f");
////        /**
////         * 新增挂号记录
////         */
////        Timestamp now_time = new Timestamp(System.currentTimeMillis());//获取系统当前时间
////        record1.setReg_time(now_time);
////        record1.setPrice(BigDecimal.valueOf(200.8));
////        record1.setPatient_id(patient1.getId());
////        record1.setDept_id(5);
////        record1.setId(1);
////
////
////        record2.setReg_time(now_time);
////        record2.setPrice(BigDecimal.valueOf(20.8));
////        record2.setPatient_id(patient2.getId());
////        record2.setDept_id(4);
////        record2.setId(2);
////
////        pa.insert(patient1);
////        re.insert(record1);
////        System.out.println(patient1.getId()+"号病人挂号成功");
////        pa.insert(patient2);
////        re.insert(record2);
////        System.out.println(patient2.getId()+"号病人挂号成功");
////
////
////        System.out.println("医院的挂号记录如下："+'\n');
////        re.query(null,null);
////        System.out.println('\n'+"10病人的挂号记录如下："+'\n');
////        re.query(10,null);
////        System.out.println('\n'+"妇产科的挂号记录如下："+'\n');
////        re.query(null,5);
//
//
//}
//}
