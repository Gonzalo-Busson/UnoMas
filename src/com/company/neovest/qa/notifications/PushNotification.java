package com.company.neovest.qa.notifications;

import com.company.neovest.qa.Interfaces.INotification;
import com.company.neovest.qa.Partido;
import com.company.neovest.qa.Usuario;
import com.company.neovest.qa.adapter.PushNotificationAdapt;

import javax.swing.*;
import java.util.List;

public class PushNotification implements INotification {
    private PushNotificationAdapt adapter;

    @Override
    public void sendNotification(Message message) {
        NotificationFacade notification = new NotificationFacade();
        adapter = new PushNotificationAdapt();
        adapter.adapt(message);
        // Additional logic for push notifications can be added here
        JOptionPane.showMessageDialog(null, message.getMessage());
        System.out.println("Push notification sent: " + message.getMessage());
    }


}
