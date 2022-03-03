package Model;

public interface Person {
    int getID();
    String getName();
    boolean getGender();
    Person create(int id, String name, boolean gender);
    void setAttribute(String key, String value);
    String getAttribute(String key);
    boolean isAttributeExist(String attribute);
}
