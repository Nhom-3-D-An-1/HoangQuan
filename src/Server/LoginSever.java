package Server;

import JDBC.DBConnect;
import Model.Login;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginSever {
    public static Login getLogin(String username, String password) {
        try {
            Connection con = DBConnect.getConnection();
            String sql = "SELECT * FROM login WHERE TaiKhoan = ? AND MatKhau = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("ID");
                String taiKhoan = rs.getString("TaiKhoan");
                String matKhau = rs.getString("MatKhau");
                String chucVu = rs.getString("ChucVu");
                return new Login(id, taiKhoan, matKhau, chucVu);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
