package com.blog.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.dao.CatsMapper;
import com.blog.dao.Post_extendsMapper;
import com.blog.dao.PostsMapper;
import com.blog.dao.Relation_post_tagsMapper;
import com.blog.pojo.Feeds;
import com.blog.pojo.Post_extends;
import com.blog.pojo.Posts;
import com.blog.pojo.Relation_post_tags;
import com.blog.service.PostService;
import com.blog.utils.DateUtil;
import com.github.pagehelper.PageHelper;

@Service
public class PostServiceImpl implements PostService{

	@Autowired
	private PostsMapper postsMapper;

	@Autowired
	private Post_extendsMapper post_extendsMapper;

	@Autowired
	private CatsMapper CatsMapper;

	@Autowired
	private Relation_post_tagsMapper Relation_post_tagsMapper;

	@Override
	public Posts getPostById(int id) {
		return postsMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Posts> listAll() {
		return postsMapper.selectAll();
	}

	@Override
	public List<Posts> listFirstAll() {
		List<Posts> plist = postsMapper.selectAllInfo();
		for(int i = 0;i<plist.size();i++){
			plist.get(i).setUpdatedAt(DateUtil.stampToDate(plist.get(i).getUpdatedAt()));
			plist.get(i).getCats().setCatName(CatsMapper.selectByPrimaryKey(plist.get(i).getCatId()).getCatName());
			plist.get(i).getPost_extends().setBrowser(post_extendsMapper.selectByPostId(plist.get(i).getId()).getBrowser());
			plist.get(i).getPost_extends().setCollect(post_extendsMapper.selectByPostId(plist.get(i).getId()).getCollect());
			plist.get(i).getPost_extends().setPraise(post_extendsMapper.selectByPostId(plist.get(i).getId()).getPraise());
			plist.get(i).getPost_extends().setComment(post_extendsMapper.selectByPostId(plist.get(i).getId()).getComment());
		}
		return plist;
	}

	@Override
	public List<Posts> getPostByTagId(int id) {
		List<Relation_post_tags> postId = Relation_post_tagsMapper.selectPostIdByTagId(id);
		List<Posts> posts = new ArrayList<Posts>();
		try {
		/*	for(int i=0;i<postId.size();i++){
				System.out.println(postId.get(i));
				int postidItem = postId.get(i).getPostId();
				Posts post = postsMapper.selectInfoByPostId(postidItem);
				posts.add(post);
//				post_extendsMapper.updateBrowserByPostId(id);
//				post_extendsMapper.updateCollectByPostId(id);
//				post_extendsMapper.updateCommentByPostId(id);
//				post_extendsMapper.updatePraiseByPostId(id);
			}*/
			for(Relation_post_tags postIdItem:postId){
				//System.out.println(postsMapper.selectByPrimaryKey(postIdItem.getPostId()));
				posts.add(postsMapper.selectByPrimaryKey(postIdItem.getPostId()));
			}
			for(int i=0;i<posts.size();i++){
				posts.get(i).setUpdatedAt(DateUtil.stampToDate(posts.get(i).getUpdatedAt()));
				posts.get(i).getCats().setCatName(CatsMapper.selectByPrimaryKey(posts.get(i).getCatId()).getCatName());
				posts.get(i).getPost_extends().setBrowser(post_extendsMapper.selectByPostId(posts.get(i).getId()).getBrowser());
				posts.get(i).getPost_extends().setCollect(post_extendsMapper.selectByPostId(posts.get(i).getId()).getCollect());
				posts.get(i).getPost_extends().setPraise(post_extendsMapper.selectByPostId(posts.get(i).getId()).getPraise());
				posts.get(i).getPost_extends().setComment(post_extendsMapper.selectByPostId(posts.get(i).getId()).getComment());
			}
			return posts;
		} catch (Exception e) {

			return posts;
		}
	}

	@Override
	public List<Posts> listValidPosts() {
		List<Posts> plist = postsMapper.selectValid();
		for(int i = 0;i<plist.size();i++){
			plist.get(i).setUpdatedAt(DateUtil.stampToDate(plist.get(i).getUpdatedAt()));
			plist.get(i).getCats().setCatName(CatsMapper.selectByPrimaryKey(plist.get(i).getCatId()).getCatName());
			plist.get(i).getPost_extends().setBrowser(post_extendsMapper.selectByPostId(plist.get(i).getId()).getBrowser());
			plist.get(i).getPost_extends().setCollect(post_extendsMapper.selectByPostId(plist.get(i).getId()).getCollect());
			plist.get(i).getPost_extends().setPraise(post_extendsMapper.selectByPostId(plist.get(i).getId()).getPraise());
			plist.get(i).getPost_extends().setComment(post_extendsMapper.selectByPostId(plist.get(i).getId()).getComment());
		}
		return plist;
	}

	@Override
	public List<Posts> listNewPosts() {
		return postsMapper.selectNewPosts();
	}

	@Override
	public List<Posts> listTopPosts() {
		return postsMapper.selectTopBrowserPost();
	}

	@Override
	public int changeValid(int id) {
		Posts posts = getPostById(id);
		//System.out.println(posts);
		if(posts.getIsValid()){
			posts.setIsValid(false);
		}else{
			posts.setIsValid(true);
		}
		return postsMapper.updateByPrimaryKeySelective(posts);
	}

	@Override
	public void addPost(Posts posts) {
		postsMapper.insertSelective(posts);
		Post_extends post_extends = new Post_extends();
		posts = postsMapper.selectByTitle(posts.getTitle());
		post_extends.setPostId(posts.getId());
		post_extendsMapper.insertSelective(post_extends);
	}
	public Posts getPostByTitle(String title){
		return postsMapper.selectByTitle(title);
	}

	@Override
	public boolean deletePost(int id) {
		postsMapper.deleteByPrimaryKey(id);
		post_extendsMapper.deleteByPostId(id);
		Relation_post_tagsMapper.deleteByPostId(id);
		return true;
	}

	@Override
	public List<Posts> queryByPage(Integer pageNo, Integer pageSize) {
		pageNo = pageNo == null?1:pageNo;
	    pageSize = pageSize == null?10:pageSize;
	    PageHelper.startPage(pageNo, pageSize);
	    List<Posts> list = listValidPosts();
	    return list;
	}


}
