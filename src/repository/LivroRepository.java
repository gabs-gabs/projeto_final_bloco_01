package repository;

import model.Livro;
import java.util.ArrayList;
import java.util.List;

public interface LivroRepository {
    List<Livro> livros = new ArrayList<>();

    default void addLivro(Livro livro) {
        livros.add(livro);
        System.out.println("Livro adicionado com sucesso: " + livro.getName());
    }

    default List<Livro> listLivros() {
        if (livros.isEmpty()) {
            System.out.println("Nenhum livro cadastrado.");
        }
        return livros;
    }

    default Livro findLivroByName(String name) {
        for (Livro livro : livros) {
            if (livro.hasName(name)) {
                return livro;
            }
        }
        System.out.println("Livro não encontrado: " + name);
        return null;
    }

    default boolean updateLivro(Livro livroAtualizado) {
        for (int i = 0; i < livros.size(); i++) {
            if (livros.get(i).hasName(livroAtualizado.getName())) {
                livros.set(i, livroAtualizado);
                System.out.println("Livro atualizado com sucesso: " + livroAtualizado.getName());
                return true;
            }
        }
        System.out.println("Livro não encontrado para atualização: " + livroAtualizado.getName());
        return false;
    }

    default boolean removeLivro(String name) {
        for (int i = 0; i < livros.size(); i++) {
            if (livros.get(i).hasName(name)) {
                livros.remove(i);
                System.out.println("Livro removido com sucesso: " + name);
                return true;
            }
        }
        System.out.println("Livro não encontrado para remoção: " + name);
        return false;
    }
}
