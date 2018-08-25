package hitstone.dashborad.response;

import org.springframework.http.ResponseEntity;

/**
 * Created by zee on 11/7/17.
 */
public class ResultFactory {


    public static  <T> ResultEntity<T> produce(ResponseEntity responseEntity, T body){
        ResultEntity<T> resultEntity = new ResultEntity<>();
        resultEntity.setBody(body);

        if(responseEntity.getHeaders().getFirst("code") == null){
            resultEntity.setMessage("成功.");
            resultEntity.setCode("0");
        }else {
            resultEntity.setCode(responseEntity.getHeaders().getFirst("code"));
            resultEntity.setMessage(responseEntity.getHeaders().getFirst("message"));
        }

        return resultEntity;
    }

    public static  <T> ResultEntity<T> produce(String code,String message,T body){
        ResultEntity<T> resultEntity = new ResultEntity<>();
        resultEntity.setBody(body);
        resultEntity.setCode(code);
        resultEntity.setMessage(message);

        return resultEntity;
    }

}
