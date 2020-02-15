package pl.kwasniak.trial.trial.Repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.kwasniak.trial.trial.Entity.EntityBills;

import java.util.List;


@Repository
public interface BillsRepo extends CrudRepository<EntityBills,Long> {

@Query(nativeQuery = true,value = "SELECT *\n" +
        "FROM `bills`.`entity_bills`;")
    List<EntityBills> getBills();
}
