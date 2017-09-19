package example;

import org.junit.*;
import static org.junit.Assert.*;


public class StringBufferTest {
    private StringBuffer buffer;
    @Before
    public void setUp() {
        buffer = new StringBuffer("hello");
    }
 
    @Test
    public void testAppend() {
                buffer.append("x");
                assertEquals(6, buffer.length());
                assertEquals("hellox", buffer.toString() );
    }
 
    @Test
    public void testDelete() {
                buffer.deleteCharAt(2);
                assertEquals(4, buffer.length());
                assertEquals("hllo", buffer.toString() );
    }
 
}