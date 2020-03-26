package com.douzone.jblog.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.douzone.jblog.vo.CartegoryVo;

@Repository
public class CartegoryRepository {
	
	@Autowired
	private SqlSession sqlSession;

	public int cartegoryinsert(CartegoryVo cartegoryvo) {
		return sqlSession.insert("cartegory.cartegoryinsert", cartegoryvo);
	}

	public List<CartegoryVo> cartegoryList(String id) {
		List<CartegoryVo> list = sqlSession.selectList("cartegory.cartegoryList", id);
		return list;
	}

	public int cartegoryaddinsert(CartegoryVo cartegoryVo) {
		return sqlSession.insert("cartegory.cartegoryaddinsert", cartegoryVo);
	}

	public int deleteCartegory(Long no) {
		return sqlSession.delete("cartegory.deleteCartegory", no);
	}

	public List<CartegoryVo> cartegoryFind(String id) {
		return sqlSession.selectList("cartegory.cartegoryFind", id);
	}

	public Long getcartegoryno(String id) {
		return sqlSession.selectOne("cartegory.getcartegoryno", id);
	}

	public Long cartegoryNo(String id) {
		return sqlSession.selectOne("cartegory.cartegoryNo", id);
	}

}
