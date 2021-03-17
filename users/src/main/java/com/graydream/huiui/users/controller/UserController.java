package com.graydream.huiui.users.controller;


import com.graydream.huiui.users.model.User;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @RequestMapping(value = "test1",method = RequestMethod.POST)
    public User getUser(@RequestParam(required = true,name = "arr",value = "arr") String arr){
        User user=new User();
        user.setUserName(arr);
        user.setPassword("huihsui");
        user.setUserId(1);
        return user;
    }



    @RequestMapping("/getUser/{userName}")
    public User getUserName(@PathVariable(value = "userName",required = true) String userName) {
        System.out.println("若下面没出现“无缓存的时候调用”字样且能打印出数据表示测试成功");
        User user = new User();
        user.setUserName(userName);
        return user;
    }
    @RequestMapping("/getUsera")
    public User getUserNamea(@RequestParam(value = "userName",required = true) String userName) {
        System.out.println("若下面没出现“无缓存的时候调用”字样且能打印出数据表示测试成功");
        return new User();
    }


    @RequestMapping("/getUserRedis")
    @Cacheable(value="user-key")
    public User getUserCache() {
        User user=new User(11,"huihuiRedis ","Redis123s");
        System.out.println("若下面没出现“无缓存的时候调用”字样且能打印出数据表示测试成功");
        return user;
    }
}
