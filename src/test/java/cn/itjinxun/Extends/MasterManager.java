package cn.itjinxun.Extends;

import java.util.Date;

public class MasterManager extends Manager {

    public MasterManager(String name, Date hireDay, Integer salary, Integer bonus){
        super(name,hireDay,salary,bonus);
        System.out.println("执行MasterManager有参数的构造器");
    }

    @Override
    public String getName(){
        return "【"+super.getName()+"】";
    }
}
