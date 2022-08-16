package mg.cdan4.tp.repository;

import mg.cdan4.tp.entity.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProduitRepository extends JpaRepository<Produit,Long> {

    //Custom query
    @Query(value = "select * from produit p where p.name Ilike %:keyword% or p.brand Ilike %:keyword% or p.madein Ilike %:keyword%" , nativeQuery = true)
    List<Produit> findByKeyword(@Param("keyword") String keyword);
}
