package club.banyuan;

import org.junit.Assert;

public class PairUtilTest {

    @org.junit.Test
    public void swap() {
        Pair<Integer> pair = new Pair<>(5, 10);
        //PairUtil.swap(pair);
        Assert.assertEquals(10, pair.getSecond().intValue());
        Assert.assertEquals(5, pair.getFirst().intValue());
    }

    @org.junit.Test
    public void test() {
        Country[] countries = new Country[]{new Country(1000), new Country(800), new Country(100), new Country(10000)};
        Pair<Country> pair = PairUtil.minMax(countries);
        Assert.assertEquals( 10000, pair.getSecond().getMeasure(),0);
        Assert.assertEquals(100, pair.getFirst().getMeasure(), 0);
    }

    @org.junit.Test
    public void testMinmax() {
        Integer[] list = new Integer[]{1, 5, 7, 10, 50, 55, 0};
        Pair<Integer> pair = PairUtil.minMax(list);
        Assert.assertEquals(55, pair.getSecond().intValue());
        Assert.assertEquals(0, pair.getFirst().intValue());
    }
}
