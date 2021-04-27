# JDBC 技术个人笔记



## 1. 数据库连接

### 1.1. 所需元素

* dirverClass

  > mysql : com.mysql.cj.jdbc.Driver

* url

  > mysql8.0之后要在地址最后面加上?useSSL = false&serverTimezone = UTC

* username

* password

## 1.2. 元素存储

* 把四个元素保存在resources文件夹内，提高代码的可复用率，需要更改数据库连接的相关数据就把资源文件里面的数据修改一下
* 文件名：jdbc.properties

### 1.3. JDBCUtils 类

* 文件保存在dbconnect中的util包下，util作为各种工具启动类的集合包



* JDBCUtil类设计

  * getConnection（）函数。用于获取数据库连接，返回类型为Connection

    * 读取配置文件中的四个基本信息
    * 加载驱动
    * 获取连接

  * closeResource（）函数。用于关闭数据库连接和Statement操作，返回类型为 void

    * 如果conn非空，关闭
    * 如果statement非空，关闭
    * 注意：关闭这两个资源非常重要，可以防止sql注入等诸多危险行为，在日常使用数据库操作的时候一定要记得关闭不需要的资源

    

## 2. java与SQL对应数据类型转换表



​						**Java类型**					**SQL类型**

​						boolean					 BIT

​						byte						    TINYINT

​						short						   INTERGER

​						long							 BIGINT

​						String						  CHAR,VARCHAR,LONGVARCHAR

​						byte array				   BINARY,VARBINARY

​						java,sql.Date			   DATE

​						java.sql.Time			   Time

​						java.sql.Timestamp	TIMESTAMP 