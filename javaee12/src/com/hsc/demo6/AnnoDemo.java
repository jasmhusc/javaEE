package com.hsc.demo6;

import org.junit.Test;

/**
 * 使用自定义注解格式:
 *
 * @注解名(属性名=属性值, 属性名=属性值)
 * 注意: 注解的每个属性都要有值
 * 注解属性可以设置默认值,可以不用给这个属性赋值会使用默认值
 * 特殊写法：
 * 1. 只有一个属性且名为“value”的，使用时可以直接给值
 * 2. 注解的其他属性都有默认值
 */
@MyAnno(name = "李华", scores = {98, 97, 100})
public class AnnoDemo {

    @MyAnno(name = "王晓静", scores = {88, 97, 75})
    public static void main(String[] args) {

    }

    @Test
    private void test() {
    }
}
