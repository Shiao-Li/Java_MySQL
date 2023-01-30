import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class resultados {
    private JLabel mi_base;
    private JButton mostrarButton;
    private JPanel resultados;

    public resultados() {
    mostrarButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/base1",
                        "root", "root1");

                Statement s = conexion.createStatement();

                ResultSet rs = s.executeQuery("Select * from estudiantes");
                while (rs.next()){
                    //System.out.println(rs.getString("id")+" "+rs.getString("nombre")+" "+rs.getString("Celular"));
                    //System.out.println(rs.getString("nombre"));
                    mi_base.setText(rs.getString("nombre"));
                }
                conexion.close();
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
    });
}

    public static void main(String[] arg) {
        JFrame frame1 = new JFrame("Inicia sesión");
        resultados f1 = new resultados();

        frame1.setContentPane(f1.resultados);
        frame1.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame1.pack();
        frame1.setSize(300, 300);
        frame1.setLocationRelativeTo(null);
        frame1.setVisible(true);
    }
}
