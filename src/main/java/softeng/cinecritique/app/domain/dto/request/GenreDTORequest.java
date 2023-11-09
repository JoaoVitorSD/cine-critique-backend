package softeng.cinecritique.app.domain.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class GenreDTORequest {
    private UUID id;
    private String name;

    private Date date;

}
