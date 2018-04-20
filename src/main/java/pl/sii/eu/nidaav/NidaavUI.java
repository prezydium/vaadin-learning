package pl.sii.eu.nidaav;


import com.vaadin.annotations.Theme;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import org.springframework.beans.factory.annotation.Autowired;

@SpringUI
@Theme("valo")
public class NidaavUI extends UI {

    private VerticalLayout layout;

    @Autowired
    private UserData debtorData;

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        setupLayout();
        addHeader();
        addForm();
        enteredData();
        addActionButton();
    }

    private void setupLayout() {
        layout = new VerticalLayout();
        layout.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
        setContent(layout);
    }

    private void addHeader() {
        Label header = new Label("Welcome to Velka application - pay your debts before we pay you a visit");
        header.addStyleName(ValoTheme.LABEL_H1);
        header.setSizeUndefined();
        layout.addComponent(header);
    }

    private void addForm() {
        VerticalLayout formLayout = new VerticalLayout();
        TextField textFieldName = new TextField();
        TextField textFieldSurname = new TextField();
        Button confirmButton = new Button("Check my debt");
        confirmButton.setIcon(VaadinIcons.PLUS_CIRCLE);

        textFieldName.setWidth("50%");
        textFieldSurname.setWidth("50%");

        formLayout.setSpacing(true);
        formLayout.setWidth("80%");
       // formLayout.setExpandRatio(textFieldName, 1); why it dosent work
        formLayout.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
        formLayout.addComponents(textFieldName, textFieldSurname, confirmButton);
        layout.addComponent(formLayout);

    }

    private void enteredData() {
        layout.addComponent(debtorData);
    }

    private void addActionButton() {
        Button deleteButton = new Button("Delete data");
        layout.addComponent(deleteButton);

    }
}
