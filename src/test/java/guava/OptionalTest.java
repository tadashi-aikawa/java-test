package guava;

import org.junit.Test;
import com.google.common.base.Enums;
import com.google.common.base.Optional;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

public class OptionalTest {

    @Test
    public void nullでないインスタンスをOptionalに変換する() {
    	Optional<String> actual = Optional.fromNullable("hoge");

    	assertTrue(actual.isPresent());
    	assertThat(actual.get(), is("hoge"));
    }

    @Test
    public void nullのインスタンスをOptionalに変換する() {
    	Optional<String> actual = Optional.fromNullable(null);

    	assertFalse(actual.isPresent());
    }

}
