import java.math.BigDecimal;
import java.util.Scanner;
import controller.LivroController;
import model.Livro;

public class Menu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LivroController livroController = new LivroController();
        int option, stock;
        String bookName, author, description;
        BigDecimal price;
        boolean proceed = true;

        while (proceed) {
            System.out.println("*****************************************************");
            System.out.println("                Blackcat Bookstore                   ");
            System.out.println("*****************************************************");
            System.out.println("            1 - Cadastrar livro                      ");
            System.out.println("            2 - Listar todos os livros               ");
            System.out.println("            3 - Consultar livro                      ");
            System.out.println("            4 - Atualizar livro                      ");
            System.out.println("            5 - Remover livro                        ");
            System.out.println("            0 - Sair                                 ");
            System.out.println("*****************************************************");
            System.out.println("Entre com a opção desejada:                          ");

            option = sc.nextInt();

            switch (option) {
                case 0:
                    System.out.println("Sistema encerrado! - Blackcat Bookstore");
                    proceed = false;
                    break;

                case 1:
                    System.out.println("Cadastrar livro");
                    sc.skip("\\R?");
                    System.out.println("Digite o nome do livro:");
                    bookName = sc.nextLine();
                    System.out.println("Digite o autor do livro:");
                    author = sc.nextLine();
                    System.out.println("Digite a descrição do livro:");
                    description = sc.nextLine();
                    System.out.println("Digite o preço do livro:");
                    price = sc.nextBigDecimal();
                    System.out.println("Digite o estoque do livro:");
                    stock = sc.nextInt();
                    Livro livro = new Livro(stock, bookName, author, description, price);
                    livroController.addLivro(livro);
                    break;

                case 2:
                    System.out.println("Listar todos os livros:");
                    for (Livro l : livroController.listLivros()) {
                        l.displayDetails();
                    }
                    break;

                case 3:
                    System.out.println("Consultar livro");
                    sc.skip("\\R?");
                    System.out.println("Digite o nome do livro:");
                    bookName = sc.nextLine();
                    try {
                        Livro foundLivro = livroController.findLivroByName(bookName);
                        foundLivro.displayDetails();
                    } catch (RuntimeException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 4:
                    System.out.println("Atualizar livro");
                    sc.skip("\\R?");
                    System.out.println("Digite o nome do livro a ser atualizado:");
                    bookName = sc.nextLine();
                    try {
                        System.out.println("Digite o novo autor do livro:");
                        author = sc.nextLine();
                        System.out.println("Digite a nova descrição do livro:");
                        description = sc.nextLine();
                        System.out.println("Digite o novo preço do livro:");
                        price = sc.nextBigDecimal();
                        System.out.println("Digite o novo estoque do livro:");
                        stock = sc.nextInt();
                        Livro livroAtualizado = new Livro(stock, bookName, author, description, price);
                        livroController.updateLivro(bookName, livroAtualizado);
                    } catch (RuntimeException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 5:
                    System.out.println("Remover livro");
                    sc.skip("\\R?");
                    System.out.println("Digite o nome do livro a ser removido:");
                    bookName = sc.nextLine();
                    try {
                        livroController.removeLivro(bookName);
                    } catch (RuntimeException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
        sc.close();
    }
}
