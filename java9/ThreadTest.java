public class ThreadTest {
    public static void main(String[] args) throws InterruptedException {
        ThreadState state = new ThreadState();
        //声明并实例化一个ThreadState对象

        Thread thread = new Thread(state);
        //利用这个名为state的ThreadState对象来创建Thread对象

        System.out.println("Create new thread: " + thread.getState());
        //使用getState()方法来获得线程的状态，并进行输出

        thread.start(); 
        //使用thread对象的start()方法来启动新的线程

        System.out.println("Start the thread: " + thread.getState());
        //输出线程的状态

        Thread.sleep(100); 
        //通过调用sleep()方法使当前这个线程休眠100毫秒，从而使新的线程运行waitForAMoment()方法

        System.out.println("Waiting for a moment (time): " + thread.getState());
        //输出线程的状态

        Thread.sleep(1000); 
        //使当前这个线程休眠1000毫秒，从而使新的线程运行waitForever()方法

        System.out.println("Waiting for a moment: " + thread.getState());
        //输出线程的状态

        state.notifyNow(); 
        // 调用state的notifyNow()方法

        System.out.println("Wake up the thread: " + thread.getState());
        //输出线程的状态

        Thread.sleep(1000); 
        //使当前线程休眠1000毫秒，使新线程结束

        System.out.println("Terminate the thread: " + thread.getState());
        //输出线程的状态
    }
}