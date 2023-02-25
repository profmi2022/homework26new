import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

//Задача 1
        List<Integer> list = new ArrayList<>(Arrays.asList(105,385,196,1020,3085,106,58,2040));
        Stream<Integer> stream = list.stream();

        findMinMax(
                stream,
                Comparator.naturalOrder(),
                (x, y) -> System.out.printf("min %s, max %s %n%n", x, y)
        );
        stream.close();

//Задача 2
        printCountEvenNumbers(list);

    }

    public static <T> void findMinMax(Stream<? extends T> stream,
                                      Comparator<? super T> order,
                                      BiConsumer<? super T, ? super T> minMaxConsumer) {
        List<T> list = stream.collect(Collectors.toList());
        if (list.isEmpty()) {
            minMaxConsumer.accept(null, null);
        } else {
            list.sort(order);
            minMaxConsumer.accept(list.get(0), list.get(list.size() - 1));
        }
    }

    public static void printCountEvenNumbers(List<Integer> list){
        System.out.println("Количество четных чисел в списке: " +
                list.stream()
                        .filter(x -> x % 2 == 0)
                        .map(Main::print)
                        .count());
    }
    public static Integer print(Integer i){
        System.out.println(i);
        return i;
    }
}
