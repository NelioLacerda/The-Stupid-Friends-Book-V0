package ex;
/**
 * @author Lord_Gargamelster
 */
public class AttributeIterator {
    private Person[] persons;
    private int size, nextIndex;
    private String attribute;

    public AttributeIterator(Person[] persons, int size, String attribute){
        this.persons = persons;
        this.size = size;
        this.nextIndex = 0;
        this.attribute = attribute;
        advance();
    }

    public boolean hasNext(){
        return nextIndex < size;
    }

    public Person next(){
        Person person = persons[nextIndex++];
        advance();
        return person;
    }

    private void advance(){
        while (nextIndex < size && !criterion(persons[nextIndex])){
            nextIndex++;
        }
    }

    private boolean criterion(Person p){
        return p.getAttribute().equals(attribute);
    }
}
