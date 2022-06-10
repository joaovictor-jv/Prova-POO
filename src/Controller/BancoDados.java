
package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class BancoDados {
    private Connection con = null;
    private Statement stm = null;
    private ResultSet result = null;

    public void conecta() {
        String servidor = "jdbc:mysql://localhost:3306/ProjetoFinal";
        String usuario = "root";
        String senha = "";
        String driver = "com.mysql.jdbc.Driver";
        try {
            Class.forName(driver);
            this.con = DriverManager.getConnection(servidor, usuario, senha);
            this.stm = this.con.createStatement();
        } catch (Exception e) {
            System.out.println("erro na conexão : " + e.getMessage());
        }
    }

    public boolean estaConecatdo() {
        if (this.con != null) {
            return true;
        } else {
            return false;
        }
    }

    public void listar() {
        try {
            String minhaQuery = "SELECT * FROM produto ORDER BY idProduto";
            this.result = this.stm.executeQuery(minhaQuery);

            while (this.result.next()) {
                System.out.println("ID: " + this.result.getString("idProduto") + " - Nome: " + this.result.getString("nomeProduto") 
                + " - Valor: " + this.result.getString("valorUnitario") + " - Quantidade: " + this.result.getString("qtdEstoque"));
            }
        } catch (Exception e) {
            System.out.println("Erro na lista: " + e.getMessage());
        }
    }

    public void selecionar(int id) {
        try {
            String minhaQuery = "SELECT * FROM Produto WHERE idProduto = " + id;
            this.result = this.stm.executeQuery(minhaQuery);

            while (this.result.next()) {
                System.out.println("ID: " + this.result.getString("idProduto") + " - Nome: " + this.result.getString("nomeProduto") 
                + " - Valor: " + this.result.getString("valorUnitario") + " - Quantidade: " + this.result.getString("qtdEstoque"));
            }
        } catch (Exception e) {
            System.out.println("Erro na lista: " + e.getMessage());
        }
    }
    
    
    public void comprar(int id, int qtd){
        try {
            String query = "UPDATE Produto SET qtdEstoque = qtdEstoque - " + qtd + " WHERE idProduto = " + id + ";";
            this.stm.executeUpdate(query);
            System.out.println("Compra efetuada com sucesso");
            System.out.println("O estoque foi atualizado");
        } catch (Exception e) {
            System.out.println("Erro na Alteracao: " + e.getMessage());
        }
    }
    

    public void excluir(String id) {
        try {
            String query = "DELETE FROM Produto WHERE id = " + id + ";";
            this.stm.executeUpdate(query);
            System.out.println("ID: " + id + " EXCLUIDO COM SUCESSO");

        } catch (Exception e) {
            System.out.println("Erro na Exclusao: " + e.getMessage());
        }
    }
    
}
