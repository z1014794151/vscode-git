public class ThreadLocalDemo {

    public static void main(String[] args) {
        //实例化一个线程对象
        ThreadDemo threadDemo = new ThreadDemo();
        //根据一个对象开启2个线程
        new Thread(threadDemo).start();
        new Thread(threadDemo).start();

    }
}

class ThreadDemo implements Runnable {
    //使用ThreadLocal提供的静态方法创建一个线程变量 并且初始化值为0
    private static ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(() -> 0);

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            //get方法获取线程变量值
            Integer integer = threadLocal.get();
            integer += 1;
            //set方法设置线程变量值
            threadLocal.set(integer);
            System.out.println(integer);
        }
    }
}
