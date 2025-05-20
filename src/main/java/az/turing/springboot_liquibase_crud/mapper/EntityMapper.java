    package az.turing.springboot_liquibase_crud.mapper;

    import java.util.List;

    public interface EntityMapper<D,E> {

        E toEntity(D d) ;

        D toDto(E e);

        List<E> toEntity(List<D> e);

        List<D> toDto(List<E> d);

    }
