import java.io.*;
import java.util.*;

public class ToDoList {
    private List<Task> tasks = new ArrayList<>();

    public void addTask(String desc) {
        tasks.add(new Task(desc));
    }

    public void displayTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks.");
        } else {
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }

    public void markTaskComplete(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.get(index).markCompleted();
        }
    }

    public void deleteTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.remove(index);
        }
    }

    public void saveToFile(String filename) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
        for (Task t : tasks) {
            writer.write(t.isCompleted() + ";" + t.getDescription());
            writer.newLine();
        }
        writer.close();
    }

    public void loadFromFile(String filename) throws IOException {
        tasks.clear();
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(";", 2);
            Task t = new Task(parts[1]);
            if (Boolean.parseBoolean(parts[0])) {
                t.markCompleted();
            }
            tasks.add(t);
        }
        reader.close();
    }
}
