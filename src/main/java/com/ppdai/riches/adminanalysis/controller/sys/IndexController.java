package com.ppdai.riches.adminanalysis.controller.sys;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ppdai.riches.adminanalysis.controller.base.BaseController;
import com.ppdai.riches.adminanalysis.framework.constant.GlobalConstant;
import com.ppdai.riches.adminanalysis.pageModel.base.Json;
import com.ppdai.riches.adminanalysis.pageModel.base.SessionInfo;
import com.ppdai.riches.adminanalysis.pageModel.sys.User;
import com.ppdai.riches.adminanalysis.service.sys.ResourceServiceI;
import com.ppdai.riches.adminanalysis.service.sys.UserServiceI;

@Controller
@RequestMapping("/admin")
public class IndexController extends BaseController {
	private Logger log=Logger.getLogger(IndexController.class);
	@Autowired
	private UserServiceI userService;
	
	@Autowired
	private ResourceServiceI resourceService;

	@RequestMapping("/index")
	public String index(HttpServletRequest request) {
		SessionInfo sessionInfo = (SessionInfo) request.getSession().getAttribute(GlobalConstant.SESSION_INFO);
		if ((sessionInfo != null) && (sessionInfo.getId() != null)) {
			return "/index";
		}
		return "/login";
	}
	@RequestMapping("/index1")
	public String index1(HttpServletRequest request) {
		SessionInfo sessionInfo = (SessionInfo) request.getSession().getAttribute(GlobalConstant.SESSION_INFO);
		if ((sessionInfo != null) && (sessionInfo.getId() != null)) {
			return "/index1";
		}else
		{
			String loginName=request.getParameter("loginname");
			String password=request.getParameter("password");
			User user=new User();
			user.setLoginname(loginName);
			user.setPassword(password);
			HttpSession session=request.getSession();
			if(login2(user,session))
				return "/index1";
			else
				return "/login";
		}
		
	}
	@RequestMapping("/index2")
	public String index2(HttpServletRequest request) {
		SessionInfo sessionInfo = (SessionInfo) request.getSession().getAttribute(GlobalConstant.SESSION_INFO);
		if ((sessionInfo != null) && (sessionInfo.getId() != null)) {
			return "/index2";
		}
		return "/login";
	}
	@ResponseBody
	@RequestMapping("/login")
	public Json login(User user, HttpSession session) {
		Json j = new Json();
		User sysuser = userService.login(user);
		if (sysuser != null) {
			j.setSuccess(true);
			j.setMsg("登陆成功！");
			SessionInfo sessionInfo = new SessionInfo();
			sessionInfo.setId(sysuser.getId());
			sessionInfo.setLoginname(user.getLoginname());
			sessionInfo.setPassword(user.getPassword());
			sessionInfo.setName(sysuser.getName());
			// user.setIp(IpUtil.getIpAddr(getRequest()));
			sessionInfo.setResourceList(userService.resourceList(sysuser.getId()));
			sessionInfo.setResourceAllList(resourceService.resourceAllList());
			session.setAttribute(GlobalConstant.SESSION_INFO, sessionInfo);
			log.info("登陆成功！");
		} else {
			j.setMsg("用户名或密码错误！");
			log.info("用户名或密码错误！");
		}
		return j;
	}

	@RequestMapping("/login2")
	public boolean login2(User user, HttpSession session) {
		User sysuser = userService.login(user);
		if (sysuser != null) {
			SessionInfo sessionInfo = new SessionInfo();
			sessionInfo.setId(sysuser.getId());
			sessionInfo.setLoginname(sysuser.getLoginname());
			sessionInfo.setName(sysuser.getName());
			// user.setIp(IpUtil.getIpAddr(getRequest()));
			sessionInfo.setResourceList(userService.resourceList(sysuser.getId()));
			sessionInfo.setResourceAllList(resourceService.resourceAllList());
			session.setAttribute(GlobalConstant.SESSION_INFO, sessionInfo);
			return true;
		} else {
			return false;
		}
	}
	@ResponseBody
	@RequestMapping("/logout")
	public Json logout(HttpSession session) {
		Json j = new Json();
		if (session != null) {
			session.invalidate();
		}
		j.setSuccess(true);
		j.setMsg("注销成功！");
		return j;
	}

}
