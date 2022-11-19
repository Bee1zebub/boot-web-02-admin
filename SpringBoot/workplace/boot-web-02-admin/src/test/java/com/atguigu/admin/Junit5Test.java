package com.atguigu.admin;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

//静态导入


public class Junit5Test {
    /**
     * 断言：前面的断言失败。报错，后面的代码就不会运行
     * 前置条件：前置条件失败，跳过，后面的代码就不会运行
     */

    private final String environment = "DEV";

    @DisplayName("assertion simple")
    @Test
    void testSimpleAssertions(){
        int cal = cal(2, 3);
        assertEquals(6,cal,"计算失败");
        Object obj1 = new Object();
        Object obj2 = new Object();
        assertNotSame(obj1,obj2,"两个对象不一样");
    }

    @Test
    @DisplayName("assertion array")
    public void array() {
        assertArrayEquals(new int[]{1, 2}, new int[] {1, 2});
    }

    int cal(int i,int j){
        return i+j;
    }

    @Test
    @DisplayName("assertion all")
    public void all() {
        //heading:该断言组合的名称
        //Executable... 是一个多个参数的函数式接口
        assertAll("Math",
                () -> assertEquals(2, 1 + 1),
                () -> assertTrue(1 > 0)
        );
    }

    @Test
    @DisplayName("assertion throw")
    public void exceptionTest() {
        //扔出断言异常
        assertThrows(ArithmeticException.class, () -> {int i = 10%0;},"业务逻辑没有数学异常");
    }

    @Test
    @DisplayName("assertion fail")
    public void shouldFail() {
        fail("This should fail");
    }

    @Test
    @DisplayName("assertion timeout")
    public void timeoutTest() {
        //如果测试方法时间超过1s将会异常
        assertTimeout(Duration.ofMillis(1000), () -> Thread.sleep(500));
    }

}
