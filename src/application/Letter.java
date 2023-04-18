package application;

public class Letter {
    private int id;
    private String name;
    private String date;
    private String content;

    public Letter(int id, String name, String date, String content) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
