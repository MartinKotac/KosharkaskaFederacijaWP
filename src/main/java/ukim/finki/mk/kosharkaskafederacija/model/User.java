package ukim.finki.mk.kosharkaskafederacija.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ukim.finki.mk.kosharkaskafederacija.enumerations.Role;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@AllArgsConstructor
public class User {
    @Id
    private String Username;

    private String password;
    private String name;
    private String surname;
    @Enumerated(value = EnumType.STRING)
    private Role role;

}
