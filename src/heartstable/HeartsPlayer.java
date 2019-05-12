/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heartstable;

public class HeartsPlayer extends Human {

    public HeartsPlayer(String name, String surname, int age) {
        super(name, surname, age);
    }

    
    
    @Override
    public String introduceSelf() {
        String information;
        information = "Hi!My name is " + this.name + " " + this.surname + " and i am "
                + this.age + " years old!";
        return information;
    }

}
