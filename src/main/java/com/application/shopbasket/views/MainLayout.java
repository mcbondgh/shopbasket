package com.application.shopbasket.views;

import com.application.shopbasket.views.accounting.AccountingView;
import com.application.shopbasket.views.customers.CustomersView;
import com.application.shopbasket.views.dashboard.DashboardView;
import com.application.shopbasket.views.defaultpage.DefaultPageView;
import com.application.shopbasket.views.humanresource.HumanResourceView;
import com.application.shopbasket.views.notifications.NotificationsView;
import com.application.shopbasket.views.productsmanager.ProductsManagerView;
import com.application.shopbasket.views.reportsmanager.ReportsManagerView;
import com.application.shopbasket.views.salesmanager.SalesManagerView;
import com.application.shopbasket.views.settings.SettingsView;
import com.application.shopbasket.views.transactions.TransactionsView;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.html.Footer;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Header;
import com.vaadin.flow.component.orderedlayout.Scroller;
import com.vaadin.flow.component.sidenav.SideNav;
import com.vaadin.flow.component.sidenav.SideNavItem;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.theme.lumo.LumoUtility;
import org.vaadin.lineawesome.LineAwesomeIcon;

/**
 * The main view is a top-level placeholder for other views.
 */
public class MainLayout extends AppLayout {

    private H2 viewTitle;

    public MainLayout() {
        setPrimarySection(Section.DRAWER);
        addDrawerContent();
        addHeaderContent();
    }

    private void addHeaderContent() {
        DrawerToggle toggle = new DrawerToggle();
        toggle.setAriaLabel("Menu toggle");

        viewTitle = new H2();
        viewTitle.addClassNames(LumoUtility.FontSize.LARGE, LumoUtility.Margin.NONE);

        addToNavbar(true, toggle, viewTitle);
    }

    private void addDrawerContent() {
        H1 appName = new H1("STOCK-BASKET");
        appName.addClassNames(LumoUtility.FontSize.LARGE, LumoUtility.Margin.NONE);
        Header header = new Header(appName);

        Scroller scroller = new Scroller(createNavigation());

        addToDrawer(header, scroller, createFooter());
    }

    private SideNav createNavigation() {
        SideNav nav = new SideNav();

        nav.addItem(new SideNavItem("Dashboard", DashboardView.class, LineAwesomeIcon.CHALKBOARD_SOLID.create()));
        nav.addItem(new SideNavItem("Accounting", AccountingView.class, LineAwesomeIcon.CASH_REGISTER_SOLID.create()));
        nav.addItem(new SideNavItem("Sales Manager", SalesManagerView.class, LineAwesomeIcon.CART_PLUS_SOLID.create()));
        nav.addItem(
                new SideNavItem("Products Manager", ProductsManagerView.class, LineAwesomeIcon.PRODUCT_HUNT.create()));
        nav.addItem(new SideNavItem("Notifications", NotificationsView.class, LineAwesomeIcon.BELL_SOLID.create()));
        nav.addItem(new SideNavItem("Transactions", TransactionsView.class, LineAwesomeIcon.CC_VISA.create()));
        nav.addItem(new SideNavItem("Customers", CustomersView.class, LineAwesomeIcon.USER_TAG_SOLID.create()));
        nav.addItem(
                new SideNavItem("Human Resource", HumanResourceView.class, LineAwesomeIcon.USER_COG_SOLID.create()));
        nav.addItem(new SideNavItem("Reports Manager", ReportsManagerView.class, LineAwesomeIcon.CHART_BAR.create()));
        nav.addItem(new SideNavItem("Settings", SettingsView.class, LineAwesomeIcon.COG_SOLID.create()));
        nav.addItem(new SideNavItem("Default Page", DefaultPageView.class, LineAwesomeIcon.CHART_AREA_SOLID.create()));

        return nav;
    }

    private Footer createFooter() {
        Footer layout = new Footer();

        return layout;
    }

    @Override
    protected void afterNavigation() {
        super.afterNavigation();
        viewTitle.setText(getCurrentPageTitle());
    }

    private String getCurrentPageTitle() {
        PageTitle title = getContent().getClass().getAnnotation(PageTitle.class);
        return title == null ? "" : title.value();
    }
}
