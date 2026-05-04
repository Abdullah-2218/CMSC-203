import java.util.ArrayList;
import java.util.List;

public class Circus {
    private List<Animal> animals;
    private List<Person> persons;
    private List<Building> buildings;

    public Circus() {
        animals = new ArrayList<>();
        persons = new ArrayList<>();
        buildings = new ArrayList<>();
    }


    public void addAnimal(Animal animal) {
    	animals.add(animal);
    }
    
    public void addPerson(Person person) {
    	persons.add(person);
    }
    
    public void addBuilding(Building building) {
    	buildings.add(building);
    }

    public List<Animal> getAnimals(){
    	return animals;
    }
    
    public List<Person> getPersons(){
    	return persons;
    }
    
    public List<Building> getBuildings(){
    	return buildings;
    }
    
    public void displayAllAnimals() {
    	for (Animal animal : animals) {
    		System.out.println(animal);
    	}
    }
    
    public void displayAllPersons() {
    	for(Person person : persons) {
    		System.out.println(person);
    	}
    }
    
    public void displayAllBuildings() {
    	for (Building building : buildings) {
    		System.out.println(building); 
    }
}
    public void sortAnimalsByAge() {
    	for(int i=0; i< animals.size()-1; i++) {
    		int minIndex = i;
    		
    		for (int j= i+1; j<animals.size(); j++) {
    			if (animals.get(j).getAge() < animals.get(minIndex).getAge()) {
    				minIndex = j;
    			}
    		}
    		
    		Animal temp = animals.get(i);
    		animals.set(i,  animals.get(minIndex));
    		animals.set(minIndex, temp);   		
    	}
      }
    
    public void sortAnimalsByName() {
    	for (int i= 0; i<animals.size()-1; i++) {
    		int minIndex = i;
    		
    		for (int j=i+1; j <animals.size(); j++) {
    			if (animals.get(j).getName().compareToIgnoreCase(
    					animals.get(minIndex).getName()) < 0) {
    				minIndex = j;
    			}
    		}
    		
    		Animal temp = animals.get(i);
    		animals.set(i, animals.get(minIndex));
    		animals.set(minIndex,  temp);
    			
    	}
    }
    
    public Animal searchAnimalByName(String name) {
    	for (Animal animal : animals) {
    		if (animal.getName().equalsIgnoreCase(name)) {
    			return animal;
    		}
    	}
    	return null;
    }
}
    