import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class CopyDemo {
    public static void main(String[] args) {
        try {
            //被拷贝的文件一定要存在 否则会抛出异常  这里的1.txt一定要存在
            Files.copy(Paths.get("/home/coding/workspace/java7/copy1.txt"),
            Paths.get("/home/coding/workspace/java7/copy2.txt"),
            StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
