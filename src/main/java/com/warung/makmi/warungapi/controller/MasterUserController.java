package com.warung.makmi.warungapi.controller;

import com.warung.makmi.warungapi.common.StatusCode;
import com.warung.makmi.warungapi.dto.User;
import com.warung.makmi.warungapi.service.MasterUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class MasterUserController extends BaseController {

    @Autowired
    private MasterUserService serviceUser;

    @RequestMapping(value = "/users/find", method = RequestMethod.GET)
    public Map<String, Object> find() {
        return convertModel(serviceUser.find());
    }

    @RequestMapping(value = "/users/find-by-email", method = RequestMethod.GET)
    public Map<String, Object> findByEmail(@RequestParam(value = "email")String email) {
        return convertModel(serviceUser.findByEmail(email));
    }

    @RequestMapping(value = "/users/save", method = RequestMethod.POST)
    public Map<String, Object> save (@RequestBody User user) {

        try {
            serviceUser.save(user);

            return convertModel(StatusCode.SAVE_SUCCESS);
        } catch (Exception e) {
            return convertModel(e.getMessage(), StatusCode.OPERATION_FAILED);
        }
    }
}
