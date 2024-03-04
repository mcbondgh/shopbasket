package com.application.shopbasket.views.productsmanager;

import com.application.shopbasket.views.MainLayout;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.accordion.Accordion;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility.Gap;

@PageTitle("Products Manager")
@Route(value = "products-manager", layout = MainLayout.class)
@Uses(Icon.class)
public class ProductsManagerView extends Composite<VerticalLayout> {

    public ProductsManagerView() {
        VerticalLayout layoutColumn2 = new VerticalLayout();
        Accordion accordion = new Accordion();
        HorizontalLayout layoutRow = new HorizontalLayout();
        Paragraph textSmall = new Paragraph();
        getContent().setWidth("100%");
        getContent().getStyle().set("flex-grow", "1");
        layoutColumn2.setWidth("100%");
        layoutColumn2.getStyle().set("flex-grow", "1");
        accordion.setWidth("100%");
        setAccordionSampleData(accordion);
        layoutRow.addClassName(Gap.MEDIUM);
        layoutRow.setWidth("100%");
        layoutRow.setHeight("min-content");
        textSmall.setText("Copyright (c) 2024 | Powered by Mc's Republic");
        textSmall.setWidth("100%");
        textSmall.getStyle().set("font-size", "var(--lumo-font-size-xs)");
        getContent().add(layoutColumn2);
        layoutColumn2.add(accordion);
        getContent().add(layoutRow);
        layoutRow.add(textSmall);
    }

    private void setAccordionSampleData(Accordion accordion) {
        Span name = new Span("Sophia Williams");
        Span email = new Span("sophia.williams@company.com");
        Span phone = new Span("(501) 555-9128");
        VerticalLayout personalInformationLayout = new VerticalLayout(name, email, phone);
        personalInformationLayout.setSpacing(false);
        personalInformationLayout.setPadding(false);
        accordion.add("Personal information", personalInformationLayout);
        Span street = new Span("4027 Amber Lake Canyon");
        Span zipCode = new Span("72333-5884 Cozy Nook");
        Span city = new Span("Arkansas");
        VerticalLayout billingAddressLayout = new VerticalLayout();
        billingAddressLayout.setSpacing(false);
        billingAddressLayout.setPadding(false);
        billingAddressLayout.add(street, zipCode, city);
        accordion.add("Billing address", billingAddressLayout);
        Span cardBrand = new Span("Mastercard");
        Span cardNumber = new Span("1234 5678 9012 3456");
        Span expiryDate = new Span("Expires 06/21");
        VerticalLayout paymentLayout = new VerticalLayout();
        paymentLayout.setSpacing(false);
        paymentLayout.setPadding(false);
        paymentLayout.add(cardBrand, cardNumber, expiryDate);
        accordion.add("Payment", paymentLayout);
    }
}
