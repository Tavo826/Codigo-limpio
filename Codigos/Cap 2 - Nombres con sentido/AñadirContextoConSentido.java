'''
Variables con un contexto ambiguo
La función es demasiado extensa y las variables aparecen por todas partes
Las variables number, verb y pluralModifier causan problemas al contexto
'''

private void printGuessStatics(char candidate, int count) {
    String number;
    String verb;
    String pluralModifier;
    if (count == 0) {
        number = "no";
        verb = "are";
        pluralModifier = "s";
    } else if (count == 1) {
        number = "1";
        verb = "is";
        pluralModifier = "";
    } else {
        number = Integer.toString(count);
        verb = "are";
        pluralModifier = "s"
    }
    
    String guessMessage = String.format("There %s %s %s%s", verb, number, candidate, pluralModifier);
    
    print(guessMessage);
}

'''
Variables con contexto
Se crea una clase GuessStaticsMessage para dividir la función en fragmentos y convertir las 3 variables en campos de la misma
'''

public class GuessStaticsMessage {
    private String number;
    private String verb;
    private String pluralModifier;
}

public String make(char candidate, int count) {
    createPluralDependentMessagePart(count);
    return String.format("There %s %s %s%s", verb, number, candidate, pluralModifier)
}

private void createPluralDependentMessagePart(int count) {
    if (count == 0) {
        thereAreNoLetters();
    } else if (count == 1) {
        thereIsOneLetter();
    } else {
        thereAreManyLetters(count);
    }
}

private void thereAreManyLetters(int count) {
    number = Integer.toString(count);
    verb = "are";
    pluralModifier = "s"
}

private void thereIsOneLetter() {
    number = "1";
    verb = "is";
    pluralModifier = "";
}

private void thereAreNoLetters() {
    number = "no";
    verb = "are";
    pluralModifier = "s";
}