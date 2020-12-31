import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileIOTest2 {
    public static void main(String[] args) {
        BufferedReader bis=null;
        try {
            FileReader fr = new FileReader("D:\\test.txt");
            bis=new BufferedReader(fr);
            String s=null;
            while((s=bis.readLine())!=null){
                System.out.println(s);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        BufferedInputStream biss=null;
        try {
            FileInputStream fis=new FileInputStream("D:\\test.txt");
            biss=new BufferedInputStream(fis);
            int ss=0;
            byte[] bytes=new byte[1024];
            while((ss=biss.read(bytes))!=-1){
                System.out.println(new String(bytes,0,ss));

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (biss != null) {
                try {
                    biss.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        PrintStream ps=System.out;
        ps.println("kk");
        ps.println("hhh");
        ps.println("hggf");
        ps.println(1234);

        //更改printstream输出方向，输出到特定文件中，可以用来作为日志文件
        try {
            System.setOut(new PrintStream(new FileOutputStream("D:\\test.txt",true)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Date date=new Date();
        SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd HH-mm-ss SSS");
        String s=sf.format(date);

        System.out.println(s+"hhhh");
        System.out.println(s+"dd");
        System.out.println(s+"cc");
        System.out.println(s+"22");
    }
}
