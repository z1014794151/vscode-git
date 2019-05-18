// FileDemo.java
import java.io.IOException;
import java.io.RandomAccessFile;

public class  RandomFile {
    public static void main(String[] args){

            int data_arr[] = {12, 32, 43, 45, 1, 5};
            try {
                RandomAccessFile randf=new RandomAccessFile("temp.dat","rw");
                for(int i = 0; i < data_arr.length; i++){
                    randf.writeInt(data_arr[i]);
                }
                for(int i = data_arr.length-1 ; i >= 0; i--){
                    //int 数据占4个字节
                    randf.seek(i * 4L);
                    System.out.println(randf.readInt());
                }
                randf.close();
            }catch(IOException e){
                System.out.println("File access error" + e);
            }
    }
}