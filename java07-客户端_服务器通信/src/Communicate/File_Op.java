package Communicate;

import java.io.*;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 * Version：1.0.0
 * Package:Communicate
 * Author:Riel
 */
public class File_Op {
    String filepath;
    String name;
    int y,m,d;
    Calendar cd = Calendar.getInstance();
    public File_Op() {
        this.y=cd.get(Calendar.YEAR);
        this.m=cd.get(Calendar.MONTH)+1;
        this.d=cd.get(Calendar.DAY_OF_MONTH);
        this.name=y+"年"+m+"月"+d+"日";
        this.filepath = this.name+".txt";
    }

    public void writeContentToFile(String filepath, String content)
    {
        FileWriter fileWriter;
        try
        {
            fileWriter = new FileWriter(this.filepath, true);
            fileWriter.write(content+"\n");
            fileWriter.close();
        } catch (IOException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void readContentFromFile(String filepath)
    {
        try
        {
            BufferedReader bufferedReader=new BufferedReader(new FileReader(filepath));
            String content="";
            try
            {
                while ((content=bufferedReader.readLine())!=null)
                {
                    System.out.println(content);
                }
            } catch (IOException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } catch (FileNotFoundException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
//    public static void main(String[] args) throws IOException
//    {
//        // TODO Auto-generated method stub
//        String filepath="text.txt";
//        File_Op operation=new File_Op();
////       // Scanner scanner=new Scanner(System.in);
////        while (true)
////        {
////           // String content=scanner.nextLine();
////            if(socketClient.result.equals("end"))
////            {
////                break;
////            }
////            operation.writeContentToFile(filepath, socketClient.result);
////        }
////       // scanner.close();
////        operation.readContentFromFile(filepath);
//    }
//


}
