package cn.itjinxun.FileAndXML;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;
import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;

public class FileUtils {
    /***
     * 获取指定目录下的所有的文件（包括文件夹），生成对应XML节点，采用了递归
     * @param File file
     * @param Element element
     * @return
     */
    public static void getListFiles(File file, Element element) {
        //获取文件名
        String fileName = file.getName();
        //获取文件大小
        Long size = file.length();
        //子目录
        Element child;
        if (file.isFile()) {
            //如果是文件，生成子节点，结束
            String name = fileName.substring(0,fileName.lastIndexOf(".") - 1);
            String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);
            child = element.addElement(name);
            child.addAttribute("type",suffix);
            child.addAttribute("size",size+"");
        } else if (file.isDirectory()) {
            //如果是目录，生成子节点，继续递归调用
            child = element.addElement(fileName);
            child.addAttribute("type","目录");
            child.addAttribute("size","0");
            File[] fileArr = file.listFiles();
            for (int i = 0; i < fileArr.length; i++) {
                File fileOne = fileArr[i];
                getListFiles(fileOne,child);
            }
        }
    }

    /***
     * 根据指定路径，生成对应XML文件
     * @param String file
     * @return
     */
    public static void getXmlFile(String path) throws Exception {
        File file = new File(path);
        if(file.exists()){
            //获取文件名
            String fileName = file.getName();
            //获取文件大小
            Long size = file.length();
            //创建Document对象
            Document document = DocumentHelper.createDocument();
            Element root;
            if (file.isFile()) {
                //如果是文件，生成子节点，结束
                String name = fileName.substring(0,fileName.lastIndexOf(".") - 1);
                String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);
                root = document.addElement(name);
                root.addAttribute("type",suffix);
                root.addAttribute("size",size+"");
            }else if(file.isDirectory()){
                //如果是目录，生成子节点，继续递归调用
                root = document.addElement(fileName);
                root.addAttribute("type","目录");
                root.addAttribute("size","0");
                File[] fileArr = file.listFiles();
                for (int i = 0; i < fileArr.length; i++) {
                    File fileOne = fileArr[i];
                    getListFiles(fileOne,root);
                }
            }
            // 5、设置生成xml的格式
            OutputFormat format = OutputFormat.createPrettyPrint();
            // 设置编码格式
            format.setEncoding("UTF-8");


            // 6、生成xml文件
            File newFile = new File("D:\\result.xml");
            XMLWriter writer = new XMLWriter(new FileOutputStream(newFile), format);
            writer.write(document);
            writer.close();
        }
    }

    @Test
    public void testCreateXml() throws Exception {
        getXmlFile("D:\\BaiduNetdiskDownload\\day13");
    }
}
