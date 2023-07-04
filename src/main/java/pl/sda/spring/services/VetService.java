package pl.sda.spring.services;

import org.springframework.stereotype.Service;
import pl.sda.spring.model.Vet;
import pl.sda.spring.model.VetSpeciality;
import pl.sda.spring.repositories.VetRepository;

@Service
public class VetService {
    VetRepository vetRepository;
    VetSpecialityService vetSpecialityService;

    public VetService(VetRepository vetRepository, VetSpecialityService vetSpecialityService) {
        this.vetRepository = vetRepository;
        this.vetSpecialityService = vetSpecialityService;
    }

    public void createVet(Vet vet) {
        Vet newVet = new Vet();
        newVet.setFirstName(vet.getFirstName());
        newVet.setLastName(vet.getLastName());
        newVet.getSpecialities().addAll(vet.getSpecialities().stream().map(s -> {
            VetSpeciality vs = vetSpecialityService.getSpeciality(s.getId());
            vs.getVets().add(newVet);
            return vs;
        }).toList());
        vetRepository.save(newVet);
    }
    public Vet getVet(Long id) {
        return vetRepository.findById(id).get();
    }
}
