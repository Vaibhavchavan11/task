import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ToDoList todo = new ToDoList();
        Scanner sc = new Scanner(System.in);
        String filename = "tasks.txt";

        while (true) {
            System.out.println("\n1. Add Task\n2. View Tasks\n3. Mark Task Completed\n4. Delete Task\n5. Save\n6. Load\n7. Exit");
            System.out.print("Choose: ");
            int choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {
                case 1:
                    System.out.print("Enter task: ");
                    String desc = sc.nextLine();
                    todo.addTask(desc);
                    break;
                case 2:
                    todo.displayTasks();
                    break;
                case 3:
                    System.out.print("Enter task number: ");
                    int index = sc.nextInt() - 1;
                    todo.markTaskComplete(index);
                    break;
                case 4:
                    System.out.print("Enter task number: ");
                    todo.deleteTask(sc.nextInt() - 1);
                    break;
                case 5:
                    try {
                        todo.saveToFile(filename);
                        System.out.println("Saved.");
                    } catch (Exception e) {
                        System.out.println("Error saving: " + e.getMessage());
                    }
                    break;
                case 6:
                    try {
                        todo.loadFromFile(filename);
                        System.out.println("Loaded.");
                    } catch (Exception e) {
                        System.out.println("Error loading: " + e.getMessage());
                    }
                    break;
                case 7:
                    System.exit(0);
            }
        }
    }
}
