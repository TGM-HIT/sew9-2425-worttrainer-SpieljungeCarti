package sew9.worttrainer.spieljungecarti;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;



public class PicTest {

    @Test
    public void testConstructorValid() {
        Pic pic = new Pic("https://example.com", "Example");
        assertEquals("https://example.com", pic.getUrl());
        assertEquals("Example", pic.getName());
    }

    @Test
    public void testConstructorNullUrl() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Pic(null, "Example");
        });
    }

    @Test
    public void testConstructorNullName() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Pic("https://example.com", null);
        });
    }

    @Test
    public void testConstructorInvalidUrl() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Pic("invalid_url", "Example");
        });
    }

    @Test
    public void testGetName() {
        Pic pic = new Pic("https://example.com", "Example");
        assertEquals("Example", pic.getName());
    }

    @Test
    public void testGetUrl() {
        Pic pic = new Pic("https://example.com", "Example");
        assertEquals("https://example.com", pic.getUrl());
    }
}


