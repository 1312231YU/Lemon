package homeworkDirCopy;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
/*
* 使用递归一定要考虑每次调用自己传入的参数格式一样
* */
public class DirCopy {
    public static void main (String[] args) {

        File fileSor=new File("D:\\dddd");
        File fileAim=new File("E:\\新建文件夹");

        CopyFiles(fileSor,fileAim);
    }
    //复制文件的函数
    public static void CopyFiles(File fileSor,File fileAim){
        //首先进行判断目标文件是文件还是文档
        if(fileSor.isFile()){
            //是文档就直接复制
            FileInputStream fis=null;
            FileOutputStream fos=null;
            try {
                fis=new FileInputStream(fileSor);
                fos=new FileOutputStream((fileAim.toString().endsWith("\\") ? fileAim : fileAim+"\\")+fileSor.getName());
                //System.out.println((fileAim.toString().endsWith("\\") ? fileAim : fileAim+"\\")+fileSor.getName());
                byte[] bytes=new byte[1024*1024];
                int byteCount=0;
                while((byteCount=fis.read(bytes))!=-1){
                    fos.write(bytes,0,byteCount);
                }
                fos.flush();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (fis != null) {
                    try {
                        fis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (fos != null) {
                    try {
                        fos.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        if(fileSor.isDirectory()){
            //若是文件夹则创建好新目录
            File newDir=new File((fileAim.toString().endsWith("\\") ? fileAim : fileAim+"\\")+fileSor.getName());
            newDir.mkdirs();
            System.out.println(newDir.getAbsolutePath());
            //获得目标文件下的所有子文件，需要获取目标文件和目的文件路径，然后递归调用本方法
            File[] files=fileSor.listFiles();
            for(File fil:files){
                //获取子文件的目标文件
                File childAim=new File(newDir.getAbsolutePath());
                /*System.out.println("目标路径"+childAim.getAbsolutePath());
                System.out.println("源路径"+fil.getAbsolutePath());*/
                CopyFiles(fil,childAim);
            }
        }
    }
}
