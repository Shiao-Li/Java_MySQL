import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class conexion {
    public conexion(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/base1",
                    "root", "root1");

            Statement s = conexion.createStatement();

            ResultSet rs = s.executeQuery("Select * from estudiantes");
            while (rs.next()){
                //System.out.println(rs.getString("id")+" "+rs.getString("nombre")+" "+rs.getString("Celular"));
                System.out.println(rs.getString("nombre"));
            }
            conexion.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
