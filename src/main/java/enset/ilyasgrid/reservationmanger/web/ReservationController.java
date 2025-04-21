package enset.ilyasgrid.reservationmanger.web;

import enset.ilyasgrid.reservationmanger.entities.*;
import enset.ilyasgrid.reservationmanger.repository.EntrepriseRepository;
import enset.ilyasgrid.reservationmanger.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/reservations")
public class ReservationController {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private EntrepriseRepository entrepriseRepository;

    @GetMapping
    public String listReservations(Model model) {
        model.addAttribute("reservations", reservationRepository.findAll());
        return "reservations/list";
    }

    @GetMapping("/form")
    public String formReservation(Model model) {
        model.addAttribute("reservation", new Reservation());
        model.addAttribute("entreprises", entrepriseRepository.findAll());
        model.addAttribute("types", TypeReservation.values());
        model.addAttribute("etats", EtatReservation.values());
        return "reservations/form";
    }

    @PostMapping("/save")
    public String saveReservation(@ModelAttribute Reservation reservation) {
        reservationRepository.save(reservation);
        return "redirect:/reservations";
    }

    @GetMapping("/edit/{id}")
    public String editReservation(@PathVariable Long id, Model model) {
        Reservation reservation = reservationRepository.findById(id).orElse(null);
        model.addAttribute("reservation", reservation);
        model.addAttribute("entreprises", entrepriseRepository.findAll());
        model.addAttribute("types", TypeReservation.values());
        model.addAttribute("etats", EtatReservation.values());
        return "reservations/form";
    }

    @GetMapping("/delete/{id}")
    public String deleteReservation(@PathVariable Long id) {
        reservationRepository.deleteById(id);
        return "redirect:/reservations";
    }
}
