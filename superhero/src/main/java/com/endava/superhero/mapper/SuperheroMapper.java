package com.endava.superhero.mapper;

import com.endava.superhero.dto.SuperheroDto;
import com.endava.superhero.model.Superhero;
import org.mapstruct.Mapper;

@Mapper(componentModel="spring", uses={})
public interface SuperheroMapper extends EntityMapper<SuperheroDto, Superhero> {

}
