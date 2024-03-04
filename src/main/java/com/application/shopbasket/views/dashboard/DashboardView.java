package com.application.shopbasket.views.dashboard;

import com.application.shopbasket.views.MainLayout;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import com.vaadin.flow.theme.lumo.LumoUtility.Gap;

@PageTitle("Dashboard")
@Route(value = "dashboard", layout = MainLayout.class)
@RouteAlias(value = "", layout = MainLayout.class)
@Uses(Icon.class)
public class DashboardView extends Composite<VerticalLayout> {

    public DashboardView() {
        VerticalLayout layoutColumn2 = new VerticalLayout();
        H2 h2 = new H2();
        Button buttonPrimary = new Button();
        TextField textField = new TextField();
        HorizontalLayout layoutRow = new HorizontalLayout();
        Paragraph textSmall = new Paragraph();
        getContent().setWidth("100%");
        getContent().getStyle().set("flex-grow", "1");
        layoutColumn2.setWidth("100%");
        layoutColumn2.getStyle().set("flex-grow", "1");
        h2.setText("Put Content here");
        h2.setWidth("max-content");
        buttonPrimary.setText("Button");
        buttonPrimary.setWidth("min-content");
        buttonPrimary.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        textField.setLabel("Text field");
        layoutColumn2.setAlignSelf(FlexComponent.Alignment.START, textField);
        textField.setWidth("min-content");
        layoutRow.addClassName(Gap.MEDIUM);
        layoutRow.setWidth("100%");
        layoutRow.setHeight("min-content");
        textSmall.setText("Copyright (c) 2024 | Powered by Mc's Republic");
        layoutRow.setAlignSelf(FlexComponent.Alignment.START, textSmall);
        textSmall.setWidth("100%");
        textSmall.getStyle().set("font-size", "var(--lumo-font-size-xs)");
        getContent().add(layoutColumn2);
        layoutColumn2.add(h2);
        layoutColumn2.add(buttonPrimary);
        layoutColumn2.add(textField);
        getContent().add(layoutRow);
        layoutRow.add(textSmall);
    }
}
