# Java to Groovy Sample

Represents a simple transformation of a Java class with lots of boilerplate to the corresponding Groovy class.

## Requirements

- Java 8+

## Steps

1. Initial state
2. Remove semicolons
3. Remove public keyword
4. Remove return keyword
5. Replace getters with read-only properties
6. Replace toString method with @ToString transformation
7. Replace equals and hashCode methods with @EqualsAndHashCode transformation
8. Replace Comparable with @Sortable transformation
9. Replace builder with @Builder transformation