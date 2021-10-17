'''
Se implementa la clase abstracta RemoteControl a la cual se le inyecta una TV. La TV será el implementador del patrón Bridge

Se tiene un RemoteControl específico llamado ModernRemoteControl que tiene la posibilidad adicional de cambiar de canal a la posición siguiente o anterior

Como TV se puede tener una digital y otra analógica. De esta forma se tienen dos jerarquías totalmente independientes y se puede separar la evolución de RemoteControl de las implementaciones concretas de TV para las que se utilizan
'''

public abstract class RemoteControl {
    private final TV implementator;
    private final int currentChannel = 0;

    public RemoteControl(TV implementator) {
        this.implementator = implementator;
    }

    protected final void setChannel(int channel) {
        implementator.setChannel(channel);
        this.currentChannel = channel;
    }

    protected final int getCurrentChannel() {
        return this.currentChannel;
    }
}

public interface TV {
    setChannel();
}

public class DigitalTV implements TV {
    @Override
    protected final setChannel(int channel) {
        // Sintoniza de forma digital
    }
}

public class AnalogTV implements TV {
    @Override
    protected final setChannel(int channel) {
        // Sintoniza de forma análoga
    }
}

public class ModernRemoteControl implements RemoteControl {
    
    public ModernRemoteControl(TV implementator) {
        super(implementator);
    }

    public void previousChannel(int channel) {
        this.setChannel(this.getCurrentChannel() - 1);
    }

    public void nextChannel(int channel) {
        this.setChannel(this.getCurrentChannel() + 1);
    }
}

public static void main(String[] args) {
    TV implementator = new DigitalTV();
    RemoteControl remoteControl = new ModernRemoteControl(implementator);
    remoteControl.setChannel(5);
}