package cn.itjinxun.JavaIO;

import org.junit.Test;

import java.io.*;
import java.util.Arrays;

public class FileTest {
    @Test
    public void test1(){//创建目录
        //在创建file对象时，这就是一个对象，没有读取文件，也不会校验文件是否存在
        //File file1 = new File("文件的全路径");
        //File file2 = new File("文件的路径","文件名");
        //路径：
        //  1、Windows中：\\
        //  2、Linux中：/
        //File file = new File("E:\\学习\\测试");
        File file = new File("E:\\学习\\测试\\1\\2");
        //没有那个规定文件一定要有后缀
        System.out.println(file.exists());//判断文件是否存在
        if(!file.exists()){
            boolean b1 = file.mkdir();//创建目录时,父目录不存在时，不会创建,并返回false
            System.out.println("mkdir = " + b1);
            boolean b2 = file.mkdirs();//创建目录时,父目录不存在时，同时创建父目录
            System.out.println("mkdirs = " + b2);
        }
    }

    @Test
    public void test2() throws IOException {//创建文件
        File file = new File("E:\\学习\\测试","测试1.txt");
        if(!file.exists()){
            boolean b1 = file.createNewFile();
            System.out.println("createNewFile = "+b1);
        }
    }

    @Test
    public void test3(){//判断是否是文件/目录
        File file1 = new File("E:\\学习\\测试");
        File file2 = new File("E:\\学习\\测试","测试1.txt");
        System.out.println(file1.isDirectory());
        System.out.println(file1.isFile());
        System.out.println(file1.isDirectory());
        System.out.println(file1.isFile());
    }

    @Test
    public void test4() {//获取路径
        //File file = new File("E:\\学习\\测试","测试1.txt");
        File file = new File("E:\\学习\\测试");
        System.out.println(file.getPath());//通常是需要找到在容器中的位置，在web当中有专门的方法，不推荐用
        System.out.println(file.length());//获取的是字节长度
        String[] fileList = file.list();
        System.out.println(Arrays.toString(fileList));
    }

    //以程序作为参照物
    @Test
    public void test5() throws IOException {//使用输入流操作文件
        File file = new File("E:\\学习\\测试","测试1.txt");
        long len1 = file.length();
        //注意：这只是个Demo，只是为了熟悉字节输入流，生产不常用
        InputStream inputStream = new FileInputStream(file);
        int len2 = inputStream.available();//获取可读数据的大小（单位字节）
        byte[] bytes = new byte[len2];
        //inputStream.read() 一次读一个字节，每次调用，自动读取下一字节
        int temp = -1;
        int index = 0;
        while((temp = inputStream.read()) != -1){
            bytes[index] = (byte) temp;
            index++;
        }
       //inputStream.read(bytes);//输入流将直接写入内存地址（太粗暴，一次性把所有数据都读进来）
        String str = new String(bytes,"GBK");
        System.out.println(str);
        inputStream.close();
    }

    //以程序作为参照物
    @Test
    public void test6() throws IOException {//使用输出流操作文件
        File file = new File("E:\\学习\\测试","测试1.txt");
        //输出流，是覆盖源文件里的内容，不是追加
        String str = "中国加油，武汉加油，fighting 123456！";
        OutputStream out = new FileOutputStream(file);
        //获取字符串字节数组
        byte[] bytes = str.getBytes();
        for(byte b : bytes){
            out.write(b);
        }
        out.flush();//把缓冲器的数据推送到输出流里（看数据量）
        out.close();
    }
}
