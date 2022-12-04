import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println();

        Scanner inputy = new Scanner(System.in);
        int op;
        String url = "jdbc:mysql://localhost:3306/ex"; //Substitua o string pelo endereço da sua database
        String user = "root"; //Usuário
        String pass = ""; //Senha

        try{

            System.out.println("CONECTANDO...");

            Connection conn = DriverManager.getConnection(url, user, pass);

            System.out.println("CONECTADO AO BANCO DE DADOS!");

            String sql = "INSERT INTO alunos(nome, idade, gen) VALUES (?, ?, ?)";

            PreparedStatement command = conn.prepareStatement(sql);

            while(true){

                Aluno temp = Aluno.reg();

                command.setString(1, temp.getName());

                command.setInt(2, temp.getIdade());

                command.setString(3, temp.getGenero());

                int lines = command.executeUpdate();

                if(lines > 0){
                    System.out.println("REGISTRO REALIZADO COM SUCESSO!");
                    System.out.println("DESEJA CONTINUAR? 0 = NAO / 1 = SIM");
                    op = inputy.nextInt();
                    if(op != 1){
                        break;
                    }
                } else {
                    System.out.println("ERRO! FALHA NO REGISTRO!");
                }

            }

            conn.close();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try{

            System.out.println("CONECTANDO...");

            Connection conn = DriverManager.getConnection(url, user, pass);

            System.out.println("CONECTADO AO BANCO DE DADOS!");

            Statement statement = conn.createStatement();

            String sql = "SELECT * FROM alunos";

            ResultSet result = statement.executeQuery(sql);

            System.out.println("---------------------------------------");

            while(result.next()){

                System.out.println("ID: " + result.getInt("id"));
                System.out.println("Nome: " + result.getString("nome"));
                System.out.println("Gênero: " + result.getString("gen"));
                System.out.println("Idade: " + result.getInt("idade"));

                System.out.println("---------------------------------------");

            }

            conn.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
