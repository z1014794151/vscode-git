import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class MoveDemo {
    public static void main(String[] args) {
        try {
            //将1.txt 重命名为3.txt 如果只需要移动到不同的目录，文件名不变即可
            Files.move(Paths.get("/home/coding/workspace/java7/copy1.txt"), Paths.get("/home/coding/workspace/java7/3.txt"), StandardCopyOption.REPLACE_EXISTING);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

// Files.delete(Paths.get("/home/project/3.txt"));