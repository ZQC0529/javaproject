package Student;
import Student.*;
public class Exmaple {
    public static void main(String[] args) {
        student_info STU_1 = new student_info();
        STU_1.setName("Riel");
        STU_1.setAddress("Hainan island");
        STU_1.setId(30293);
        STU_1.setSex("male");
        student_info STU_2 = new student_info();
        STU_2.setName("Stacey");
        STU_2.setAddress("shaoxing");
        STU_2.setId(30108);
        STU_2.setSex("female");
        STU_1.printStudent(STU_1);
        System.out.printf('\n'+"*****************************************************************************"+'\n');
        STU_2.printStudent(STU_2);
    }

}
//  out 文件夹里面存储的是字节码文件
