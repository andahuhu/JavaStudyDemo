package cn.itjinxun.Collection;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class MapSimpleUse {
    @Test
    public void test1(){
        //Map 键值对，包括键值、值；
        //可以通过键值快速找到对应的值
        //示例：
        //001 --> {name:张三,age:20 ...}
        //002 --> {name:李四,age:22 ...}
        //特性：
        //1、键值不能重复
        //2、put方法如果键值已经存在，那么就会使用新值替换旧值
        //3、键值可以为null？可以
        //4、值可以为null？可以
        Map<Integer,String> map = new HashMap<>();
        String putRet1 = map.put(1,"张三，20");
        System.out.println(putRet1);
        String putRet2 = map.put(1,"李四，20");
        System.out.println(putRet2);
        map.put(2,"王五，20");
        String str = map.get(1);
        System.out.println(str);

        for (Map.Entry<Integer, String> entry : map.entrySet()){
            System.out.println(entry.getKey()+"="+entry.getValue());
        }
        map.put(null,"没有人");
        map.put(null,"没有人2");
        map.put(null,null);
        map.put(3,null);
        map.remove(2);
        System.out.println(map);
    }
}
