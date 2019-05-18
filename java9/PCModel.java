import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;

public class PCModel {
    //阻塞队列
    private static LinkedBlockingQueue<Integer> queue = new LinkedBlockingQueue<>();

    public static void main(String[] args) {
        //生产者
        Thread provider = new Thread(() -> {
            Random random = new Random();
            for (int j = 0; j < 5; j++) {
                try {
                    int i = random.nextInt();
                    //注释直到插入数据
                    queue.put(i);
                    System.out.println("生产数据：" + i);
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        //消费者
        Thread consumer = new Thread(() -> {
            Integer data;
            for (int i = 0; i < 5; i++) {
                try {
                    //阻塞直到取出数据
                    data = queue.take();
                    System.out.println("消费数据：" + data);
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        //启动线程
        provider.start();
        consumer.start();
    }
}