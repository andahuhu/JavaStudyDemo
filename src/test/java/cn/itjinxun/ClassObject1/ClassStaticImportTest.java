package cn.itjinxun.ClassObject1;

import cn.itjinxun.ClassObject.ClassStaticImport;
import static cn.itjinxun.ClassObject.ClassStaticImport.name;
import static cn.itjinxun.ClassObject.ClassStaticImport.println;
import org.junit.Test;

public class ClassStaticImportTest {
    @Test
    public void testStaticImport(){
        System.out.println(ClassStaticImport.name);
        ClassStaticImport.println();
    }

    @Test
    public void testStaticImport2(){
        System.out.println(name);
        println();
    }
}
