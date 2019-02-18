package jdbc1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ManagerStu {

    public List<Student> getAll() throws Exception {
        Connection conn = DBConnector.getConnection();
        List<Student> list = new ArrayList<>();
        String sql = "SELECT * FROM users";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            Student c = new Student();
            c.setId(rs.getInt(1));
            c.setName(rs.getString(2));
            c.setPass(rs.getString(3));
            c.setAddress(rs.getString(4));
            list.add(c);
        }
        return list;
    }

    public int add(Student c) throws Exception {
        Connection conn = DBConnector.getConnection();
        String sql = "INSERT INTO users(name, pass,address) VALUES(?,?,?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, c.getName());
        pstmt.setString(2, c.getPass());
        pstmt.setString(3, c.getAddress());
        return pstmt.executeUpdate();
    }

    public int update(Student c) throws Exception {
        Connection conn = DBConnector.getConnection();
        String sql = "UPDATE users SET name = ? , pass = ? , adrress = ? WHERE id = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, c.getName());
        pstmt.setString(2, c.getPass());
        pstmt.setString(3, c.getAddress());
        pstmt.setInt(4, c.getId());
        return pstmt.executeUpdate();
    }

    public int delete(int id) throws Exception {
        Connection conn = DBConnector.getConnection();
        String sql = "DELETE FROM users WHERE id = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, id);
        return pstmt.executeUpdate();
    }

    public Student getById(int id) throws Exception {
        Connection conn = DBConnector.getConnection();
        String sql = "SELECT * FROM users WHERE id = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, id);
        ResultSet rs = pstmt.executeQuery();
        Student c = new Student();
        while (rs.next()) {
            c.setId(rs.getInt("id"));
            c.setName(rs.getString("name"));
            c.setPass(rs.getString("pass"));
            c.setAddress(rs.getString("address"));

        }
        return c;

    }
}
