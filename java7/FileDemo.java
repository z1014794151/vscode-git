import java.io.File;
import java.io.IOException;

public class  FileDemo {
    public static void main(String[] args){
        //同学们可以根据自己的路径进行更改
        File f1 =new
        File("/home/coding/workspace/java7/1.txt");
        //File(String parent,String child)
        File f2 =new File("/home/coding/workspace/java7","2.txt");
        //separator 跨平台分隔符
        File f3 =new File("/home"+File.separator+"coding"+File.separator+"workspace"+File.separator+"java7");
        File f4 =new File(f3,"3.txt");

        try {
             System.out.println(f1);
                //当文件存在时返回 false；不存在时返回 true
                System.out.println(f2.createNewFile());
                //当文件不存在时返回 false
                System.out.println(f3.delete());
        }catch(IOException e) {
                e.printStackTrace();
        }

        //列出磁盘下的文件和文件夹
        File[] files =File.listRoots();
        for(File file:files){
            System.out.println(file);
            if(file.length()>0){
                String[] filenames =file.list();
                for(String filename:filenames){
                    System.out.println(filename);
                }
            }
        }
    }

}