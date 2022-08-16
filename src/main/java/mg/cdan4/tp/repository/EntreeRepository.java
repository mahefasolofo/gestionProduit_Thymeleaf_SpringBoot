package mg.cdan4.tp.repository;

import mg.cdan4.tp.entity.Entree;
import mg.cdan4.tp.entity.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EntreeRepository extends JpaRepository<Entree,Integer> {
    List<Entree> findByNent(@Param("nent") String nent);
}
