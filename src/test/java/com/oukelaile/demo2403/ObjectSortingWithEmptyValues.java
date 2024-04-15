package com.oukelaile.demo2403;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ObjectSortingWithEmptyValues {

    public static void main(String[] args) {
        // 创建一个包含 Person 对象的 List
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("Charlie123", null));
        personList.add(new Person("Alice", 25));
        personList.add(new Person("Bob", 30));
        personList.add(new Person("Charlie", null));

        List<Person> sortedPersonList =
                personList.stream()
                        .sorted((Comparator.comparing(Person::getAge,Comparator.nullsLast(Integer::compareTo))))
                        .collect(Collectors.toList());


        // 打印排序后的结果
        sortedPersonList.forEach(person -> System.out.println(person.getName() + ": " + person.getAge()));
    }

    static class Person {
        private String name;
        private Integer age;

        public Person(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public Integer getAge() {
            return age;
        }
    }
}