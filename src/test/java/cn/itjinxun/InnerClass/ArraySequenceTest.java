package cn.itjinxun.InnerClass;

import itjinxun.InnerClass.ArraySequence;
import itjinxun.InnerClass.Selector;
import org.junit.Test;

public class ArraySequenceTest {
    @Test
    public void testArraySequence(){
        ArraySequence as = new ArraySequence(5);
        as.add(1);
        as.add(2);
        as.add(3);
        as.print();
        as.add(4);
        as.add(5);
        as.add(6);
        as.print();

        //ArraySequence.SelectorImpl impl = as.new ArraySequence.SelectorImpl();
        boolean reverse = true;
        Selector impl;
        if(reverse){
            System.out.println("倒序");
            impl = as.selectorReverse();
        }else{
            System.out.println("正序");
            impl = as.selector();
        }

        while(!impl.end()){
            System.out.println(">" + impl.current());
            impl.next();
        }
    }
}
