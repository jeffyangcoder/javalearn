package com.ecc.javalanguage.dbconnect.dao;

import com.ecc.javalanguage.dbconnect.bean.Customers;

import java.sql.Connection;
import java.util.Date;
import java.util.List;

public interface CustomerDAO {
    /*
     * @Description 讲customer对象添加到数据库中
     * @author yangshiwei
     * @date 2021/5/2 22:38
 * @param conn
 * @param customer
     */
    void insert(Connection conn, Customers customer);

    /*
     * @Description 针对指定的id ，删除表中的一条记录
     * @author yangshiwei
     * @date 2021/5/2 22:39
 * @param null
 * @return null
     */
    void deleteById(Connection conn,int id);

    /*
     * @Description 针对内存中的customer对象，去修改数据表中的指定记录
     * @author yangshiwei
     * @date 2021/5/2 22:41
 * @param conn
 * @param customer
     */
    void updateById(Connection conn,Customers customer);

    /*
     * @Description 针对指定的id查询得到对应的Customers对象
     * @author yangshiwei
     * @date 2021/5/2 22:42
 * @param conn
 * @param id
     */

    Customers getCustomersById(Connection conn,int id);

    /*
     * @Description
     * @author yangshiwei 查询表中所有记录构成的集合
     * @date 2021/5/2 22:43
 * @param conn
 * @return java.util.List<com.ecc.javalanguage.dbconnect.bean.Customers>
     */
    List<Customers> getAll(Connection conn);

    /*
     * @Description 返回数据表中数据的条目数
     * @author yangshiwei
     * @date 2021/5/2 22:44
 * @param conn
 * @return java.lang.Long
     */
    Long getCount(Connection conn);

    /*
     * @Description 返回数据表中最大的生日
     * @author yangshiwei
     * @date 2021/5/2 22:45
 * @param conn
 * @return java.util.Date
     */
    Date getMaxBirth(Connection conn);



}