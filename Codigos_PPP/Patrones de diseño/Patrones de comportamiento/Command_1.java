'''
Se tienen dos clases como Receivers. Las clases command tienen como atributo su respectivo receiver y se encargan de ejecutar y revertir las acciones pertinentes

Una pequeña desventaja es el incremento del número de clases por comando
'''

public interface Command {
    void execute();
    void undo();
}

// Receiver

public class Speaker {
    public String turnUpVolume() {
        return "Turning up volume..."
    }

    public String turnDownVolume() {
        return "Turning down volume..."
    }
}

public class AirCondition {
    public String on() {
        return "A.C is on"
    }

    public String off() {
        return "A.C is off"
    }
}

public class VolumeDownSpeakerCommand implements Command {
    private Speaker speaker;

    // Constructor

    @Override
    public void execute() {
        speaker.turnDownVolume();
    }

    @Override
    public void undo() {
        speaker.turbUpVolume();
    }
}

//Similar para la clase AirConditionOnCommand

public class VolumeUpSpeakerCommand implements Command {
    private Speaker speaker;

    //Constructor

    @Override
    public void execute() {
        speaker.turnUpVolume();
    }

    @Override
    public void undo() {
        speaker.turnDownVolume();
    }
}

// Similar para la clase AirConditionOffCommand