package cn.itjinxun.StringAndArray;

import itjinxun.StringAndArray.ArrayHomeWork;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

public class ArrayTest {
    @Test
    public void test1(){//数组声明
        int[] arr1;
        int arr2[];
        String[] arr3;
        String arr4[];
    }

    @Test
    public void test2(){//数组初始化
        //方式1
        int[] arr1 = new int[3];
        System.out.println(Arrays.toString(arr1));
        boolean arr2[] = new boolean[2];
        System.out.println(Arrays.toString(arr2));
        Object[] arr3 = new Object[5];
        System.out.println(Arrays.toString(arr3));
        String[] arr4;
        arr4 = new String[4];
        System.out.println(Arrays.toString(arr4));
        //方式2
        int[] arr5 = new int[]{1,2,3};
        System.out.println(Arrays.toString(arr5));
        //方式3
        int[] arr6 = {1,2,3};
        System.out.println(Arrays.toString(arr6));
        String[] arr7 = new String[]{"hello",null,"world",""};
        System.out.println(Arrays.toString(arr7));
        Integer[] arr8 = {null,3,5,0};
        System.out.println(Arrays.toString(arr8));
    }

    @Test
    public void test3(){//数组遍历
        Integer[] arr = {1,2,3,4,5};
        //方式1
        for (int i = 0; i < arr.length; i++) {
            System.out.println(String.format("下标：%d 存放的值是 %d",i,arr[i]));
        }
        //方式2
        int index = 1;
        for (int i : arr) {
            System.out.println(String.format("第 %d 次取到的值是 %d",index,i));
            index++;
        }
        //方式3 拉姆达表达式
        Arrays.asList(arr).forEach(val -> {
            System.out.println("值是：" + val);
        });
    }
    @Test
    public void test4() {//数组拷贝
        Integer[] arr1 = {1,2,3,4,5};
        Integer[] arr2 = {6,7,8,9,10};
        //常规复制
        Integer[] arr3 = new Integer[3];
        arr3[0] = arr1[0];
        arr3[1] = arr1[1];
        arr3[2] = arr1[2];
        System.out.println("arr3 = " + Arrays.toString(arr3));
        //Array的copyOf方法
        Integer[] arr4 = Arrays.copyOf(arr1,3);
        System.out.println("arr4 = " + Arrays.toString(arr4));
        //拷贝数组arr1的后三位元素到一个新的数组
        Integer[] arr5 = Arrays.copyOfRange(arr1,arr1.length-3,arr1.length);
        System.out.println("arr5 = " + Arrays.toString(arr5));

        //拷贝数组arr1的第1位到第3位的元素（不包括第3位）
        Integer[] arr6 = Arrays.copyOfRange(arr1,0,2);
        System.out.println("arr6 = " + Arrays.toString(arr6));

        //拷贝数组arr1的后3位到arr2的后3位
        System.arraycopy(arr2,arr2.length-3,arr1,arr1.length-3,3);
        System.out.println("arr1 = " + Arrays.toString(arr1));
    }

    @Test
    public void test5() {//数组填充
        //示例：定义一个大小为 10 的 int 数组，并将数组全部初始化为指定的值 5，打印数组；
        int[] arr1 = new int[10];
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = 5;
        }
        System.out.println("arr1 = " + Arrays.toString(arr1));
        //然后将数组后 3 位赋值为 3，再次打印数组。
        for (int i = arr1.length-1; i >= arr1.length-3; i--) {
            arr1[i] = 3;
        }
        System.out.println("arr1 = " + Arrays.toString(arr1));
        //方式2
        int[] arr2 = new int[10];
        Arrays.fill(arr2,5);
        System.out.println("arr2 = " + Arrays.toString(arr2));
        Arrays.fill(arr2,arr2.length-3,arr2.length,3);
        System.out.println("arr2 = " + Arrays.toString(arr2));
    }

    @Test
    public void test6() {//数组排序
        //示例：定义一个大小为 100 的 int 数组，
        int[] arr = new int[100];
        //随机给每一位赋值一个 `0 ~ 100` 之间的数值，
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Random().nextInt(100);
        }
        System.out.println("arr = " + Arrays.toString(arr));
        //然后对该数组进行排序并打印排序结果。
        Arrays.sort(arr);
        System.out.println("arr = " + Arrays.toString(arr));
    }

    @Test
    public void test7() {//多维及不规则数组
        //示例：定义一个二维数组，
        //第一维表示用户，
        //第二维表示用户的具体信息（1. 编码, 2. 姓名, 3.性别, 4.年龄）。
        //定义赋值并打印。
        String[][] users = new String[3][];
        users[0] = new String[4];
        users[0][0] = "001";
        users[0][1] = "张三";
        users[0][2] = "男";
        users[0][3] = "13";

        users[1] = new String[3];
        users[1][0] = "002";
        users[1][1] = "李四";
        users[1][2] = "男";
        //users[1][3] = "未知";
        for (int i = 0; i < users.length; i++) {
            System.out.println("users["+i+"] = " + Arrays.toString(users[i]));
        }
    }
    @Test
    public void testTwoSum(){//课后练习测试验证
        int[] test = {123,20,31,4,55,16,27,8,19,109};
        int[] result = ArrayHomeWork.twoSum(test,24);
        System.out.println("result = " + Arrays.toString(result));
    }
}
