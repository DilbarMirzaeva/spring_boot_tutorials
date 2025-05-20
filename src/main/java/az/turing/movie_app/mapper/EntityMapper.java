package az.turing.movie_app.mapper;

public interface EntityMapper<E,D> {
    E toEntity(D dto);
    D toDto(E entity);
}
