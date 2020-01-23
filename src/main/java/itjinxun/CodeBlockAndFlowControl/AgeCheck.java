package itjinxun.CodeBlockAndFlowControl;

public class AgeCheck {
    /*
     *    |年龄范围    |描述         |
     *    |-----------|------------|
     *    |0 ~ 6岁     |儿童 |
     *    |7 ~ 17岁    |少年 |
     *    |18 ~ 40岁   |青年 |
     *    |41 ~ 59岁   |中年 |
     *    |60及以上     |老年 |
     * */
    public static String getAgeName(int age){
        if(age <= 6){
            return "儿童";
        } else if (age >= 7 && age <= 17 ){
            return "少年";
        } else if (age >= 18 && age <= 40 ){
            return "青年";
        } else if (age >= 41 && age <= 59 ){
            return "中年";
        } else if (age >= 60 && age < 200){
            return "老年";
        } else {
            return "异常年龄";
        }
    }
}
