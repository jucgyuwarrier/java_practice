//크기 그대로 이미지 다운로드
/*
  package com.spring.pro28.ex01;
  
  import java.io.File; import java.io.FileInputStream; import
  java.io.OutputStream;
  
  import javax.servlet.http.HttpServletResponse;
  
  import org.springframework.stereotype.Controller; 
  import org.springframework.web.bind.annotation.RequestMapping; 
  import org.springframework.web.bind.annotation.RequestParam;
  
  @Controller public class FileDownloadController { private static String
  CURR_IMAGE_REPO_PATH = "C:\\spring\\image_repo"; //파일 저장 위치를 지정
  
  @RequestMapping("/download") 
  //download로 호출되었을때 실행 다운로드 할 이미지파일 이름을 전달함 
  protected void download(@RequestParam("imageFileName") String imageFileName, HttpServletResponse response) throws Exception { 
  OutputStream out = response.getOutputStream(); 
  String downFile = CURR_IMAGE_REPO_PATH + "\\" + imageFileName; 
  //마지막 경로에 그 파일이름으로 저장하는 경로를 string형태로 downFile이란 변수에 넣음 ex) "C:\\spring\\image_repo\\cat1.jpg"
  
  File file = new File(downFile); //다운로드할 파일 객체를 최후경로를 매개변수로 하여 생성
  response.setHeader("Cache-Control", "no-cache"); //캐시 관련 설정 캐시 안한다는듯
  response.addHeader("Content-disposition", "attachment; fileName=" +
  imageFileName); //헤더에 파일 이름을 설정 FileInputStream in = new
  FileInputStream(file); 
  byte[] buffer = new byte[1024 * 8]; 
  
   //버퍼를 통해 한번에 8kbyte씩 브라우저로 전송함 
  while (true) {
  int count = in.read(buffer); if (count == -1)
  break; 
  out.write(buffer, 0, count); //OutputStream 클래스 안의 메서드 write 
  }
  in.close(); 
  out.close();
  
  } 
  }
  
 */