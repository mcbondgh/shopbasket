package com.application.shopbasket.views.customers;

import com.application.shopbasket.data.SamplePerson;
import com.application.shopbasket.services.SamplePersonService;
import com.application.shopbasket.views.MainLayout;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.data.VaadinSpringDataHelpers;
import com.vaadin.flow.theme.lumo.LumoUtility.Gap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;

@PageTitle("Customers")
@Route(value = "customer", layout = MainLayout.class)
@Uses(Icon.class)
public class CustomersView extends Composite<VerticalLayout> {

    public CustomersView() {
        VerticalLayout layoutColumn2 = new VerticalLayout();
        Grid multiSelectGrid = new Grid(SamplePerson.class);
        HorizontalLayout layoutRow = new HorizontalLayout();
        Paragraph textSmall = new Paragraph();
        getContent().setWidth("100%");
        getContent().getStyle().set("flex-grow", "1");
        layoutColumn2.setWidth("100%");
        layoutColumn2.getStyle().set("flex-grow", "1");
        multiSelectGrid.setSelectionMode(Grid.SelectionMode.MULTI);
        multiSelectGrid.setWidth("100%");
        multiSelectGrid.getStyle().set("flex-grow", "0");
        setGridSampleData(multiSelectGrid);
        layoutRow.addClassName(Gap.MEDIUM);
        layoutRow.setWidth("100%");
        layoutRow.setHeight("min-content");
        textSmall.setText("Copyright (c) 2024 | Powered by Mc's Republic");
        textSmall.setWidth("100%");
        textSmall.getStyle().set("font-size", "var(--lumo-font-size-xs)");
        getContent().add(layoutColumn2);
        layoutColumn2.add(multiSelectGrid);
        getContent().add(layoutRow);
        layoutRow.add(textSmall);
    }

    private void setGridSampleData(Grid grid) {
        grid.setItems(query -> samplePersonService.list(
                PageRequest.of(query.getPage(), query.getPageSize(), VaadinSpringDataHelpers.toSpringDataSort(query)))
                .stream());
    }

    @Autowired()
    private SamplePersonService samplePersonService;
}
