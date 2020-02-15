package pl.kwasniak.trial.trial.Service;

import pl.kwasniak.trial.trial.Entity.EntityBills;

import java.util.List;

public interface PersonService {
    List<EntityBills> fetchPersons(int offset, int limit);
    List<EntityBills> findAll();
}
