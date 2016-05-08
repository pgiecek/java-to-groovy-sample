import org.hamcrest.collection.IsIterableContainingInOrder
import org.junit.Test

import static org.hamcrest.CoreMatchers.instanceOf
import static org.junit.Assert.assertEquals
import static org.junit.Assert.assertNotEquals
import static org.junit.Assert.assertThat

public class GUserTest {

    @Test
    public void testProperties() throws Exception {
        final GUser user = GUser.builder().firstName("John").lastName("Black").birthYear(1980).build();

        assertEquals("John", user.getFirstName());
        assertEquals("Black", user.getLastName());
        assertEquals(1980, user.getBirthYear());
    }

    @Test
    public void testToString() throws Exception {
        final GUser user = GUser.builder().firstName("John").lastName("Black").birthYear(1980).build();

        assertEquals("GUser(firstName:John, lastName:Black, birthYear:1980)", user.toString());
    }

    @Test
    public void testEquals() throws Exception {
        final GUser user1 = GUser.builder().firstName("John").lastName("Black").birthYear(1980).build();
        final GUser user2 = GUser.builder().firstName("John").lastName("Black").birthYear(1980).build();

        assertEquals(user1, user2);
    }

    @Test
    public void testNotEquals() throws Exception {
        final GUser user1 = GUser.builder().firstName("John").lastName("Black").birthYear(1980).build();
        final GUser user2 = GUser.builder().firstName("George").lastName("White").birthYear(1970).build();
        final GUser user3 = GUser.builder().firstName("Mark").lastName("Black").birthYear(1955).build();

        assertNotEquals(user1, user2);
        assertNotEquals(user1, user3);
        assertNotEquals(user2, user3);
    }

    @Test
    public void testHashCode() throws Exception {
        final GUser user1 = GUser.builder().firstName("John").lastName("Black").birthYear(1980).build();
        final GUser user2 = GUser.builder().firstName("John").lastName("Black").birthYear(1980).build();

        assertEquals(user1.hashCode(), user2.hashCode());
    }

    @Test
    public void isComparable() throws Exception {
        final GUser user = GUser.builder().firstName("John").lastName("Black").birthYear(1980).build();

        assertThat(user, instanceOf(Comparable.class));
    }

    @Test
    public void testCompareTo() throws Exception {
        final GUser user1 = GUser.builder().firstName("John").lastName("Black").birthYear(1980).build();
        final GUser user2 = GUser.builder().firstName("George").lastName("White").birthYear(1970).build();
        final GUser user3 = GUser.builder().firstName("Mark").lastName("Black").birthYear(1955).build();
        final GUser user4 = GUser.builder().firstName("Tom").lastName("Brown").birthYear(1975).build();

        final List<GUser> actual = Arrays.asList(user1, user2, user3, user4);

        Collections.sort(actual);

        final List<GUser> expected = Arrays.asList(user1, user3, user4, user2);

        assertThat(actual, IsIterableContainingInOrder.contains(expected.toArray()));
    }
}