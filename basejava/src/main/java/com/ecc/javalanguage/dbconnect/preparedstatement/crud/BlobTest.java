package com.ecc.javalanguage.dbconnect.preparedstatement.crud;

import com.ecc.javalanguage.dbconnect.preparedstatement.bean.Star;
import com.ecc.javalanguage.dbconnect.util.JDBCUtils;
import org.junit.jupiter.api.Test;

import javax.imageio.stream.FileImageOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.*;

/**
 * @author yangshiwei
 * @Description 使用preparedStatement往数据库里添加图片类型的数据
 * @date 2021/4/30-10:50
 */
public class BlobTest {
    // 向star表重插入Blob类型的字段
    @Test
    public void testInsert() throws Exception {
        Connection conn = JDBCUtils.getConnection();
        String sql = "insert into star (name,email,birth,photo)values(?,?,?,?)";

        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setObject(1, "猫弟");
        ps.setObject(2, "Yshiwi@outlook.com");
        ps.setObject(3, "2020-07-08");

        FileInputStream inputStream = new FileInputStream(new File("src/main/resources/img/cat.jpg"));
        ps.setBlob(4, inputStream);
        ps.execute();

        JDBCUtils.closeResource(conn, ps);
    }

    @Test
    public void testQuery() throws Exception {
        Connection conn = JDBCUtils.getConnection();
        String sql = " select id,name,email,birth,photo from star where id = ?";

        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, 1);

        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
//            int id = rs.getInt(1);
//            String name = rs.getString(2);
//            String email = rs.getString(3);
//            Date birth = rs.getDate(4);
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String email = rs.getString("email");
            Date birth = rs.getDate("birth");

            Star star = new Star(id, name, email, birth);

            Blob photo = rs.getBlob("photo");
            InputStream is = photo.getBinaryStream();
            FileOutputStream fos = new FileOutputStream("src/main/resources/img/猫弟.jpg");
            byte[] buffer = new byte[1024];
            int len;
            while ((len = is.read(buffer)) != -1) {
                fos.write(buffer, 0, len);
            }
            JDBCUtils.closeResource(conn, ps, rs);
            is.close();
            fos.close();
        }

    }
}
