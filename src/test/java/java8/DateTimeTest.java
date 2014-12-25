package java8;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

public class DateTimeTest {

    @Test
    public void LocalDateTimeで日時を作成する() {
        LocalDateTime actual = LocalDateTime.of(2000, 2, 28, 10, 40, 30);
        assertThat(actual.getYear(), is(2000));
        assertThat(actual.getMonthValue(), is(2));
        assertThat(actual.getDayOfMonth(), is(28));
        assertThat(actual.getHour(), is(10));
        assertThat(actual.getMinute(), is(40));
        assertThat(actual.getSecond(), is(30));
    }

}
