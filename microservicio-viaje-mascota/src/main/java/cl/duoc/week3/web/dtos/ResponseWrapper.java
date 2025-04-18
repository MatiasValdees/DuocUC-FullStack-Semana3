package cl.duoc.week3.web.dtos;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;



@JsonPropertyOrder({ "status", "timestamp", "data" }) 
public class ResponseWrapper<T> {
    private String status;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime timestamp;
    private T data;

    public ResponseWrapper() {
    }

    public ResponseWrapper(String status, LocalDateTime timestamp, T data) {
        this.status = status;
        this.timestamp = timestamp;
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static class Builder<T> {
        private String status;
        private LocalDateTime timestamp;
        private T data;

        public Builder<T> status(String status) {
            this.status = status;
            return this;
        }

        public Builder<T> timestamp(LocalDateTime timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public Builder<T> data(T data) {
            this.data = data;
            return this;
        }

        public ResponseWrapper<T> build() {
            return new ResponseWrapper<>(status, timestamp, data);
        }
    }

    public static <T> Builder<T> builder() {
        return new Builder<>();
    }
}

