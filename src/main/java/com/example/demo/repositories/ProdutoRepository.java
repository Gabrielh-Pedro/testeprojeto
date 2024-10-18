package main.java.com.example.demo.repositories;

import com.example.demo.models.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    
    // Retorna todos os produtos com preço maior do que um determinado valor
    List<Produto> findByPrecoGreaterThan(Double valor);

    // Retorna todos os produtos com preço menor ou igual a um determinado valor
    List<Produto> findByPrecoLessThanEqual(Double valor);

    // Retorna todos os produtos que começam com um determinado nome
    List<Produto> findByNomeStartingWith(String nome);
}
