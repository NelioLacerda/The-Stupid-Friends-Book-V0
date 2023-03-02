package ex;
/**
 * @author Lord_Gargamelster
 */
public class SocialSystem implements SocialSystemInterface{
    private Person[] persons;
    private int numOfPersons;

    public SocialSystem(){
        this.persons = new Person[10];
        this.numOfPersons = 0;
    }

    @Override
    public boolean isAnExistentPerson(String name){
        for (int i = 0; i<numOfPersons; i++){
            if (persons[i].getName().equals(name)){
                return true;
            }
        }
        return false;
    }

    @Override
    public void addPerson(String name){
        if (persons.length == numOfPersons){
            grow();
        }
        persons[numOfPersons++] = new Person(name);
    }

    @Override
    public void addPublication(String name, String actionName){
        findPerson(name).addPublication(actionName);
    }

    @Override
    public boolean isAnExistentPublication(String name, String actionName){
        return findPerson(name).findPublication(actionName) != null;
    }

    @Override
    public void vote(String name, int yourSelfPoints, int othersPoints){
        findPerson(name).setPoints(yourSelfPoints, othersPoints);
    }

    public AttributeIterator attributeIterator(String attribute){
        return new AttributeIterator(persons, numOfPersons, attribute);
    }

    @Override
    public String getAttribute(String name){
        return findPerson(name).getAttribute();
    }
    private Person findPerson(String name){
        for (int i = 0; i<numOfPersons; i++){
            if (persons[i].getName().equals(name)){
                return persons[i];
            }
        }
        return null;
    }
    private void grow(){
        Person[] aux = new Person[2*persons.length];
        for (int i = 0; i<persons.length; i++){
            aux[i] = persons[i];
        }
        persons = aux;
    }
}
