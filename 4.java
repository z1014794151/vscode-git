// 类类型
class Test<T> {
    //类型参数，父类定义的不能被子类继承
    private T ob;
    // 构造函数
    public Test(T ob) {
        this.ob = ob;
    }
    //getter方法
    public T getOb() {
        return ob;
    }
    //setter方法
    public void setOb(T ob) {
        this.ob = ob;
    }
    public void showType() {
        System.out.println("T的实际类型是："+ob.getClass().getName());
    }
}

public class TestDemo {
    public static void main(String[] args) {
        Test<Integer> intOb = new Test<Integer>(88);
        intOb.showType();
                int i = intOb.getOb();
        System.out.println("value= " + i);
        System.out.println("----------------------------------");
        // 定义泛型类Test的一个String版本
        Test<String> strOb = new Test<String>("Hello Gen!");
        strOb.showType();
        String s = strOb.getOb();
        System.out.println("value= " + s);
    }
}

// Test.java
public class Test {

/*
注意：定义带类型参数的方法，其主要目的是为了表达多个参数以及返回值之间的关系。例如本例子中T和S的继承关系， 返回值的类型和第一个类型参数的值相同。
*/
    //定义了一个T,S（子类）型泛型方法，返回值为T,参数列表有T和S型
    public<T,S extends T> T testDemo(T t,S s){
        System.out.println("我是 T 类型，我的类型是" + t.getClass().getName());
        System.out.println("我是 S 类型，我的类型是" + s.getClass().getName());
        return t;
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Test test = new Test();
        Dog d = new Dog();
        Animal a0 = new Animal();
        Animal a1  = test.testDemo(a0,d);
        System.out.println("我是整数 a，我的类型是" + a1.getClass().getName());
    }

}

import java.util.List;
import java.util.ArrayList;

public class Test2 {
    //普通方法，参数里有通配泛型list
    public void testDemo(List<?> s){
        for(Object obj:s){
            System.out.println("我的类型是" + obj.getClass().getName());
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Test test = new Test();
        Dog a0 = new Dog();
        Animal a1 = new Animal();
        List<Animal> s = new ArrayList<Animal>();
        s.add(a0);
        s.add(a1);
        test.testDemo(s);
    }

}

public class Student {
    public String id;
    public String name;
    public Student(String id,String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
                return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}

import java.util.*;


public class ListTest {


    //集合后面的<>代表泛型的意思
    //泛型是规定了集合元素的类型
    /**
     * 用于存放学生的List
     */
    public List<Student> students;


    public ListTest() {
        this.students = new ArrayList<Student>();
    }

    /**
     * 用于往students中添加学生
     */
    public void testAdd() {
        // 创建一个学生对象，并通过调用add方法，添加到学生管理List中
        Student st1 = new Student("1", "张三");
        students.add(st1);

        // 取出 List中的Student对象 索引为0 也就是第一个
        Student temp = students.get(0);
        System.out.println("添加了学生：" + temp.id + ":" + temp.name);

        Student st2 = new Student("2", "李四");
        //添加到list中，插入到索引为0的位置，也就是第一个
        students.add(0,st2);
        Student temp2 = students.get(0);
        System.out.println("添加了学生：" + temp2.id + ":" + temp2.name);

        // 对象数组的形式添加
        Student[] student = {new Student("3","王五"),new Student("4","马六")};

        // Arrays类包含用来操作数组（比如排序和搜索）的各种方法，asList() 方法用来返回一个受指定数组支持的固定大小的列表
        students.addAll(Arrays.asList(student));
        Student temp3 = students.get(2);
        Student temp4 = students.get(3);
        System.out.println("添加了学生：" + temp3.id + ":" + temp3.name);
        System.out.println("添加了学生：" + temp4.id + ":" + temp4.name);
        Student[] student2 = {new Student("5", "周七"), new Student("6", "赵八")};
        students.addAll(2, Arrays.asList(student2));
        Student temp5 = students.get(2);
        Student temp6 = students.get(3);
        System.out.println("添加了学生：" + temp5.id + ":" + temp5.name);
        System.out.println("添加了学生：" + temp6.id + ":" + temp6.name);
    }


    /**
     * 取得List中的元素的方法
     */
    public void testGet() {
        int size = students.size();
        for (int i = 0; i < size; i++) {
            Student st = students.get(i);
            System.out.println("学生：" + st.id + ":" + st.name);

        }
    }


    /**
     * 通过迭代器来遍历
     * 迭代器的工作是遍历并选择序列中的对象，Java 中 Iterator 只能单向移动
     */
    public void testIterator() {
        // 通过集合的iterator方法，取得迭代器实例
        Iterator<Student> it = students.iterator();
        System.out.println("有如下学生（通过迭代器访问）：");
        while (it.hasNext()) {

            Student st = it.next();
            System.out.println("学生" + st.id + ":" + st.name);
        }
    }

    /**
     * 通过for each 方法访问集合元素
     *
     */
    public void testForEach() {
        System.out.println("有如下学生（通过for each）：");
        for (Student obj:students) {
            Student st = obj;
            System.out.println("学生：" + st.id + ":" + st.name);
        }
        //使用java8 Steam将学生排序后输出
        students.stream()//创建Stream
                //通过学生id排序
                .sorted(Comparator.comparing(x -> x.id))
                //输出
                .forEach(System.out::println);
    }

    /**
     * 修改List中的元素
     *
     */
    public void testModify() {
        students.set(4, new Student("3", "吴酒"));
    }

    /**
     * 删除List中的元素
     *
     */
    public void testRemove() {
        Student st = students.get(4);
        System.out.println("我是学生：" + st.id + ":" + st.name + "，我即将被删除");
        students.remove(st);
        System.out.println("成功删除学生！");
        testForEach();
    }


    public static void main(String[] args) {
        ListTest lt = new ListTest();
        lt.testAdd();
        lt.testGet();
        lt.testIterator();
        lt.testModify();
        lt.testForEach();
        lt.testRemove();

    }
}

public class Dog extends Animal {
    public Dog(){
        System.out.println("我是狗");
    }
}

// Animal.java
public class Animal {
    public Animal(){
        System.out.println("我是动物");
    }
}

方法	返回值	说明
clear()	void	从此映射中移除所用映射关系（可选操作）
containsKey(Object key)	boolean	如果此映射包含指定键的映射关系，则返回true
containsValue(Object value)	boolean	如果此映射将一个或多个键映射到指定值，则返回 true
entrySet()	Set<Map.Entry<K,V>>	返回此映射中包含的映射关系的 Set 视图
equals(Object o)	boolean	比较指定的对象与此映射是否相等
get(Object key)	V	返回指定键所映射的值；如果此映射不包含该键的映射关系，则返回 null
hashCode()	int	返回此映射的哈希码值
isEmpty()	boolean	如果此映射未包含键-值映射关系，则返回 true
keySet()	Set<K>	返回此映射中包含的键的 Set 视图
put(K key, V value)	V	将指定的值与此映射中的指定键关联（可选操作）
putAll(Map<? extends K, ? extends V> m)	void	从指定映射中将所有映射关系复制到此映射中（可选操作）
remove(Object key)	V	如果存在一个键的映射关系，则将其从此映射中移除（可选操作）
size	int	返回此映射中的键-值映射关系数
values()	Collection<V>	返回此映射中包含的值的 Collection 视图

方法	返回值	说明
add(int index, E element)	void	在列表的指定位置插入指定元素（可选操作）
addAll(int index, Collection<? extends E> c)	boolean	将指定 collection 中的所有元素都插入到列表中的指定位置（可选操作）
get(int index)	E	返回列表中指定位置的元素
indexOf(Object o)	int	返回此列表中第一次出现的指定元素的索引；如果此列表不包含该元素，则返回 -1
lastIndexOf(Object o)	int	返回此列表中最后出现的指定元素的索引；如果列表不包含此元素，则返回 -1
listIterator()	ListIterator<E>	返回此列表元素的列表迭代器（按适当顺序）
listIterator(int index)	ListIterator<E>	返回此列表元素的列表迭代器（按适当顺序），从列表的指定位置开始
remove(int index)	E	移除列表中指定位置的元素（可选操作）
set(int index, E element)	E	用指定元素替换列表中指定位置的元素（可选操作）
subList(int fromIndex, int toIndex)	List<E>	返回列表中指定的 fromIndex（包括 ）和 toIndex（不包括）之间的部分视图

方法	返回值	说明
add(E e)	boolean	向 collection 的尾部追加指定的元素（可选操作）
addAll(Collection<? extend E> c)	boolean	将指定 collection 中的所有元素都添加到此 collection 中（可选操作）
clear()	void	移除此 collection 中的所有元素（可选操作）
contains(Object o)	boolean	如果此 collection 包含指定的元素，则返回 true
containsAll(Collection<?> c)	boolean	如果此 collection 包含指定 collection 的所有元素，则返回 true
equals(Object o)	boolean	比较此 collection 与指定对象是否相等
hashCode()	int	返回此 collection 的哈希码值
isEmpty()	boolean	如果此 collection 不包含元素，则返回true
iterator()	Iterator<E>	返回在此 collection 的元素上进行迭代的迭代器
remove(Object o)	boolean	移除此 collection 中出现的首个指定元素(可选操作)
removeAll(Collection<?> c)	boolean	移除此 collection 中那些也包含在指定 collection 中的所有元素（可选操作）
retainAll(Collection<?> c)	boolean	仅保留此 collection 中那些也包含在指定 collection 的元素（可选操作）
size()	int	返回此 collection 中的元素数
toArray()	Object[]	返回包含此 collection 中所有元素的数组
toArray(T[] a)	<T> T[]	返回包含此 collection 中所有元素的数组；返回数组的运行时类型与指定数组的运行时类型相同