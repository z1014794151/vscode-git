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

// Course.java
public class Course {
    public String id;
    public String name;
    public Course(String id, String name){
        this.id = id;
        this.name = name;
    }
}

// MapTest.java
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class MapTest {

    /**
     * 用来承装课程类型对象
     */
    public Map<String, Course> courses;

    /**
     * 在构造器中初始化 courses 属性
     * @param args
     */
    public MapTest() {
        this.courses = new HashMap<String, Course>();
    }

    /**
     * 测试添加：输入课程 ID，判断是否被占用
     * 若未被占用，输入课程名称，创建新课程对象
     * 并且添加到 courses 中
     * @param args
     */
    public void testPut() {
        //创建一个 Scanner 对象，用来获取输入的课程 ID 和名称
        Scanner console = new Scanner(System.in);

        for(int i = 0; i < 3; i++) {
            System.out.println("请输入课程 ID：");
            String ID = console.next();
            //判断该 ID 是否被占用
            Course cr = courses.get(ID);
            if(cr == null){
                //提示输入课程名称
                System.out.println("请输入课程名称：");
                String name = console.next();
                //创建新的课程对象
                Course newCourse = new Course(ID,name);
                //通过调用 courses 的 put 方法，添加 ID-课程映射
                courses.put(ID, newCourse);
                System.out.println("成功添加课程：" + courses.get(ID).name);
            }
            else {
                System.out.println("该课程 ID 已被占用");
                continue;
            }
        }
    }

    /**
     * 测试 Map 的 keySet 方法
     * @param args
     */

    public void testKeySet() {
        //通过 keySet 方法，返回 Map 中的所有键的 Set 集合
        Set<String> keySet = courses.keySet();
        //遍历 keySet，取得每一个键，在调用 get 方法取得每个键对应的 value
        for(String crID: keySet) {
            Course cr = courses.get(crID);
            if(cr != null){
                System.out.println("课程：" + cr.name);
            }
        }
    }

    /**
     * 测试删除 Map 中的映射
     * @param args
     */
    public void testRemove() {
        //获取从键盘输入的待删除课程 ID 字符串
        Scanner console = new Scanner(System.in);
        while(true){
            //提示输出待删除的课程 ID
            System.out.println("请输入要删除的课程 ID！");
            String ID = console.next();
            //判断该 ID 是否对应的课程对象
            Course cr = courses.get(ID);
            if(cr == null) {
                //提示输入的 ID 并不存在
                System.out.println("该 ID 不存在！");
                continue;
            }
            courses.remove(ID);
            System.out.println("成功删除课程" + cr.name);
            break;
        }
    }

    /**
     * 通过 entrySet 方法来遍历 Map
     * @param args
     */
    public void testEntrySet() {
        //通过 entrySet 方法，返回 Map 中的所有键值对
        Set<Entry<String,Course>> entrySet = courses.entrySet();
        for(Entry<String,Course> entry: entrySet) {
            System.out.println("取得键：" + entry.getKey());
            System.out.println("对应的值为：" + entry.getValue().name);
        }
    }

    /**
     * 利用 put 方法修改Map 中的已有映射
     * @param args
     */
    public void testModify(){
        //提示输入要修改的课程 ID
        System.out.println("请输入要修改的课程 ID：");
        //创建一个 Scanner 对象，去获取从键盘上输入的课程 ID 字符串
        Scanner console = new Scanner(System.in);
        while(true) {
            //取得从键盘输入的课程 ID
            String crID = console.next();
            //从 courses 中查找该课程 ID 对应的对象
            Course course = courses.get(crID);
            if(course == null) {
                System.out.println("该 ID 不存在！请重新输入！");
                continue;
            }
            //提示当前对应的课程对象的名称
            System.out.println("当前该课程 ID，所对应的课程为：" + course.name);
            //提示输入新的课程名称，来修改已有的映射
            System.out.println("请输入新的课程名称：");
            String name = console.next();
            Course newCourse = new Course(crID,name);
            courses.put(crID, newCourse);
            System.out.println("修改成功！");
            break;
        }
    }

    public static void main(String[] args) {
        MapTest mt = new MapTest();
        mt.testPut();
        mt.testKeySet();
        mt.testRemove();
        mt.testModify();
        mt.testEntrySet();

    }
}

import java.util.HashSet;
import java.util.Set;
/*
 * 项目组长类
 */
public class PD {

    public String id;
    public String name;
    //集合后面的<>代表泛型的意思
    //泛型是规定了集合元素的类型
    public Set<Student> students;
    public PD(String id, String name){
        this.id = id;
        this.name = name;
        this.students = new HashSet<Student>();
    }
}

public class Student {
    public String id;
    public String name;
    public Student(String id, String name){
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

// SetTest.java
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SetTest {

    public List<Student> students;

    public SetTest() {
        students = new ArrayList<Student>();
    }

    /*
     * 用于往students中添加学生
     */
    public void testAdd() {
        //创建一个学生对象，并通过调用add方法，添加到学生管理List中
        Student st1 = new Student("1", "张三");
        students.add(st1);

        //添加到List中的类型均为Object，所以取出时还需要强转

        Student st2 = new Student("2","李四");
        students.add(st2);

        Student[] student = {new Student("3", "王五"),new Student("4", "马六")};
        students.addAll(Arrays.asList(student));

        Student[] student2 = {new Student("5", "周七"),new Student("6", "赵八")};
        students.addAll(Arrays.asList(student2));

    }

    /**
     * 通过for each 方法访问集合元素
     * @param args
     */
    public void testForEach() {
        System.out.println("有如下学生（通过for each）：");
        for(Object obj:students){
            Student st = (Student)obj;
            System.out.println("学生：" + st.id + ":" + st.name);
        }
    }

    public static void main(String[] args){
        SetTest st = new SetTest();
        st.testAdd();
        st.testForEach();
        PD pd = new PD("1","张老师");
        System.out.println("请：" + pd.name + "选择小组成员！");
        //创建一个 Scanner 对象，用来接收从键盘输入的学生 ID
        Scanner console = new Scanner(System.in);

        for(int i = 0;i < 3; i++){
            System.out.println("请输入学生 ID");
            String studentID = console.next();
            for(Student s:st.students){
                if(s.id.equals(studentID)){
                    pd.students.add(s);
                }
            }
        }
        st.testForEachForSer(pd);
        // 关闭 Scanner 对象
        console.close();
    }
    //打印输出，老师所选的学生！Set里遍历元素只能用foreach 和 iterator 
    //不能使用 get() 方法，因为它是无序的，不能想 List 一样查询具体索引的元素
    public void testForEachForSer(PD pd){
        for(Student s: pd.students) {
        System.out.println("选择了学生：" + s.id + ":" + s.name);
        }
    }

}

方法名	描述
void sort(List list)	按自然升序排序
void sort(List list, Comparator c)	自定义排序规则排序
void shuffle(List list)	随机排序，用于打乱顺序
void reverse(List list)	反转，将列表元素顺序反转
void swap(List list, int i , int j)	交换处于索引 i 和 j 位置的元素
int binarySearch(List list, Object key)	二分查找，列表必须有序，返回找到的元素索引位置
int max(Collection coll)	查找最大值
int min(Collection coll)	查找最小值
void fill(List list, Object obj)	使用 obj 填充 list 所有元素
boolean replaceAll(List list, Object oldVal, Object newVal)	使用用 newVal 替换所有的 oldVal。
<K,V> Map<K,V> synchronizedMap(Map<K,V> m)	将 m 包装为线程安全的 Map
<T> List<T> synchronizedList(List<T> list)	将 list 包装为线程安全的 List

//CollectionsDemo.java
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionsDemo {
    public static void main(String[] args) {
//        创建一个空List
        List<Integer> list = new ArrayList<>();
        //赋值
        list.add(3);
        list.add(5);
        list.add(7);
        list.add(9);
        list.add(12);
        System.out.print("初始顺序：");
        list.forEach(v -> System.out.print(v + "\t"));


        //打乱顺序
        Collections.shuffle(list);
        System.out.print("\n打乱顺序：");
        list.forEach(v -> System.out.print(v + "\t"));

        //反转
        Collections.reverse(list);
        System.out.print("\n反转集合：");
        list.forEach(v -> System.out.print(v + "\t"));

        //第一个位和最后一位交换
        Collections.swap(list,0,list.size()-1);
        System.out.print("\n交换第一位和最后一位：");
        list.forEach(v -> System.out.print(v + "\t"));

        //按自然升序排序
        Collections.sort(list);
        System.out.print("\nSort排序后：");
        list.forEach(v -> System.out.print(v + "\t"));

        //二分查找 必须排序后
        System.out.print("\n二分查找数值7的位置："+Collections.binarySearch(list, 7));

        //返回线程安全的list
        List<Integer> synchronizedList = Collections.synchronizedList(list);
    }
}

//sortDemo.java
import java.util.Arrays;

public class InsertSort {
    public static void sort(int[] arr) {
        int temp;
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                //对已经排序好的元素比较，找到一个比插入元素大的元素 交换位置
                if (arr[i] < arr[j]) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] ints = {5, 3, 4, 1, 2};
        sort(ints);
        System.out.println(Arrays.toString(ints));
    }
}

import java.util.Arrays;

public class BubbleSort {
    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                //如果当前元素比后一位元素大 交换位置
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] ints = {5, 3, 4, 1, 2};
        sort(ints);
        System.out.println(Arrays.toString(ints));
    }
}

import java.util.Arrays;

public class MergeSort {

    public static void mergeSort(int[] arrays, int left, int right) {
//        如果数组还可以拆分
        if (left < right) {
            //数组的中间位置
            int middle = (left + right) / 2;
            //拆分左边数组
            mergeSort(arrays, left, middle);
            //拆分右边数组
            mergeSort(arrays, middle + 1, right);
            //合并
            merge(arrays, left, middle, right);

        }
    }


    /**
     * 合并数组
     */
    public static void merge(int[] arr, int left, int middle, int right) {
        //申请合并空间 大小为两个已经排序序列之和
        int[] temp = new int[right - left + 1];
        //i 和 j为两个已经排好序的数组的起始位置
        int i = left;
        int j = middle + 1;
        int k = 0;
        //排序
        while (i <= middle && j <= right) {
            //将比较小的数组放入合并空间
            if (arr[i] < arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }
        //将左边剩余元素写入合并空间
        while (i <= middle) {
            temp[k++] = arr[i++];
        }
        //将右边剩余的元素写入合并空间
        while (j <= right) {
            temp[k++] = arr[j++];
        }
        //将排序后的数组写回原来的数组
        for (int l = 0; l < temp.length; l++) {
            arr[l + left] = temp[l];
        }

    }

    public static void main(String[] args) {
        int[] ints = {5, 3, 4, 1, 2};
        mergeSort(ints,0,ints.length-1);
        System.out.println(Arrays.toString(ints));
    }
}

import java.util.Arrays;

public class QuickSort {
    public static void sort(int[] arr, int head, int tail) {
        if (head >= tail || arr == null || arr.length <= 1) {
            return;
        }
        //设置数组的起始位置 i 结束位置j 基准 pivot 为数组的中间
        int i = head, j = tail, pivot = arr[(head + tail) / 2];
        while (i <= j) {
            //当数组小于基准 循环结束后 相当于i所处的位置的值为大于基准的元素
            while (arr[i] < pivot) {
                ++i;
            }
            //当数组大于基准 循环结束后 相当于j所处的位置的值为小于于基准的元素
            while (arr[j] > pivot) {
                --j;
            }
            //如果i<j 那么则将交互i j对应位置的值
            if (i < j) {
                int t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
                //将指针继续移动
                ++i;
                --j;
            } else if (i == j) {
//如果i=j 那么说明本次排序已经结束 将i++ 如果这里不使用i++ 那么后面的sort(arr,i,tail)将改为arr(arr,i+1,tail)
                ++i;
            }
        }
        //继续将数组分割  
        sort(arr, head, j);
        sort(arr, i, tail);
    }

    public static void main(String[] args) {
        int[] ints = {5, 3, 4, 1, 2};
        sort(ints, 0, ints.length - 1);
        System.out.println(Arrays.toString(ints));
    }
}

public class BinarySearch {
    public static int search(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int middle = (high + low) / 2;
            //如果相等 返回值
            if (key == arr[middle]) {
                return key;
            } else if (key < arr[middle]) {
                //如果key小于中间值，那么改变high，值可能在左边部（比较小的部分）
                high = middle - 1;
            }else {
                //如果key大于中间值，那么改变low，值可能在右边部（比较大的部分）
                low = middle + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] ints = {5, 3, 4, 1, 2};
        System.out.println(search(ints, 4));
    }
}

