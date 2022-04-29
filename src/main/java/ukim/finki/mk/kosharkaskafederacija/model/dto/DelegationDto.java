package ukim.finki.mk.kosharkaskafederacija.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class DelegationDto {
    private int level;

    public DelegationDto(int level) {
        this.level = level;
    }
}
