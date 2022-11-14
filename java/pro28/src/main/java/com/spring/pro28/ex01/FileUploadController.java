
package com.spring.pro28.ex01;

import java.io.File;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FileUploadController {
	public static final String CURR_IMAGE_REPO_PATH = "c:\\spring\\image_repo";
	@RequestMapping(value = "/form")
	public String form() {//업로드창인 uploadForm.jsp를 반환함
		return "uploadForm";
	}
	
	@RequestMapping(value="/upload", method = RequestMethod.POST)
	public ModelAndView upload(MultipartHttpServletRequest multipartRequest, HttpServletResponse response)
	throws Exception{//upload가 호출되면 파일name을 가져와서 enu에 넣고 string형의 name과 value로 각각 배열형식으로 만들어서 해쉬맵에 키 값으로 넣음 
		multipartRequest.setCharacterEncoding("utf-8");
		Map map = new HashMap(); //매개변수 정보와 파일 정보를 저장할 Map을 생성
		Enumeration enu = multipartRequest.getParameterNames();
		while(enu.hasMoreElements()) {
			String name = (String)enu.nextElement();
			String value = multipartRequest.getParameter(name); //ex 키ljg 값 이정규
			map.put(name, value);
		}
		
		List fileList = fileProcess(multipartRequest);
		map.put("fileList", fileList);
		//업로드하고 반환된 파일이름이 저장된 fileList를 다시 map에 저장
		ModelAndView mav = new ModelAndView();
		mav.addObject("map", map);
		mav.setViewName("result");
		//map을 "result"결과창으로 포워딩함
		return mav;
	}
	
	private List<String> fileProcess(MultipartHttpServletRequest multipartRequest) throws Exception{
		List<String> fileList = new ArrayList<String>();
		Iterator<String> fileNames = multipartRequest.getFileNames();
		while(fileNames.hasNext()) {
			String fileName = fileNames.next();
			MultipartFile mFile = multipartRequest.getFile(fileName); //스프링에서 지원해주는 파일 업로드 관련 클래스
		String originalFileName = mFile.getOriginalFilename();
		fileList.add(originalFileName);
		File file = new File(CURR_IMAGE_REPO_PATH + "\\" + fileName);
		if(mFile.getSize() !=0 ) { //첨부된 파일이 있는지 체크
			if(! file.exists()) { //경로에 파일이 없으면 그 경로에 해당하는 디렉터리를 만든후 파일 생성
				if(file.getParentFile().mkdirs()) { 
					file.createNewFile();
				}
			}
			mFile.transferTo(new File(CURR_IMAGE_REPO_PATH + "\\" + originalFileName));
			//임시로 저장된 multipartFile을 실제 파일로 전송
		 }
		}
		return fileList; 
		//첨부한 파일 이름이 저장된 fileList를 반환함
	}
}
