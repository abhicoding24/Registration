package com.api;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class A {
    public static void main(String[] args) {
        Predicate<Integer> val = x -> x > 300;
        Boolean result = val.test(100);
        System.out.println(result);

        Predicate<String> value = y -> y.equals("mike");
        boolean res = value.test("john");
        System.out.println(res);

        List<Integer> data = Arrays.asList(10, 12, 15, 20, 5, 17);
        List<Integer> newData = data.stream().filter(a -> a > 15).collect(Collectors.toList());
        System.out.println(newData);

        List<String> names = Arrays.asList("sai", "ravi", "mahi", "sara", "navin");
        List<String> getNames = names.stream().filter(n -> n.startsWith("n")).collect(Collectors.toList());
        System.out.println(getNames);

        List<Integer> nums = Arrays.asList(10, 11, 13, 14, 15, 16);
        List<Integer> evenNums = nums.stream().filter(m -> m % 2 == 0).collect(Collectors.toList());
        System.out.println(evenNums);

        List<Integer> numbers = Arrays.asList(10, 11, 13, 14, 15, 16);
        List<Integer> oddNumbers = numbers.stream().filter(b -> b % 2 != 0).collect(Collectors.toList());
        System.out.println(oddNumbers);

        Function<String, Integer> num = c -> c.length();
        Integer lengthNum = num.apply("harry");
        System.out.println(lengthNum);

        List<String> datas = Arrays.asList("sai", "ravi", "mahi", "sara", "navin");
        List<String> uppercaseDatas = datas.stream().map(d -> d.toUpperCase()).collect(Collectors.toList());
        System.out.println(uppercaseDatas);

        List<Integer> values = Arrays.asList(10, 20, 30, 40, 50);
        List<Integer> squareOfValues = values.stream().map(v -> v * v).collect(Collectors.toList());
        System.out.println(squareOfValues);

        List<Integer> valuesList = Arrays.asList(10, 20, 30, 40, 50);
        List<Integer> newValues = valuesList.stream().map(v -> v + 5).collect(Collectors.toList());
        System.out.println(newValues);

        List<String> allNames = Arrays.asList("sai", "ravi", "mahi", "sara", "navin");
        List<Integer> lengthOfNames = allNames.stream().map(e -> e.length()).collect(Collectors.toList());
        System.out.println((lengthOfNames));

        List<String> allName = Arrays.asList("sai", "ravi", "mahi", "sara", "navin");
        List<String> sortedList = allName.stream().sorted().collect(Collectors.toList());
        System.out.println(sortedList);

        List<String> nameList = Arrays.asList("sai", "ravi", "mahi", "navin", "ravi", "harry", "mahi", "suraj", "navin");
        List<String> uniqueNames = nameList.stream().distinct().collect(Collectors.toList());
        System.out.println(uniqueNames);

        Consumer<String> word = u -> System.out.println(u);
        word.accept("mike");

        List<String> namesList = Arrays.asList("Alice", "Bob", "Charlie");
        Consumer<String> newList = s -> System.out.println(s);
        namesList.forEach(newList);

        List<Employee> employees = Arrays.asList(
                new Employee(1, "mike", 5000),
                new Employee(2, "stallin", 4000),
                new Employee(3, "adam", 9000)
        );
        //List<Employee> emps = employees.stream().filter(h->h.getSal()>4000).collect(Collectors.toList());
        List<Employee> emps = employees.stream().filter(h -> h.getName().startsWith("a")).collect(Collectors.toList());
        //System.out.println(emps);
        for (Employee emp : emps) {
            System.out.println(emp.getId());
            System.out.println(emp.getName());
            System.out.println(emp.getSal());
        }
        List<Employee> empps = Arrays.asList(
                new Employee(1,"mike",5000),
                new Employee(2,"will",4000),
                new Employee(3,"eddy",5000));
        Map<Long,List<Employee>> empss = empps.stream().collect(Collectors.groupingBy(j->j.getSal()));
        System.out.println(empss);


        List<Employee> emppss = Arrays.asList(
                new Employee(1,"mike",5000),
                new Employee(2,"will",4000),
                new Employee(3,"eddy",5000));
        List<Long> em = emppss.stream().map(Employee::getSal).collect(Collectors.toList());
        System.out.println(em);

        List<Integer> nms = Arrays.asList(10,20,30,40);
        Integer sum  = nms.stream().mapToInt(Integer::intValue).sum();
        System.out.println(sum);

        List<Integer> n1 = Arrays.asList(10,2,80,63,99,25,100,101,7,64);
        Optional<Integer> maxNum = n1.stream().max(Integer::compareTo);
        System.out.println(maxNum.get());

        List<Integer> n2 = Arrays.asList(10,2,80,63,99,25,100,101,7,64);
        Optional<Integer> minNum = n2.stream().min(Integer::compareTo);
        System.out.println(minNum.get());

        List<Integer> n3 = Arrays.asList(5,10,15,20);
        Integer sumOfn3 = n3.stream().mapToInt(Integer::intValue).sum();
        System.out.println(sumOfn3);

        List<String> s1 = Arrays.asList("mike","ravi","sanjoy","sri");
        List<String> filtereds1 = s1.stream().filter(a1->a1.startsWith("s")).collect(Collectors.toList());
        System.out.println(filtereds1);

        List<Integer> n4 = Arrays.asList(5,10,15,20,10,80,65,15,20,10,80,95,10,65);
        Map<Integer, Long> groupsOfn4 = n4.stream().collect(Collectors.groupingBy(a->a, Collectors.counting()));
        System.out.println(groupsOfn4);

        List<Integer> n5 = Arrays.asList(5,10,2,11,15,20,2,9,11,15);
        Optional<Integer> nf = n5.stream().filter(a->a>10).findFirst();
        System.out.println(nf.get());

        List<Employee> e1 = Arrays.asList(
                new Employee(1,"mike",5000),
                new Employee(2,"will",2000),
                new Employee(3,"eddy",1000),
                new Employee(4,"john",7000)
        );
        List<Employee> newe1 = e1.stream().sorted(Comparator.comparing(a->a.getSal())).collect(Collectors.toList());
        for(Employee emp:newe1){
            System.out.println(emp.getId());
            System.out.println(emp.getName());
            System.out.println(emp.getSal());
        }

        List<Integer> n6 = Arrays.asList(10,20,10,7,1,15,20,2,7,3,30,1,1,20,10);
        List<Integer> newn6 = n6.stream().distinct().sorted().collect(Collectors.toList());
        System.out.println(newn6);

        List<String> s2 = Arrays.asList("mike","navin","eddy","kia","om","will","raj","nobita");
        Map<Integer,List<String>> news2 = s2.stream().collect(Collectors.groupingBy(String::length));
        //same code just doing using method refference
        //Map<Integer,List<String>> news2 = s2.stream().collect(Collectors.groupingBy(s->s.length()));
        System.out.println(news2);

        List<Employee> emList = Arrays.asList(
                new Employee(1,"mike",5000),
                new Employee(2,"eddy",4000),
                new Employee(3,"john",2000)
        );
        //List<EmployeeDto> dtos = emList.stream().map(e->mapToDto(e)).collect(Collectors.toList());
        //same thing doing below using method refference
        List<EmployeeDto> dtos = emList.stream().map(A::mapToDto).collect(Collectors.toList());
        for(EmployeeDto dt:dtos){
            System.out.println(dt.getId());
            System.out.println(dt.getName());
        }


        }
        static EmployeeDto mapToDto(Employee employee){
        EmployeeDto dto = new EmployeeDto();
        dto.setId(employee.getId());
        dto.setName(employee.getName());
        return dto;
        }















    }
