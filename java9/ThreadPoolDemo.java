import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolDemo {
    //使用Executors 创建一个固定大小为5的线程池
    private static ExecutorService executorService = Executors.newFixedThreadPool(5);

    public static void main(String[] args) {
//        提交任务
        executorService.submit(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.print(i + " ");
            }
        });
        //停止线程池 并不会立即关闭 ，而是在线程池中的任务执行完毕后才关闭
        executorService.shutdown();
    }
}

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

// public class ThreadPoolDemo2 {
//     private static ExecutorService executorService = new ThreadPoolExecutor(
//             5, //核心线程数为5
//             10,//最大线程数为10
//             0L, TimeUnit.MILLISECONDS,//非核心线程存活时间
//             new LinkedBlockingQueue<>());//任务队列 

//     public static void main(String[] args) {
//         //提交任务
//         executorService.submit(() -> {
//             for (int i = 0; i < 10; i++) {
//                 System.out.print(i + " ");
//             }
//         });
//         //关闭线程池
//         executorService.shutdown();
//     }
// }
