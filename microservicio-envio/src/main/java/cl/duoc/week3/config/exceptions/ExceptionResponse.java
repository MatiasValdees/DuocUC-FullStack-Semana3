package cl.duoc.week3.config.exceptions;



public class ExceptionResponse<T> {
    private String code;
    private T message;


    public ExceptionResponse() {
    }

    public ExceptionResponse(String code, T message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public T getMessage() {
        return message;
    }

    public void setMessage(T message) {
        this.message = message;
    }

    public static class Builder<T> {
        private String code;
        private T message;

        public Builder<T> code(String code) {
            this.code = code;
            return this;
        }

        public Builder<T> message(T message) {
            this.message = message;
            return this;
        }

        public ExceptionResponse<T> build() {
            return new ExceptionResponse<>(code, message);
        }
    }

    public static <T> Builder<T> builder() {
        return new Builder<>();
    }
}
