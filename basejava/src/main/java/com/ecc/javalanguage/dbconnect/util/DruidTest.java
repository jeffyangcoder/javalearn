package com.ecc.javalanguage.dbconnect.util;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.junit.jupiter.api.Test;

import javax.sql.DataSource;
import java.io.InputStream;
import java.io.Reader;
import java.sql.Connection;
import java.util.Properties;

/**
 * @author yangshiwei
 * @Description Druid learn
 * @date 2021/5/4-19:27
 */
public class DruidTest {
    @Test
    public void getConnection() throws Exception {
        Connection conn = JDBCUtils.getConnection();
        System.out.println(conn);
    }


}
