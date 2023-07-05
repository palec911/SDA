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

    @PostMapping("/createOwner")
    public String createOwner(@RequestBody Owner owner) {
        ownerServiceJPA.addOwner(owner);
        return "Created owner :" + owner;
    }

    @PostMapping("/createVisit")
    public String createVisit(@RequestBody Visit visit) {
        visitService.createVisit(visit);
        return "createdVisit : " + visit;
    }

    @GetMapping("/getOwner/{id}")
    public String getOwner(@PathVariable Long id) {
        return ownerServiceJPA.getOwnerById(id).toString();
    }

    @PostMapping("/createVet")
    public ResponseEntity createVet(@RequestBody Vet vet) {
        vetService.createVet(vet);
        System.out.println( "Created vet " + vet);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/createSpeciality")
    public ResponseEntity createSpeciality(@RequestBody VetSpeciality vetSpeciality) {
        vetSpecialityService.saveSpeciality(vetSpeciality);
        System.out.println( "Created vet speciality " + vetSpeciality);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @PutMapping("/assign/{vetId}/{specialityId}")
    public ResponseEntity assignVetToSpeciality(@PathVariable Long vetId, @PathVariable Long specialityId) {
        Vet vet = vetService.getVet(vetId);
        VetSpeciality specialitiesToSet = vetSpecialityService.getSpeciality(specialityId);
        Set<VetSpeciality> specialitiesFromVet = vet.getSpecialities();
        specialitiesFromVet.add(specialitiesToSet);
        vet.setSpecialities(specialitiesFromVet);
        vetService.createVet(vet);
        Set<Vet> vets = specialitiesToSet.getVets();
        vets.add(vet);
        specialitiesToSet.setVets(vets);
        vetSpecialityService.saveSpeciality(specialitiesToSet);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping("/hello")
    public String homepage(Model model) {
        model.addAttribute("theDate", new java.util.Date());

        return "helloworld";
    }

    @GetMapping("/pets")
    public String getPets(Model model) {
        model.addAttribute("pets", petServiceJPA.getAllPets());

        return "list-pets";
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
