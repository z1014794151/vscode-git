import java.io.File;
import java.util.Arrays;

public class FileInfo {
    public static void main(String[] args) {
        File file = new File("/home/coding/workspace/java7");
        System.out.println("文件或者目录名：" + file.getName());
        System.out.println("绝对路径：" + file.getAbsolutePath());
        System.out.println("父目录：" + file.getParent());
        System.out.println("文件路径：" + file.getPath());
        //判断文件是否是目录
        if (file.isDirectory()) {
            //打印目录中的文件
            Arrays.stream(file.list()).forEach(System.out::println);
        }
        System.out.println("是否隐藏：" + file.isHidden());
        System.out.println("是否存在：" + file.exists());
    }
}
