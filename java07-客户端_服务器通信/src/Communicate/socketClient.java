package Communicate;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * Version：1.0.0
 * Package:Communicate
 * Author:Riel
 */
public class socketClient {
    static String result1;//服务器的消息
    static String content1;
    public static void main(String[] args) {
        String host = "localhost";
        int port = 55533;
        Socket socket;

        try
        {
            socket = new Socket(host, port);
            OutputStream outputStream = socket.getOutputStream();//客户端的输出
            PrintWriter printWriter=new PrintWriter(new OutputStreamWriter(outputStream,"utf-8"), true);
            //把outputStream这个输出流用更高层的与机器无关的OutputStreamWriter封装，再用更高层的PrintWriter封装
            /**
             * printWriter的构造函数里面有一个带参构造函数：
             *     public PrintWriter(OutputStream out)
             *outputStreamWriter也有一个带参构造函数：
             *    public OutputStreamWriter(OutputStream out)
             */
            InputStream inputStream = socket.getInputStream();//客户端的输入
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream, "utf-8"));

            Scanner scanner=new Scanner(System.in);
            //首先向服务端发送一条开始信息
            printWriter.println("start:Riel");
            socketClient.content1 = "";
            File_Op operation=new File_Op();// 1231231231212312131321312311213
            while ((socketServer.content2=br.readLine())!=null)
            {//在控制台输出服务端的消息，同时接受控制台的输入，并将其传递给服务端
                socketClient.result1="服务器说："+socketServer.content2;
                System.out.println("服务器说："+socketServer.content2);
                operation.writeContentToFile(operation.filepath,socketClient.result1);
                if(socketServer.content2.equals("bye"))
                {
                    break;
                }else {
                    printWriter.println(scanner.nextLine());
                }
            }
            scanner.close();
            inputStream.close();
            outputStream.close();
            socket.close();
        } catch (UnknownHostException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
