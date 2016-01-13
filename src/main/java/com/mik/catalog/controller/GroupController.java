package com.mik.catalog.controller;

import com.mik.catalog.dao.GroupDAO;
import com.mik.catalog.model.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by mikitjuk on 13.01.16.
 */
@Controller
public class GroupController {

    @Autowired
    @Qualifier("groupDAO")
    private GroupDAO groupDAO;

    @RequestMapping(value = "/group", method = RequestMethod.GET)
    public ModelAndView handleRequest() {
        List<Group> listUsers = groupDAO.listAll();
        ModelAndView model = new ModelAndView("groupList");
        model.addObject("groupList", listUsers);
        return model;
    }

//    @RequestMapping(value = "/new", method = RequestMethod.GET)
//    public ModelAndView newUser() {
//        ModelAndView model = new ModelAndView("UserForm");
//        model.addObject("user", new User());
//        return model;
//    }
//
//    @RequestMapping(value = "/edit", method = RequestMethod.GET)
//    public ModelAndView editUser(HttpServletRequest request) {
//        int userId = Integer.parseInt(request.getParameter("id"));
//        User user = userDao.get(userId);
//        ModelAndView model = new ModelAndView("UserForm");
//        model.addObject("user", user);
//        return model;
//    }
//
//    @RequestMapping(value = "/delete", method = RequestMethod.GET)
//    public ModelAndView deleteUser(HttpServletRequest request) {
//        int userId = Integer.parseInt(request.getParameter("id"));
//        userDao.delete(userId);
//        return new ModelAndView("redirect:/");
//    }
//
//    @RequestMapping(value = "/save", method = RequestMethod.POST)
//    public ModelAndView saveUser(@ModelAttribute User user) {
//        userDao.saveOrUpdate(user);
//        return new ModelAndView("redirect:/");
//    }
//

}
