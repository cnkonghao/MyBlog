package com.blog.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;

import com.blog.pojo.Admin;
import com.blog.pojo.Cats;
import com.blog.pojo.Page;
import com.blog.pojo.Posts;
import com.blog.service.impl.AdminServiceImpl;
import com.blog.service.impl.CatsServiceImpl;
import com.blog.service.impl.PostServiceImpl;
import com.blog.service.impl.Relation_post_tagsServiceImpl;
import com.blog.service.impl.TagsServiceImpl;
import com.blog.utils.DateUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/home")
@SessionAttributes({"loginadmin","username"})
public class homeController {

	@Autowired
	private AdminServiceImpl adminServiceImpl;
	
	@Autowired
	private PostServiceImpl postServiceImpl;
	
	@Autowired
	private CatsServiceImpl catsServiceImpl;
	
	@Autowired
	private TagsServiceImpl tagsServiceImpl;
	
	@Autowired
	private Relation_post_tagsServiceImpl relation_post_tagsServiceImpl;

	@RequestMapping("/index")
	public String homeView(HttpServletRequest request,Model model){
		if (request.getSession().getAttribute("loginadmin")!=null) {
			Admin admin = (Admin) request.getSession().getAttribute("loginadmin");
			model.addAttribute("role",admin.getRole());
//			System.out.println(admin.getRole());
			return "home";
		}
		return "redirect:/home/login";
	}
	//显示登录页面(管理员)
	@RequestMapping("/login")
	public String loginView() {
		return "login";

	}
	//登录操作
	@RequestMapping("/dologin")
	public String dologin(Admin admin,Model model){
		Admin admin2  = adminServiceImpl.checkPassword(admin);
		if (null==admin2) {
			return "err";
		}else{
			if (admin2.getStatus()!=1) {
				return "err";
			}
			model.addAttribute("loginadmin",admin2);
			model.addAttribute("username",admin2.getUsername());
			return "redirect:/home/index";
		}
	}

	//注销
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request,SessionStatus sessionStatus){
		request.getSession().removeAttribute("loginadmin");
		request.getSession().removeAttribute("username");
		sessionStatus.setComplete();
		return "redirect:/home/login";
	}
	
		//显示用户资料
		@RequestMapping("/admin/selects")
		public String SelectAdmin(HttpServletRequest request,Model model){
			
			return "Admin/select";
		}
		
	//显示增加用户界面
	@RequestMapping("/admin/add")
	public String addUser(HttpServletRequest request){
		if(request.getSession().getAttribute("loginadmin")!=null){
			Admin admin = (Admin) request.getSession().getAttribute("loginadmin");
			if(admin.getRole()>20) {
				return "Admin/add";
			}
		}
		return "err";
	}

	//添加用户
	@RequestMapping(value="/admin/doadd",method=RequestMethod.POST)
	public String doAdminAdd(Admin newAdmin,HttpSession session){
		if(session.getAttribute("loginadmin")!=null){
			Admin admin = (Admin) session.getAttribute("loginadmin");
			if (admin.getRole()>20) {
				adminServiceImpl.addAdmin(newAdmin);
				return "redirect:/home/admin/index";
			}
		}
		return "err";
	}
	
	//显示用户
	@RequestMapping("/admin/index")
	public String showUsers(HttpServletRequest request,Model model){
		if (request.getSession().getAttribute("loginadmin")!=null) {
			Admin admin = (Admin) request.getSession().getAttribute("loginadmin");
			if (admin.getRole()>20) {
				List<Admin> admins = adminServiceImpl.selectAll();
				for (int i = 0; i < admins.size(); i++) {
					if (null!=admins.get(i).getUpdatedAt()) {
						admins.get(i).setUpdatedAt(DateUtil.stampToDate(admins.get(i).getUpdatedAt()));
					}
				}
				model.addAttribute("admins",admins);
				return "Admin/index";
			}
		}
		return "err";
	}

	//修改用户是否合法(启用禁用)
	@RequestMapping("admin/setValid/{username}")
	public String setUserValid(@PathVariable String username,HttpSession session){
		if (session.getAttribute("loginadmin")!=null) {
			Admin admin = (Admin) session.getAttribute("loginadmin");
			if (admin.getRole()>20){
				adminServiceImpl.checkStatus(username);
				return "redirect:/home/admin/index";
			}
		}
		return "err";
	}

	//修改用户资料界面
	@RequestMapping(value="/admin/toupdate",method=RequestMethod.GET)
	public String updateUser(Integer id,HttpSession session,Model model){
		if(session.getAttribute("loginadmin")!=null) {
			Admin admin = (Admin) session.getAttribute("loginadmin");
			if(admin.getRole()>20) {
				Admin admin2 = adminServiceImpl.selectAdmin(id);
				model.addAttribute("admin", admin2);
				return "Admin/update";
			}
		}
		return "err";
	}
	
	//修改用户资料
	@RequestMapping(value="/admin/update",method=RequestMethod.POST)
	public String doAdminUpdate(Admin newAdmin,HttpSession session){
		if(session.getAttribute("loginadmin")!=null){
			Admin admin = (Admin) session.getAttribute("loginadmin");
			if (admin.getRole()>20) {
				if (newAdmin.getPasswordHash().equals(adminServiceImpl.selectAdmin(newAdmin.getId()).getPasswordHash())) {
					newAdmin.setPasswordHash(null);
				}
				adminServiceImpl.UpdateAdmin(newAdmin);
				return "redirect:/home/admin/index";
			}
		}
		return "err";
	}
	
	//删除用户
	@RequestMapping(value="/admin/delete")
	public String AdminDelete(HttpServletRequest request,Integer id) {
		System.out.println("ID是："+id);
		if(request.getSession().getAttribute("loginadmin")!=null) {
			Admin admin = (Admin) request.getSession().getAttribute("loginadmin");
			if(admin.getRole()>20) {
				adminServiceImpl.DeleteAdmin(id);
				return "redirect:/home/admin/index";
			}
		}
		return "err";
	}

	//显示文章管理页面
			@RequestMapping("post/index")
			public String postView(Model model,HttpServletRequest request,@RequestParam(value="pageNo",defaultValue="1")Integer pageNo){
				if (request.getSession().getAttribute("loginadmin")!=null) {
				    Integer pageSize = 20;
				    PageHelper.startPage(pageNo, pageSize);
					List<Posts> posts = postServiceImpl.listAll();
					PageInfo<Posts> data = new PageInfo<Posts>(posts);
					//Page<Posts> data = new Page<Posts>();
					data.setList(posts);
					//data
					model.addAttribute("data",data);
					//System.out.println(data.getPageSize()());
					//System.out.println(data.getTotal());
					return "Post/index";
				}else {
					return "err";
				}
			}
			//设置文章合法性
			@RequestMapping("post/setValid/{postId}")
			public String postValid(@PathVariable Integer postId,HttpServletRequest request){
				if (request.getSession().getAttribute("loginadmin")!=null) {
					postServiceImpl.changeValid(postId);
					return "redirect:/home/post/index";
				}else {
					return "err";
				}
			}
			//删除文章
			@RequestMapping("post/delete/{postId}")
			public String postdelete(@PathVariable Integer postId,HttpServletRequest request){
				if (request.getSession().getAttribute("loginadmin")!=null) {
					postServiceImpl.deletePost(postId);
					return "redirect:/home/post/index";
				}else {
					return "err";
				}
			}
			//添加文章页面(权限大于10)
			@RequestMapping("post/add")
			public String addPost(HttpServletRequest request){
				if (request.getSession().getAttribute("loginadmin")!=null) {
					Admin admin = (Admin) request.getSession().getAttribute("loginadmin");
					if (admin.getRole()>10) {
						return "Post/add";
					}
				}
				return "err";

			}
			//添加修改文章时获取分类(ajax)
			@RequestMapping(value="post/getAllCats",method=RequestMethod.POST)
			public @ResponseBody List<Cats> getAllCat(){
				return catsServiceImpl.selectAll();
			}
			//添加文章
			@RequestMapping(value="post/postadd",method=RequestMethod.POST)
			public @ResponseBody String postAdd(String title,String catId,String isValid,@RequestParam("summary[]") List<String> summary,@RequestParam("content[]") List<String> content,String tags,String labelImg,HttpSession session){
				String data;
				String name = (String)session.getAttribute("username");
				try {
					String newContent="";
					for (int i = 0; i < content.size(); i++) {
						newContent+=content.get(i);
					}
					String newSummary="";
					for (int i = 0; i < summary.size(); i++) {
						newSummary+=summary.get(i);
					}
					Posts posts = new Posts();
					posts.setTitle(title);
					posts.setCatId(Integer.parseInt(catId));
					posts.setContent(newContent);
					posts.setSummary(newSummary);
					posts.setCreatedAt(DateUtil.dateToStamp(new Date()));
					posts.setUpdatedAt(DateUtil.dateToStamp(new Date()));
					posts.setIsValid(isValid.equals("1"));
					posts.setUserId(566);
					posts.setUserName(name);
					posts.setLabelImg(labelImg);
					postServiceImpl.addPost(posts);
					//System.out.println(tags);
					String[] tag = tags.split("/");
					for (int i = 0; i < tag.length; i++) {
						int tagId = tagsServiceImpl.selectByTagName(tag[i]);
						//System.out.println(tagId);
						relation_post_tagsServiceImpl.addRelations(postServiceImpl.getPostByTitle(title).getId(), tagId);
					}
					data="success";
				} catch (Exception e) {
					data="err";
					e.printStackTrace();
				}

				return data;
			}
		
			//上传封面图片
			 @ResponseBody
			    @RequestMapping("post/addpic")
			    public String upload(@RequestParam(value = "file", required = false) MultipartFile file, HttpServletRequest request, ModelMap model) {  
			    	SimpleDateFormat dateForma=new SimpleDateFormat("yyyyMMdd");
					Date c= new Date();
			        String path = request.getSession().getServletContext().getRealPath("/WEB-INF/resources/image/"+dateForma.format(c));  
			       // System.out.println(file);
			        StringBuffer ped=new StringBuffer(file.getOriginalFilename());
			        int index=ped.reverse().indexOf(".");
			        String fileName =String.valueOf(c.getTime())+'.'+file.getOriginalFilename().substring(ped.length()-index, ped.length());
			        
			        File targetFile = new File(path, fileName);  
			        if(!targetFile.exists()){  
			            targetFile.mkdirs();  
			        }  
			        //保存  
			        try {  
			            file.transferTo(targetFile);  
			        } catch (Exception e) {  
			            e.printStackTrace();  
			        }   
			  
			        return "/image/"+dateForma.format(c)+'/'+fileName;  
			    } 

}
