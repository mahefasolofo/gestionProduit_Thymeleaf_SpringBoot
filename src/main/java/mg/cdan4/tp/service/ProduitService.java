package mg.cdan4.tp.service;

import mg.cdan4.tp.entity.Produit;
import mg.cdan4.tp.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProduitService {

    @Autowired
    ProduitRepository produitRepository;

    public List<Produit> listAll(){
        return produitRepository.findAll();
    }

    public void save(Produit product){
        produitRepository.save(product);
    }

    public Produit get(long id){
        return produitRepository.findById(id).get();
    }

    public void delete(long id){
        produitRepository.deleteById(id);
    }

    public List<Produit> getByKeyword(String keyword){
        return produitRepository.findByKeyword(keyword);
    }
}
