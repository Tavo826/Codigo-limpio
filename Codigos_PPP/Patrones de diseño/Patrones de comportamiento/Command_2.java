'''
La clase RemoteControl no sabe la implementación del comando que se quiere ejecutar, solo conoce su interfaz

Ventajas:

* Cumple con SRP. Se desacoplan las clases que invocan las acciones de las que la ejecutan
* Cumple con Open/Close. Se puede introducir tantos comandos como se necesiten
"Se puede gestionar operaciones de reversión o encolado de comandos"
'''

import Command_1.*;

// Invoker

public class RemoteControl {
    private Command command;

    public RemoteControl(Command command) {
        this.command = command;
    }

    public void executeOperation() {
        command.execute();
    }

    public void undoOperation() {
        command.undo();
    }
}

public class Main {
    public static void main(String[] args) {
        Speaker speaker = new Speaker();
        Command volumeUpSpeaker = new VolumeUpSpeakerCommand(speaker);
        RemoteControl remoteControl = new RemoteControl(volumeUpSpeaker);

        remoteControl.executeOperation();
        remoteControl.undoOperation();
    }
}