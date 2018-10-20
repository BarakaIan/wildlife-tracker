import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertTrue;

public class AnimalTest {
    @Test
    public void Animal_returns_instamce_Object() {
        Animal animal = new Animal("Lion");
        assertTrue(animal instanceof Object);
    }

    @Test
    public void Animal_returnsInstance_Animal() {
        Animal animal = new Animal("Lion");
        assertTrue(animal instanceof Animal);
    }

    @Test
    public void Animal_getName_String() {
        Animal animal = new Animal("Lion");
        assertEquals("Lion", animal.getName());
    }

    @Test
    public void Animal_returnsEqualsSameAnimals_true() {
        Animal animal = new Animal("Lion");
        Animal animal2 = new Animal("Lion");
        assertTrue(animal.equals(animal2));
    }
}
