package controller;

import model.Livro;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LivroController {
    private List<Livro> livros;

    public LivroController() {
        this.livros = new ArrayList<>();
    }

    // Adicionar livro
    public void addLivro(Livro livro) {
        if (livro == null) {
            throw new IllegalArgumentException("O livro não pode ser nulo.");
        }
        livros.add(livro);
        System.out.println("Livro adicionado com sucesso: " + livro.getName());
    }

    // Listar todos os livros
    public List<Livro> listLivros() {
        if (livros.isEmpty()) {
            System.out.println("Nenhum livro cadastrado.");
        }
        return Collections.unmodifiableList(livros);
    }

    // Buscar livro por nome
    public Livro findLivroByName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("O nome do livro não pode ser vazio.");
        }
        for (Livro livro : livros) {
            if (livro.hasName(name)) {
                return livro;
            }
        }
        throw new RuntimeException("Livro não encontrado: " + name);
    }

    // Atualizar livro
    public void updateLivro(String name, Livro livroAtualizado) {
        if (name == null || name.isEmpty() || livroAtualizado == null) {
            throw new IllegalArgumentException("Os parâmetros não podem ser nulos ou vazios.");
        }
        for (int i = 0; i < livros.size(); i++) {
            if (livros.get(i).hasName(name)) {
                livros.set(i, livroAtualizado);
                System.out.println("Livro atualizado com sucesso: " + livroAtualizado.getName());
                return;
            }
        }
        throw new RuntimeException("Livro não encontrado para atualização: " + name);
    }

    // Remover livro
    public void removeLivro(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("O nome do livro não pode ser vazio.");
        }
        for (int i = 0; i < livros.size(); i++) {
            if (livros.get(i).hasName(name)) {
                livros.remove(i);
                System.out.println("Livro removido com sucesso: " + name);
                return;
            }
        }
        throw new RuntimeException("Livro não encontrado para remoção: " + name);
    }

}
