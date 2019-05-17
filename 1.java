// 1.第一个java程序
public class HelloWorld{
    public static void main(String[] args){
        System.out.println("Helloworld!");
    }
}

//2.量与运算符
final double PI = 3.14;

//3.字符串
String s0 = "abc";
String s1 = new String("abd");
int len=s0.length();
s0.equals(); == equalsIgnoreCase();
String s1 = "World" + "!";
String s2 = s0.concat(s1);
char c = s.charAt(1);
String s="abcdef";
s.indexOf('a');
s.lastIndexOf('a');
s.substring((3,6));

//4.输入输出
import java.util.Scanner;
public class ScannerDemo {
    public static void main(String[] args){
        Scanner in =new Scanner(System.in);
        String s = in.nextLine();
        System.out.println(s);
        int i = in.nextInt();
        System.out.println(i);
        while(!in.hasNext("exit")){
            System.out.println(in.nextInt());
        }
        in.close();
    }
}

//5.函数
public void functionName (Object obj){
    //方法体
}

//6.流程控制
int num = 2;
switch(num){
    case 1:
    System.out.println("1");
    break;
    case 2:
    System.out.println("2");
    break;
    case 3:
    System.out.println("3");
    break;
    case 4:
    System.out.println("4");
    break;
    default:
    System.out.println("下次再来");
}
//while先判断再执行 do-while先执行再判断
//continue跳过循环体剩余的语句执行下一次的循环

//7.数组
// 1)隐式声明数组
int ages[];
String [] name;
// 2) 声明并赋初值
int ages[] = {20,21,22,24};
// 3)声明并分配好空间
char [] symbol = new char[10]
