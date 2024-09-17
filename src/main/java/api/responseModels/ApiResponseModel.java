package api.responseModels;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class ApiResponseModel {
    @JsonProperty("code")
    private int code;
    @JsonProperty("type")
    private String type;
    @JsonProperty("message")
    private String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ApiResponseModel(int code, String type, String message) {
        this.code = code;
        this.type = type;
        this.message = message;
    }
    public ApiResponseModel() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ApiResponseModel that)) return false;
        return getCode() == that.getCode() && Objects.equals(getType(), that.getType()) && Objects.equals(getMessage(), that.getMessage());
    }

}
