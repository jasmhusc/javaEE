package com.hsc.demo9;

/**
 * 1.代理模式四要素
 * 调用者: 你
 * 真实对象: 真正调用功能的对象(12306)
 * 代理对象: 在调用者和真实对象之间的对象(黄牛)
 * 抽象对象: 代理对象和真实对象都要实现的接口
 * 2. 动态代理在程序运行的过程中,动态的创建出代理对象
 * 3. 优点：在不修改方法源码的情况下，拦截对真实对象方法的直接访问，增强真实对象方法的功能
 * 4. 动态代理的API
 * Proxy类: proxy翻译为代理
 * static Object newProxyInstance​(ClassLoader loader, Class<?>[] interfaces, InvocationHandler h)
 * 创建一个代理对象
 * ClassLoader loader: 类加载器
 * Class<?>[] interfaces: 接口数组,创建出的代理对象就会实现这些接口
 * InvocationHandler h: 调用处理器,当执行代理对象的方法时,就会执行这个对象的方法
 * Object返回值:就是创建出的代理对象
 */
public class ProxyIntro {
}
