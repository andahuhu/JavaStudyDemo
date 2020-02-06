package cn.itjinxun.Extends;

import org.junit.Test;

public class CopyTest {
    @Test
    public void testCopy() throws Exception {
        Employee employee = new Employee();
        Employee e2 = employee.clone();
    }
}
