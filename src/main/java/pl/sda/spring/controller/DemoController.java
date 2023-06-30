package pl.sda.spring.controller;

import org.springframework.boot.CommandLineRunner;
import org.springframework.web.bind.annotation.*;
import pl.sda.spring.model.*;
import pl.sda.spring.repositories.VisitRepository;
import pl.sda.spring.services.OwnerServiceJPA;
import pl.sda.spring.services.PetServiceJPA;
import pl.sda.spring.services.VisitService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@RestController
public class DemoController {
    PetServiceJPA petServiceJPA;
    OwnerServiceJPA ownerServiceJPA;
    VisitService visitService;

    public DemoController(PetServiceJPA petServiceJPA, OwnerServiceJPA ownerServiceJPA, VisitService visitService) {
        this.petServiceJPA = petServiceJPA;
        this.ownerServiceJPA = ownerServiceJPA;
        this.visitService = visitService;
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
}
