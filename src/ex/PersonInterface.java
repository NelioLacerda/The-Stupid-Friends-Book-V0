package ex;

public interface PersonInterface {
    Publication findPublication(String actionName);
    void addPublication(String actionName);
    void setPoints(int yourSelfPoints, int othersPoints);
}
