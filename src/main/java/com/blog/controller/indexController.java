package com.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.blog.pojo.Posts;
import com.blog.pojo.Tags;
import com.blog.service.impl.PostServiceImpl;
import com.blog.service.impl.TagsServiceImpl;

@Controller
public class indexController {
@Autowired
private PostServiceImpl postServiceImpl;
@Autowired
private TagsServiceImpl tagsServiceImpl;
@RequestMapping("/index")
public String indexView(Model model){
	List<Posts> pList=postServiceImpl.listFirstAll();//查询首页的合法文章
	List<Posts> nList=postServiceImpl.listNewPosts();//查出最新的6篇文章，扔在  最新文章
	List<Posts> tList=postServiceImpl.listTopPosts();//查询可见的浏览量最多的三篇文章
	List<Tags> tags=tagsServiceImpl.getTagName();//查询所有的标签名字
	
	model.addAttribute("posts", pList);
	model.addAttribute("newposts",nList);
	model.addAttribute("topposts", tList);
	model.addAttribute("tags",tags);
	return "index";
	
}
}
