
package com.example.myasyntask;

/**
 * 定义一个枚举，两种类型
 * @author jin
 *
 */
public enum TaskMode {

    masync, // 需要和界面交互，用async
    bgTask // 不需要和界面交互，直接起一个后台线程就可以了
}
