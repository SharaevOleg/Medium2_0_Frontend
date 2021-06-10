package com.example.application.login;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.login.LoginI18n;
import com.vaadin.flow.component.login.LoginOverlay;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;

@Route(value = "hello")
@RouteAlias(value = "")
@PageTitle("Страница авторизации")
public class LoginView extends HorizontalLayout {


    public LoginView() {
        LoginOverlay component = new LoginOverlay();
        H1 title = new H1();
        title.getStyle().set("color", "var(--lumo-base-color)");
        title.add(new Text("MEDIUM 2.0"));
        component.setTitle(title);

        component.addLoginListener(e -> component.close());

        LoginI18n i18n = LoginI18n.createDefault();
        i18n.setAdditionalInformation("Чтобы закрыть форму входа, заполните имя пользователя и пароль");
        i18n.setHeader(new LoginI18n.Header());
        i18n.getHeader().setDescription("платформа для социальной журналистики");
        i18n.getForm().setUsername("Пользователь (E-mail)");
        i18n.getForm().setTitle("Войдите в свою учетную запись");
        i18n.getForm().setPassword("Пароль");
        i18n.getForm().setForgotPassword("Я забыл свой пароль");
        i18n.getErrorMessage().setTitle("Пользователь/пароль неверные");
        i18n.getErrorMessage().setMessage("Проверьте свое имя пользователя и пароль и попробуйте еще раз.");


        component.setI18n(i18n);


        Button open = new Button(" ВХОД ",
                e -> component.setOpened(true));

        add(component, open);

//        Checkbox checkbox = new Checkbox();
//        checkbox.setLabel("Запомни меня");
//        checkbox.setValue(false);
//        add(checkbox);


    }

}

