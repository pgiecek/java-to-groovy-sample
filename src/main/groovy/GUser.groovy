import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString
import groovy.transform.TypeChecked

@TypeChecked
@ToString(includeNames = true)
@EqualsAndHashCode
class GUser implements Comparable<GUser> {

    final String firstName

    final String lastName

    final int birthYear

    private GUser(Builder builder) {
        this.firstName = builder.firstName
        this.lastName = builder.lastName
        this.birthYear = builder.birthYear
    }

    static Builder builder() {
        new Builder()
    }

    @Override
    int compareTo(GUser o) {
        if (this.is(o)) {
            return 0;
        }

        int result = this.lastName.compareTo(o.lastName)
        if (result != 0) {
            return result
        }

        this.firstName.compareTo(o.firstName)
    }

    static class Builder {

        private String firstName

        private String lastName

        private int birthYear

        Builder firstName(String firstName) {
            this.firstName = firstName
            this
        }

        Builder lastName(String lastName) {
            this.lastName = lastName
            this
        }

        Builder birthYear(int birthYear) {
            this.birthYear = birthYear
            this
        }

        GUser build() {
            new GUser(this)
        }
    }
}
