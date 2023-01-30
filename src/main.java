import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class main {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/base1",
                    "root", "root1");
            String query = "SELECT * FROM estudiantes";
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(query);

            // Get metadata object
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();

            // Create JTable and set model
            JTable table = new JTable();
            DefaultTableModel model = (DefaultTableModel) table.getModel();

            // Add columns to table model
            for (int i = 1; i <= columnCount; i++) {
                model.addColumn(rsmd.getColumnName(i));
            }

            // Add rows to table model
            while (rs.next()) {
                Object[] row = new Object[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    row[i - 1] = rs.getObject(i);
                }
                model.addRow(row);
            }

            // Display JTable in JFrame
            JFrame frame = new JFrame();
            frame.add(new JScrollPane(table));
            frame.setSize(500, 300);
            frame.setVisible(true);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            // Clean up resources
            rs.close();
            st.close();
            conexion.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    }

