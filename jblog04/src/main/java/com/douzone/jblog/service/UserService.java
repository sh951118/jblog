package com.douzone.jblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.douzone.jblog.repository.BlogRepository;
import com.douzone.jblog.repository.CartegoryRepository;
import com.douzone.jblog.repository.UserRepository;
import com.douzone.jblog.vo.BlogVo;
import com.douzone.jblog.vo.CartegoryVo;
import com.douzone.jblog.vo.UserVo;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private BlogRepository blogRepository;
	@Autowired
	private CartegoryRepository categoryRepository;
	
	public UserVo getUser(UserVo vo) {
		return userRepository.findUser(vo);
	}

	public boolean join(UserVo vo) {
		int user = userRepository.insert(vo);
		return user == 1;
	}

	public boolean blogjoin(BlogVo blogvo) {
		int user = blogRepository.bloginsert(blogvo);
		return user == 1;
		
	}

	public boolean cartegoryjoin(CartegoryVo cartegoryvo) {
		int user = categoryRepository.cartegoryinsert(cartegoryvo);
		return user == 1;
	}

}
