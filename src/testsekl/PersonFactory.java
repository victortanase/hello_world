package testsekl;

public interface PersonFactory<T> {

	T create(String firstName, String lastName);
}
