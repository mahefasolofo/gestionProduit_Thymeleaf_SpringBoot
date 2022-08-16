package mg.cdan4.tp.repository;

import mg.cdan4.tp.entity.Entree;
import mg.cdan4.tp.entity.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateurRepository extends JpaRepository<Utilisateur,Integer> {

}
