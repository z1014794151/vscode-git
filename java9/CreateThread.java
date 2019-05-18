public class CreateThread {
  public static void main(String[] args) {
    Thread1 thread1 = new Thread1();
    Thread thread2 = new Thread(new Thread2());
    thread1.start();
    thread2.start();
  }
}

class Thread1 extends Thread {
  @Override
  public void run() {
    for (int i = 0; i < 100; ++i) {
      System.out.println("Hello! This is " + i);
    }
  }
}

class Thread2 implements Runnable {
  @Override
  public void run() {
    for (int i = 0; i < 100; ++i) {
      System.out.println("Thanks! There is " + i);
    }
  }
}