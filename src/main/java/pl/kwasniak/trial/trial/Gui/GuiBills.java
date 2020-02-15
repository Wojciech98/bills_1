package pl.kwasniak.trial.trial.Gui;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.splitlayout.SplitLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.UIScope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import pl.kwasniak.trial.trial.Entity.EntityBills;
import pl.kwasniak.trial.trial.Repo.BillsRepo;

@Route
@UIScope
public class GuiBills extends VerticalLayout {
    private BillsRepo billsRepo;
    private TextField name;
    private TextField cost;
    private TextField description;
    private Button buttonSave;
    private Grid<EntityBills> grid = new Grid<>(EntityBills.class);

    @Autowired
    public GuiBills(BillsRepo billsRepo) {
        this.billsRepo = billsRepo;
        name = new TextField("name");
        cost = new TextField("cost");
        description = new TextField("description");
        buttonSave = new Button("save");
        buttonSave.addClickListener(buttonSaveClickEvent -> addBills());
        setSizeFull();
        updateList();

        grid.setColumns("name","cost","description");
        add(mainView());
    }

    public VerticalLayout mainView(){
        VerticalLayout splitLayout = new VerticalLayout();

        add(createCard(),grid);
            return splitLayout;
    }
    public void addBills() {

        EntityBills entityBills = new EntityBills();
        entityBills.setName(name.getValue());
        entityBills.setCost(Integer.parseInt(cost.getValue()));
        entityBills.setDescription(description.getValue());
        billsRepo.save(entityBills);

    }
    public void updateList() {

        grid.setItems(billsRepo.getBills());
    }
    public Component createCard() {

        HorizontalLayout card = new HorizontalLayout();
        name = new TextField("","name");
        name.setWidth("25%");



        cost = new TextField("","cost");
        cost.setWidth("25%");

        description = new TextField("","description");
        description.setWidth("25%");


        buttonSave = new Button("save");
        buttonSave.addClickListener(buttonSaveClickEvent -> addBills());
        buttonSave.setWidth("25%");



        card.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        card.setAlignItems(Alignment.CENTER);
        card.setVerticalComponentAlignment(Alignment.CENTER);
        setSizeFull();
        card.setWidthFull();
        card.setPadding(false);

        card.add(name,cost,description,buttonSave);

        return card;
    }
}
