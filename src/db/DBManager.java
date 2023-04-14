package db;

import java.util.HashMap;
import java.util.Map;

public class DBManager {

    private static DBManager instance;
    private final Map<Integer, Task> tasks = new HashMap<>();
    private int index = 1;

    private DBManager() {
        addTask(new Task("Create JavaEE webapp", "description", "2021-10-23", true));
        addTask(new Task("Housecleaning and grocery shopping", "description", "2021-10-25", true));
        addTask(new Task("Finish homeworks", "description", "2021-10-28", false));
        addTask(new Task("Go to gym", "description", "2021-12-12", false));
        addTask(new Task("Learn Italian", "description", "2021-05-01", false));
    };

    public static DBManager getInstance() {
        if (instance == null) {
            instance = new DBManager();
        }
        return instance;
    }

    public void addTask(Task task) {
        if (task.getId() == 0) {
            task.setId(index++);
        }
        tasks.put(task.getId(), task);
    }

    public Task getTask(int id) {
        return tasks.get(id);
    }
    public Map<Integer, Task> getAllTasks() {
        return tasks;
    }

    public void deleteTask(int id) {
        tasks.remove(id);
    }
}
