'''
Se define la interfaz Text con su implementación BaseText que define un comportamiento básico que oidrá ser modificado por un decorador.

BoldTextDecorador, italic y Underline definen el comportamiento que se va a añadir dinámicamente al componente (BaseText)

Ventajas:

* Añade o elimina funcionalidades de forma flexible a un objeto en tiempo de ejecución
* Sigue el principio Open/Closed
* Permite envolver un objeto en varios decorators
'''

public interface Text {
    void write();
}

public class BaseText extends Text {
    @Override
    public void write() {
        System.out.println("Some basic text");
    }
}

public class TextDecorator implements Text {
    private Text decoratedText;

    public TextDecorator(Text decoratedText) {
        this.decoratedText = decoratedText;
    }

    @Override
    public void write() {
        decoratedText.write();
    }
}

public class BoldTextDecorator extends TextDecorator {
    public BoldTextDecorator(Text decoratedText) {
        super(decoratedText);
    }

    @Override
    public void write() {
        System.out.println("Adding bold style to text");
        super.write();
    }
}

/*
Another class for ItalicTextDecorator
Another class for UderlineTextDecorator
*/

public class Main {
    public static void main(String[] args) {
        Text baseText = new BaseText();
        baseText.write();

        Text boldText = new BoldTextDecorator(baseText);
        boldText.write();

        Text italicText = new ItalicTextDecorator(baseText);
        italicText.write();
    }
}
