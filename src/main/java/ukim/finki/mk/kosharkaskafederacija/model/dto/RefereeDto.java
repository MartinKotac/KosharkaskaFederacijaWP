package ukim.finki.mk.kosharkaskafederacija.model.dto;

import lombok.Data;

@Data
public class RefereeDto {
    private Integer level;

    public RefereeDto(Integer level) {
        this.level = level;
    }
}
