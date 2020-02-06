package cn.itjinxun.Extends;

import java.util.Date;

public class Employee extends Object implements Cloneable {
    private String name;
    private Date hireDay;
    private Integer salary;
    public Employee(){
        System.out.println("执行Employee无参数的构造器");
    }
    public Employee(String name,Date hireDay,Integer salary){
        this.name = name;
        this.hireDay = hireDay;
        this.salary = salary;
        System.out.println("执行Employee有参数的构造器");
    }
    public String getName() {
        return name;
    }

    public final void setName(String name) {
        this.name = name;
    }

    public final Date getHireDay() {
        return hireDay;
    }

    public final void setHireDay(Date hireDay) {
        this.hireDay = hireDay;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public void printInfo(){
        StringBuilder tmp = new StringBuilder();
        tmp.append("姓名：");
        tmp.append(getName());
        tmp.append("入职时间：");
        tmp.append(getHireDay());
        tmp.append("薪水：");
        tmp.append(getSalary());
        System.out.println(tmp.toString());
    }

    @Override
    protected Employee clone() throws CloneNotSupportedException {
        return (Employee)super.clone();
    }
}
