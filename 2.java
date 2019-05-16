// 1.类
public class People{
    double height;
    void cry(){
        System.out.println("我在哭！");
    }
}

// 2.对象
//Lilei只是一个引用
People Lilei = new People();

//3.构造方法
public class People{
    double height;
    int age;
    int sex;
    public People(double h,int a,int s){
        height = h;
        age = a;
        sex =s;
    }
}
People XiaoMing = new People(168,21,1);
//4.static
// static属性可以直接调用，static方法不能访问非静态方法
//5.final
// 修饰类：不能被继承
// 修饰方法：不能被重写
// 修饰属性：不能隐式声明（或在构造方法中声明）
// 修饰变量：只能赋值一次
// 6.权限修饰符
// |访问修饰符|本类|同包|子类|其他|
// |private|1|0|0|0|
// |默认|1|1|0|0|
// |protected|1|1|1|0|
// |public|1|1|1|1|
//7.封装
//get和set
// 8.this
// this代表当前的未实例化的当前类
public void setAge(int age) {
    this.age = age;
}

public int getAge() {
    return age;
}
//9.继承
class Dog extends Animal {

}
// java中单继承，一个类只有一个父类
// 10.super
// 类似this，表示未实例化的父类
//调用父类构造方法
super();
public People(){

}
//11.方法重载与方法重写
// 重载是同名方法写多次，每次有不同的参数个数或参数类型
// 重写是改写父类的同名方法
// 12.多态，向上转型
// 多态是指允许不同类的对象对同一消息做出响应。即同一消息可以根据发送对象的不同而采用多种不同的行为方式。
Animal b = new Dog();
// 上面只能调用父类和子类的重写方法
// 13.抽象类
public abstract class TelePhone {
    public abstract void call();
    public abstract void message();
}
// 14.接口
interface Animal {
    //所有的都是static final 属性 和 抽象方法
}

public class Cat implements Animal,Asia
{
    //一般有主函数
}

// 15.内部类
// 成员内部类：可使用任意权限修饰符，内部类可访问外部类方法和属性，反之不行，必需在new前"加外部类对象.",a.this
public class People {
    public class Student {

    }
}
People a = new People();
Student b = a.new Student();
// 静态内部类：访问外部类成员必须new 外部类().成员 直接调用
public class People {
    public static class Student {
        new People().属性
    }
}
Student b = new Student();
//局部内部类
public class People {
    public void peopleInfo() {
        class Student {

        }
    }
    if(b) {
        class student {

        }
    }
}
//匿名内部类
public class Outer {
    public Inner getInner(){
        return new Inner() {

        }
    }
}

// 16.package
package java.io.scanner
// 分别是系统名，包名（往往是功能） 类名 必须放在第一行，全小写字母
// 不同包的情况下用import
import com.shiyanlou.people
// *代表所有类