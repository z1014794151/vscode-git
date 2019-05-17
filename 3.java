import java.util.Arrays;
import java.util.Random;

public class ArraysDemo {
    public static void main(String[] args) {
        int[] arr = new int[10];
        //将数组元素都设为9
        Arrays.fill(arr, 9);
        System.out.println("fill:" + Arrays.toString(arr));
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            //使用100以内的随机数赋值数组
            arr[i] = random.nextInt(101);
        }
        //重新赋值后的数组
        System.out.println("重新赋值：" + Arrays.toString(arr));
        //将索引为5的元素设为50
        arr[5] = 50;
        //排序
        Arrays.sort(arr);
        //排序后的数组
        System.out.println("sort排序后：" + Arrays.toString(arr));
        //查找50的位置
        int i = Arrays.binarySearch(arr, 50);
        System.out.println("值为50的元素索引："+i);
        //复制一份新数组
        int[] newArr = Arrays.copyOf(arr, arr.length);
        //比较
        System.out.println("equals:"+Arrays.equals(arr, newArr));
    }
}

public class StringBuilderTest {

    public static void main(String[] args){
        //定义和初始化一个StringBuilder类的字串s
        StringBuilder s = new StringBuilder("I");
        //在s后面添加字串" java"
        s.append(" java");
        //在s[1]的位置插入字串
        s.insert(1, " love");
        String t = s.toString(); //转为字符串
        System.out.println(t);
    }
}

// StringBuilder 的构造方法：

// 构造方法	说明
// StringBuilder()	构造一个其中不带字符的 StringBuilder，其初始容量为 16 个字符
// StringBuilder(CharSequence seq)	构造一个 StringBuilder，它包含与指定的 CharSequence 相同的字符
// StringBuilder(int capacity)	构造一个具有指定初始容量的 StringBuilder
// StringBuilder(String str)	并将其内容初始化为指定的字符串内容
// StringBuilder 类的常用方法：

// 方法	返回值	功能描述
// insert(int offsetm,Object obj)	StringBuilder	在 offsetm 的位置插入字符串 obj
// append(Object obj)	StringBuilder	在字符串末尾追加字符串 obj
// length()	int	确定 StringBuilder 对象的长度
// setCharAt(int index,char ch)	void	使用 ch 指定的新值设置 index 指定的位置上的字符
// toString()	String	转换为字符串形式
// reverse()	StringBuilder	反转字符串
// delete(int start, int end)	StringBuilder	删除调用对象中从 start 位置开始直到 end 指定的索引（end-1）位置的字符序列
// replace(int start, int end, String str)	StringBuilder	使用一组字符替换另一组字符。将用替换字符串从 start 指定的位置开始替换，直到 end 指定的位置结束

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalendarDemo {
    public static void main(String[] args) {
        System.out.println("完整显示日期时间：");
        // 字符串转换日期格式
        DateFormat fdate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String str = fdate.format(new Date());
        System.out.println(str);

        //创建Calendar对象单例
        Calendar calendar = Calendar.getInstance();
        //初始化calendar，但不必要
        calendar.setTime(new Date());

        //显示年份
        System.out.println("年： " + calendar.get(Calendar.YEAR));

                // 显示月份 (从0开始, 实际显示要加一)
        System.out.println("月： " + calendar.get(Calendar.MONTH));


        // 当前分钟数
        System.out.println("分钟： " + calendar.get(Calendar.MINUTE));

        // 今年的第 N 天
        System.out.println("今年的第 " + calendar.get(Calendar.DAY_OF_YEAR) + "天");

        // 本月第 N 天
        System.out.println("本月的第 " + calendar.get(Calendar.DAY_OF_MONTH) + "天");

        //3小时以后
        calendar.add(Calendar.HOUR_OF_DAY,3);
        System.out.println("三小时以后的时间： " + calendar.getTime());

                // 格式化显示
        str = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SS")).format(calendar.getTime());
        System.out.println(str);

        // 重置 Calendar 显示当前时间
        calendar.setTime(new Date());
        str = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SS")).format(calendar.getTime());
        System.out.println(str);

        // 创建一个 Calendar 用于比较时间
        Calendar calendarNew = Calendar.getInstance();

        // 设定为 5 小时以前，后者大，显示 -1
        calendarNew.add(Calendar.HOUR, -5);
        System.out.println("时间比较：" + calendarNew.compareTo(calendar));

        // 设定7小时以后，前者大，显示 1
        calendarNew.add(Calendar.HOUR, +7);
        System.out.println("时间比较：" + calendarNew.compareTo(calendar));

        // 退回 2 小时，时间相同，显示0
        calendarNew.add(Calendar.HOUR, -2);
        System.out.println("时间比较：" + calendarNew.compareTo(calendar));

        // calendarNew创建时间点
        System.out.println((new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SS")).format(calendarNew.getTime()));
        // calendar创建时间点
        System.out.println((new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SS")).format(calendar.getTime()));
        System.out.println("时间比较：" + calendarNew.compareTo(calendar));
    }
}

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateDemo {
    public static void main(String[] args) {
        String strDate, strTime;
        Date objDate = new Date();
        System.out.println("今天的日期是：" + objDate);
        long time = objDate.getTime();
        System.out.println("自1970年1月1日起以毫秒为单位的时间（GMT）：" + time);
        strDate = objDate.toString();
        //提取 GMT 时间
        strTime = strDate.substring(11, (strDate.length() - 4));
        //按小时、分钟和秒提取时间
        strTime = "时间：" + strTime.substring(0, 8);
        System.out.println(strTime);
        //格式化时间
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(formatter.format(objDate));
    }
}

public class MathDemo {
    public static void main(String[] args) {
        System.out.println(Math.abs(-12.7));
        System.out.println(Math.ceil(12.7));
        System.out.println(Math.rint(12.49));
        System.out.println(Math.random());
        System.out.println("sin30 = " + Math.sin(Math.PI/6));
        // 计算30°的正弦值，参数是用弧度表示的角，即π的六分之一
        System.out.println("cos30 = " + Math.cos(Math.PI / 6));
        // 计算30°的余弦值，这些计算三角函数的方法，其参数和返回值的类型都为double
        System.out.println("tan30 = " + Math.tan(Math.PI / 6));
        // 计算30°的正切值
    }
}

//pow(a,b) sqrt(a) max/min(a,b)

import java.util.Random;

public class RandomDemo {
    public static void main(String[] args) {
        Random random = new Random();
        //随机生成一个整数 int范围
        System.out.println(random.nextInt());
        //生成 [0,n] 范围的整数  设n=100
        System.out.println(random.nextInt(100+1));
        //生成 [0,n) 范围的整数  设n=100
        System.out.println(random.nextInt(100));
        //生成 [m,n] 范围的整数  设n=100 m=40
        System.out.println((random.nextInt(100-40+1)+40));
        //随机生成一个整数 long范围
        System.out.print(random.nextLong());
        //生成[0,1.0)范围的float型小数
        System.out.println(random.nextFloat());
        //生成[0,1.0)范围的double型小数
        System.out.println(random.nextDouble());
    }
}

import java.util.Arrays;

public class SystemDemo {
    public static void main(String[] args) {
        int[] a = {7, 8, 9, 10, 11};
        int[] b = {1, 2, 3, 4, 5, 6};
        //从数组a的第二个元素开始，复制到b数组的第三个位置 复制的元素长度为3
        System.arraycopy(a,1,b,2,3);
        //输出结果
        System.out.println(Arrays.toString(b));
        System.out.println("当前时间：" + System.currentTimeMillis());
        System.out.println("java版本信息：" + System.getProperty("java.version"));
        //运行垃圾收集器
        System.gc();
        //退出
        System.exit(0);
    }
}
//getProperties()

