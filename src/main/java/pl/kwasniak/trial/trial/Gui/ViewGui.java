/*
package pl.kwasniak.trial.trial.Gui;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import pl.kwasniak.trial.trial.Entity.EntityBills;
import pl.kwasniak.trial.trial.Repo.BillsRepo;
import pl.kwasniak.trial.trial.Service.PersonService;

import java.awt.*;

@Route
public class ViewGui  extends VerticalLayout {


    BillsRepo billsRepo;


    private Grid<EntityBills> grid = new Grid<>(EntityBills.class);

    @Autowired
    public ViewGui( BillsRepo billsRepo) {
        this.billsRepo= billsRepo;
        grid.setColumns("name", "cost", "description");
        updateList();
        add(grid);
    }
    public void updateList() {

        grid.setItems(billsRepo.getBills());
    }
}
*/
