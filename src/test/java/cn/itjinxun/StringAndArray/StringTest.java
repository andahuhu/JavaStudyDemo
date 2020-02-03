package cn.itjinxun.StringAndArray;

import org.junit.Test;

public class StringTest {
    @Test
    public void test1(){//String初始化
        String str1 = "hello";
        String str2 = "hello";
        System.out.println(str1 == str2);

        String str3 = "hello world";
        String str4 = str1 + " world";
        System.out.println(str3 == str4);

        String str5 = new String("hello");
        String str6 = new String("hello");
        System.out.println("str5 = str6,"+ (str5 == str6));

        String str7 = str6.intern();
        String str8 = new String("hello").intern();
        System.out.println("str7 = str8,"+ (str7 == str8));
    }

    @Test
    public void test2(){//String长度
        String str = "hello,\uD835\uDD5D\uD835\uDD60\uD835\uDD60\uD835\uDD5C";
        System.out.println(str);
        System.out.println("length is: " + str.length());
        System.out.println("code point count is: " + str.codePointCount(0, str.length()));
    }

    @Test
    public void test3(){//字符串subString方法
        String str = "hello,china";
        String str1 = str.substring(7,str.length());
        String str2 = str.substring(7);
        System.out.println(str1);
        System.out.println(str2);
        String str3 = str.substring(7,str.length()-1);
        System.out.println(str3);
    }

    @Test
    public void test4(){//字符串拼接
        String str = "hello"+",world";
        str += "."+"2019";
        System.out.println(str);
    }

    @Test
    public void test5(){//字符串格式化
        System.out.printf("大写a: %C %n",'A');
        String str1 = "大写a: "+'A'+" "+"\n";
        System.out.printf(str1);
        String str2 = String .format("大写a: %C %n",'A');
        System.out.printf(str2);
    }

    @Test
    public void test6(){//字符串equals方法
        String str1 = "hello";
        String str2 = "hello";
        System.out.println(str1.equals(str2));
        System.out.println(str1.equalsIgnoreCase(str2));
    }

    @Test
    public void test7(){//字符串前缀后缀判断方法
        String str1 = "hello";
        System.out.println(str1.startsWith("he"));
        System.out.println(str1.startsWith("hel"));
        System.out.println(str1.startsWith("h el"));
        System.out.println(str1.startsWith("a"));
        System.out.println(str1.endsWith("llo"));
        System.out.println(str1.endsWith("o"));
        System.out.println(str1.endsWith("ll o"));
        System.out.println(str1.contains("llo"));
        System.out.println(str1.contains("elo"));
        System.out.println(str1.contains("hello"));
    }

    @Test
    public void test8(){//字符串查找指定字符出现的位置方法
        String str1 = "hello . world .today is Friday . say hello to me";
        /*int index = str1.indexOf("o");
        System.out.println(index);*/
        int index = 0;
        while (true) {
            int at1 = str1.indexOf("o",index);
            if(at1 == -1){
                break;
            }
            index = at1+1;
            System.out.println(String.format("第 %d 位是小写字母o",index));

        }

        index = str1.length();
        while (true) {
            int at1 = str1.lastIndexOf("o",index);
            if(at1 == -1){
                break;
            }
            index = at1-1;
            System.out.println(String.format("第 %d 位是小写字母o",at1+1));

        }
    }

    @Test
    public void test9(){//字符串替换方法
        String str1 = "hello , world";
        System.out.println(str1.replace('o','O'));
        System.out.println(str1.replace("o","O"));
        System.out.println(str1.replaceAll("l","L"));
    }

    @Test
    public void test10(){//字符串去空格和大小写转换方法
        String str1 = "          hello , wo    rld        ";
        System.out.println(str1.trim());
        System.out.println(str1.trim().toLowerCase());
        System.out.println(str1.trim().toUpperCase());
    }

    @Test
    public void test11(){//String，StringBuilder,StringBuffer
        String str1 = "hello";
        str1 += ",";
        str1 += "world";
        str1 += ".";
        System.out.println(str1);

        StringBuilder sb1 = new StringBuilder();
        sb1.append("hello");
        sb1.append(",");
        sb1.append("world");
        sb1.append(".");
        System.out.println(sb1.length());
        System.out.println(sb1.toString());
        sb1.setLength(10);
        System.out.println(sb1.toString());
        sb1.setLength(20);//控制台在打印时不显示，但是选中控制台会有空白占位符
        System.out.println(sb1.toString());

        StringBuffer sb2 = new StringBuffer();
        sb2.append("hello");
        sb2.append(",");
        sb2.append("world");
        sb2.append(".");
        System.out.println(sb2.length());
        System.out.println(sb2.toString());
        sb2.setLength(16);
        System.out.println(sb2.toString());
        sb2.setLength(12);
        System.out.println(sb2.toString());
        sb2.setLength(10);
        System.out.println(sb2.toString());
    }
    @Test
    public void test12(){//String拼接的JVM优化1
        //优化前
        String str1 = "hello" + "," + "world";
        System.out.println(str1);
        //优化后
        String str2 = "hello,world";
        System.out.println(str2);
    }

    @Test
    public void test13(){//String拼接的JVM优化2
        //优化前
        String str1 = "hello";
        String str2 = str1 + ",world";
        System.out.println(str2);
        //优化后
        String str3 = "hello";
        StringBuilder sb1 = new StringBuilder();
        sb1.append(str3);
        sb1.append(",world");
        System.out.println(sb1.toString());
    }

    @Test
    public void test14(){//String拼接的JVM优化3
        //优化前
        long start = System.currentTimeMillis();
        String str = "";
        for (int i = 0; i < 20000; i++) {
            str += i;
        }
        System.out.println(str.length());
        System.out.println(System.currentTimeMillis()-start);
        //JVM优化后
        start = System.currentTimeMillis();
        str = "";
        for (int i = 0; i < 20000; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(i);
            str = sb.toString();
        }
        System.out.println(str.length());
        System.out.println(System.currentTimeMillis()-start);
        //我们自己优化代码后
        start = System.currentTimeMillis();
        str = "";
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        for (int i = 0; i < 20000; i++) {
            sb.append(i);
        }
        System.out.println(sb.length());
        System.out.println(System.currentTimeMillis()-start);
    }
}
