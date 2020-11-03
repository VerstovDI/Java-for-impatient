package ru.mephi.java.TheoryStaff.InvCoContrvariance;

import java.util.Optional;

public class Examples {
    public static void main(String[] args) {
        /*Тип Optional<A> ковариантен.
        Например, всегда можно привести Optional<Integer> к Optional<Number> и это будет безопасно.
        */
        Optional<Integer> optionalInt = Optional.of(5);
        Optional<Number> optionalNum = Optional.empty();

        /*Тип Consumer<A> контравариантен.
        Всегда можно безопасно привести Consumer<Number> к Consumer<Integer>.
        */

        /*
        Дженерики без вайлдкардов инвариантны:
        List<Number> нельзя положить  ни в переменную типа List<Double>,
        ни в List<Object>.

        Тип List<A> инвариантен, так как он не является ни ковариантным, ни контравариантным .
        То есть нельзя безопасно привести ни от List<Integer> к List<Number>,
        и ни от List<Number> к List<Integer>
         */
    }
}
