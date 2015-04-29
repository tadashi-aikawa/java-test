package gscollections;

import com.gs.collections.api.list.MutableList;
import com.gs.collections.api.multimap.Multimap;
import com.gs.collections.api.multimap.list.ImmutableListMultimap;
import com.gs.collections.impl.factory.Lists;
import com.gs.collections.impl.factory.Multimaps;
import com.gs.collections.impl.list.Interval;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class BasicTest {

    @Test
    public void Listの中身をselectで変換する() {
        List<Integer> numbers = Arrays.asList(1, 3, 4, 5, 8);

        MutableList<Integer> actual = Lists.mutable.ofAll(numbers)
                .collect(e -> e + 1);

        assertThat(actual, contains(2, 4, 5, 6, 9));
    }

    @Test
    public void List1から100までの和を求める() {
        long actual = Interval.fromTo(1, 100).sumOfInt(e -> e);

        assertThat(actual, is(5050L));
    }

    @Test
    public void 指定範囲の数から偶数のみを抜き出し10の位でグルーピングする() {
        ImmutableListMultimap<Integer, Integer> expected = Multimaps.immutable.list
                .with(0, 2)
                .newWithAll(0, Arrays.asList(4, 6, 8))
                .newWithAll(1, Arrays.asList(10, 12, 14, 16, 18))
                .newWithAll(2, Arrays.asList(20));

        Multimap<Integer, Integer> actual = Interval.fromTo(1, 20)
                .select(e -> e % 2 == 0)
                .groupBy(e -> e / 10);
        assertThat(actual, is(expected));
    }

}
