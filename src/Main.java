import model.Doctor;
import model.Patient;
import model.User;

import java.util.Date;

import static ui.UIMenu.*;

public class Main {

    public static void main(String[] args) {
        showMenu();

        User user1 = new User("Diomedes","elCacique@ron.com") {
            @Override
            public void showDataUser() {
                System.out.println("Joda mani vaina pa raras las clases anonimas");
                System.out.println("viva el junior tu papa");
            }
        };
        user1.showDataUser();


    }
}