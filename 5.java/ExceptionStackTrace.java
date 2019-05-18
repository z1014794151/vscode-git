public class ExceptionStackTrace {
    private static void method1() {
        method2();
    }

    private static void method2() {
        throw new NullPointerException();
    }
    public static void main(String[] args) {
        try {
            method1();
        } catch (Exception e) {
            //打印堆栈轨迹
            e.printStackTrace();
        }
    }
}