package cn.wbhan.disaster.model.dto;

/**
 * Restful Response entity
 *
 * @param <T> the operation results.
 */
public class Result<T> {
    private Integer status;
    private String message;
    private Boolean success;
    private T data;

    private Result(Integer status, String message, Boolean success, T data) {
        this.status = status;
        this.message = message;
        this.success = success;
        this.data = data;
    }

    public static <F> Result<F> success(int status, String message, F data) {
        return new Result<F>(status, message, true, data);
    }

    public static <F> Result<F> fail(int status, String message) {
        return new Result<F>(status, message, false, null);
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
