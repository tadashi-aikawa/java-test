package java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

public class StreamTest {

    @Test
    public void filterは条件を満たさない要素を省く() {
        List<Integer> actual = Arrays.asList(1, 2, 3, 4, 5)
                .stream()
                .filter(e -> e > 3)
                .collect(Collectors.toList());
        assertThat(actual, is(contains(4, 5)));
    }

    @Test
    public void mapは全ての要素を変換する() {
        List<Integer> actual = Arrays.asList(1, 2, 3, 4, 5)
                .stream()
                .map(e -> e - 1)
                .collect(Collectors.toList());
        assertThat(actual, is(contains(0, 1, 2, 3, 4)));
    }

    @Test
    public void distinctは重複要素を1つにする() {
        List<Integer> actual = Arrays.asList(1, 2, 1, 3, 1, 4)
                .stream()
                .distinct()
                .collect(Collectors.toList());
        assertThat(actual, is(contains(1, 2, 3, 4)));
    }

    @Test
    public void limitは指定数を越えた要素を削除する() {
        List<Integer> actual = Arrays.asList(1, 2, 3, 4, 5)
                .stream()
                .limit(3)
                .collect(Collectors.toList());
        assertThat(actual, is(contains(1, 2, 3)));
    }

    @Test
    public void skipは指定数分の要素を無視して残りを返却する() {
        List<Integer> actual = Arrays.asList(1, 2, 3, 4, 5)
                .stream()
                .skip(2)
                .collect(Collectors.toList());
        assertThat(actual, is(contains(3, 4, 5)));
    }

    @Test
    public void sortedは特定条件でソートして返却する() {
        List<Integer> actual = Arrays.asList(1, 2, 3, 4, 5)
                .stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        assertThat(actual, is(contains(5, 4, 3, 2, 1)));
    }

    @Test
    public void countは要素数を返却する() {
        long actual = Arrays.asList(1, 2, 3, 4, 5)
                .stream()
                .count();
        assertThat(actual, is(5L));
    }

    @Test
    public void groupingByは各要素に対してグルーピングする() {
        class Human {
            String name;
            Integer age;

            public Human(String name, Integer age) {
                this.name = name;
                this.age = age;
            }
        }

        Map<Integer, List<Human>> actual = Arrays.asList(
                new Human("human1", 10),
                new Human("human2", 12),
                new Human("human3", 12),
                new Human("human4", 12),
                new Human("human5", 18)
                )
                .stream()
                .collect(Collectors.groupingBy(h -> h.age));
        assertThat(actual.keySet(), is(containsInAnyOrder(10, 12, 18)));
        assertThat(
                actual.get(10).stream().map(h -> h.name).collect(Collectors.toList()),
                is(containsInAnyOrder("human1"))
                );
        assertThat(
                actual.get(12).stream().map(h -> h.name).collect(Collectors.toList()),
                is(containsInAnyOrder("human2", "human3", "human4"))
                );
        assertThat(
                actual.get(18).stream().map(h -> h.name).collect(Collectors.toList()),
                is(containsInAnyOrder("human5"))
                );

    }

}
