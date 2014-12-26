package guava;

import org.junit.Test;
import com.google.common.base.Enums;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

public class EnumsTest {
	
	enum TestColor {
		RED, GREEN, BLUE;
	}

    @Test
    public void Enumインスタンス名と文字列が一致するときにインスタンスを返す() {
    	TestColor actual = Enums.getIfPresent(TestColor.class, "GREEN").orNull();
        assertThat(actual, is(TestColor.GREEN));
    }

    @Test
    public void Enumインスタンス名と文字列が一致しないときにnullを返す() {
    	TestColor actual = Enums.getIfPresent(TestColor.class, "UREEEEEE").orNull();
        assertNull(actual);
    }

}
