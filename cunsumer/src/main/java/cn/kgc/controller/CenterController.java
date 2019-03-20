package cn.kgc.controller;

import cn.kgc.service.TableToObjectService;
import cn.kgc.vo.TableToObject;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2019/3/20 0020.
 */
@Controller
public class CenterController {
	    @Autowired
	        private TableToObjectService tableToObjectService;
	        //登录
	        @RequestMapping("/login.do")
	        public String login(TableToObject tableToObject, HttpSession session){
	            TableToObject loginuser=tableToObjectService.findByCondition(tableToObject);
	            session.setAttribute("loginuser",loginuser);
	            return  "/index.html";
	        }
	        //退出登录
	        @RequestMapping("/exitLogin.do")
	        public String exitLogin(TableToObject tableToObject, HttpSession session){
	            session.removeAttribute("loginuser");
	            return  "/login.html";
	        }
	        //分页查询
	        @ResponseBody
	        @RequestMapping("/showPage.do")
	        public HashMap<Object,Object> showPage(@RequestParam(defaultValue = "1",required = false)int pageno, TableToObject tableToObject, HttpSession session) {
	            HashMap<Object,Object> map=new HashMap<Object,Object>();
	            TableToObject loginuser=(TableToObject)session.getAttribute("loginuser");
	            Integer pagesize=2;
	            //分页数据
	            PageInfo<TableToObject> pageInfo=tableToObjectService.findPage(pageno,pagesize,tableToObject);
	            //一方集合
	            List<TableToObject> oneList=tableToObjectService.findOneList();
	            map.put("pageInfo",pageInfo);
	            map.put("loginuser",loginuser);
	            map.put("oneList",oneList);
	            return map;
	        }
	    //    //查询所有或条件查询
	    //    //首页查询的起点index.html，因为只有有index.html过来，才会执行showData
	    //    @ResponseBody
	    //    @RequestMapping(value = "/showData.do")
	    //    public HashMap<Object,Object> showData(HttpSession session,TableToObject tableToObject) {
	    //        HashMap<Object,Object> map=new HashMap<Object,Object>();
	    //        TableToObject loginuser=(TableToObject)session.getAttribute("loginuser");
	    //        List<TableToObject> list=tableToObjectService.findPage(tableToObject);
	    //        map.put("list",list);
	    //        map.put("loginuser",loginuser);
	    //        return map;
	    //    }
	        //根据主键查询单条
	        @ResponseBody
	        @RequestMapping("/findById.do")
	        public HashMap<Object,Object> findById(Integer key) {
	            HashMap<Object,Object> map=new HashMap<Object,Object>();
	            TableToObject data=new TableToObject(key);
	            TableToObject tableToObject=tableToObjectService.findByCondition(data);
	            //一方集合
	            List<TableToObject> oneList=tableToObjectService.findOneList();
	            map.put("tableToObject",tableToObject);
	            map.put("oneList",oneList);
	            return map;
	        }

	        //添加
	        @RequestMapping("/saveData.do")
	        public String saveData(TableToObject tableToObject) {
	            int num= tableToObjectService.addObject(tableToObject);
	            return "/index.html";
	        }

	        //修改
	        @RequestMapping("/editData.do")
	        public String editData(TableToObject tableToObject) {
	            int num=tableToObjectService.editObject(tableToObject);
	            return "/index.html";
	        }

	        //删除
	        @RequestMapping("/deleteData.do")
	        public String deleteData(Integer key) {
	            int num=tableToObjectService.deleteObject(key);
	            return "/index.html";
	        }
}
