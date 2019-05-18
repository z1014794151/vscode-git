import java.io.File;
public class ReadDir {
    public static void main(String[] args) {
        readDir(new File("/home"));
    }

    static void readDir(File file) {
        if (file == null) {
            return;
        }
        //如果当前file是目录
        if (file.isDirectory()) {
            File[] files;
            //如果目录不为空
            if ((files = file.listFiles()) != null) {
                for (File file1 : files) {
                    //递归读取目录内容
                    readDir(file1);
                }
            }
        } else {
            //如果不是目录 直接输出文件名
            System.out.println(file.getName());
        }
    }
}