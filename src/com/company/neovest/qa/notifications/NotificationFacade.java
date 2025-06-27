package com.company.neovest.qa.notifications;

import com.company.neovest.qa.Interfaces.INotification;
import com.company.neovest.qa.Usuario;

import java.util.List;

public class NotificationFacade {

   INotification notificationMail = new Email();
   INotification notificationPush = new PushNotification();

   public void sendNotificationPartidoNecesitandoJugadores(List<Usuario> usuarios) {
       Message message = new Message("Partido creado con exito! Ahora en busqueda de jugadores.");
       notificarATodos(usuarios,message);
   }

   public void sendNotificationPartidoCancelado(List<Usuario> usuarios) {
       Message message = new Message("Partido cancelado");
         notificarATodos(usuarios, message);
   }
    public void sendNotificationPartidoEnArmado(List<Usuario> usuarios) {
        Message message = new Message("El partido esta Armado");
        notificarATodos(usuarios, message);
    }

    public void sendNotificationPartidoEnJuego(List<Usuario> usuarios) {
       Message message = new Message("El partido esta en juego");
       notificarATodos(usuarios, message);
   }

    public void sendNotificationPartidoFinalizado(List<Usuario> usuarios) {
        Message message = new Message("El partido ha Finalizado");
        notificarATodos(usuarios, message);
    }


   public void notificarATodos(List<Usuario> usuarios, Message message) {
       for (Usuario usuario : usuarios) {
           System.out.println("------------Notificando a: " + usuario.getEmail() + " con el mensaje: " + message.getMessage());
           notificationMail.sendNotification(message);
           notificationPush.sendNotification(message);
       }
   }
}
