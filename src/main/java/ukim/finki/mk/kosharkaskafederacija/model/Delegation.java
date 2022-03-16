package ukim.finki.mk.kosharkaskafederacija.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
public class Delegation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "delegation_id", nullable = false)
    private String id;

    @Column(nullable = false)
    private Integer level;


    public Delegation(Integer level) {
        this.level = level;
    }
}
