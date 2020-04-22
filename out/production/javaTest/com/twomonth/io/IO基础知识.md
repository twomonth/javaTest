[java.io基础知识链接](https://www.cnblogs.com/furaywww/p/8849850.html )





## File 类相关方法

**用于操作文件和文件夹**

---



### 对于文件
- 创建
    1. File（String parent，String child）
    2. File（File parent，String child）
    3. File（String name）没有盘符以 user.dir 为相对目录
    
- getName（）

- getPath（）根据创建的时候的路径决定

- getAbsolutePath（）返回绝对路劲

- getParent（）根据创建时候的父路径决定返回值，返回父路径或者空

- length（） 返回文件大小，如果是 0  表示文件不存在，或者是个文件夹

- exists（）判断文件是否存在

- isFile（）判断是不是文件

- isDirectory（）判断是否为文件夹

- createNewFile（）创建文件（如果文件已经存在，则创建失败）

- delete（）删除文件

    

### 对于文件夹

---



- makedir（）上级目录不存在创建失败

- makedirs（） 上级目录不存在就创建上级目录

- list（）下级名称

- listFiles（）下级File

- listRoots（）根路径

  

## 四大抽象类

**接口，方便操作和辨识**





---



| 抽象类       | 说明                             | 常用方法                                               |
| ------------ | -------------------------------- | ------------------------------------------------------ |
| InputStream  | 字节输入流的父类，数据单位为字节 | int read（）<br />void close（）                       |
| OutputStream | 字节输出流的父类，数据单位为字节 | void write（）<br />void flush（）<br />void close（） |
| Reader       | 字符输人流的父类，数据单位为字符 |                                                        |
| Writer       | 字符输出流的父类，数据单位为字符 |                                                        |

### 基本操作步骤

---

1.创建数据源

2.选择合适的流

3.操作

4.释放资源

