package com.topcoder.SRM599;

import static org.junit.Assert.*;

import org.junit.Test;

public class BigFatInteger2Test {

    @Test
    public void test() {
	BigFatInteger2 app = new BigFatInteger2();
	assertEquals(true, app.isDivisible(6, 1, 2, 1));
    }

    @Test
    public void test1() {
	BigFatInteger2 app = new BigFatInteger2();
	assertEquals(false, app.isDivisible(2, 1, 6, 1));
    }

    @Test
    public void test2() {
	BigFatInteger2 app = new BigFatInteger2();
	assertEquals(false,
		app.isDivisible(1000000000, 1000000000, 1000000000, 200000000));
    }

    @Test
    public void test3() {
	BigFatInteger2 app = new BigFatInteger2();
	assertEquals(false, app.isDivisible(8, 100, 4, 200));
    }

    @Test
    public void test4() {
	BigFatInteger2 app = new BigFatInteger2();
	assertEquals(false,
		app.isDivisible(999999937, 1000000000, 999999929, 1));
    }

    @Test
    public void test5() {
	BigFatInteger2 app = new BigFatInteger2();
	assertEquals(true, app.isDivisible(2, 2, 4, 1));
    }

}
