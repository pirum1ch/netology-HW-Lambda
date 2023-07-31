import java.util.function.*;

public class Main {
    public static void main(String[] args) {
        Calculator calc = Calculator.instace.get();

        int a = calc.plus.apply(1, 2);
        int b = calc.minus.apply(1,1);
        int c = calc.devide.apply(a, b);

        // Выполнеине прерывается ArithmeticException - / by zero,
        // тк в функцию при вычислении производится недопустимая операция деления на 0
        // В функцию devide передаются 2 аргумента, ранее вычисленных на предыдущих шагах.
        // Знаменатель (b) после вычисления (calc.minus.apply(1,1)) равен нулю,
        // а делить на ноль нельзя

        calc.println.accept(c);
    }

}

