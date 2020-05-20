package club.banyuan;

import org.junit.Assert;
import org.junit.Test;

/**
 * 提供合适的测试类以确保其按预期工作。
 */
public class largestStadiumTest {

    @Test
    public void test() {
        ObjectPair[] stadiums = new ObjectPair[3];
        stadiums[0] = new ObjectPair("五棵松", 25000);
        stadiums[1] = new ObjectPair("鸟巢", 109901);
        stadiums[2] = new ObjectPair("奥体中心", "66,233");

        Assert.assertEquals(stadiums[1].getFirst().toString(),ObjectPairDriver.largestStadium(stadiums));


    }
}
