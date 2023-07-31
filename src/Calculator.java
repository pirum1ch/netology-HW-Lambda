import java.util.function.*;

class Calculator {
    protected static Supplier<Calculator> instace = Calculator::new;

    BinaryOperator<Integer> plus = (x, y) -> x + y;
    BinaryOperator<Integer> minus  = (x,y) -> x - y;
    BinaryOperator<Integer> multiply = (x,y) -> x * y;
    BinaryOperator<Integer> devide  = (x,y) -> {
        try {
            return x / y;
        }catch (ArithmeticException ae){
            System.out.println("деление на ноль! ");
            return 0;
        }
    };
    UnaryOperator<Integer> pow = x -> x * x;
    UnaryOperator<Integer> abs = x -> x > 0 ? x : x * -1;
    Predicate<Integer> isPositive = x -> x > 0;
    Consumer<Integer> println = System.out::println;
}