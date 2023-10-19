package TodoList;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import TodoList.interfaces.TaskIterator;
import TodoList.models.Task;
import TodoList.models.TodoList;

public class App {
    private static Scanner inScanner = new Scanner(System.in);

    private static List<String> showTask(TaskIterator<Task> iterator) {
        int count = 1;
        List<String> list = new ArrayList<String>();
        while (iterator.hasNext()) {
            Task task = iterator.getNext();
            System.out.println(count + ". " + task);
            count++;
            list.add(task.getTitle());
        }
        return list;
    }

    private static String selectTasks(TaskIterator<Task> iterator) {
        List<String> tasksTitle;
        if (iterator.hasNext()) {
            System.out.println("--------------------------------");
            tasksTitle = showTask(iterator);
            System.out.println("Seleccione la tarea : ");
            System.out.println("--------------------------------");
            int selectTitle = inScanner.nextInt();
            return tasksTitle.get(selectTitle-1);
        } else {
            return null;
        }
    }

    public static void main(String[] args) throws Exception {
        TodoList todo = new TodoList();

        int option = 0;
        String title = "";
        TaskIterator<Task> iterator;

        do {
            System.out.println("\n\t\t--------------------------------");
            System.out.println("\t\tBienvenido al sistema de tareas");
            System.out.println("\t\t--------------------------------");
            System.out.println("\t\t1. Agregar tarea");
            System.out.println("\t\t2. Completar tarea");
            System.out.println("\t\t3. Ver tareas completas");
            System.out.println("\t\t4. Ver tareas incompletas");
            System.out.println("\t\t5. Ver tareas");
            System.out.println("\t\t6. Eliminar tarea");
            System.out.println("\t\tPara salir otro numero");
            System.out.println("\t\t--------------------------------");
            System.out.println("");
            System.out.print("Ingrese la opción : ");
            option = inScanner.nextInt();
            switch (option) {
                case 1:
                    inScanner.nextLine();
                    System.out.print("Ingrese el titulo > ");
                    title = inScanner.nextLine();
                    System.out.print("Ingrese la descripcion > ");
                    String description = inScanner.nextLine();

                    todo.addTask(title, description);
                    break;

                case 2:
                    iterator = todo.inCompletedTasks();
                    System.out.println("Tareas incompletas");
                    title = selectTasks(iterator);
                    todo.completeTask(title);
                    break;
                case 3:
                    iterator = todo.completedTasks();
                    if (iterator.hasNext()) {
                        showTask(iterator);
                    } else {
                        System.out.println("No tienes tareas completadas");
                    }
                    break;
                case 4:
                   iterator = todo.inCompletedTasks();
                    if (iterator.hasNext()) {
                        showTask(iterator);
                    } else {
                        System.out.println("Tienes todas tus tareas completadas");
                    }
                    break;
                case 5:
                    iterator = todo.allTask();
                    if (iterator.hasNext()) {
                        showTask(iterator);
                    } else {
                        System.out.println("Aún no tienes ninguna tarea");
                    }
                    break;
                case 6:
                    System.out.println("--------------------------------");
                    System.out.println("Tareas");
                    iterator = todo.allTask();
                    title = selectTasks(iterator);
                    todo.removeTask(title);
                    break;
                default:
                    option = -1;
            }
        } while (option != -1);

    }
}
