package com.company.neovest.qa.Interfaces;

import com.company.neovest.qa.Partido;
import com.company.neovest.qa.Usuario;
import com.company.neovest.qa.notifications.Message;

import java.util.List;

public interface INotification {
    void sendNotification(Message message);
}
