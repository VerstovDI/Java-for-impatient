package ru.mephi.java.part6.Extras.GenericArraysCreation.TArray;

import ru.mephi.java.part6.Extras.GenericArraysCreation.СoContrVariance.Employee;
import ru.mephi.java.part6.Extras.GenericArraysCreation.СoContrVariance.Manager;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.function.*;

public class Main {

    public static void main(String[] args)
            throws InstantiationException, IllegalAccessException, NoSuchMethodException,
                    InvocationTargetException {
        // Второй способ получения generic-массива
        Integer[] ints1 = getTypedArray1(Integer[]::new, 10);
        Integer[] ints2 = getTypedArray2(Integer[].class, 10);
        ints1[0] = 6;
        ints2[0] = 8;

        // Примеры со слайда Class
        // Строка 1
        Employee employeeInstance1 = new Employee();
        Employee employeeInstance2 = getTypedInstance1(Employee.class);
        Employee employeeInstance3 = getTypedInstance2(Employee.class.getConstructor());
        Employee employeeInstance4 = getTypedInstance3(Employee::new);
        employeeInstance2.getAge();
        employeeInstance3.getAge();
        employeeInstance4.getAge();

        // Строка 2
        Class<?> someClass1 = someAPIMethod(Employee.class, Object.class);
        System.out.println("Is Employee an Object -> " + someClass1);
        Class<?> someClass2 = someAPIMethod(Object.class, Employee.class);
        System.out.println("Is Object an Employee -> " + someClass2);
        Class<?> someClass3 = someAPIMethod(Manager.class, Employee.class);
        System.out.println("Is Manager an Employee -> " + someClass3);
        Class<?> someClass4 = someAPIMethod(Employee.class, Manager.class);
        System.out.println("Is Employee a Manager -> " + someClass4);

        BiPredicate<Class<Employee>, Class<Manager>> tBiPredicate1 = (aCl, tCl) -> tCl.isAssignableFrom(aCl);
        Class<?> someCl1 = someAPIMethodLambda(tBiPredicate1, Employee.class, Manager.class);
        System.out.println("[2]Is Employee a Manager -> " + someCl1);
        BiPredicate<Class<Manager>, Class<Employee>> tBiPredicate2 = (aCl, tCl) -> tCl.isAssignableFrom(aCl);
        Class<?> someCl2 = someAPIMethodLambda(tBiPredicate2, Manager.class, Employee.class);
        System.out.println("[2]Is Manager an Employee -> " + someCl2);

        // Строка 3
        // используется в getTypedArray

        // Строка 4
        Employee newEmp = new Employee("Henry", 49, "OFFICE", 1000);
        System.out.println(newEmp);

        ArgumentsSupplier<Employee> argumentsSupplier = Employee::new;
        Employee newNewEmp = randomEmployee1(argumentsSupplier);
        System.out.println(newNewEmp);
        Random rnd2 = new Random();
        Employee theEmp = randomEmployee2(Employee.class
                .getConstructor(String.class, int.class, String.class, double.class));
        System.out.println(theEmp);

        // Строка 5
        Size[] sizes1 = Size.values();
        Size[] sizes2 = getTypedArrayFromEnum1(Size.class);
        //Function<Class<Size>, Size[]> classSizeFunction = Class::getEnumConstants;
        //Size[] sizes3 = getTypedArrayFromEnum2(Size.class, classSizeFunction);
        Supplier<Size[]> supplier = Size::values;
        Size[] sizes3 = getTypedArrayFromEnum2(supplier);
        System.out.println(Arrays.toString(sizes1) + "\n" +
                Arrays.toString(sizes2) + "\n" +
                Arrays.toString(sizes3) + "\n");
        //

        // Более наглядный ответ по примеру на контравариантность
        // см. package CoContr..
    }

    // ---- Второй способ создания generic-массива ----
    public static <T> T[] getTypedArray1(IntFunction<T[]> constr, int sz) {
        return constr.apply(sz);
    }

    public static <T> T[] getTypedArray2(Class<T[]> type, int sz) {
        return type.cast(Array.newInstance(type.getComponentType(), sz));
    }

    /*@SuppressWarnings("unchecked")
    public static <T> T[] getTypedArray3(Class<T> type, int sz) {
        return (T[]) Array.newInstance(type, sz);
    }*/

    // Примеры со слайда Class Class<T>
    // ---- 1 ----
    public static <T> T getTypedInstance1(Class<T> cl)
            throws IllegalAccessException, InstantiationException {
        return cl.newInstance();
    }

    public static <T> T getTypedInstance2(Constructor<T> constr)
            throws IllegalAccessException, InvocationTargetException, InstantiationException {
        return constr.newInstance();
    }

    public static <T> T getTypedInstance3(Supplier<T> supplier) {
        return supplier.get();
    }

    // ---- 2 ----
    public static <T> Class<? extends T> someAPIMethod(Class<?> from, Class<T> as) {
        if (as.isAssignableFrom(from)) {
            return from.asSubclass(as);
        }
        return null;
    }

    public static <T, K> Class<? extends T>someAPIMethodLambda(BiPredicate<Class<K>, Class<T>> tBiPredicate,
                                                                Class<K> kClass,
                                                                Class<T> tClass) {
        if (tBiPredicate.test(kClass, tClass)) {
            return kClass.asSubclass(tClass);
        }
        return null;
    }


    // ---- 3 ----
    public static <T> T getTypedCast1(Class<T> cl, Object object) {
        return cl.cast(object);
    }

    public static <T> T getTypedCast2(Supplier<T> supplier, Object object) {
        return supplier.get();
    }

    // ---- 5 ----
    public static <T extends Enum<T>> T[] getTypedArrayFromEnum1(Class<T> tClass) {
        return tClass.getEnumConstants();
    }

    public static <T extends Enum<T>> T[] getTypedArrayFromEnum2(Supplier<T[]> func) {
        return func.get();  // TODO: без рефлексии
    }

    public static <T> T randomEmployee1(ArgumentsSupplier<T> argumentsSupplier) {
        Random rnd2 = new Random();
        return argumentsSupplier.get(UUID.randomUUID().toString(),
                18 + rnd2.nextInt(40),
                        UUID.randomUUID().toString(),
                        12000 + 50000*rnd2.nextDouble());
    }

    public static <T> T randomEmployee2(Constructor<T> constructor)
            throws IllegalAccessException, InvocationTargetException, InstantiationException {
        Random rnd3 = new Random();
        return constructor.newInstance(UUID.randomUUID().toString(),
                18 + rnd3.nextInt(40),
                UUID.randomUUID().toString(),
                12000 + 50000*rnd3.nextDouble());
    }
}
