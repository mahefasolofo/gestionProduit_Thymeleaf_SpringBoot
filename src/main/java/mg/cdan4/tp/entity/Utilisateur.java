package mg.cdan4.tp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "utilisateur")
public class Utilisateur implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer iduser;

    private String nom;
    private String prenom;
    private String email;

    @OneToMany(mappedBy = "utilisateur")
    private List<Entree> entree;


}
