package paramonov.valentine.dcservice;

import java.util.Optional;

public interface Repo<T> {
    default Optional<T> wrap(T t) {
        return Optional.ofNullable(t);
    }
}
