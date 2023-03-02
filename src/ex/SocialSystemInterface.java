package ex;

public interface SocialSystemInterface {
    boolean isAnExistentPerson(String name);
    void addPerson(String name);
    void addPublication(String name, String actionName);
    boolean isAnExistentPublication(String name, String actionName);
    void vote(String name, int yourSelfPoints, int othersPoints);
    String getAttribute(String name);

}
