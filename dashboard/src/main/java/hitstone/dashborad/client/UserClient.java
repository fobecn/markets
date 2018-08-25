package hitstone.dashborad.client;

import cn.hitstone.client.user.User;
import cn.hitstone.client.user.UserAccount;
import cn.hitstone.client.user.UserDetail;
import cn.hitstone.client.user.request.UsernameSignInRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name ="user")
@Component
public interface UserClient {

    @RequestMapping(method = RequestMethod.GET, value = "/users/{id}/detail")
    UserDetail findUserDetailById(@PathVariable("id") Long id);

    @RequestMapping(method = RequestMethod.GET, value = "/user/accounts")
    UserAccount findUserAccountByTypeAndTypeId(@RequestParam("type") String type, @RequestParam("typeId") String typeId);

    @RequestMapping(method = RequestMethod.GET, value = "/users/{id}")
    User findByUserId(@PathVariable("id") Long id);

    @RequestMapping(value = "/user/name/sign/in",method = RequestMethod.POST,params ={"usernameSignInRequest"})
    UserDetail signIn(@RequestBody UsernameSignInRequest usernameSignInRequest, @RequestParam(value = "usernameSignInRequest") Boolean is);

    @RequestMapping(method = RequestMethod.GET,value = "/users",params ={"page","size"})
    List<User> findLimit(@RequestParam(value = "page") Integer page, @RequestParam(value = "size") Integer size) ;

    @RequestMapping(value = "/user/count",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    Long count() ;


}
