package com.blog.controller;

import java.util.List;

import javax.servlet.ServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.blog.pojo.Feeds;
import com.blog.pojo.Page;
import com.blog.service.impl.FeedsServiceImpl;
import com.blog.service.impl.SensitiveService;
import com.blog.utils.DateUtil;
import com.github.pagehelper.PageInfo;
@Controller
public class feelsController {
	
	@Autowired
	private FeedsServiceImpl feedsService;
	@Autowired
	private SensitiveService sensitiveService;
	@RequestMapping("/feels")
	public String aboutView(@RequestParam(required = false, defaultValue = "1")int page,Model model){
		List<Feeds> list = feedsService.queryByPage(page, 8);//查询
		 // 取分页信息
        PageInfo<Feeds> pageInfo = new PageInfo<Feeds>(list);
        for (int i = 0; i < list.size(); i++) {
			list.get(i).setCreatedAt(DateUtil.stampToDate(list.get(i).getCreatedAt()));
		}
        Page<Feeds> data = new Page<Feeds>();
        data.setList(list);
        data.setTotal(pageInfo.getPages());
        data.setPagesize(8);
        data.setPage(pageInfo.getPageNum());
        model.addAttribute("data",data);
		return "feels";
	}
	@RequestMapping(value="/feels/add",method=RequestMethod.POST)
	public @ResponseBody String addFeels(String user,String content,ServletRequest request){
		//System.out.println(content);
		content = sensitiveService.filter(content);
		Feeds feeds = new Feeds();
		feeds.setContent(content);
		feeds.setUser(user);
		System.out.println(user);
		feedsService.addFeeds(feeds);
		return "{}";
	}
}
