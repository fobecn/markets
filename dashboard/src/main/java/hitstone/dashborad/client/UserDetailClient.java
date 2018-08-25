package hitstone.dashborad.client;

import cn.hitstone.client.user.UserDetail;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name ="user")
@Component
public interface UserDetailClient {

    @RequestMapping(method = RequestMethod.GET,value = "/user/details",params ={"page","size"})
    List<UserDetail> findPages(@RequestParam(value = "page") Integer page, @RequestParam(value = "size") Integer size) ;

    @RequestMapping(method = RequestMethod.GET, value = "/users/{id}/detail")
    UserDetail findById(@PathVariable("id") Long id);

}
