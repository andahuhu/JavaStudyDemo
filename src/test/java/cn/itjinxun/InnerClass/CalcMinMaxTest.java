package cn.itjinxun.InnerClass;

import itjinxun.InnerClass.CalcMinMax;
import org.junit.Test;

public class CalcMinMaxTest {
    @Test
    public void testCalcMinMax(){
        /*int[] result = CalcMinMax.calc(1,3,2,9,30,7,2);
        System.out.println(Arrays.toString(result));
        System.out.println("最小值：" + result[0]);
        System.out.println("最大值：" + result[1]);*/
        int[] param = {1,3,2,9,30,7,2};
        CalcMinMax.Pair result = CalcMinMax.calc2(param);
        System.out.println("最小值：" + result.getMinValue());
        System.out.println("最大值：" + result.getMaxValue());

        //CalcMin.calc().getMin();

    }
}
