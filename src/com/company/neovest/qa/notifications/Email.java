package com.company.neovest.qa.notifications;

import com.company.neovest.qa.Interfaces.INotification;
import com.company.neovest.qa.Partido;
import com.company.neovest.qa.Usuario;
import com.company.neovest.qa.adapter.JavaMial;

import java.util.List;

public class Email implements INotification {
    private JavaMial adapter;


    @Override
    public void sendNotification(Message message) {
        NotificationFacade notification = new NotificationFacade();
        adapter = new JavaMial();
        adapter.adapt(message);
        // Additional logic for email notifications can be added here
        System.out.println("Email notification sent: " + message.getMessage());
    }

}
