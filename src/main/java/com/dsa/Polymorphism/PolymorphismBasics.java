package com.dsa.Polymorphism;

/**
 * Polymorphism Basics - Demonstrating Compile-time and Run-time Polymorphism
 *
 * Polymorphism allows entities to take on multiple forms, fundamentally enhancing
 * architectural flexibility and code reusability.
 *
 * Types of Polymorphism:
 * 1. Compile-time Polymorphism (Static Polymorphism) - Method Overloading
 * 2. Run-time Polymorphism (Dynamic Polymorphism) - Method Overriding
 */

public class PolymorphismBasics {

    // ============================================================================
    // 1. COMPILE-TIME POLYMORPHISM - METHOD OVERLOADING
    // ============================================================================

    /**
     * Multiple methods with the same name but different parameter signatures.
     * The compiler determines which method to call at compile time.
     */
    static class Calculator {

        // Method to add two integers
        public int add(int a, int b) {
            System.out.println("Adding two integers: " + a + " + " + b);
            return a + b;
        }

        // Method to add two doubles (overloaded version - different parameter type)
        public double add(double a, double b) {
            System.out.println("Adding two doubles: " + a + " + " + b);
            return a + b;
        }

        // Method to add three integers (overloaded version - different parameter quantity)
        public int add(int a, int b, int c) {
            System.out.println("Adding three integers: " + a + " + " + b + " + " + c);
            return a + b + c;
        }

        // Method to concatenate two strings (overloaded version - different parameter type)
        public String add(String a, String b) {
            System.out.println("Concatenating strings: " + a + " + " + b);
            return a + b;
        }
    }


    // ============================================================================
    // 2. RUN-TIME POLYMORPHISM - METHOD OVERRIDING
    // ============================================================================

    /**
     * Base class: Animal
     * Defines a common interface for all animals
     */
    static class Animal {

        public void sound() {
            System.out.println("Animal makes a sound");
        }

        public void move() {
            System.out.println("Animal is moving");
        }
    }

    /**
     * Subclass: Dog
     * Overrides the sound() method from Animal class
     * This is run-time polymorphism - actual method called depends on object type at runtime
     */
    static class Dog extends Animal {

        @Override
        public void sound() {
            System.out.println("Dog barks: Woof! Woof!");
        }

        @Override
        public void move() {
            System.out.println("Dog runs on four legs");
        }
    }

    /**
     * Subclass: Cat
     * Overrides the sound() method from Animal class
     */
    static class Cat extends Animal {

        @Override
        public void sound() {
            System.out.println("Cat meows: Meow! Meow!");
        }

        @Override
        public void move() {
            System.out.println("Cat walks gracefully on four legs");
        }
    }

    /**
     * Subclass: Bird
     * Overrides the sound() method from Animal class
     */
    static class Bird extends Animal {

        @Override
        public void sound() {
            System.out.println("Bird chirps: Tweet! Tweet!");
        }

        @Override
        public void move() {
            System.out.println("Bird flies in the sky");
        }
    }


    // ============================================================================
    // DEMO AND MAIN METHOD
    // ============================================================================

    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("COMPILE-TIME POLYMORPHISM (Method Overloading)");
        System.out.println("========================================\n");

        demonstrateCompileTimePolymorphism();

        System.out.println("\n========================================");
        System.out.println("RUN-TIME POLYMORPHISM (Method Overriding)");
        System.out.println("========================================\n");

        demonstrateRunTimePolymorphism();
    }

    /**
     * Demonstrates compile-time polymorphism through method overloading
     */
    static void demonstrateCompileTimePolymorphism() {
        Calculator calc = new Calculator();

        // Calling different overloaded methods based on parameter types and quantity
        System.out.println("Result: " + calc.add(10, 20)); // Calls add(int, int)
        System.out.println();

        System.out.println("Result: " + calc.add(10.5, 20.5)); // Calls add(double, double)
        System.out.println();

        System.out.println("Result: " + calc.add(10, 20, 30)); // Calls add(int, int, int)
        System.out.println();

        System.out.println("Result: " + calc.add("Hello", " World")); // Calls add(String, String)
        System.out.println();

        System.out.println("Key Point: The compiler determines which method to call at COMPILE TIME");
        System.out.println("based on the method name and parameter signature.");
    }

    /**
     * Demonstrates run-time polymorphism through method overriding
     */
    static void demonstrateRunTimePolymorphism() {

        // Parent class reference can hold child class objects
        // This is the essence of polymorphism

        Animal animal1 = new Dog();    // Dog object referenced as Animal
        Animal animal2 = new Cat();    // Cat object referenced as Animal
        Animal animal3 = new Bird();   // Bird object referenced as Animal
        Animal animal4 = new Animal(); // Animal object

        System.out.println("Calling sound() method on different animal objects:\n");

        // The actual method called depends on the RUNTIME type of the object
        animal1.sound();  // Calls Dog's sound()
        animal1.move();
        System.out.println();

        animal2.sound();  // Calls Cat's sound()
        animal2.move();
        System.out.println();

        animal3.sound();  // Calls Bird's sound()
        animal3.move();
        System.out.println();

        animal4.sound();  // Calls Animal's sound()
        animal4.move();
        System.out.println();

        System.out.println("Key Points:");
        System.out.println("1. The REFERENCE type is Animal (parent class)");
        System.out.println("2. The OBJECT type can be Dog, Cat, or Bird (child classes)");
        System.out.println("3. The method called depends on the OBJECT type at RUNTIME");
        System.out.println("4. This enables flexible and extensible code design");

        // Demonstrating polymorphism with array
        System.out.println("\n--- Using Polymorphism with Arrays ---\n");

        Animal[] animals = {new Dog(), new Cat(), new Bird(), new Animal()};

        System.out.println("Iterating through array of animals:\n");
        for (Animal animal : animals) {
            animal.sound();
            animal.move();
            System.out.println();
        }
    }
}

