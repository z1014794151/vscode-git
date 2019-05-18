import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataStream {

    public static void main(String[] args) throws IOException{
        //向文件 a.txt 写入
        //文件到流
        FileOutputStream fos = new FileOutputStream("a.txt");
        //流到数据
        DataOutputStream dos = new DataOutputStream(fos);
        try {
            dos.writeBoolean(true);
            dos.writeByte((byte)123);
            dos.writeChar('J');
            dos.writeDouble(3.1415926);
            dos.writeFloat(2.122f);
            dos.writeInt(123);
        }
        finally {
            dos.close();
        }
        //从文件 a.txt 读出
        FileInputStream fis = new FileInputStream("a.txt");
        DataInputStream dis = new DataInputStream(fis);
        try {
            System.out.println("\t" + dis.readBoolean());
            System.out.println("\t" + dis.readByte());
            System.out.println("\t" + dis.readChar());
            System.out.println("\t" + dis.readDouble());
            System.out.println("\t" + dis.readFloat());
            System.out.println("\t" + dis.readInt());
        }
        finally {
            dis.close();
        }
    }

}
