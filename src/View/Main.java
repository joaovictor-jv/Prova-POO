package View;

import Controller.BancoDados;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        BancoDados bancoDados = new BancoDados();
        bancoDados.conecta();
        if (bancoDados.estaConecatdo()) {

            Scanner leitor = new Scanner(System.in);
            
            System.out.println("Lista de produtos:");
            bancoDados.listar();
            
            System.out.print("Digite o ID do produto:");
            int id = leitor.nextInt();
            bancoDados.selecionar(id);
            
            System.out.print("Quantidade que deseja:");
            int qtd = leitor.nextInt();
            bancoDados.comprar(id, qtd);

        } else {
            System.out.println("Banco NÃO OK");
        }
    }

}
