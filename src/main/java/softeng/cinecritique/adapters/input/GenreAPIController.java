package softeng.cinecritique.adapters.input;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import softeng.cinecritique.app.domain.dto.request.GenreDTORequest;
import softeng.cinecritique.app.domain.dto.response.GenreDTOResponse;
import softeng.cinecritique.app.service.GenreService;

import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1")
public class GenreAPIController {
    private GenreService service;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public GenreDTOResponse insert(@RequestBody GenreDTORequest request){
        return service.insert(request);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public GenreDTOResponse update(@RequestBody GenreDTORequest request){
        return service.update(request);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@RequestParam("id")UUID id){
        service.delete(id);
    }

    @GetMapping
    public List<GenreDTOResponse> find(){
        return service.find();
    }

}
