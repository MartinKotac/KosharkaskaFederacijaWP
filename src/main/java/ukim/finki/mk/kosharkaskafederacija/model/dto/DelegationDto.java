package ukim.finki.mk.kosharkaskafederacija.model.dto;

import lombok.Data;

@Data
public class DelegationDto {
    private Integer level;

    public DelegationDto(Integer level) {
        this.level = level;
    }
}
