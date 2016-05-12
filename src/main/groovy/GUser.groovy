import groovy.transform.EqualsAndHashCode
import groovy.transform.Sortable
import groovy.transform.ToString
import groovy.transform.TypeChecked
import groovy.transform.builder.Builder

@TypeChecked
@ToString(includeNames = true)
@EqualsAndHashCode
@Sortable(includes = ['lastName', 'firstName'])
@Builder
class GUser {

    String firstName

    String lastName

    int birthYear
}
