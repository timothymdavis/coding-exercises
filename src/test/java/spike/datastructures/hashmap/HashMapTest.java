package spike.datastructures.hashmap;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;

public class HashMapTest {

    @Test(expected = IllegalArgumentException.class)
    public void testGetWithMapSizeOfZero() throws Exception {
        new HashMap<>(0);
    }

    @Test
    public void testGetWithMapSizeOfOne() throws Exception {
        HashMap<String, String> map = new HashMap<>(1);
        map.put("some-key", "some-value");
        map.put("next-key", "next-value");
        assertThat(map.get("some-key"), is("some-value"));
        assertThat(map.get("next-key"), is("next-value"));
    }

    @Test
    public void testGet() throws Exception {
        HashMap<String, String> map = new HashMap<>();
        map.put("some-key", "some-value");
        assertThat(map.get("some-key"), is("some-value"));
    }

    @Test
    public void testGetWithTwoEntries() throws Exception {
        HashMap<String, String> map = new HashMap<>();
        map.put("some-key", "some-value");
        map.put("next-key", "next-value");
        assertThat(map.get("some-key"), is("some-value"));
        assertThat(map.get("next-key"), is("next-value"));
    }

    @Test
    public void testGetWithLotsOfEntries() throws Exception {
        HashMap<String, String> map = new HashMap<>();
        final int ENTRY_NUM = 1000;
        for (int i = 0; i < ENTRY_NUM; i++) {
            map.put("some-key-" + i, "some-value-" + i);
        }
        for (int i = 0; i < ENTRY_NUM; i++) {
            assertThat(map.get("some-key-" + i), is("some-value-" + i));
        }
    }

    @Test
    public void testGetWithLotsOfEntriesMapSizeOfOne() throws Exception {
        HashMap<String, String> map = new HashMap<>(1);
        final int ENTRY_NUM = 1000;
        for (int i = 0; i < ENTRY_NUM; i++) {
            map.put("some-key-" + i, "some-value-" + i);
        }
        for (int i = 0; i < ENTRY_NUM; i++) {
            assertThat(map.get("some-key-" + i), is("some-value-" + i));
        }
    }

    @Test
    public void testGetFromEmptyMap() throws Exception {
        HashMap<String, String> map = new HashMap<>();
        assertThat(map.get("some-key"), nullValue());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetWithNullKey() throws Exception {
        new HashMap<String, String>().get(null);
    }

    @Test
    public void testRemoveWithLotsOfEntries() throws Exception {
        HashMap<String, String> map = new HashMap<>();
        final int ENTRY_NUM = 1000;
        for (int i = 0; i < ENTRY_NUM; i++) {
            map.put("some-key-" + i, "some-value-" + i);
        }
        for (int i = 0; i < ENTRY_NUM / 2; i++) {
            map.remove("some-key-" + i);
        }
        for (int i = 0; i < ENTRY_NUM / 2; i++) {
            assertThat(map.get("some-key-" + i), nullValue());
        }
        for (int i = ENTRY_NUM / 2; i < ENTRY_NUM; i++) {
            assertThat(map.get("some-key-" + i), is("some-value-" + i));
        }
    }

}
