package ex;

/**
 * @author Lord_Gargamelster
 */
public class Person implements PersonInterface{
    private static final String SMART = "Inteligente";
    private static final String STUPID = "Estupido";
    private static final String ANGEL = "Anjinho";
    private static final String BANDIT = "Bandido";
    private static final String BORING = "Aborrecido";

    private int yourSelfPoints, othersPoints, numOfPublications;
    private String name, attribute;
    private Publication[] publications;

    public Person(String name){
        this.othersPoints = 0;
        this.yourSelfPoints = 0;
        this.numOfPublications = 0;
        this.publications = new Publication[10];
        this.setName(name);
        this.setAttribute(this.calcAttribute());
    }

    @Override
    public Publication findPublication(String actionName){
        for (int i = 0; i < numOfPublications; i++){
            if (publications[i].getAction().getName().equals(actionName)){
                return publications[i];
            }
        }
        return null;
    }
    @Override
    public void addPublication(String actionName){
        if (numOfPublications == publications.length){
            grow();
        }
        publications[numOfPublications++] = new Publication(actionName);
    }

    private void grow(){
        Publication[] aux = new Publication[2*publications.length];
        for (int i = 0; i<publications.length; i++){
            aux[i] = publications[i];
        }
        publications = aux;
    }

    private String calcAttribute(){
        if (getYourSelfPoints() > 0 && getOthersPoints() > 0){
            return SMART;
        } else if (getYourSelfPoints() > 0 && getOthersPoints() < 0) {
            return BANDIT;
        } else if (getYourSelfPoints() < 0 && getOthersPoints() > 0) {
            return ANGEL;
        } else if (getYourSelfPoints() < 0 && getOthersPoints() < 0) {
            return STUPID;
        }else{
            return BORING;
        }
    }

    @Override
    public void setPoints(int yourSelfPoints, int othersPoints) {
        this.setYourSelfPoints(yourSelfPoints);
        this.setOthersPoints(othersPoints);
        calcAttribute();
    }
    private int getYourSelfPoints() {
        return yourSelfPoints;
    }

    private void setYourSelfPoints(int yourSelfPoints) {
        this.yourSelfPoints += yourSelfPoints;
    }

    private int getOthersPoints() {
        return othersPoints;
    }

    private void setOthersPoints(int othersPoints) {
        this.othersPoints += othersPoints;
    }

    public String getName() {
        return name;
    }

    private void setName(String name){
        this.name = name;
    }

    public String getAttribute() {
        return attribute;
    }

    private void setAttribute(String attribute) {
        this.attribute = attribute;
    }

}
