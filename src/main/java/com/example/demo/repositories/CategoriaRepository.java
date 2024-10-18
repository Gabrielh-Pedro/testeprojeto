package main.java.com.example.demo.repositories;

import com.example.demo.models.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    
    // Retorna todas as categorias que começam com um determinado nome
    List<Categoria> findByNomeStartingWith(String nome);

    // Retorna uma categoria pelo ID e todos os produtos relacionados usando LEFT JOIN FETCH
    @Query("SELECT c FROM Categoria c LEFT JOIN FETCH c.produtos WHERE c.id = :id")
    Categoria findByIdWithProdutos(@Param("id") Long id);
}
