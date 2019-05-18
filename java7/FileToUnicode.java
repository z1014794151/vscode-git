// FileToUnicode.java
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileToUnicode {
    public static void main(String args[]) {
        try {
          // 由文件到输入流
            FileInputStream fis = new FileInputStream("file1.txt");
            // 由输入流到读取
            InputStreamReader dis = new InputStreamReader(fis);
            // 由读取到缓冲
            BufferedReader reader = new BufferedReader(dis);
            String s;
            //每次读取一行，当改行为空时结束
            while((s = reader.readLine()) != null){
                System.out.println("read:" + s);
            }
            dis.close();
        }
        catch(IOException e) {
            System.out.println(e);
        }
    }
}
