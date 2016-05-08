import org.hamcrest.collection.IsIterableContainingInOrder;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertThat;

public class UserTest {

    @Test
    public void testProperties() throws Exception {
        final User user = User.builder().firstName("John").lastName("Black").birthYear(1980).build();

        assertEquals("John", user.getFirstName());
        assertEquals("Black", user.getLastName());
        assertEquals(1980, user.getBirthYear());
    }

    @Test
    public void testToString() throws Exception {
        final User user = User.builder().firstName("John").lastName("Black").birthYear(1980).build();

        assertEquals("User(firstName:John, lastName:Black, birthYear:1980)", user.toString());
    }

    @Test
    public void testEquals() throws Exception {
        final User user1 = User.builder().firstName("John").lastName("Black").birthYear(1980).build();
        final User user2 = User.builder().firstName("John").lastName("Black").birthYear(1980).build();

        assertEquals(user1, user2);
    }

    @Test
    public void testNotEquals() throws Exception {
        final User user1 = User.builder().firstName("John").lastName("Black").birthYear(1980).build();
        final User user2 = User.builder().firstName("George").lastName("White").birthYear(1970).build();
        final User user3 = User.builder().firstName("Mark").lastName("Black").birthYear(1955).build();

        assertNotEquals(user1, user2);
        assertNotEquals(user1, user3);
        assertNotEquals(user2, user3);
    }

    @Test
    public void testHashCode() throws Exception {
        final User user1 = User.builder().firstName("John").lastName("Black").birthYear(1980).build();
        final User user2 = User.builder().firstName("John").lastName("Black").birthYear(1980).build();

        assertEquals(user1.hashCode(), user2.hashCode());
    }

    @Test
    public void isComparable() throws Exception {
        final User user = User.builder().firstName("John").lastName("Black").birthYear(1980).build();

        assertThat(user, instanceOf(Comparable.class));
    }

    @Test
    public void testCompareTo() throws Exception {
        final User user1 = User.builder().firstName("John").lastName("Black").birthYear(1980).build();
        final User user2 = User.builder().firstName("George").lastName("White").birthYear(1970).build();
        final User user3 = User.builder().firstName("Mark").lastName("Black").birthYear(1955).build();
        final User user4 = User.builder().firstName("Tom").lastName("Brown").birthYear(1975).build();

        final List<User> actual = Arrays.asList(user1, user2, user3, user4);

        Collections.sort(actual);

        final List<User> expected = Arrays.asList(user1, user3, user4, user2);

        assertThat(actual, IsIterableContainingInOrder.contains(expected.toArray()));
    }
}