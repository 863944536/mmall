package com.mmall.controller.backend;


import com.mmall.common.Const;
import com.mmall.common.ResponseCode;
import com.mmall.common.ServerResponse;
import com.mmall.pojo.Category;
import com.mmall.pojo.User;
import com.mmall.service.ICategoryService;
import com.mmall.service.IUserService;
import com.mmall.util.CookieUtil;
import com.mmall.util.JsonUtil;
import com.mmall.util.RedisPoolUtil;
import com.mmall.util.RedisShardedPoolUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 分类管理模块
 */
@Controller
@RequestMapping("/manage/category/")
public class CategoryManageController {

    @Autowired
    private IUserService iUserService;

    @Autowired
    private ICategoryService iCategoryService;

    /**
     * 品类添加
     * @param httpServletRequest
     * @param categoryName
     * @param parentId
     * @return
     */
    @RequestMapping("add_category.do")
    @ResponseBody
    public ServerResponse addCategory(HttpServletRequest httpServletRequest,String categoryName,@RequestParam(value = "parentId",defaultValue = "0") int parentId){
//  1.0普通登录       User user = (User)session.getAttribute(Const.CURRENT_USER);
//  2.0   String loginToken = CookieUtil.readLoginToken(httpServletRequest);
//        if(StringUtils.isEmpty(loginToken)){
//            return ServerResponse.createByErrorMessage("用户未登录，无法获取用户信息");
//        }
//        String userJsonStr = RedisShardedPoolUtil.get(loginToken);
//        User user = JsonUtil.stringToObj(userJsonStr,User.class);
//        if(user == null){
//            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),"用户未登录");
//        }
//        //校验是否是管理员
//        if(iUserService.checkAdminRole(user).isSuccess()){
//            //增加处理分类的逻辑
//            return iCategoryService.addCategory(categoryName,parentId);
//        }else{
//            return ServerResponse.createByErrorMessage("无权限操作");
//        }
        //全部通过拦截器验证是否登录以及权限
        return iCategoryService.addCategory(categoryName,parentId);
    }

    /**
     * 更新品类信息
     * @param httpServletRequest
     * @param categoryId
     * @param categoryName
     * @return
     */
    @RequestMapping("set_category_name.do")
    @ResponseBody
    public ServerResponse setCategoryName(HttpServletRequest httpServletRequest,Integer categoryId,String categoryName){
//        User user = (User)session.getAttribute(Const.CURRENT_USER);
//        String loginToken = CookieUtil.readLoginToken(httpServletRequest);
//        if(StringUtils.isEmpty(loginToken)){
//            return ServerResponse.createByErrorMessage("用户未登录，无法获取用户信息");
//        }
//        String userJsonStr = RedisShardedPoolUtil.get(loginToken);
//        User user = JsonUtil.stringToObj(userJsonStr,User.class);
//        if(user == null){
//            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),"用户未登录");
//        }
//        //校验是否是管理员
//        if(iUserService.checkAdminRole(user).isSuccess()){
//            //更新品类名字
//            return iCategoryService.updateCategoryName(categoryId,categoryName);
//        }else{
//            return ServerResponse.createByErrorMessage("无权限操作");
//        }
        //全部通过拦截器验证是否登录以及权限
        return iCategoryService.updateCategoryName(categoryId,categoryName);
    }

    /**
     * 获取子节点的category信息，并且不递归
     * @return
     */
    @RequestMapping("get_category.do")
    @ResponseBody
    public ServerResponse getChildrenParallelCategory(HttpServletRequest httpServletRequest,@RequestParam(value = "categoryId",defaultValue = "0") Integer categoryId){
//        User user = (User)session.getAttribute(Const.CURRENT_USER);
//        String loginToken = CookieUtil.readLoginToken(httpServletRequest);
//        if(StringUtils.isEmpty(loginToken)){
//            return ServerResponse.createByErrorMessage("用户未登录，无法获取用户信息");
//        }
//        String userJsonStr = RedisShardedPoolUtil.get(loginToken);
//        User user = JsonUtil.stringToObj(userJsonStr,User.class);
//        if(user == null){
//            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),"用户未登录");
//        }
//        //校验是否是管理员
//        if(iUserService.checkAdminRole(user).isSuccess()){
//            return iCategoryService.getChildrenParallelCategory(categoryId);
//        }else{
//            return ServerResponse.createByErrorMessage("无权限操作");
//        }
        //全部通过拦截器验证是否登录以及权限
        return iCategoryService.getChildrenParallelCategory(categoryId);
    }

    @RequestMapping("get_category_deep.do")
    @ResponseBody
    public ServerResponse getCategoryAndDeepChildrenCategory(HttpServletRequest httpServletRequest, @RequestParam(value = "categoryId",defaultValue = "0") Integer categoryId){
//        User user = (User)session.getAttribute(Const.CURRENT_USER);
//        String loginToken = CookieUtil.readLoginToken(httpServletRequest);
//        if(StringUtils.isEmpty(loginToken)){
//            return ServerResponse.createByErrorMessage("用户未登录，无法获取用户信息");
//        }
//        String userJsonStr = RedisShardedPoolUtil.get(loginToken);
//        User user = JsonUtil.stringToObj(userJsonStr,User.class);
//        if(user == null){
//            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),"用户未登录");
//        }
//        //校验是否是管理员
//        if(iUserService.checkAdminRole(user).isSuccess()){
//            //查询当前节点的id和递归子节点的id 0-->10000-->100000
//            return iCategoryService.selectCategoryAndChildrenCategoryById(categoryId);
//        }else{
//            return ServerResponse.createByErrorMessage("无权限操作");
//        }
        //全部通过拦截器验证是否登录以及权限
        return iCategoryService.selectCategoryAndChildrenCategoryById(categoryId);

    }

}
