package gs.hexagonaldemo.springhexagonaldemo;

import gs.hexagonaldemo.springhexagonaldemo.ports.GetUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsersRestController {

    private GetUserService getUserService;

    @Autowired
    public UsersRestController(GetUserService getUserService) {
        this.getUserService = getUserService;
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String getUsers() {
        return getUserService.getAllUsers();
    }

    @RequestMapping(value = "/users/{userid}", method = RequestMethod.GET)
    public String getUser(@PathVariable int userid) {
        return getUserService.getUser(userid);
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public ResponseEntity addUser() {
        return new ResponseEntity(HttpStatus.CREATED);
    }
}