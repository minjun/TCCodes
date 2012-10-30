package com.SRM1;

import static org.junit.Assert.*;

import org.junit.Test;

public class BinaryCodeTest {
	BinaryCode bc = new BinaryCode();
	@Test
	public void test1() {
		assertArrayEquals(bc.decode("123210122"),new String[]{ "011100011",  "NONE" });
	}
	@Test
	public void test2() {
		assertArrayEquals(bc.decode("11"),new String[]{ "01",  "10" });
	}
   @Test
    public void test3() {
    	assertArrayEquals(bc.decode("22111"),new String[]{ "NONE",  "11001" });
    }
    @Test
    public void test4() {
    	assertArrayEquals(bc.decode("3"),new String[]{ "NONE",  "NONE" });
    }
    @Test
    public void test5() {
    	assertArrayEquals(bc.decode("12221112222221112221111111112221111"),new String[]{ "01101001101101001101001001001101001",  "10110010110110010110010010010110010" });
    }
}
