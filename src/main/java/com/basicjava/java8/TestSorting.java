package com.basicjava.java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class TestSorting {

    public static class Employee {
        private int id = -1;
        private String name = null;
        public Employee(int id, String name) {
            this.id = id;
            this.name = name;
        }
        @Override
        public String toString() {
            return "Employee{" +
                    "name='" + name + '\'' +
                    ", id=" + id +
                    '}';
        }

        @Override
        public int hashCode() {
            return super.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            return super.equals(obj);
        }
    }

    public static void main(String[] args) {
        Employee e1 = new Employee(1, "TestName2");
        Employee e2 = new Employee(2, "TestName1");
        Employee e3 = new Employee(3, "TestName3");

        List<Employee> employees = new ArrayList<>();
        employees.add(e2);
        employees.add(e3);
        employees.add(e1);

        Collections.sort(employees, (o1, o2) -> (o1.name.compareTo(o2.name)));
        //Collections.sort(employees, (o1, o2) -> (o1.id  - o2.id));

        // UnSorted List
        System.out.println(employees);

        System.out.println(employees.stream().filter(emp -> emp.id>2).collect(Collectors.toList()));


        Consumer<Employee> c3 = employee -> System.out.println(employee);
        Consumer<Employee> c2 = employee -> System.out.println(employee.name);
        Consumer<Employee> c1 = employee -> System.out.println(employee.id);

        Consumer<Employee> consumer = (employee) -> {
            if(employee.id >= 2){
                c1.andThen(c2).accept(employee);
                c3.accept(employee);
            }
        };
        employees.forEach(consumer);

        BiConsumer<String,Integer> bi = (name,age) -> System.out.println(name +" : "+age);
        employees.forEach(employee -> bi.accept(employee.name,employee.id));


        Predicate<Integer> p = (p1) -> p1 % 2 == 0;
        Predicate<Integer> p2 = (p1) -> p1 % 3 == 0;
        Predicate<Integer> p3 = (p1) -> p1 % 5 == 0;
        System.out.println(p.test(4));
        System.out.println(p.and(p2).and(p3).negate().test(30));

    }
}
