# 需求场景： 
##求解系数为整数的一元二次方程
### 设计：
    类：EquationRoots
    数据成员：三个整数abc分别表示二次项，一次项，常数项int a,int b,int c。
    成员方法：
        求跟公式int[] getRoot(int a,int b,int c);
        判别式求值  int delta(int a, int b,int c);
    异常：
        1：a=b=0;
        2：判别式<0;

## 一、类的定义：
* 可见修饰符class类名 {<br>
    数据成员<br>
    可能需要定义静态代码块<br>
    成员方法<br>
}

* 数据成员定义<br>
    1.可见修饰符 <br> 数据类型 <br>  变量名<br>成员名（可以需要赋值操作初始化）
成员方法
    可见修饰符   返回的数据类型 方法名（参数列表）{
        注意：方法里面声明变量的时候不要用可见修饰符
}

可见修饰符 类名（参数列表）{
    //构造方法用于对象的初始化
}

可见修饰符有三种类型：public，private，protected
public 到处可见
private 类内部可见
protected 包可见、继承可见
省略的时候，默认是protected


二、类的实例（对象）
    类通过new关键字创建实例，不需要析构，垃圾回收由JVM自动完成
    对象的成员访问通过"."操作符访问
    
三、static关键字
    Math.abs(-3);Math.sqrt(a,b);为什么能这么访问？
        通过了static修饰的成员，可以用过类名+"."+成员    来直接访问，不需要创建对象
    java中对象有两种：一种是class对象（又称类对象），另一种为类的实例（通过new关键字创建），class对象内部含类定义的元数据，class类对象在JVM加载class文件的时候就加载到内存了


3.26本次课内容 
1、继承
    使用关键字 extends
    职责：继承父类中public、protected成员。
    类的组织：
        父类：ParentEquRoot
        子类：ChildEquRoot
    使用关键字 final类不能被继承
    //常用代码输入模板
    关于抽象类 //abstract//
        引入的目的有两点：
            禁止用户创建该类的对象
            含未实现的方法留待后续去实现或留给用户自己去实现
    同时，抽象类中未实现的也要使用abstract修饰。

2、接口
    定义：
        public interface 接口名{
            //1如果有数据成员的话 一定是public static 修饰的数据成员
            //2如果有完整实现的方法，则该方法一定是通过static修饰的
            //方法签名(不再使用abstract修饰，抽象类中抽象方法一定要用abstract修饰)
        }
    新建包：aboutInterface
    新建接口IEquaRoot，内部包含两个方法签名：
        int[]getIntRoot(int a,int b,int c)
        double[]getDoubleRoot(double a, int b,int c)
    接口的实现使用关键字implements，如果接口中有方法没有实现，则该实现类为抽象类，否则需要实现全部的方法。
    接口作用
        统一型 统一规范
    
2021/04/02  
接口衍生内容
内部类
    在一个类的内部再创建一个类
    需求场景：
        一个用户类，包含用户名userName和密码password两个属性，外界能够将数据写入user用户类，也可以获取用户类的相关信息
        有一个学生类student，有用户类的相关特性，同时扩展了用户信息：其中包含学号，并且能够计算自己的每学期三门必修课的平均成绩。
        建一个内部类Worker，他只有一个功能，提供工资总额（基本工资+加班费用+绩效工资）
    设计：
        User
            内部类student其继承user类，求三个实数的平均数IAverage，包含方法签名getAverage()
            数据成员：userName，password均为string类型
            成员方法：get set
        Student：
            student为user类的内部类，实现IAverage的接口
            数据成员：stuNo
            成员方法：IAverage（）
        
匿名内部类

# 为什么去掉返回数组

1. 因为传入的参数是地址，后续的操作都是围绕这个地址中的内容来展开。

2. 浪费了空间
3. 有返回数组的函数，脱离了实际使用需求。

Lunce

ElasticSearch

搜索



# IO

* 阻塞型IO和非阻塞型NIO

* 向管道里面写数据，用输出流write，反之用read
* ==当流到达末尾时，返回-1==
* ![image-20210430142931376](C:\Users\yangshiwei\AppData\Roaming\Typora\typora-user-images\image-20210430142931376.png)
* ![image-20210430142951087](C:\Users\yangshiwei\AppData\Roaming\Typora\typora-user-images\image-20210430142951087.png)
* ![image-20210430143006765](C:\Users\yangshiwei\AppData\Roaming\Typora\typora-user-images\image-20210430143006765.png)
* ![image-20210430143021915](C:\Users\yangshiwei\AppData\Roaming\Typora\typora-user-images\image-20210430143021915.png)
* ![image-20210430143042094](C:\Users\yangshiwei\AppData\Roaming\Typora\typora-user-images\image-20210430143042094.png)
* ![查看源图像](https://pic4.zhimg.com/v2-6bf8bc5b398d688cf8887f79e6c0bd27_r.jpg)
*



# 实例操作

* 按照字节流的方式读取文件内容

1. 根据文件路径，构建文件对象
2. 创建输入流来读取文件内容
3. 创建字节数组来存放读取内容
4. 关闭文件的输入流



## 语言基础

## 项目开发实践

### 分布式平台Spring boost

### Java web :vue,React

###  Tomcat容器

后端：异常，控制，并发，异步，集群

### 多学习第三方框架


运行异常，api异常，业务异常
使用的大致步骤：
    1：定义异常，可以不定义，直接使用JDK中的异常类Exception,也可以定义自己的异常类（需要对输出的异常信息进行定制）
    2：将异常使用到具体的类中，相当于我们在向别人提供开发工具的到时候，设计类时候要考虑的异常情况提醒使用我们开发的API人员注意，有异常，需要捕获，本步关键是要抛出异常
    3：使用API


