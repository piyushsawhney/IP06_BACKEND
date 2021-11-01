package in.knaps.api.mf.v1.scheme;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class SchemeReturn {
    Double schemeReturn;

    public SchemeReturn() {
    }

    public SchemeReturn(Double schemeReturn) {
        this.schemeReturn = schemeReturn;
    }

    public Double getSchemeReturn() {
        return schemeReturn;
    }

    public void setSchemeReturn(Double schemeReturn) {
        this.schemeReturn = schemeReturn;
    }
}
