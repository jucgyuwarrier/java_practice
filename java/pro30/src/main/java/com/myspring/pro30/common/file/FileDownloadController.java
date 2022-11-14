package com.myspring.pro30.common.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.coobird.thumbnailator.Thumbnails;

//썸네일 폴더와 함께 크기 조정한 이미지 + 원본이미지를 같이 받을때

@Controller
public class FileDownloadController {
	private static String CURR_IMAGE_REPO_PATH = "c:\\spring\\image_repo";
	@RequestMapping("/download")
	protected void download(@RequestParam("imageFileName") String imageFileName, HttpServletResponse response) throws Exception {
		OutputStream out = response.getOutputStream();
		String filePath = CURR_IMAGE_REPO_PATH + "\\" + imageFileName;
		File image = new File(filePath);
		int lastIndex = imageFileName.lastIndexOf(".");
		String fileName = imageFileName.substring(0, lastIndex);
		//원본 이미지 파일 이름과 같은 이름의 썸네일 파일에 대한 file 객체를 생성합니다.
		File thumbnail = new File(CURR_IMAGE_REPO_PATH + "\\" + "thumbnail" + "\\" + fileName + ".png");
		if(image.exists()) {
			thumbnail.getParentFile().mkdirs(); 
			Thumbnails.of(image).size(50, 50).outputFormat("png").toFile(thumbnail);
		}//썸네일 이미지파일생성
		
		FileInputStream in = new FileInputStream(thumbnail);
		byte[] buffer = new byte[1024 * 8];
		while (true) {
			int count = in.read(buffer);
			if(count == -1)
				break;
			out.write(buffer, 0, count);
		}
		in.close();
		out.close();
		
		
		/* 썸네일폴더에 이미지 저장안하고 썸네일 이미지 바로 출력하기
		 * 	@RequestMapping("/download")
	protected void download(@RequestParam("imageFileName") String imageFileName, HttpServletResponse response) throws Exception {
		OutputStream out = response.getOutputStream();
		String filePath = CURR_IMAGE_REPO_PATH + "\\"  + imageFileName;
		File image = new File(filePath);
		int lastIndex = imageFileName.lastIndexOf(".");
		String fileName = imageFileName.substring(0,lastIndex);
		File thumbnail = new File(CURR_IMAGE_REPO_PATH + "\\" + "thumbnail" + "\\" + fileName + ".png");
		if(image.exists()) {
			Thumbnails.of(image).size(50,50).outputFormat("png").toOutputStream(out);
		} else {
			return;
		}
		byte[] buffer = new byte[1024 * 8];
		out.write(buffer);
		out.close();
	}
		 * */
	}
}
