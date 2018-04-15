# xtest-testng-demo

将 **testng** 测试结果发送到 **ｘ-utest** 系统的类

## 依赖:

- fastjson

- testng

## 使用方法：

1. 复制 `com.xutest` 到你的项目中;

2. 在你的 `testng.xml` 文件中按照 `src/com/testng.xml` 的格式添加监听器

**注意: listener标签需要添加在suite标签下内, test标签之前**

```
<listeners>
    <listener class-name="com.xutest.XListener" />
</listeners>
```

3. 修改 `xutest.properties` 配置文件中的信息为你搭建的 xutest系统 中的信息;

4. 以 `testng.xml` 为入口运行你的测试用例.

## 已做工作:

1. 重写 `TestListenerAdapter` 类, 在 `onFinish` 中提取测试结果

2. 编写 `Connect` 类, 实现与 `x-utest` 的握手与结果上传

3. 在 `onFinish` 类中添加上传测试结果操作

4. 提取配置文件到 `xutest.properties` 中, 通过 `PropertiesReader` 类读取配置信息 (18-04-15)

## TODOs:

1. 更好的引用方式 (jar包)

~~2. 提取配置文件~~

**欢迎懂java的朋友改进代码与项目**

## 相关链接:

- [x-utest Docker-compose](https://github.com/x-utest/xtest-docker-compose)

- [TestNG Doc](http://testng.org/doc/)

- [TestNG jar package download](http://mvnrepository.com/artifact/org.testng/testng)

- [fastjson Github](https://github.com/alibaba/fastjson)

- [fastjson jar package download](http://repo1.maven.org/maven2/com/alibaba/fastjson/)

## Author

ityoung@foxmail.com
