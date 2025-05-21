import java.util.ArrayList;
import java.util.Scanner;

class Task {
    String description;
    boolean isCompleted;

    public Task(String description) {
        this.description = description;
        this.isCompleted = false;
    }

    public void toggleComplete() {
        isCompleted = !isCompleted;
    }

    @Override
    public String toString() {
        return (isCompleted ? "Completed " : "Pending ") + description;
    }
}

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Task> tasks = new ArrayList<>();
        boolean running = true;

        while (running) {
            System.out.println("\n--- To-Do List Menu ---");
            System.out.println("1. Add Task");
            System.out.println("2. Update Task");
            System.out.println("3. Delete Task");
            System.out.println("4. Toggle Task Completion");
            System.out.println("5. View All Tasks");
            System.out.println("6. Exit");
            System.out.print("Choose an option (1-6): ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1: // Add
                    System.out.print("Enter task description: ");
                    String desc = scanner.nextLine();
                    tasks.add(new Task(desc));
                    System.out.println("Task added.");
                    break;

                case 2: // Update
                    System.out.print("Enter task number to update: ");
                    int updateIndex = scanner.nextInt() - 1;
                    scanner.nextLine();
                    if (updateIndex >= 0 && updateIndex < tasks.size()) {
                        System.out.print("Enter new description: ");
                        String newDesc = scanner.nextLine();
                        tasks.get(updateIndex).description = newDesc;
                        System.out.println("Task updated.");
                    } else {
                        System.out.println("Invalid task number.");
                    }
                    break;

                case 3: // Delete
                    System.out.print("Enter task number to delete: ");
                    int deleteIndex = scanner.nextInt() - 1;
                    if (deleteIndex >= 0 && deleteIndex < tasks.size()) {
                        tasks.remove(deleteIndex);
                        System.out.println("Task deleted.");
                    } else {
                        System.out.println("Invalid task number.");
                    }
                    break;

                case 4: // Toggle Complete
                    System.out.print("Enter task number to toggle complete/incomplete: ");
                    int toggleIndex = scanner.nextInt() - 1;
                    if (toggleIndex >= 0 && toggleIndex < tasks.size()) {
                        tasks.get(toggleIndex).toggleComplete();
                        System.out.println("Task status toggled.");
                    } else {
                        System.out.println("Invalid task number.");
                    }
                    break;

                case 5: // View
                    System.out.println("\n--- To-Do List ---");
                    if (tasks.isEmpty()) {
                        System.out.println("No tasks available.");
                    } else {
                        for (int i = 0; i < tasks.size(); i++) {
                            System.out.println((i + 1) + ". " + tasks.get(i));
                        }
                    }
                    break;

                case 6: // Exit
                    running = false;
                    System.out.println("Exiting To-Do List App. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }
}
