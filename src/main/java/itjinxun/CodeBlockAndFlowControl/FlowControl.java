package itjinxun.CodeBlockAndFlowControl;

public class FlowControl {
    /*
    *    |年龄范围    |描述         |
    *    |-----------|------------|
    *    |0 ~ 6岁     |儿童 |
    *    |7 ~ 17岁    |少年 |
    *    |18 ~ 40岁   |青年 |
    *    |41 ~ 59岁   |中年 |
    *    |60及以上     |老年 |
    * */
    public void decideAge(int age){
        if(age <= 6){
            System.out.println(age + "岁，属于儿童");
        } else if (age >= 7 && age <= 17 ){
            System.out.println(age + "岁，属于少年");
        } else if (age >= 18 && age <= 40 ){
            System.out.println(age + "岁，属于青年");
        } else if (age >= 41 && age <= 59 ){
            System.out.println(age + "岁，属于中年");
        } else if (age >= 60 && age < 200){
            System.out.println(age + "岁，属于老年");
        } else {
            System.out.println(age + "岁，不是一个合理的年龄");
        }
    }

    /*
     *       |数字指令    |执行命令
     *       |----------|--------|
     *       |1  |扫地
     *       |2  |开灯
     *       |3  |关灯
     *       |4  |播放音乐
     *       |5  |关闭音乐
     *       |其他数字  |不能识别的指令
     * */
    public void receiveOrder(int order){
        switch (order) {
            case 1 :
                System.out.println("扫地");
                break;
            case 2 :
                System.out.println("开灯");
                break;
            case 3 :
                System.out.println("关灯");
                break;
            case 4 :
                System.out.println("播放音乐");
                break;
            case 5 :
                System.out.println("关闭音乐");
                break;
            default :
                System.out.println("不能识别的指令");
                break;
        }
    }
    /*
     *       编写一个方法 `int getMaxNumRem7(int n1, int n2)`
     *       找出 `0 ~ n2` 范围内除以 n1 余 7 的最大的数
     *       找到则返回该数，如果找不到则返回 -1
     * */
    public int getMaxNumRem7(int n1, int n2){
        for(int n = n2;n>=0;n--){
            if(n%n1 == 7){
                return n;
            }
        }
        return -1;
    }
}
