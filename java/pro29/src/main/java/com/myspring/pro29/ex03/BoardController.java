package com.myspring.pro29.ex03;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/boards")
public class BoardController {
	static Logger logger = LoggerFactory.getLogger(BoardController.class);

@RequestMapping(value = "/all", method = RequestMethod.GET)
//Get방식으로 요청하므로 모든 글의 정보를 조회함
public ResponseEntity<List<ArticleVO>> listArticles() {
	logger.info("listArticles 메서드 호출");
	List<ArticleVO> list = new ArrayList<ArticleVO>();
	for (int i = 0; i < 10; i++) {
		ArticleVO vo = new ArticleVO();
		vo.setArticleNO(i);
		vo.setWriter("이순신" + i);
		vo.setTitle("안녕하세요" + i);
		vo.setContent("새 상품을 소개합니다."+i);
		list.add(vo);
	}
	return new ResponseEntity(list, HttpStatus.OK);
}
@RequestMapping(value="/{articleNO}", method = RequestMethod.GET)
//GET방식으로 요청하면서 글 번호를 전달함으로 글번호에 대한 글 정보를 조회함.
public ResponseEntity<ArticleVO> findArticle (@PathVariable("articleNO") Integer articleNO) {
	logger.info("findArticle 메서드 호출");
	ArticleVO vo = new ArticleVO();
	vo.setArticleNO(articleNO);
	vo.setWriter("홍킬동");
	vo.setTitle("안녕하세요");
	vo.setContent("홍킬동의 글입니다.");
	return new ResponseEntity(vo, HttpStatus.OK);
}

@RequestMapping(value = "", method = RequestMethod.POST)
//POST방식으로 요청하므로 요청시 JSON으로 전달되는 객체를 새 글로 추가함
public ResponseEntity<String> addArticle (@RequestBody ArticleVO articleVO) {
	ResponseEntity<String> resEntity = null;
	try {
		logger.info("addArticle 메서드 호출");
		logger.info(articleVO. toString());
		resEntity = new ResponseEntity("ADD_SUCCEEDED", HttpStatus.OK);
		} catch(Exception e) {
			resEntity = new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return resEntity;
	}
	
	@RequestMapping(value = "/{articleNO}", method = RequestMethod.PUT)
	//PUT방식으로 요청하므로 articleNO에 대한 글을 전달되는 JSON 정보로 수정합니다.
	public ResponseEntity<String> modArticle(@PathVariable("articleNO") Integer articleNO, @RequestBody ArticleVO articleVO) {
		//전송된 JSON 회원 정보를 바로 ArticleVO 객체의 속성에 설정함
		ResponseEntity<String> resEntity = null;
		try {
			logger.info("modArticle 메서드 호출");
			logger.info(articleVO.toString());
			resEntity = new ResponseEntity("MOD_SUCCEEDED", HttpStatus.OK);
		} catch(Exception e) {
			resEntity = new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return resEntity;
	}
	@RequestMapping(value = "/{articleNO}", method = RequestMethod.DELETE)
	//DELETE 방식으로 요청함으로 전달되는 articleNO에 대한 글을 삭제함
	public ResponseEntity<String> removeArticle (@PathVariable("articleNO") Integer articleNO) {
		ResponseEntity<String> resEntity = null;
		try {
			logger.info("removeArticle 메서드 호출");
			logger.info(articleNO.toString());
			resEntity= new ResponseEntity("REMOVE_SUCCEEDED", HttpStatus.OK);
		} catch(Exception e) {
			resEntity = new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
		return resEntity;
	}
}
