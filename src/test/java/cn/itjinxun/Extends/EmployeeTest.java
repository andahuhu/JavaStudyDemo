package cn.itjinxun.Extends;

import org.junit.Test;

import java.util.Date;

public class EmployeeTest {
    @Test
    public void testPrint(){
        /*Employee employee1 = new Employee();
        employee1.setName("普通员工");
        employee1.setHireDay(new Date());
        employee1.setSalary(1800);*/
        Employee employee1 = new Employee("普通员工",new Date(),1800);
        employee1.printInfo();
        /*Manager manager = new Manager();
        manager.setName("经理");
        manager.setHireDay(new Date());
        manager.setSalary(5400);
        manager.setBonus(1000);*/
        Manager manager = new Manager("经理",new Date(),5400,1000);
        manager.printInfo();
    }
    @Test
    public void testPolymorphic(){//多态
        Employee employee1 = new Employee("普通员工",new Date(),1800);
        Manager manager = new Manager("经理",new Date(),5400,1000);
        System.out.println("我的奖金是"+manager.getBonus());
        MasterManager masterManager = new MasterManager("总经理",new Date(),5400,1000);
        System.out.println("我的奖金是"+masterManager.getBonus());
        Employee employee2;
        employee2 = employee1;
        employee2.printInfo();
        employee2 = manager;
        //System.out.println("我的奖金是"+employee2.getBonus());
        Manager manager1 = (Manager)employee2;
        System.out.println("我的奖金是"+manager1.getBonus());
        employee2.printInfo();
        employee2 = masterManager;
        employee2.printInfo();
        System.out.println(employee2 instanceof MasterManager);
        System.out.println(employee2 instanceof Manager);
        System.out.println(employee2 instanceof Employee);

        System.out.println(manager1 instanceof MasterManager);
        System.out.println(manager1 instanceof Manager);
        System.out.println(manager1 instanceof Employee);

        Object object = new Date();
        if(object instanceof Manager){
            Manager manager2 = (Manager)object;
        }else{
            System.out.println("object不是一个Manager");
        }

    }
}
