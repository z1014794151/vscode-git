import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.util.Scanner;

public class NioDemo {
    public static void main(String[] args) {
        try {
            File file = new File("/home/coding/workspace/java7/nio.txt");
            if (!file.exists()) {
                file.createNewFile();
            }
            //创建channel  nio通过channel来连接文件 相当于桥梁
            FileChannel writeChannel = new RandomAccessFile(file, "rw").getChannel();
            //创建一个ByteBuffer 容量为100
            ByteBuffer byteBuffer = ByteBuffer.allocate(100);
            System.out.println("请输入字符串");
            Scanner in = new Scanner(System.in);
            String s = in.nextLine();
            //将字符串写入到缓冲区
            byteBuffer.put(s.getBytes());
            System.out.println("写入数据后指针变化-position:" + byteBuffer.position() + " limit：" + byteBuffer.limit() + " capacity :" + byteBuffer.capacity());
            //为输出数据做准备 将limit移动到position位置，position置0
            byteBuffer.flip();
            System.out.println("flip后指针变化-position:" + byteBuffer.position() + " limit：" + byteBuffer.limit() + " capacity :" + byteBuffer.capacity());
            //将缓冲区写入channel
            writeChannel.write(byteBuffer);
            //清除缓冲区 为下次写入或者读取数据做准备 恢复到初始状态 position=0 limit=capacity=100  因为我们这里分配的容量大小为100
            byteBuffer.clear();
            System.out.println("clear后指针变化-position:" + byteBuffer.position() + " limit：" + byteBuffer.limit() + " capacity :" + byteBuffer.capacity());
            //关闭channel
            writeChannel.close();
            FileChannel readChannel = new RandomAccessFile(file, "r").getChannel();
            //从channel中将数据读取到缓冲区
            while (readChannel.read(byteBuffer) != -1) {
                //为读取数据做准备
                byteBuffer.flip();
                //输出数据 设置解码器
                Charset charset = Charset.forName("UTF-8");
                CharsetDecoder decoder = charset.newDecoder();
                System.out.println("读取结果：" + decoder.decode(byteBuffer));
                //清除缓冲区
                byteBuffer.clear();
            }
            readChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}