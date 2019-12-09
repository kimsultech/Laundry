package XI_RPL4;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class db_koneksi {
    Connection con;
    Statement st;

public void config() {
    try {
        Class.forName("com.mysql.jdbc.Driver");
        con = (Connection) DriverManager.getConnection ("jdbc:mysql://localhost/laundry","root","");
        st = (Statement) con.createStatement();
    }catch(Exception e) {
        JOptionPane.showMessageDialog(null, "Koneksi Gagal masuk ke Database!!!\n" + e.getMessage());
    }
  }
}
