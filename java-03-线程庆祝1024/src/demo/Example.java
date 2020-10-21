package demo;

class Celebration1 implements Runnable
{
    Thread thread1;
    Celebration1()
    {
        thread1= new Thread(this);
    }
    public void run(){
        while(true) {
            System.out.println("1024'll be HYSTERICAL");
            try{thread1.sleep(700);}
            catch (InterruptedException e)
            {
            }
       }
    }
}

class Celebration2 implements Runnable {
    Thread thread2;

    Celebration2() {
        thread2 = new Thread(this);
    }

    public void run() {
        while (true) {
           try {
            System.out.println("celebratING for all Programmers");
                thread2.sleep(400);
            } catch (InterruptedException e2) {

            }
            ;
        }
    }
        }
class Celebration3 implements Runnable
{
    Thread thread3;
    Celebration3()
    {
        thread3= new Thread(this);
    }
    public void run()
    {
        while(true)
        {
            try {
                System.out.println("Respect for HAIR");
                thread3.sleep(900);
            }
            catch (InterruptedException e3)
            {
        }
    }
}
}
public class Example
{
    public static void main(String[] args) {
        Celebration1 one =new Celebration1();
        one.thread1.start();
        Celebration2 two = new Celebration2();
        Celebration3 three = new Celebration3();
        two.thread2.start();
        three.thread3.run();
    }
}
