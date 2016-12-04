package com.github.mykhalechko.webchat.util;


import java.util.Optional;

class MyClass {
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

public class OptionalExample {


    public static void main(String[] args) throws Exception {
        MyClass myClass = new MyClass();
        myClass.setName("ivan");

        Optional<MyClass> optional = Optional.ofNullable(null);
        Optional<String> optionalStr = Optional.ofNullable("");

//        MyClass second = optional.get();
        System.out.println(optional.isPresent());

        System.out.println(optionalStr.orElse(new String("test")));


        MyClass aClass = optional.orElseThrow(() -> {
            return new Exception("vasya");
        });
        System.out.println(aClass);

    }

}
