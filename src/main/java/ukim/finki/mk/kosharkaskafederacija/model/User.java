package ukim.finki.mk.kosharkaskafederacija.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@Entity
@AllArgsConstructor
public class User {
    @Id
    private String Username;

    private String password;


}
