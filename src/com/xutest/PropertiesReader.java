package com.xutest;


import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

public class PropertiesReader {

    //读取配置文件, 加载配置文件到Properties
    public static Properties getProperties() throws IOException{
        //创建一个Properties
        Properties properties = new Properties();
        //建立输入字符流对象
        FileReader fileReader = new FileReader("src/xutest.properties");
        //加载配置文件的数据到Properties
        properties.load(fileReader);
        return properties;
    }
}