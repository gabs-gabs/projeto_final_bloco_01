import java.math.BigDecimal;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int option, stock;
        String bookName, author, description;
        BigDecimal price;
        boolean proceed = true;

        while (proceed) {
            System.out.println("*****************************************************");
            System.out.println("                                                     ");
            System.out.println("                Blackcat Bookstore                   ");
            System.out.println("                                                     ");
            System.out.println("*****************************************************");
            System.out.println("                                                     ");
            System.out.println("            1 - Cadastrar livro                      ");
            System.out.println("            2 - Listar todos os livros               ");
            System.out.println("            3 - Consultar preços                     ");
            System.out.println("            4 - Atualizar dados do livro             ");
            System.out.println("            5 - Apagar livro                         ");
            System.out.println("            0 - Sair                                 ");
            System.out.println("                                                     ");
            System.out.println("*****************************************************");
            System.out.println("Entre com a opção desejada:                          ");

            option = sc.nextInt();

            if (option == 0) {
                System.out.println("Sistema encerrado! - Blackcat Bookstore");
                sc.close();
                System.exit(0);
            }

            switch (option) {
                case 1:
                    System.out.println("Cadastrar livro");
                    System.out.println("");
                    System.out.println("Digite o nome do livro");
                    sc.skip("\\R?");
                    bookName = sc.nextLine();
                    System.out.println("Digite o autor do livro");
                    sc.skip("\\R?");
                    author = sc.nextLine();
                    System.out.println("Digite a descrição do livro");
                    sc.skip("\\R?");
                    description = sc.nextLine();
                    System.out.println("Digite o preço do livro");
                    price = sc.nextBigDecimal();
                    break;

                case 2:
                    System.out.println("Listar todos os livros");
                    break;

                case 3:
                    System.out.println("Consultar preços");
                    System.out.println("Digite o nome do livro que deseja consultar");
                    sc.skip("\\R?");
                    bookName = sc.nextLine();
                    break;

                case 4:
                    System.out.println("Atualizar dados dos livros");
                    System.out.println("Digite o nome do livro");
                    sc.skip("\\R?");
                    bookName = sc.nextLine();
                    System.out.println("Digite o autor do livro");
                    sc.skip("\\R?");
                    author = sc.nextLine();
                    System.out.println("Digite a descrição do livro");
                    sc.skip("\\R?");
                    description = sc.nextLine();
                    System.out.println("Digite o preço do livro");
                    price = sc.nextBigDecimal();
                    break;

                case 5:
                    System.out.println("Apagar livro");
                    System.out.println("Digite o nome do livro a ser apagado do sistema");
                    sc.skip("\\R?");
                    bookName = sc.nextLine();
                    break;
            }

        }
        sc.close();
    }
}
