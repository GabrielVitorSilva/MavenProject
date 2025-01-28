import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

public class JDBCPostgres {
    public static void main(String[] args) {
        try {
            String url = "jdbc:postgresql://localhost:5432/java";
            Properties props = new Properties();
            props.setProperty("user", "docker");
            props.setProperty("password", "docker");
//            props.setProperty("ssl", "true");
            Connection conn = DriverManager.getConnection(url, props);
            System.out.println("Conexão realizada com sucesso");
            String sql = "INSERT INTO public.tab_cadastro (nome, idade) VALUES(?, ?)";

            PreparedStatement pst = conn.prepareStatement(sql);
            String nome = "Lívia";
            Integer idade = 23;
            pst.setString(1, nome);
            pst.setInt(2, idade);

            pst.execute();
            System.out.println("Inserido com sucesso");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
