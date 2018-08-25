package hitstone.dashborad.response;

/**
 * Created by zee on 11/7/17.
 */
public class ResultEntity<T> {

    private String code;
    private String message;
    private Long count;
    private T body;

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
