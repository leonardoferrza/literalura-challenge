package com.alura.literalura.principal;

import com.alura.literalura.dto.DadosLivro;
import com.alura.literalura.dto.ResultadosDTO;
import com.alura.literalura.model.Autor;
import com.alura.literalura.model.Livro;
import com.alura.literalura.repository.AutorRepository;
import com.alura.literalura.repository.LivroRepository;
import com.alura.literalura.service.ConsumoApi;
import com.alura.literalura.service.ConverteDados;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Principal {
    private final Scanner leitura = new Scanner(System.in);
    private final ConsumoApi consumoApi = new ConsumoApi();
    private final ConverteDados conversor = new ConverteDados();
    private final String ENDERECO = "https://gutendex.com/books/?search=";
    private final LivroRepository livroRepositorio;
    private final AutorRepository autorRepositorio;

    public Principal(LivroRepository livroRepositorio, AutorRepository autorRepositorio) {
        this.livroRepositorio = livroRepositorio;
        this.autorRepositorio = autorRepositorio;
    }

    public void exibeMenu() {
        var opcao = -1;
        while (opcao != 0) {
            var menu = """
                    \n*** LiterAlura ***
                    Escolha uma opção:
                    1 - Buscar livro pelo título
                    2 - Listar livros registrados
                    3 - Listar autores registrados
                    4 - Listar autores vivos em um determinado ano
                    5 - Listar livros em um determinado idioma
                    0 - Sair
                    """;

            System.out.println(menu);
            opcao = leitura.nextInt();
            leitura.nextLine();

            switch (opcao) {
                case 1:
                    buscarLivroWeb();
                    break;
                case 2:
                    listarLivrosRegistrados();
                    break;
                case 3:
                    listarAutoresRegistrados();
                    break;
                case 4:
                    listarAutoresVivosPorAno();
                    break;
                case 5:
                    listarLivrosPorIdioma();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        }
    }

    private void buscarLivroWeb() {
        System.out.println("Qual livro você quer buscar?");
        var nomeLivro = leitura.nextLine();
        var json = consumoApi.obterDados(ENDERECO + nomeLivro.replace(" ", "%20"));
        ResultadosDTO dadosBusca = conversor.obterDados(json, ResultadosDTO.class);

        if (dadosBusca != null && !dadosBusca.resultados().isEmpty()) {
            DadosLivro dadosLivro = dadosBusca.resultados().get(0);
            Livro livro = new Livro(dadosLivro);

            Optional<Autor> autorDb = autorRepositorio.findByNomeContainingIgnoreCase(dadosLivro.autores().get(0).nome());

            if (autorDb.isPresent()) {
                livro.setAutor(autorDb.get());
            } else {
                Autor autor = new Autor(dadosLivro.autores().get(0));
                autorRepositorio.save(autor);
                livro.setAutor(autor);
            }

            livroRepositorio.save(livro);

            System.out.println("Livro salvo com sucesso!");
            System.out.println(livro);
        } else {
            System.out.println("Livro não encontrado.");
        }
    }

    private void listarLivrosRegistrados() {
        List<Livro> livros = livroRepositorio.findAll();
        if (livros.isEmpty()) {
            System.out.println("Nenhum livro registrado.");
        } else {
            livros.forEach(System.out::println);
        }
    }

    private void listarAutoresRegistrados() {
        List<Autor> autores = autorRepositorio.findAll();
        if (autores.isEmpty()){
            System.out.println("Nenhum autor registrado.");
        } else {
            autores.forEach(System.out::println);
        }
    }

    private void listarAutoresVivosPorAno() {
        System.out.println("Qual ano você quer pesquisar?");
        var ano = leitura.nextInt();
        leitura.nextLine();
        List<Autor> autores = autorRepositorio.buscarAutoresVivosNoAno(ano);
        if (autores.isEmpty()){
            System.out.println("Nenhum autor vivo encontrado para o ano " + ano);
        } else {
            autores.forEach(System.out::println);
        }
    }

    private void listarLivrosPorIdioma() {
        System.out.println("Qual idioma você quer pesquisar? (ex: en, pt, es, fr)");
        var idioma = leitura.nextLine();
        List<Livro> livros = livroRepositorio.findByIdioma(idioma);
        if (livros.isEmpty()){
            System.out.println("Nenhum livro encontrado para o idioma " + idioma);
        } else {
            livros.forEach(System.out::println);
        }
    }
}