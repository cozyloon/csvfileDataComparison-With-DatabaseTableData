package Model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DBDetails {
    private int id;
    private String name;
    private String address;
    private int age;

    @Override
    public String toString() {
        return "DBDetails{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", age=" + age +
                '}';
    }
}