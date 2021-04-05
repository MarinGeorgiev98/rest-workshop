package mapper;

import java.util.Collection;

public interface EntityMapper<D,E> {
    D toDto(E entity);
    Collection<D>  toDto(Collection<E> entities);
}
