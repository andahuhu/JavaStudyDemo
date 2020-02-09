package itjinxun.InnerClass.Temp;

import itjinxun.InnerClass.Pair;

public class CalcMin {
    public static Pair/* CalcMinMax.Pair */ calc(int... numbs){
        Integer min = null;
        for (int num : numbs){
            if(min == null ||min.intValue() > num){
                min = num;
            }
        }
        //return new CalcMinMax.Pair(min,-1);
        return new Pair(min,-1);
    }
}
