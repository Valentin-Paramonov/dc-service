package paramonov.valentine.dcservice;

import java.util.Optional;

public interface Repo<T> {
    class EntityNotFoundException extends RuntimeException {
        public EntityNotFoundException(String message) {
            super(message);
        }
    }

    default Optional<T> wrap(T t) {
        return Optional.ofNullable(t);
    }
}
