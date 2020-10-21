package Communicate;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * Version：1.0.0
 * Package:Communicate
 * Author:Riel
 */
public class socketServer {
    static String result2;//客户端的消息
    static String content2;
    public static void main(String[] args)
    {
        // TODO Auto-generated method stub
        // 监听指定的端口
        int port = 55533;
        ServerSocket server;
        try
        {
            server = new ServerSocket(port);
            // server将一直等待连接的到来，相当于一个蹲在port端口上的人，有一个clinet来就给它创建一个socket
            while(true)
            {
                System.out.println("等待客户端连接...");
                Socket socket = server.accept();//客户端来请求了，为它创建一个socket
                System.out.println("客户端连接成功");

                // 建立好连接后，从socket中获取输入流，并建立缓冲区进行读取
                InputStream inputStream = socket.getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(inputStream, "utf-8"));
/**
 * 读取对方输出流中的数据（即自己的输入流），需要用到BufferedReader。
 * 写入自己输出流需要用到PrintWriter。
 * 这两个方法分别对应的是获取缓冲区中的输入流和获取缓冲区中的输出流
 *   大致结构：   服务器---创建socket---socket输出<输出流>---缓冲区---<输入流>---客户端
 *               服务器---<输入流>---缓冲区---<输出流>---客户端
 */
                OutputStream outputStream=socket.getOutputStream();
                PrintWriter printWriter=new PrintWriter(new OutputStreamWriter(outputStream,"utf-8"),true);
                Scanner scanner=new Scanner(System.in);
                File_Op operation=new File_Op();
               socketServer.content2 = "";
                String name="";//客户端名称
                while ((socketClient.content1=br.readLine())!=null)
                {
                    socketServer.result2="客户端说："+socketClient.content1;
                    operation.writeContentToFile(operation.filepath,socketServer.result2);
                    if(socketClient.content1.startsWith("start:"))
                    {//开启对话，向客户端输出欢迎信息
                        name=socketClient.content1.split(":")[1];
                        printWriter.println("欢迎你，"+name+",请开始你的提问。");
                    }else if(socketClient.content1.equals("end"))
                    {//结束对话
                        printWriter.println("bye");
                        break;
                    }else {
                        //在控制台输出客户端的消息，同时接受控制台的输入，并将器传递给客户端
                        System.out.println(name+"说："+socketClient.content1);
                        printWriter.println(scanner.nextLine());
                    }
                }
                scanner.close();
                inputStream.close();
                outputStream.close();
                socket.close();
            }
        } catch (IOException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
