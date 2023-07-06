package pl.sda.spring.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.sda.spring.model.*;
import pl.sda.spring.services.*;

import java.util.Set;

@Controller
public class DemoController {
    PetServiceJPA petServiceJPA;
    OwnerServiceJPA ownerServiceJPA;
    VisitService visitService;
    VetService vetService;
    VetSpecialityService vetSpecialityService;

    public DemoController(PetServiceJPA petServiceJPA,
                          OwnerServiceJPA ownerServiceJPA,
                          VisitService visitService,
                          VetService vetService,
                          VetSpecialityService vetSpecialityService) {
        this.petServiceJPA = petServiceJPA;
        this.ownerServiceJPA = ownerServiceJPA;
        this.visitService = visitService;
        this.vetService = vetService;
        this.vetSpecialityService = vetSpecialityService;
    }
    @GetMapping("/hello")
    public String homepage(Model model) {
        model.addAttribute("theDate", new java.util.Date());

        return "helloworld";
    }

    @GetMapping("/pets")
    public String getPets(Model model) {
        model.addAttribute("pets", petServiceJPA.getAllPets());

        return "petClinic";
    }

    @PostMapping("/pet")
    public String savePet(@ModelAttribute("pet") Pet pet) {
        petServiceJPA.createPet(pet);

        return "redirect:/pets";
    }

    @GetMapping("/addPetForm")
    public String addPetForm(Model model) {
        Pet pet = new Pet();
        model.addAttribute(pet);

        return "petAddForm";
    }

    @GetMapping("/updatePetForm")
    public String updatePetForm(Model model, @RequestParam("petId") Long petId) {
        Pet petToUpdate = petServiceJPA.getPetById(petId).get();
        model.addAttribute("pet", petToUpdate);
        return "petAddForm";
    }

    @GetMapping("/deletePet")
    public String removePet(@RequestParam("petId") Long petId) {
        petServiceJPA.deletePetById(petId);
        return "redirect:/pets";
    }

}
