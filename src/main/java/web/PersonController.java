package web;

import entities.Person;
import metier.PersonMetier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api")
public class PersonController {

    private final PersonMetier metier; // null

    public PersonController(PersonMetier metier) {
        this.metier = metier;
    }

    @GetMapping("/person/{id}")
    public String getPerson(@PathVariable Long id, Model model){
        Person person = metier.getProfile(id);
        model.addAttribute("person",person);
        return "person";
    }
}
