package ukim.finki.mk.kosharkaskafederacija.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
public class Referee {
    @Id
    @Column(name = "referee_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer level;


    public Referee(Integer level) {
        this.level = level;
    }
}
