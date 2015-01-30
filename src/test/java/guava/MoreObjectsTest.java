package guava;

import org.junit.Test;
import com.google.common.base.Enums;
import com.google.common.base.MoreObjects;
import com.google.common.base.Optional;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

public class MoreObjectsTest {

    @Test
    public void 第1引数がNullでないときは第1引数を返す() {
    	String actual = MoreObjects.firstNonNull("hoge1", "hoge2");
    	assertThat(actual, is("hoge1"));
    }

    @Test
    public void 第1引数がNullのときは第2引数を返す() {
    	String actual = MoreObjects.firstNonNull(null, "hoge2");
    	assertThat(actual, is("hoge2"));
    }

}
