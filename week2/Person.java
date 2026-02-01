// Source code is decompiled from a .class file using FernFlower decompiler (from Intellij IDEA).
class Person {
    private String name;
    private int age;

    Person(String var1, int var2) {
        this.name = var1;
        this.age = var2;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public static boolean isOlderThan(Person var0, int var1) {
        return var0.getAge() > var1;
    }
}
