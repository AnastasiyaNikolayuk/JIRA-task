package veeeeryTry;


import java.sql.SQLException;
import java.util.ArrayList;

public class Phonebook {

    private static Phonebook instance = null;

    public static Phonebook getInstance() throws SQLException {
        if (instance == null) {
            instance = new Phonebook();
        }

        return instance;
    }

    public ArrayList<Phone> Phones;

    public Phonebook() {
        Phones = new ArrayList<>();
        Phone phone1 = new Phone("Me", "+375 12 3456789");
        Phone phone2 = new Phone("Him", "+375 13 3456789");
        Phone phone3 = new Phone("Her", "+375 14 3456789");
        Phones.add(phone1);
        Phones.add(phone2);
        Phones.add(phone3);
    }

    public void addPhone(Phone phone) {
        Phones.add(phone);
    }

    public String getName(int i) {
        return Phones.get(i).name;
    }

    public String getPhone(int i) {
        return Phones.get(i).phone;
    }

    public int findBySomething(String parameter, String value) {
        if (parameter.equals("name")) {
            for (int i = 0; i < Phones.size(); i ++) {
                if (Phones.get(i).name.equals(value)) {
                    return i;
                }
            }
        }
        else if (parameter.equals("phone")) {
            for (int i = 0; i < Phones.size(); i ++) {
                if (Phones.get(i).phone.equals(value)) {
                    return i;
                }
            }
        }
        return -1;
    }
}
