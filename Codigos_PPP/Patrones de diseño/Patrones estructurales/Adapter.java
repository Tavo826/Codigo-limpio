'''
Se tiene una aplicación diseñada en Estados Unidos que devuelve el precio de un coche en dólares. Se quiere utilizar esta funcionalidad en otra aplicación que devuelve los precios en euros

Se crea una interfaz AdapterPricer que envuelve a la interfaz Pricer, que es la que devuelve el precio en dólares
'''

public interface Pricer {
    // Return price in
    double getPrice();
}

public class FerrariPricer implements Pricer {
    // Return price in $
    double getPrice() {
        return 2000000
    }
}

public interface AdapterPricer {
    // Return price in
    double getPrice();
}

public class AdapterPricerImpl implements AdapterPricer {
    private final Pricer pricer;

    // Constructor

    public double getPrice() {
        ...
        double priceInDolars = pricer.getPrice();
        double priceInEuros = convertToEuros(priceInDolars);
    }

    private double convertToEuros(double price){
        // Returns price in euros
    }
}

public class Main {
    public static void main(String[] args) {
        final FerrariPricer ferrariPricer = new FerrariPricer();
        final AdapterPricer ferrariPricerAdapter = new AdapterPricerImpl(ferrariPricer);
        ...
        double ferrariPrice = ferrariPricerAdapter.getPrice();
        // ferrari price in Euros
    }
}