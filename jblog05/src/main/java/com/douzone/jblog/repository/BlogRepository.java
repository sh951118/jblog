package com.douzone.jblog.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.douzone.jblog.vo.BlogVo;

@Repository
public class BlogRepository {

	@Autowired
	private SqlSession sqlSession;
	
	public int bloginsert(BlogVo blogvo) {
		return sqlSession.insert("blog.bloginsert", blogvo);
	}

	public int updateblog(BlogVo blogVo) {
		return sqlSession.update("blog.updateblog", blogVo);
	}

	public BlogVo findheader(String id) {
		return sqlSession.selectOne("blog.findheader", id);
	}
}
