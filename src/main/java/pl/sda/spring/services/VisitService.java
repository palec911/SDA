package pl.sda.spring.services;

import org.springframework.stereotype.Service;
import pl.sda.spring.model.Visit;
import pl.sda.spring.repositories.VisitRepository;

@Service
public class VisitService {
    VisitRepository visitRepository;

    public VisitService(VisitRepository visitRepository) {
        this.visitRepository = visitRepository;
    }

    public void createVisit(Visit visit) {
        visitRepository.save(visit);
    }
}
