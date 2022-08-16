package mg.cdan4.tp.controller;

import mg.cdan4.tp.entity.Entree;
import mg.cdan4.tp.entity.Produit;
import mg.cdan4.tp.entity.Utilisateur;
import mg.cdan4.tp.service.EntreeService;
import mg.cdan4.tp.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/entree")
public class EntreeController {
    @Autowired
    EntreeService entreeService;

    @Autowired
    UtilisateurService utilisateurService;


    @RequestMapping("/newEntree/")
    public String nouveauentree(Model model) {
        Entree entree = new Entree();
        List<Utilisateur> listUser = utilisateurService.listAll();
        model.addAttribute("entree", entree);
        model.addAttribute("listUser", listUser);
        return "new_entree";
    }

    @PostMapping(value = "/saveEntree")
    public String saveentree(@ModelAttribute("entree") Entree entree) {
        entreeService.save(entree);
        return "redirect:/entree/";
    }

    @RequestMapping(path = { "/","/search" })
    public String home(Model model, String nent) {
        if (nent != null) {

            List<Entree> listEntrees = entreeService.listByNent(nent);
            model.addAttribute("listEntrees", listEntrees);

        } else {

            List<Entree> listEntrees = entreeService.listAll();
            model.addAttribute("listEntrees", listEntrees);

        }

        return "entree";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView afficheEntreeEdit(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("edit_entree");
        Entree entree = entreeService.get(id);
        mav.addObject("entree", entree);
        return mav;
    }

    @RequestMapping("/delete/{id}")
    public String supprimEntree(@PathVariable(name = "id") int id) {
        entreeService.delete(id);
        return "redirect:/entree/";
    }

}
