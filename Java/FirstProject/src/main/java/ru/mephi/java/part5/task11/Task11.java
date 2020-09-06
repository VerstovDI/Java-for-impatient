package ru.mephi.java.part5.task11;

import java.util.ArrayList;
import java.util.Objects;

// https://www.baeldung.com/java-assert
// https://habr.com/ru/post/141080/
// https://tproger.ru/translations/10-ways-to-handle-null-in-java/
// https://stackoverflow.com/questions/1081409/why-should-i-use-asserts
// https://softwareengineering.stackexchange.com/questions/137158/is-it-better-to-use-assert-or-illegalargumentexception-for-required-method-param
public class Task11 {
    public static double someMethod(ArrayList<Double> arrayList) {
        /* public static method that checks that the specified object reference is not null.
        Throws NullPointerException if obj is null
        returns obj
        Сразу можно обращаться в этой же строке к объекту: Objects.requireNonNull().method.method...
        Из-за этого компактнее и удобнее запись, поскольку не надо отдельно прорабатывать блок
        обработки ислючений + не надо повторно обращаться к объекту
        assert удобнее использовать при тестировании, отлове багов.
        явно подсвечиваются в коде, пишутся отдельно и видно
        Кроме того, не влияют на производительность, могут отключаться
        при развертывании в продуктовой среде (ключ -ea)
        Objects.requireNonNull - "для пользователей программы, для отловливания ислючений"
        asserts - "для программиста, всегда, чтобы в рантайме избегать критических ситуаций,
        которые иногда, на первый взгляд, могут и не произойти"
        существенно упрощают локализацию багов в код
        Правильно расставленные assert'ы способны заменить большинство комментариев в коде
        Т.к. assert'ы могут быть удалены на этапе компиляции либо во время исполнения программы,
        они не должны менять поведение программы.
        Если в результате удаления assert'а поведение программы может измениться,
         то это явный признак неправильного использования assert'а.
        */
        Objects.requireNonNull(arrayList).add(5.0);
        return arrayList.get(0);
    }

    public int factorial(int n)
    {
        // Факториал отрицательного числа не считается
        assert(n >= 0);
        if (n < 2) {
            return 1;
        }
        return factorial(n - 1) * n;
    }
}
