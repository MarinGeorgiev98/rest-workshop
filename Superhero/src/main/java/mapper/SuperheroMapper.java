package mapper;

import com.Superheroes.Superhero.model.Superhero;
import com.Superheroes.Superhero.model.SuperheroDto;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring",uses = {})
public interface SuperheroMapper extends EntityMapper<SuperheroDto, Superhero> {

}
