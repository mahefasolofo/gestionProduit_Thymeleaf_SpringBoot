package mg.cdan4.tp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Entree {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer ident;

    @ManyToOne
    private Utilisateur utilisateur;

    private String nent;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;
    private String description;
    private double montant;

    private Integer code;


}
