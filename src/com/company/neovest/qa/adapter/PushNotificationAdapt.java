package com.company.neovest.qa.adapter;

import com.company.neovest.qa.Interfaces.IAdapter;
import com.company.neovest.qa.notifications.Message;

public class PushNotificationAdapt implements IAdapter {
    @Override
    public void adapt(Message message) {
        // Logic to adapt the message for push notification
        // This could involve formatting, adding metadata, etc.
        // Additional adaptation logic can be added here
        System.out.println("Adapted message for push notification: " + message.getMessage());
    }
}
