package application;

import java.util.List;

public class Characteristic {

    private Choice choice;
    private List<Option> options;
    
    public Characteristic(Choice choice, List<Option> options) {
    	this.choice = choice;
    	this.options = options;
    }

    public Choice getChoice() {
        return choice;
    }

    public List<Option> getOptions() {
        return options;
    }
}