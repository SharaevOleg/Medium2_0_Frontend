package com.example.application.login;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.confirmdialog.ConfirmDialog;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;

@Route(value = "hello")
@RouteAlias(value = "")
@PageTitle("Страница авторизации")
public class LoginView extends HorizontalLayout {


    public LoginView() {

//        Форма диалогового окна и кнопка перехода на форму

        ConfirmDialog dialog = new ConfirmDialog("MEDIUM 2.0",
                "Чтобы закрыть форму входа, заполните имя пользователя и пароль", "Log in", this::onPublish,
                "Exit", this::onCancel);
        Button button = new Button("Вход");
        button.addClickListener(event -> dialog.open());
        add(button, dialog);

//        Добавляем поля
        VerticalLayout layout = new VerticalLayout();
        layout.setJustifyContentMode(JustifyContentMode.CENTER);

        layout.setDefaultHorizontalComponentAlignment(
                FlexComponent.Alignment.STRETCH);

        Text text = new Text("Войдите в свою учетную запись");

        EmailField emailField = new EmailField("Пользователь (E-mail)");
        emailField.setClearButtonVisible(true);
        emailField.setErrorMessage("Пожалуйста, введите действительный адрес электронной почты");

        PasswordField passwordField = new PasswordField();
        passwordField.setLabel("Пароль");
        passwordField.setPlaceholder("Введите пароль");
        passwordField.setValue("пароль!");

        Checkbox checkbox = new Checkbox();
        checkbox.setLabel("запомните меня");
        checkbox.setValue(false);

        Anchor anchor = new Anchor("https://vaadin.com", "Я забыл свой пароль");
        anchor.getElement().addEventListener("click", e -> Notification.show("переходим в новое окно"));

        layout.add(text, emailField, passwordField, checkbox, anchor);

        dialog.add(layout);
    }


//    Методы на кнопки Входа/авторизации и выхода из формы
    private void onPublish(ConfirmDialog.ConfirmEvent confirmEvent) {
    }

    private void onCancel(ConfirmDialog.CancelEvent cancelEvent) {
    }


}

