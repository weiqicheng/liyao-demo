package com.liyao.code.generator.controller;
import com.liyao.code.generator.model.TrUser;
import com.liyao.code.generator.service.TrUserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 *
 * Created by zhh on 2018/11/09.
 */
@Controller
@RequestMapping("/trUser/")
public class TrUserController {

    @Autowired
    TrUserService trUserService;

    @RequestMapping("add")
    @ResponseBody
    public String add(TrUser trUser) {
        trUserService.save(trUser);
        return "";
    }

    @RequestMapping("delete")
    @ResponseBody
    public String delete(@RequestParam Integer id) {
	    trUserService.deleteById(id);
	    return "";
    }

    @RequestMapping("update")
    @ResponseBody
    public String update(TrUser trUser) {
	    trUserService.update(trUser);
	    return "";
    }

    @RequestMapping("detail")
    @ResponseBody
    public String detail(@RequestParam Integer id) {
        TrUser trUser = trUserService.findById(id);
        return trUser.toString();
    }

    @RequestMapping("list")
    @ResponseBody
    public String list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<TrUser> list = trUserService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return list.toString();
    }
}
