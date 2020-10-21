package TimeDemo;

import java.sql.Time;
import java.util.*;

public class nowTime {
    public static void main(String[] args) {
        while(true){
            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException e){};
        Date javaDate = new Date();
        long javatime = javaDate.getTime();
        System.out.println("we'll go until:      "+javaDate.toString());}
//        Scanner a = new Scanner(System.in);// in 是个对象
//        int i;
//        i=a.nextInt();
//        System.out.println(i);

}
}