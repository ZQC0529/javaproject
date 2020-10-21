package mysqlTest.Example;


import mysqlTest.STU_Dao.*;  //这里不能写import mysqlTest.*

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*   Reasons：
 *java中的package 相当于我们人中的姓，而类的名字 就相当于我们人中的名。
 * 比如我的名字叫王二狗，就是我的姓是王 名字是二狗
 * Java中同名的类命有很多（据说比日本人还多），用package就能准确地找到某个人，而不发生混乱。
 * import mysql.Test.STU_Dao 就是 “ * ”（java中星号表示任意）的姓，我们在import以后在下面使用包里面的类的过程中，就可以仅称呼它
 的姓名，而不用每次都要加上它复杂又冗长的姓了。
 */

public class demo {
    public static void main(String[] args) {

        StudentDao stu = new StudentDao();

        System.out.println("1------------show Data" + '\n' +
                "2------------Insert Data" + '\n' +
                "3------------Delete Data" + '\n' +
                "4------------Update Data" + '\n' +
                "0------------exit java_program");
//        Scanner value = new Scanner(System.in);
//        int type = value.nextInt();

        while (true) {

//            Scanner value = new Scanner(System.in);
//            String type = value.next();
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

            String buffer="0";

            try {
                buffer=br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                switch (buffer) {

                        case "1":
                            //QuerySQL
                            stu.query();
                            continue;
                            //break;

                        case "2":
                            //InsertSQL
                            stu.insert();
//                            continue;
                            break;

                        case "3":
                            //DeleteSQL
                            stu.delete();
                            continue;
                            //break;

                        case "4":
                            //UpdateSQL
                            stu.update();
                            continue;
                            //break;

                        case "0":
                            System.out.println("Thank you!");
                            break;

                        default:
                            System.out.println("Wrong Type!");
                    }
            } catch (Exception e) {
                e.printStackTrace();
            }
            break;
        }
    }

}


