'''
NotificatioScreen será la clase encargada de imprimir los mensajes correspondientes usando los métodos de la clase Iterator
'''

import Iterator1.*;

public class NotificationScreen {
    private Iterable messages
    
    public NotificationScreen(Iterable messages) {
        this.messages = messages;
    }

    public void showMessages() {
        Iterator iterator = messages.createIterator();
        while (iterator.hasNext()) {
            System.out.println("Next item: " + iterator.next());
            // ...
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Iterable message = new MessageIterable();
        NotificationScreen notificationScreen = new NotificationScreen(messages);
        notificationScreen.showMessages();
    }
}