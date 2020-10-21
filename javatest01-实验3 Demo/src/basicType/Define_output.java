package basicType;

/**
 * Java基本类型共有八种，基本类型可以分为三类，字符类型char，布尔类型boolean以及数值类型byte、short、int、long、float、double
 */
public class Define_output {
    char a='*';
    boolean b=true;
    byte c=127;// -128~127
    int d=222222222;//32位
    long e=222222222;//64位
    short f=22222;//16位
    float h=2.2222222f;//直接赋值要在后面加上f
    double i=2.222222;

    public static void main(String[] args) {
        Define_output i=new Define_output();
        System.out.println("char:"+i.a+'\n'+"boolean:"+i.b+'\n'+"byte:"+i.c+'\n'+"int:"+i.d+'\n'+"long:"+i.e+'\n'+"short:"+i.f+'\n'+"float:"+i.h+'\n'+
                "double:"+i.i+'\n');
    }

}

