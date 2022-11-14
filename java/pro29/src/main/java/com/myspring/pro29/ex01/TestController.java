package com.myspring.pro29.ex01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/test/*")
public class TestController {
static final Logger logger = LoggerFactory.getLogger(TestController.class);
	
	
@RequestMapping("/hello")
public String hello() {
	return "Hello REST!!";
}

@RequestMapping("/member")
public MemberVO member() {
	MemberVO vo = new MemberVO();
	vo.setid("hong");
	vo.setpwd("1234");
	vo.setname("홍킬동");
	vo.setemail("hong@test.com");
	return vo; //제이슨형태로 출력됨
}
	
@RequestMapping("/membersList") //@RequestController를 이용해 list 전달
public List<MemberVO> listMembers() {
		List<MemberVO> list = new ArrayList<MemberVO>();
		for (int i = 0; i < 10; i++) {
		MemberVO vo = new MemberVO();
		vo.setid("hong" + i);
		vo.setpwd("123"+ i);
		vo.setname("홍킬동" + i);
		vo.setemail("hong"+i+"@test.com");
		list.add(vo);
		}
		return list;
	}

	@RequestMapping("/membersMap") //@RequestController를 이용해 Map 전달하기
	public Map<Integer, MemberVO> membersMap() {
		Map<Integer, MemberVO> map = new HashMap<Integer, MemberVO>();
		for(int i=0; i<10; i++) {
			MemberVO vo = new MemberVO();
			vo.setid("hong" + i);
			vo.setpwd("123" + i);
			vo.setname("홍킬동" + i);
			vo.setemail("hong"+i+"@test.com");
			map.put(i, vo);
		}
		return map;
		
		}
	
	@RequestMapping(value="/notice/{num}", method = RequestMethod.GET)
	//브라우저에서 요청시 {num}부분의 값이 @PathVariable로 지정됩니다. get방식으로 임의의 숫자를 넣어서 요청하면 그 숫자를 가져옴
	//즉 PathVariable을 사용하면 브라우저에서 요청URL로 전달된 매개변수를 가져 올 수 있음 트위터나 유튜브의 더보기 기능과 관련
	public int notice(@PathVariable("num") int num) throws Exception {
		return num;
	}
@RequestMapping(value= "/info", method = RequestMethod.POST)
public void modify(@RequestBody MemberVO vo) {
	logger.info(vo.toString());
	
}

//오류코드 자세히 보기
@RequestMapping("/membersList2")
public ResponseEntity<List<MemberVO>> listMembers2() {
	//ResponseEntity로 응답합니다.
	List<MemberVO> list = new ArrayList<MemberVO>();
	for (int i = 0; i < 10; i++) {
		MemberVO vo = new MemberVO();
		vo.setid("lee" + i);
		vo.setpwd("123" + i);
		vo.setname("이순신" + i);
		vo.setemail("lee" + i + "@test.com");
		list.add(vo);
	}
	return new ResponseEntity(list, HttpStatus.INTERNAL_SERVER_ERROR); //오류 코드 500으로 응답함
}

@RequestMapping(value= "/res3")
public ResponseEntity res3() {
	HttpHeaders responseHeaders = new HttpHeaders();
	responseHeaders.add("Content-Type", "text/html; charset=utf-8");
	String message = "<script>";
	message += " alert('새 회원을 등록합니다.');";
	message += " location.href='/pro29/test/membersList2'; ";
	message += " </script>";
	return new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
	//ResponseEntity를 이용해 html형식으로 전송함
}
}

