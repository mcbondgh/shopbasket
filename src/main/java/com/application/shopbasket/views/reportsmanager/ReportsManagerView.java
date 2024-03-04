package com.application.shopbasket.views.reportsmanager;

import com.application.shopbasket.components.phonenumberfield.PhoneNumberField;
import com.application.shopbasket.components.pricefield.PriceField;
import com.application.shopbasket.views.MainLayout;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.TabSheet;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility.Gap;

@PageTitle("Reports Manager")
@Route(value = "reports", layout = MainLayout.class)
@Uses(Icon.class)
public class ReportsManagerView extends Composite<VerticalLayout> {

    public ReportsManagerView() {
        VerticalLayout layoutColumn2 = new VerticalLayout();
        TabSheet tabSheet = new TabSheet();
        PhoneNumberField phoneNumber = new PhoneNumberField();
        PriceField price = new PriceField();
        HorizontalLayout layoutRow = new HorizontalLayout();
        Paragraph textSmall = new Paragraph();
        getContent().setWidth("100%");
        getContent().getStyle().set("flex-grow", "1");
        layoutColumn2.setWidth("100%");
        layoutColumn2.getStyle().set("flex-grow", "1");
        tabSheet.setWidth("100%");
        setTabSheetSampleData(tabSheet);
        phoneNumber.setLabel("Phone number");
        phoneNumber.setWidth("min-content");
        price.setLabel("Price");
        price.setWidth("min-content");
        layoutRow.addClassName(Gap.MEDIUM);
        layoutRow.setWidth("100%");
        layoutRow.setHeight("min-content");
        textSmall.setText("Copyright (c) 2024 | Powered by Mc's Republic");
        textSmall.setWidth("100%");
        textSmall.getStyle().set("font-size", "var(--lumo-font-size-xs)");
        getContent().add(layoutColumn2);
        layoutColumn2.add(tabSheet);
        layoutColumn2.add(phoneNumber);
        layoutColumn2.add(price);
        getContent().add(layoutRow);
        layoutRow.add(textSmall);
    }

    private void setTabSheetSampleData(TabSheet tabSheet) {
        tabSheet.add("Dashboard", new Div(new Text("This is the Dashboard tab content")));
        tabSheet.add("Payment", new Div(new Text("This is the Payment tab content")));
        tabSheet.add("Shipping", new Div(new Text("This is the Shipping tab content")));
    }
}
