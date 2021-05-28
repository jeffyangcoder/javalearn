package com.ecc.exercise.ex1.silumtemvc;

/**
 * @author yangshiwei
 * @Description 控制器类
 * @date 2021/5/21-14:44
 */
@Controller
public class MyController {
    @RequestMapping(value = "addPerson")
    public void add(){
        new DBCurd().add();
    }
}
