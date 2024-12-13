import java.util.*;

public class Test {
    public static void main(String[] args) {

        //Collection.sort(null) -> sort in natural order
        Set<Task> allTasks = TaskData.getTasks("All");
        sortAndPrint("All tasks:", allTasks);

        Comparator<Task> byPriority = Comparator.comparing(Task::getPriority).reversed();
        Set<Task> annTasks = TaskData.getTasks("Ann");
        sortAndPrint("Ann tasks:", annTasks, byPriority);

        Comparator<Task> byStatus = Comparator.comparing(Task::getStatus);
        Set<Task> bobTasks = TaskData.getTasks("Bob");
        sortAndPrint("Bob tasks:", bobTasks, byStatus);

        Comparator<Task> combined = byPriority.thenComparing(byStatus);
        Set<Task> carolTasks = TaskData.getTasks("Carol");
        sortAndPrint("Carol tasks:", carolTasks, combined);
    }

    public static void sortAndPrint(String header, Collection<Task> collections,
                                    Comparator<Task> sorter)
    {
        String line = "-".repeat(90);
        System.out.println(line);
        System.out.println(header.indent(34));
        System.out.println(line);

        List<Task> taskList = new ArrayList<>(collections);
        taskList.sort(sorter);
        taskList.forEach(System.out::println);
    }
    public static void sortAndPrint(String header, Collection<Task> collections)
    {
        sortAndPrint(header, collections, null);
    }
}
