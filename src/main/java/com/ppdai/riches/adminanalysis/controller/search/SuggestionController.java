package com.ppdai.riches.adminanalysis.controller.search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ppdai.riches.adminanalysis.controller.base.BaseController;
import com.ppdai.riches.adminanalysis.entity.Suggestion;
import com.ppdai.riches.adminanalysis.pageModel.base.Grid;
import com.ppdai.riches.adminanalysis.pageModel.base.Json;
import com.ppdai.riches.adminanalysis.pageModel.base.PageFilter;
import com.ppdai.riches.adminanalysis.pageModel.base.Tree;
import com.ppdai.riches.adminanalysis.pageModel.sys.Role;
import com.ppdai.riches.adminanalysis.service.sys.RoleServiceI;
import com.ppdai.riches.adminanalysis.utils.HttpUtil;


@Controller
@RequestMapping("/search")
public class SuggestionController extends BaseController {

	@Autowired
	private RoleServiceI roleService;
	
	@RequestMapping("/manager")
	public String manager() {
		return "/search/suggestion";
	}

	@RequestMapping("/dataGrid")
	@ResponseBody
	public Grid dataGrid(Role role, PageFilter ph) {
		Grid grid = new Grid();
		HttpUtil http = new HttpUtil();
		
		Map map = new HashMap();
		map.put("query", "");
		map.put("start", (ph.getPage()-1)*ph.getRows());
		map.put("limit",ph.getRows());
		String li = http.HttpPost("http://192.168.20.86:8181/searchAdmin", "admin/suggestion/list.json", map);
		JSONObject json = JSONObject.fromObject(li);
		System.out.println(li);
		JSONArray ja = json.getJSONArray("list");
		List<Suggestion> list = new ArrayList<Suggestion>();
		for(int i=0;i < ja.size(); i++){
			Suggestion s = new Suggestion();
			JSONObject js = (JSONObject)ja.get(i);
			s.setSid((long)js.getInt("sid"));
			s.setKeyword(js.getString("keyword"));
			list.add(s);
		}
		grid.setRows(list);
		grid.setTotal((long)json.getInt("total"));
		return grid;
	}
	
	@RequestMapping("/tree")
	@ResponseBody
	public List<Tree> tree() {
		return roleService.tree();
	}
	
	@RequestMapping("/addPage")
	public String addPage() {
		return "/search/suggestionAdd";
	}

	@RequestMapping("/add")
	@ResponseBody
	public Json add(Suggestion suggestion) {
		Json j = new Json();
			HttpUtil http = new HttpUtil();
			Map map = new HashMap();
			JSONObject json = new JSONObject();
			json.put("sid", 0);
			json.put("keyword", suggestion.getKeyword());
			map.put("data", json);
			String li = http.HttpPost("http://192.168.20.86:8181/searchAdmin", "admin/suggestion/new.json", map);
			JSONObject json1 = JSONObject.fromObject(li);
			if(json1.getBoolean("success")){
			j.setSuccess(true);
			j.setMsg("添加成功！");
			}else{
				j.setMsg("添加失败");
			}
		
		return j;
	}

	@RequestMapping("/delete")
	@ResponseBody
	public Json delete(Long sid) {
		Json j = new Json();
		HttpUtil http = new HttpUtil();
		Map map = new HashMap();
		JSONObject json = new JSONObject();
		json.put("sid", sid);
		json.put("keyword", "");
		map.put("data", json);
		String li = http.HttpPost("http://192.168.20.86:8181/searchAdmin", "admin/suggestion/destroy.json", map);
		JSONObject json1 = JSONObject.fromObject(li);
		if(json1.getBoolean("success")){
		j.setSuccess(true);
		j.setMsg("删除成功！");
		}else{
			j.setMsg("删除失败");
		}
		return j;
	}

	@RequestMapping("/get")
	@ResponseBody
	public Role get(Long id)  {
		return roleService.get(id);
	}
	
	@RequestMapping("/editPage")
	public String editPage(HttpServletRequest request, Long sid) {
		HttpUtil http = new HttpUtil();
		Map map = new HashMap();
		map.put("sid", sid);
		String li = http.HttpPost("http://192.168.20.86:8181/searchAdmin", "admin/suggestion/one.json", map); 
		JSONObject json = JSONObject.fromObject(li);
		JSONObject j = json.getJSONObject("suggestion");
		Suggestion su = new Suggestion();
		su.setSid((long)j.getInt("sid"));
		su.setKeyword(j.getString("keyword"));
		request.setAttribute("suggestion", su);
		return "/search/suggestionEdit";
	}

	@RequestMapping("/edit")
	@ResponseBody
	public Json edit(Suggestion suggestion) {
		Json j = new Json();
		HttpUtil http = new HttpUtil();
		Map map = new HashMap();
		JSONObject json = new JSONObject();
		json.put("sid", suggestion.getSid());
		json.put("keyword", suggestion.getKeyword());
		map.put("data", json);
		String li = http.HttpPost("http://192.168.20.86:8181/searchAdmin", "admin/suggestion/update.json", map);
		JSONObject json1 = JSONObject.fromObject(li);
		if(json1.getBoolean("success")){
		j.setSuccess(true);
		j.setMsg("修改成功！");
		}else{
			j.setMsg("修改失败");
		}
		return j;
	}
	
	@RequestMapping("/grantPage")
	public String grantPage(HttpServletRequest request, Long id) {
		Role r = roleService.get(id);
		request.setAttribute("role", r);
		return "/admin/roleGrant";
	}

	@RequestMapping("/grant")
	@ResponseBody
	public Json grant(Role role) {
		Json j = new Json();
		try {
			roleService.grant(role);
			j.setMsg("授权成功！");
			j.setSuccess(true);
		} catch (Exception e) {
			j.setMsg(e.getMessage());
		}
		return j;
	}

}
