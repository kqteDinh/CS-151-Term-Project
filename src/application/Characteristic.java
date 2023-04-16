package application;

import java.util.List;

public class Characteristic {

    private Category category;
    private List<Option> options;
    
    public Characteristic(Category category, List<Option> options) {
    	this.category = category;
    	this.options = options;
    }

    public Category getChoice() {
        return category;
    }

    public List<Option> getOptions() {
        return options;
    }
}