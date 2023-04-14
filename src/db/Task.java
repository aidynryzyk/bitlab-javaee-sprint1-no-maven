package db;

public class Task {
    private int id;
    private String name;
    private String description;
    private String date;
    private boolean isDone;

    public Task() {
    }

    public Task(String name, String description, String date, boolean isDone) {
        this.name = name;
        this.description = description;
        this.date = date;
        this.isDone = isDone;
    }

    public Task(int id, String name, String description, String date, boolean isDone) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.date = date;
        this.isDone = isDone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public String getDateDMYFormat() {
        String[] date = getDate().split("-");
        return date[2] + "." + date[1] + "." + date[0];
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String isDone() {
        if (isDone) {
            return "Done";
        }
        return "Not done";
    }

    public void setDone(boolean done) {
        isDone = done;
    }
}
