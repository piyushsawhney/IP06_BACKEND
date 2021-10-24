package in.knaps.domain.model.base;

import java.util.Objects;

public class Validator {
    public static void isNotNull(Object object) {
        if (Objects.isNull(object)) {
            throw new IllegalArgumentException("ERROR: Object is null");
        }

    }
}
