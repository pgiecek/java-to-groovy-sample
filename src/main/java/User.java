public class User implements Comparable<User> {

    private final String firstName;

    private final String lastName;

    private final int birthYear;

    private User(Builder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.birthYear = builder.birthYear;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public int compareTo(User o) {
        if (this == o) {
            return 0;
        }

        int result = this.lastName.compareTo(o.lastName);
        if (result != 0) {
            return result;
        }

        return this.firstName.compareTo(o.firstName);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (birthYear != user.birthYear) return false;
        if (firstName != null ? !firstName.equals(user.firstName) : user.firstName != null) return false;
        return lastName != null ? lastName.equals(user.lastName) : user.lastName == null;

    }

    @Override
    public int hashCode() {
        int result = firstName != null ? firstName.hashCode() : 0;
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + birthYear;
        return result;
    }

    @Override
    public String toString() {
        return "User(" +
                "firstName:" + firstName +
                ", lastName:" + lastName +
                ", birthYear:" + birthYear +
                ')';
    }

    public static class Builder {

        private String firstName;

        private String lastName;

        private int birthYear;

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder birthYear(int birthYear) {
            this.birthYear = birthYear;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}
