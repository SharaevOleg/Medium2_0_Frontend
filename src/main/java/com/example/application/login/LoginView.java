package com.example.application.login;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value = "/login")
@PageTitle("Страница авторизации")

public class LoginView extends HorizontalLayout {

    private final Text text = new Text("Войдите в свою учетную запись");

    public LoginView() {

        setWidthFull();
        setHeightFull();
        add(loginFormConfig());
    }

    private Component h1Cofig() {
        H1 h1Field = new H1("MEDIUM 2.0");
        return h1Field;
    }

    private Component emailFieldConfig() {
        EmailField emailField = new EmailField("Пользователь (E-mail)");
        emailField.setClearButtonVisible(true);
        emailField.setErrorMessage("Пожалуйста, введите действительный адрес электронной почты");
        return emailField;
    }

    private Component passwordFieldConfig() {
        PasswordField passwordField = new PasswordField();
        passwordField.setLabel("Пароль");
        passwordField.setPlaceholder("Введите пароль");
        return passwordField;
    }

    private Component checkboxConfig() {
        Checkbox checkbox = new Checkbox();
        checkbox.setLabel("запомнить меня");
        checkbox.setValue(false);
        return checkbox;
    }

    private Component buttonConfig() {
        Button button = new Button("Войти");
        return button;
    }

    private Component loginFormConfig() {
        VerticalLayout loginFormVerticalLayout = new VerticalLayout();
        loginFormVerticalLayout.setJustifyContentMode(JustifyContentMode.CENTER);
        loginFormVerticalLayout.setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        loginFormVerticalLayout.add(h1Cofig(), text, emailFieldConfig(), passwordFieldConfig(), checkboxConfig(), buttonConfig());
        return loginFormVerticalLayout;
    }
}

