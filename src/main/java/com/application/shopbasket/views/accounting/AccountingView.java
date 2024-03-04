package com.application.shopbasket.views.accounting;

import com.application.shopbasket.views.MainLayout;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility.Gap;

@PageTitle("Accounting")
@Route(value = "accounting", layout = MainLayout.class)
@Uses(Icon.class)
public class AccountingView extends Composite<VerticalLayout> {

    public AccountingView() {
        VerticalLayout layoutColumn2 = new VerticalLayout();
        H2 h2 = new H2();
        HorizontalLayout layoutRow = new HorizontalLayout();
        Paragraph textSmall = new Paragraph();
        getContent().setWidth("100%");
        getContent().getStyle().set("flex-grow", "1");
        layoutColumn2.setWidth("100%");
        layoutColumn2.getStyle().set("flex-grow", "1");
        h2.setText("Put Content here");
        h2.setWidth("max-content");
        layoutRow.addClassName(Gap.MEDIUM);
        layoutRow.setWidth("100%");
        layoutRow.setHeight("min-content");
        textSmall.setText("Copyright (c) 2024 | Powered by Mc's Republic");
        textSmall.setWidth("100%");
        textSmall.getStyle().set("font-size", "var(--lumo-font-size-xs)");
        getContent().add(layoutColumn2);
        layoutColumn2.add(h2);
        getContent().add(layoutRow);
        layoutRow.add(textSmall);
    }
}
