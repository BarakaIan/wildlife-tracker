import org.junit.Rule;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertTrue;

public class AnimalTest {
    @Rule
    public DatabaseRule database = new DatabaseRule();
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

    @Test
    public void Animal_InsertsIntoDatabase_Animal() {
        Animal animal = new Animal("Lion");
        animal.save();
        Animal animal2 = new Animal("Cheeter");
        animal2.save();
        assertTrue(Animal.all().get(0).equals(animal));
        assertTrue(Animal.all().get(1).equals(animal2));
    }

    @Test
    public void save_assignsIdToObject() {
        Animal animal = new Animal("Lion");
        animal.save();
        Animal savedAnimal = Animal.all().get(0);
        assertEquals(animal.getId(), savedAnimal.getId());
    }

    @Test
    public void find_returnsAnimalsWithTheSameId_animal2() {
        Animal animal = new Animal("Lion");
        animal.save();
        Animal animal2 = new Animal("Cheeter");
        animal2.save();
        assertEquals(Animal.find(animal2.getId()), animal2);
    }
}
