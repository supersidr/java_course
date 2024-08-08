public class Main {
    public static void main(String[] args) {
        Calculator calc = Calculator.instance.get();

        int a = calc.plus.apply(1, 2);
        int b = calc.minus.apply(1,1);
        int c = calc.divide.apply(a, b);
//      Ошибка возникает, так как на 0 делить нельзя.
//      Можно поставить условие, если y !=0 и возращать другое значение например 0
        calc.println.accept(c);
    }
}
