'''
Problemas:

La función es de gran tamaño y crecerá con nuevos tipos de empleados
Hace más de una cosa
Incumple el pricipio de responsabilidad única (SRP) y el principio Open/Closed (OCP)
Hay un número ilimitado de funciones que tienen la misma estructura
    Ejemplos:
    isPayday(Employee e, Date date)
    deliveryPay(Employee e, Money pay)
'''

public Money calculatePay(Employee e)
throws InvalidEmployeeType {
    switch (e.type) {
        case COMISSIONED:
            return calculateComissionedPay(e);
        case HOURLY:
            return calculateHourlyPay(e);
        case SALARIED:
            return calculateSalariedPay(e);
        default:
            throw new InvalidEmployeeType(e.type);
    }
}

'''
Esto se soluciona ocultando la instrucción switch en una factoría abstracta que usa la instrucción switch para crear las instancias adecuadas de los derivados de Employee y las distintas funciones calculatePay, isPayday y deliverPay se entregan de forma polimórfica a través de la interfaz Employee
'''

public abstract class Employee {
    public abstract boolean isPayday();
    public abstract Money calculatePay();
    public abstract void deliveryPay();
}

public interface EmployeeFactory {
    public Employee makeEmployee(EmployeeRecord r) throws invalidEmployeeType;
}

public class EmployeeFactoryImpl implements EmployeeFactory {
    public Employee makeEmployee(EmployeeRecord r) throws invalidEmployeeType {
        switch (r.type) {
            case COMISSIONED:
                return new CommisionedEmployee(r);
            case HOURLY:
                return new HourlyEmployee(r);
            case SALARIED:
                return new SalariedEmployee(r);
            default:
                throw new InvalidEmployeeType(e.type);
            }
    }
}