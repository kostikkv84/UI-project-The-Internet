package HH_Pages;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ProfileClass {
    private String gender;
    private int age;
    private String city;
    boolean isPhoneConfirmed;
    boolean isReadyTORelocate;

    public ProfileClass() {super();
    }

    public ProfileClass(String gender, int age, String city, boolean isPhoneConfirmed, boolean isReadyTORelocate) {
        this.gender = gender;
        this.age = age;
        this.city = city;
        this.isPhoneConfirmed = isPhoneConfirmed;
        this.isReadyTORelocate = isReadyTORelocate;
    }
}
