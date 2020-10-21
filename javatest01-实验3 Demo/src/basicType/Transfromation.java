package basicType;

public class Transfromation {
    int a=(short)4;
    char b=(int)'a';
    short c = 30;
    float d =(long) 2.2f;
    double e = 2.22;

    public double transfomation(){
        double response = a+b+c+d+e;
        return response;
    }
    public static void main(String[] args) {
        Transfromation test = new Transfromation();
        double result = test.transfomation();
        System.out.println(result);

    }
}
