package pl.sda.spring.services;

import org.springframework.stereotype.Service;
import pl.sda.spring.model.VetSpeciality;
import pl.sda.spring.repositories.VetSpecialityRepository;

import java.util.Set;

@Service
public class VetSpecialityService {

    VetSpecialityRepository vetSpecialityRepository;

    public VetSpecialityService(VetSpecialityRepository vetSpecialityRepository) {
        this.vetSpecialityRepository = vetSpecialityRepository;
    }

    public void saveSpeciality(VetSpeciality vetSpeciality) {
        vetSpecialityRepository.save(vetSpeciality);
    }
    public VetSpeciality getSpeciality(Long id) {
        return vetSpecialityRepository.findById(id).get();
    }
}
