package mg.cdan4.tp.controller;

import mg.cdan4.tp.entity.Entree;
import mg.cdan4.tp.entity.Produit;
import mg.cdan4.tp.service.EntreeService;
import mg.cdan4.tp.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
/*@RequestMapping("/produit")*/
public class ProduitController {
    @Autowired
    ProduitService produitService;


    @RequestMapping("/")
    public String viewHomePage(Model model){
        List<Produit> listProducts = produitService.listAll();
        model.addAttribute("listProducts",listProducts);
        return "index";
    }

    @RequestMapping("/new")
    public String nouveauProduit(Model model){
        Produit produit = new Produit();
        model.addAttribute("product",produit);
        return "new_product";
    }

    @PostMapping(value="/save")
    public String saveProduct(@ModelAttribute("product") Produit produit){
        produitService.save(produit);
        return "redirect:/";
    }


    @RequestMapping("/edit/{id}")
    public ModelAndView afficherProduitEdit(@PathVariable(name="id")int id){
        ModelAndView mav = new ModelAndView("edit_produit");
        Produit produit = produitService.get(id);
        mav.addObject("product",produit);

        return mav;
    }
    @RequestMapping("/delete/{id}")
    public String supprimProduit(@PathVariable(name="id") int id){
        produitService.delete(id);
        return "redirect:/";
    }

    @RequestMapping(path="/search")
    public String home(Model model, String keyword) {
        if(keyword!=null) {
            List<Produit> list = produitService.getByKeyword(keyword);
            model.addAttribute("listProducts", list);
        }else {
            List<Produit> list = produitService.listAll();
            model.addAttribute("listProducts", list);}
        return "index";
    }



}
