package basicType;

public class stringType {
    String a= "do what you wanna do ";
    String b= "DO WHAT YOU WANNA DO";
    String c = "do what you ought to do";
    String d = "DO WHAT YOU OUGHT TO DO";


    public static void main(String[] args) {

        stringType s = new stringType();
        boolean equal = s.a.toLowerCase().equals(s.b);
        int compare = s.c.compareTo(s.d);
        char charat = s.a.charAt(6);


        System.out.println("a,b相等吗 ？  "+equal+'\n');
        System.out.println("c,d值差多少？   "+compare);
        System.out.println("a的第六个字母是啥？    "+ charat);
    }


}

