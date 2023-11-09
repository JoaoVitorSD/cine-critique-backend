package softeng.cinecritique.app.domain.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import softeng.cinecritique.app.domain.entity.GenreEntity;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class GenreDTOResponse {
    private String name;

    private Date date;

    public GenreDTOResponse(GenreEntity entity){
        this.name = entity.getName();
        this.date = entity.getCreation_date();
    }
}
