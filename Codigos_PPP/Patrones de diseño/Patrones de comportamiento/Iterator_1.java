'''
Se define la interfaz Iterator con dos métodos y su implementación

MessageIterator debería implementar el algoritmo específico para recorrer esa colección

La interfaz Iterable define un método para instanciar Iterator
'''

public class Message {
    // ...
}

public interface Iterator {
    Boolean hasNext();
    Object next();
}

public interface Iterable {
    Iterator creatIterator() {
        return new MessageIterator(messageList)
    }
}

public class MessageIterator implements Iterator {
    private Message[] messageList;
    private int currentPosition;
    // Constructor

    @Override
    public Boolean hasNext() {
        if(position >= messageList.length) {
            return false
        } else {true}
    }

    @Override
    public Object next() {
        Message nextItem = messageList[currentPosition];
        currentPosition += 1;
        return nextItem;
    }
}