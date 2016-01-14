package com.mik.catalog.controller;

import com.mik.catalog.dao.GroupDAO;
import com.mik.catalog.model.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by mikitjuk on 13.01.16.
 */
@RestController
public class GroupController {

    @Autowired
    @Qualifier("groupDAO")
    private GroupDAO groupDAO;

    // получение списка груп
    @RequestMapping(value = "/group/list", method = RequestMethod.GET)
    public List<Group> groupList() {
        List<Group> listUsers = groupDAO.listAll();
        return listUsers.size() == 0 ? null : groupDAO.listAll();
    }

    // создание группы
    @RequestMapping(value = "/group/create", method = RequestMethod.POST)
    public String newGroup(@RequestBody Group group) {

        String retStr;
        if (groupDAO.findGroup(group).size() > 0 )
            retStr = "find similar - not add";
        else if (group.getDept() == null || group.getName() == null)
            retStr = "not all fields are filled";
        else
            retStr = "Group add id = " + groupDAO.create(group);

        return retStr;
    }

    // получение группы по id
    @RequestMapping(value = "/group/read", method = RequestMethod.GET)
    public Group readGroup(@RequestParam Integer id) {
        return groupDAO.read(id);
    }

    // обновление группы
    @RequestMapping(value = "/group/update", method = RequestMethod.POST)
    public String editGroup(@RequestBody Group group) {
        //?? - обновленеи не хорошо
        groupDAO.update(group);
        return "Update - ok";
    }

    // удаление группы
    @RequestMapping(value = "/group/delete", method = RequestMethod.GET)
    public String editGroup(@RequestParam Integer id) {

        String retStr;
        Group group = groupDAO.read(id);
        //!!нужна проверка перед удаление по продуктам!!!
        if (group == null) {
            retStr = "not find group id = " + id;
        } else {
            groupDAO.delete(group);
            retStr = "Group deleted successfully!";
        }

        return retStr;
    }
}
