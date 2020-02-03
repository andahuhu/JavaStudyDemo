package cn.itjinxun.Utils;

import itjinxun.Utils.StringUtils;
import org.junit.Assert;
import org.junit.Test;

public class StringUtilsTest {
    @Test
    public void testTrimAll(){
        String str = "hello";
        Assert.assertEquals(StringUtils.trimAll("     hello"),str);
        Assert.assertEquals(StringUtils.trimAll("hello    "),str);
        Assert.assertEquals(StringUtils.trimAll("     hel    lo"),str);
        Assert.assertEquals(StringUtils.trimAll("he   llo      "),str);
        Assert.assertEquals(StringUtils.trimAll("     h el l    o     "),str);

        Assert.assertEquals(StringUtils.reverse("hello"),"olleh");
    }
}
