# xtest-testng-demo

将 **testng** 测试结果发送到 **ｘ-utest** 系统的类

## 使用方法：

1. 复制 `com.xutest` 到你的项目中;

2. 在你的 `testng.xml` 文件中按照 `src/com/testng.xml` 的格式添加监听器

```
<listeners>
    <listener class-name="com.xutest.XListener" />
</listeners>
```

3. 修改 `XListener` 类的 `onFinish` 方法中的配置信息(Line 60-63)

4. 以 `testng.xml` 为入口运行你的测试用例.

## 已做工作:

1. 重写 `TestListenerAdapter` 类, 在 `onFinish` 中提取测试结果

2. 编写 `Connect` 类, 实现与 `x-utest` 的握手与结果上传

3. 在 `onFinish` 类中添加上传测试结果操作

## TODOs:

1. 更好的引用方式 (jar包)

2. 提取配置文件

**欢迎懂java的朋友改进代码与项目**

## Author

ityoung@foxmail.com
