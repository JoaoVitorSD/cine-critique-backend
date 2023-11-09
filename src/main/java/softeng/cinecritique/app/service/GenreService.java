package softeng.cinecritique.app.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import softeng.cinecritique.app.domain.dto.request.GenreDTORequest;
import softeng.cinecritique.app.domain.dto.response.GenreDTOResponse;
import softeng.cinecritique.app.domain.entity.GenreEntity;
import softeng.cinecritique.app.ports.output.GenreRepository;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class GenreService {
    private GenreRepository genreRepository;


    public GenreDTOResponse insert(GenreDTORequest request){
        GenreEntity entity = new GenreEntity(null,request.getName(),Date.from(Instant.now()), null );
        return new GenreDTOResponse(genreRepository.save(entity));
    }
    public GenreDTOResponse update(GenreDTORequest request){
        GenreEntity entity = genreRepository.findById(request.getId())
                .orElseThrow(()-> new EntityNotFoundException("Genre not found"));
        entity.setName(request.getName());
        return new GenreDTOResponse(genreRepository.save(entity));
    }


    public void delete(UUID id){
        genreRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Genre not found"));
        genreRepository.deleteById(id);
    }

    public List<GenreDTOResponse> find(){
        return genreRepository.findAll().stream()
                .map(GenreDTOResponse::new)
                .collect(Collectors.toList());
    }

}
