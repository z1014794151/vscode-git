import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test {

    public static void main(String[] args) {
        try {
            //inFile 作为输入流的数据文件必须存在，否则抛出异常
            File inFile = new File("/home/coding/workspace/java7/file1.txt");

            //file2.txt没有，系统可以创建
            File outFile = new File("file2.txt");
            FileInputStream fis = new FileInputStream(inFile) ;
            FileOutputStream fos = new FileOutputStream(outFile);
            int c;
            while((c = fis.read()) != -1 ){
              fos.write(c);
            }
            //打开了文件一定要记着关，释放系统资源
            fis.close();
            fos.close();
        }catch(FileNotFoundException e) {
            System.out.println("FileStreamsTest:" + e);
        }catch(IOException e){
            System.err.println("FileStreamTest:" + e);
        }
    }
}

// 还有FileReader写法
// FileReader file = new FileReader("/home/project/shiyanlou.txt");
// //声明一个文件输入流file，并指明该文件在系统中的路径以方便定位

// int data = 0;
// //声明一个整型变量用于存放读取的数据

// while((data=file.read())!=-1){
//     //在while循环中使用read()方法持续读取file，数据赋到data中
//     //如果读取失败或者结束，则将返回-1，这个特殊的返回值可以作为读取结束的标识

//     System.out.print((char)data);
//     //输出读取到数据
// }

// file.close();
// //一定要记得读取结束后要关闭文件