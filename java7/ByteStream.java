import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ByteStream {

    /**
     * 把输入流中的所有内容赋值到输出流中
     * @param in
     * @param out
     * @throws IOException
     */
    public void copy(InputStream in, OutputStream out) throws IOException {
        byte[] buf = new  byte[4096];
        int len = in.read(buf);
        //read 是一个字节一个字节地读，字节流的结尾标志是-1
        while (len != -1){
            out.write(buf, 0, len);
            len = in.read(buf);
        }
    }
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        Test t = new Test();
        System.out.println("输入字符：");
        t.copy(System.in, System.out);
    }

}
// InputStreamReader ir = new InputStreamReader(is,"8859_1");