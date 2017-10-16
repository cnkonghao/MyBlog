package com.blog.controller;

import java.util.List;

import javax.servlet.ServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.blog.pojo.Comment;
import com.blog.pojo.Feeds;
import com.blog.pojo.Page;
import com.blog.pojo.Posts;
import com.blog.pojo.Tags;
import com.blog.service.impl.CatsServiceImpl;
import com.blog.service.impl.CommentServiceImpl;
import com.blog.service.impl.PostServiceImpl;
import com.blog.service.impl.Post_extendsServiceImpl;
import com.blog.service.impl.SensitiveService;
import com.blog.service.impl.TagsServiceImpl;
import com.blog.utils.DateUtil;
import com.github.pagehelper.PageInfo;

@Controller
public class PostController {

	@Autowired
	private PostServiceImpl postService;
	@Autowired
	private Post_extendsServiceImpl post_extendsService;
	@Autowired
	private TagsServiceImpl tagsServiceImpl;
	@Autowired
	private CommentServiceImpl commentService;
	@Autowired
	private CatsServiceImpl catsService;
	@Autowired
	private SensitiveService sensitiveService;
	@RequestMapping(value="/post",method=RequestMethod.GET)
	public String postView(@RequestParam(required = false, defaultValue = "1")int page,Model model){
		System.out.println(page);
		List<Posts> list = postService.queryByPage(page, 5);//查询
		 // 取分页信息
       PageInfo<Posts> pageInfo = new PageInfo<Posts>(list);
       for (int i = 0; i < list.size(); i++) {
			list.get(i).setCreatedAt(DateUtil.stampToDate(list.get(i).getCreatedAt()));
		}
       Page<Posts> data = new Page<Posts>();
       data.setList(list);
       data.setTotal(pageInfo.getPages());
       data.setPagesize(5);
       data.setPage(pageInfo.getPageNum());
       model.addAttribute("data",data);
		
		//List<Posts> posts = postService.listValidPosts();
		List<Posts> nList = postService.listNewPosts();
		List<Posts> tList = postService.listTopPosts();
		List<Tags> tags = tagsServiceImpl.getTagName();
		//model.addAttribute("posts",posts);
		model.addAttribute("newposts",nList);
		model.addAttribute("topposts",tList);
		model.addAttribute("tags",tags);
		return "allpost";
	}
	
	@RequestMapping(value = "/post/{postId}")
	public String showPostDetails(@PathVariable int postId,Model model){
		try {
			List<Comment> comments = commentService.getCommentByPostId(postId);
			Posts post = postService.getPostById(postId);
			post_extendsService.postBrowserAdd(postId);
//			post_extendsService.postCollectAdd(postId);
//			post_extendsService.postPraiseAdd(postId);
			post.setCreatedAt(DateUtil.stampToDate(post.getCreatedAt()));
			model.addAttribute("post",post);
			List<Posts> nList = postService.listNewPosts();
			List<Posts> tList = postService.listTopPosts();
			List<Tags> tags = tagsServiceImpl.getTagName();
			model.addAttribute("comments",comments);
			model.addAttribute("newposts", nList);
			model.addAttribute("topposts", tList);
			model.addAttribute("tags",tags);
			return "post";
		} catch (Exception e) {
			return "err";
		}
	}
	
	@RequestMapping(value="/post/addComment",method=RequestMethod.POST)
	public @ResponseBody String commentAdd(int postid,String content,ServletRequest request){
		Comment comment = new Comment();
		content = sensitiveService.filter(content);
		comment.setContent(content);
		comment.setPostid(postid);
		comment.setUsername(request.getRemoteAddr());//取得来访者的IP地址
		commentService.addComment(comment);
		post_extendsService.postCommentAdd(postid);
		return "{}";
	}
	
	@RequestMapping(value = "/tags/{tagsId}")
	public String showPostsByTag(@PathVariable int tagsId,Model model){
		try {
			List<Posts> posts = postService.getPostByTagId(tagsId);
			List<Posts> nList = postService.listNewPosts();
			List<Posts> tList = postService.listTopPosts();
			List<Tags> tags = tagsServiceImpl.getTagName();
			model.addAttribute("newposts", nList);
			model.addAttribute("topposts", tList);
			model.addAttribute("tags",tags);
			model.addAttribute("posts",posts);
			for (Posts postsItem : posts) {
				System.out.println(postsItem);
			}
			return "allpost";
		} catch (Exception e) {
			e.printStackTrace();
			return "err";
		}
	}
}


