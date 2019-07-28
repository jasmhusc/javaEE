package com.hsc.demo1;

import org.junit.*;

/*
    @Before: 在每个测试方法前执行
    @After: 在每个测试方法后执行
    @BeforeClass: 在所有测试方法前执行  必须为static
    @AfterClass: 在所有测试方法后执行   必须为static
 */
public class TestJunite {
    @Before
    public void testBefore() {
        System.out.println("before:在每个测试方法前执行");
    }

    @After
    public void testAfter() {
        System.out.println("After:在每个测试方法后执行");
    }

    @Test
    public void test1() {
        System.out.println("test1");
    }

    @Test
    public void test2() {
        System.out.println("test2");
    }

    @AfterClass
    public static void testAfterClass() {
        System.out.println("AfterClass: 在所有测试方法后执行");
    }

    @BeforeClass
    public static void testBeforeClass() {
        System.out.println("BeforeClass: 在所有测试方法前执行");
    }
}
