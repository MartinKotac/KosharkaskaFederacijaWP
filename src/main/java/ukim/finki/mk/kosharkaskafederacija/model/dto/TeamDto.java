package ukim.finki.mk.kosharkaskafederacija.model.dto;

import lombok.Data;

import javax.persistence.Column;

@Data
public class TeamDto {

    private String name;

    private String address;

    private String sponsor;

    private String homeField;

    private Integer points;

    public TeamDto(String name, String address, String sponsor, String homeField) {
        this.name = name;
        this.address = address;
        this.sponsor = sponsor;
        this.homeField = homeField;
        this.points = 0;
    }
}
