package com.mycompany.loginvaadin;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.annotations.Widgetset;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@Theme("mytheme")
@Widgetset("com.mycompany.loginvaadin.MyAppWidgetset")
public class MyUI extends UI {

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        final VerticalLayout layout = new VerticalLayout();
        final FormLayout panelLayout = new FormLayout();
        panelLayout.setMargin(true);
        layout.setMargin(true);
        setContent(layout);

        TextField txtUser = new TextField("User:");
        txtUser.setRequired(true);
        txtUser.setDescription("Enter your username");
        TextField txtPassword = new TextField("Password:");
        txtPassword.setRequired(true);

        Panel panel = new Panel("Login");
        panel.setSizeUndefined();
        final Label acessLabel = new Label("Thank you for clicking!!");
        acessLabel.setVisible(false);

        Button button = new Button("Enter");
        button.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(ClickEvent event) {
                acessLabel.setVisible(true);
            }
        });
        panelLayout.addComponent(txtUser);
        panelLayout.addComponent(txtPassword);
        panelLayout.addComponent(button);
        panelLayout.addComponent(acessLabel);
        panel.setContent(panelLayout);
        layout.setSizeFull();
        layout.addComponent(panel);
        layout.setComponentAlignment(panel, Alignment.MIDDLE_CENTER);

    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
