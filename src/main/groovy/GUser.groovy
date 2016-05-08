import groovy.transform.TypeChecked

@TypeChecked
class GUser implements Comparable<GUser> {

    private final String firstName

    private final String lastName

    private final int birthYear

    private GUser(Builder builder) {
        this.firstName = builder.firstName
        this.lastName = builder.lastName
        this.birthYear = builder.birthYear
    }

    String getFirstName() {
        return firstName
    }

    String getLastName() {
        return lastName
    }

    int getBirthYear() {
        return birthYear
    }

    static Builder builder() {
        return new Builder()
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

        return this.firstName.compareTo(o.firstName)
    }

    @Override
    boolean equals(Object o) {
        if (this.is(o)) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GUser user = (GUser) o;

        if (birthYear != user.birthYear) return false
        if (firstName != null ? !firstName.equals(user.firstName) : user.firstName != null) return false
        return lastName != null ? lastName.equals(user.lastName) : user.lastName == null

    }

    @Override
    int hashCode() {
        int result = firstName != null ? firstName.hashCode() : 0
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0)
        result = 31 * result + birthYear
        return result
    }

    @Override
    String toString() {
        return "GUser(" +
                "firstName:" + firstName +
                ", lastName:" + lastName +
                ", birthYear:" + birthYear +
                ')'
    }

    static class Builder {

        private String firstName

        private String lastName

        private int birthYear

        Builder firstName(String firstName) {
            this.firstName = firstName
            return this
        }

        Builder lastName(String lastName) {
            this.lastName = lastName
            return this
        }

        Builder birthYear(int birthYear) {
            this.birthYear = birthYear
            return this
        }

        GUser build() {
            return new GUser(this)
        }
    }
}
