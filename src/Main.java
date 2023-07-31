import org.w3c.dom.ls.LSOutput;

import java.util.function.*;

public class Main {
    public static void main(String[] args) {
        Calculator calc = Calculator.instace.get();

        int a = calc.plus.apply(1, 2);
        int b = calc.minus.apply(1,1);
//        int c = calc.devide.apply(a, b);
        // Выполнеине прерывается ArithmeticException - / by zero,
        // тк в функцию при вычислении производится недопустимая операция деления на 0
        // В функцию devide передаются 2 аргумента, ранее вычисленных на предыдущих шагах.
        // Знаменатель (b) после вычисления (calc.minus.apply(1,1)) равен нулю,
        // а делить на ноль нельзя

        try{
            int c = calc.devide.apply(a, b);
            calc.println.accept(c);
        }catch (ArithmeticException ae){
            System.out.println("Ошибка деления на 0");
        }
        // По заданию необходимо реализовать обработку исключения.
        // В моем решенеии используется блок try/catch тк
        // я считаю некорректным изменять функцию - keep it simple and stupid,
        // а исключения нужно отлавливать на этапе вычисления

    }

}

class Calculator {
    static Supplier<Calculator> instace = Calculator::new;

    BinaryOperator<Integer> plus = (x,y) -> x + y;
    BinaryOperator<Integer> minus  = (x,y) -> x - y;
    BinaryOperator<Integer> multiply = (x,y) -> x * y;
    BinaryOperator<Integer> devide  = (x,y) -> x / y;

    UnaryOperator<Integer> pow = x -> x * x;
    UnaryOperator<Integer> abs = x -> x > 0 ? x : x * -1;

    Predicate<Integer> isPositive = x -> x > 0;

    Consumer<Integer> println = System.out::println;


}