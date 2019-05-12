/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heartstable;

public abstract class Human {

    String name, surname;
    int age;

    protected Human(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public String getSurName() {
        return this.surname;
    }

    public int getAge() {
        return this.age;
    }

    public void setName(String value) {
        this.name = value;
    }

    public void setSurName(String value) {
        this.surname = value;
    }

    public void setAge(int value) {
        this.age = age;
    }

    public abstract String introduceSelf();

}
