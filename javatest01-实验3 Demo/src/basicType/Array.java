package basicType;

/**
 * 所谓的静态和动态是相对于程序运行是而言的，静态是在程序编译时就初始化好了的，
 * 动态初始化是在程序运行是才动态分配内存空间。对于代码而言，其实都可以。
 * 唯一不一样的地方， 就是动态的初始值都是0,静态的是直接给定值了。
 */
public class Array {
    int[] a={1,2,3,4,5};//静态初始化 简单写法
    int []arr= new int[5];//静态初始化
    int array[] = new int[5];//动态初始化，自动赋值为0

    public static void main(String[] args) {
        int i=0;
        Array arg = new Array();
        arg.arr[0]=0;
        arg.arr[1]=1;
        arg.arr[2]=2;
        arg.arr[3]=3;
        arg.arr[4]=3;

        while (i<5){
            System.out.println(arg.a[i]);
            System.out.println(arg.arr[i]);
            System.out.println(arg.array[i]);
            i++;
        }


    }
}
