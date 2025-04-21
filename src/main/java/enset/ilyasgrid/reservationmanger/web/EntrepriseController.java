package enset.ilyasgrid.reservationmanger.web;

import enset.ilyasgrid.reservationmanger.entities.Entreprise;
import enset.ilyasgrid.reservationmanger.repository.EntrepriseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/entreprises")
public class EntrepriseController {
    @Autowired
    private EntrepriseRepository entrepriseRepository;

    @GetMapping
    public String listEntreprises(Model model) {
        List<Entreprise> entreprises = entrepriseRepository.findAll();
//        System.out.println(entreprises.size());
        model.addAttribute("entreprises", entreprises);
        return "entreprises/list";
    }
    @GetMapping("/form")
    public String formEntreprise(Model model) {
        model.addAttribute("entreprise", new Entreprise());
        return "entreprises/form";
    }

    @PostMapping("/save")
    public String saveEntreprise(@ModelAttribute Entreprise entreprise) {
        entrepriseRepository.save(entreprise);
        return "redirect:/entreprises";
    }

    @GetMapping("/edit/{id}")
    public String editEntreprise(@PathVariable Long id, Model model) {
        Entreprise entreprise = entrepriseRepository.findById(id).orElse(null);
//        System.out.println(entreprise);
        model.addAttribute("entreprise", entreprise);
        return "entreprises/form";
    }

    @GetMapping("/delete/{id}")
    public String deleteEntreprise(@PathVariable Long id) {
        entrepriseRepository.deleteById(id);
        return "redirect:/entreprises";
    }
}
