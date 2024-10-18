package main.java.com.example.demo.runner;

import com.example.demo.models.Categoria;
import com.example.demo.models.Produto;
import com.example.demo.repositories.CategoriaRepository;
import com.example.demo.repositories.ProdutoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public void run(String... args) throws Exception {
        // Limpar dados existentes
        produtoRepository.deleteAll();
        categoriaRepository.deleteAll();

        // Criar categorias
        Categoria cat1 = new Categoria("Eletrônicos");
        Categoria cat2 = new Categoria("Vestuário");

        categoriaRepository.save(cat1);
        categoriaRepository.save(cat2);

        // Criar produtos
        Produto prod1 = new Produto("TV Smart", 2500.0, cat1);
        Produto prod2 = new Produto("Celular", 1200.0, cat1);
        Produto prod3 = new Produto("Camiseta Polo", 80.0, cat2);

        produtoRepository.save(prod1);
        produtoRepository.save(prod2);
        produtoRepository.save(prod3);

        // Demonstrando métodos do ProdutoRepository
        System.out.println("\n*** Produtos com preço maior que 1000 ***");
        List<Produto> produtosCaros = produtoRepository.findByPrecoGreaterThan(1000.0);
        produtosCaros.forEach(p -> System.out.println(p.getNome() + " - R$ " + p.getPreco()));

        System.out.println("\n*** Produtos com preço menor ou igual a 1000 ***");
        List<Produto> produtosBaratos = produtoRepository.findByPrecoLessThanEqual(1000.0);
        produtosBaratos.forEach(p -> System.out.println(p.getNome() + " - R$ " + p.getPreco()));

        System.out.println("\n*** Produtos que começam com 'C' ***");
        List<Produto> produtosComC = produtoRepository.findByNomeStartingWith("C");
        produtosComC.forEach(p -> System.out.println(p.getNome() + " - R$ " + p.getPreco()));

        // Demonstrando métodos do CategoriaRepository
        System.out.println("\n*** Categorias que começam com 'E' ***");
        List<Categoria> categoriasE = categoriaRepository.findByNomeStartingWith("E");
        categoriasE.forEach(c -> System.out.println(c.getNome()));

        System.out.println("\n*** Categoria com ID " + cat1.getId() + " e seus produtos ***");
        Categoria categoriaComProdutos = categoriaRepository.findByIdWithProdutos(cat1.getId());
        System.out.println("Categoria: " + categoriaComProdutos.getNome());
        categoriaComProdutos.getProdutos().forEach(p -> System.out.println("- " + p.getNome()));
    }
}
