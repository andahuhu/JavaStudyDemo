package cn.itjinxun.ClassObject;

import org.junit.Test;

//import java.util.Arrays;
//import java.util.Date;
import java.util.*;
import java.util.zip.ZipFile;

public class PackageTeat {
    @Test
    public void testPkg(){
        java.util.Date date1 = new java.util.Date();
        System.out.println(date1.toString());
        Date date2 = new Date();
        System.out.println(date2.toString());
        int[] nums = {1,2,3};
        System.out.println(Arrays.toString(nums));
        java.util.zip.ZipFile zipFile;

    }
}
