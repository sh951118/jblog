package com.douzone.jblog.controller.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.douzone.jblog.dto.JsonResult;
import com.douzone.jblog.service.BlogService;
import com.douzone.jblog.vo.CartegoryVo;
import com.douzone.security.Auth;

@Auth
@RestController("CartegoryController")
@RequestMapping("/{id:(?!assets).*}/cartegory")
public class BlogController {

	@Autowired
	private BlogService blogService;
	
//	카테고리 ------------------------------------------------------------
	
	@GetMapping("/list")
	public JsonResult blogcategory(@PathVariable("id")Optional<String> id) {
		List<CartegoryVo> list = blogService.cartegoryList(id.get());
		return JsonResult.success(list);
	}
	@PostMapping("/add")
	public JsonResult blogcategory(@PathVariable("id")String id, 
								   @RequestBody CartegoryVo vo) {
		
		vo.setId(id);
		blogService.cartegoryaddinsert(vo);
		
		return JsonResult.success(vo);
	}
	@RequestMapping("/delete/{no}")
	public JsonResult delete(@PathVariable("id")String id,
						 	 @PathVariable("no")Long no){
		boolean result = blogService.deleteCartegory(no);
		
		return JsonResult.success(result ? no : -1);
	}
//	카테고리 ------------------------------------------------------------
	
}
