package com.douzone.jblog.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.douzone.jblog.vo.PostVo;


@Repository
public class PostRepository {

	@Autowired
	private SqlSession sqlSession;
	
	public int postinsert(PostVo postVo) {
		return sqlSession.insert("post.postinsert", postVo);
		
	}

	public List<PostVo> postFind(String id, Long cartegoryno, Long postno) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("cartegoryno", cartegoryno);
		map.put("postno", postno);
		return sqlSession.selectList("post.postFind", map );
	}

	public Long getpostno(Long cartegoryno) {
		return sqlSession.selectOne("post.getpostno", cartegoryno);
	}

	public PostVo getpostcontent(Long postNo) {
		return sqlSession.selectOne("post.getpostcontent", postNo);
	}
}
