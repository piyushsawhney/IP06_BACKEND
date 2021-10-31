package in.knaps.domain.model.base;

import org.apache.commons.lang3.StringUtils;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import java.util.Objects;

public class Validator {
    public static void isNotNull(Object object) {
        if (Objects.isNull(object)) {
            throw new InvalidArgumentException("ERROR: Object is null");
        }

    }

    public static void checkWebArgument(String object) {
        if (!StringUtils.isNotEmpty(object)) {
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }

    }

}
