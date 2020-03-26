package com.douzone.jblog.service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.douzone.jblog.repository.BlogRepository;
import com.douzone.jblog.repository.CartegoryRepository;
import com.douzone.jblog.repository.PostRepository;
import com.douzone.jblog.vo.BlogVo;
import com.douzone.jblog.vo.CartegoryVo;
import com.douzone.jblog.vo.PostVo;

@Service
public class BlogService {

	@Autowired
	private BlogRepository BlogRepository;
	
	@Autowired
	private CartegoryRepository cartegoryRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	private static final String SAVE_PATH = "/jblog-logo";
	private static final String URL = "/assets/blog/images/";
	
	public String restore(MultipartFile multipartFile) {
		String profile = "";
		try {
			if (multipartFile.isEmpty()) {
				return profile;
			}
			String originFilename = multipartFile.getOriginalFilename();
			
			String extName = originFilename.substring(originFilename.lastIndexOf('.') + 1);
			
			String saveFilename = generatrSaveFilename(extName);
			long fileSize = multipartFile.getSize();
			byte[] fileData = multipartFile.getBytes();
			OutputStream os = new FileOutputStream(SAVE_PATH + "/" + saveFilename);
			os.write(fileData);
			os.close();
			
			profile = URL + "/" + saveFilename;
			
		} catch (IOException ex) {
			throw new RuntimeException("file upload error:" + ex);
		}
		return profile;
	}
	
	private String generatrSaveFilename(String extName) {
		String filename = "";
		
		Calendar calendar = Calendar.getInstance();
		filename += calendar.get(Calendar.YEAR);
		filename += calendar.get(Calendar.MONTH);
		filename += calendar.get(Calendar.DATE);
		filename += calendar.get(Calendar.HOUR);
		filename += calendar.get(Calendar.MINUTE);
		filename += calendar.get(Calendar.SECOND);
		filename += calendar.get(Calendar.MILLISECOND);
		filename += ("." + extName);
		
		return filename;
	}

	public boolean updateblog(BlogVo blogVo) {
		int count = BlogRepository.updateblog( blogVo );
		return count == 1;
	}

	public BlogVo getList(String id) {
		return BlogRepository.findheader(id);
	}

	public List<CartegoryVo> cartegoryList(String id) {
		List<CartegoryVo> list = cartegoryRepository.cartegoryList(id);
		return list;
	}

	public boolean cartegoryaddinsert(CartegoryVo cartegoryVo) {
		int user = cartegoryRepository.cartegoryaddinsert(cartegoryVo);
		return user == 1;
	}

	public boolean deleteCartegory(Long no) {
		int count = cartegoryRepository.deleteCartegory(no);
		return count == 1;
	}

	public boolean postinsert(PostVo postVo) {
		int count =  postRepository.postinsert(postVo);
		return count == 1;
	}

	public Map<String, Object> getAll(String id, Long cartegoryno, Long postNo) {
		
		BlogVo blog = BlogRepository.findheader(id);
		List<CartegoryVo> cartegorylist = cartegoryRepository.cartegoryFind(id);
		List<PostVo> postlist = postRepository.postFind(id, cartegoryno, postNo);
		Long cartegoryNo = cartegoryRepository.cartegoryNo(id);
		PostVo getpost = postRepository.getpostcontent(postNo);
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("bloglist", blog);
		map.put("cartegorylist", cartegorylist);
		map.put("postlist", postlist);
		map.put("cartegoryNo", cartegoryNo);
		map.put("getpost", getpost);
		
		return map;
	}

	public Long getcartegoryno(String id) {
		return cartegoryRepository.getcartegoryno(id);
		
	}

	public Long getpostno(Long cartegoryno) {
		Long postNo = postRepository.getpostno(cartegoryno);
		return postNo;
	}
}
