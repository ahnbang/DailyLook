package com.ahnbang.common;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component   // controller, service, repository
public class FileManagerService {
	public final static String FILE_UPLOAD_PATH = "C:\\STS\\dailylookpic/";
	
	// input: MultipartFile, userLoginId 
	// output: String path
	public String saveFile(String loginid, MultipartFile file) {
		// 파일명이 겹치지 않게 하기 위해 userLoginId, 현재시간을 경로에 붙여준다.
		// 파일 디렉토리 경로  예: marobiana_164567873651/sun.png
		String directoryName = loginid + "_" + System.currentTimeMillis() + "/"; // marobiana_164567873651/
		// D:\\shinboram\\spring_project\\sns\\workspace\\images/marobiana_164567873651/
		String filePath = FILE_UPLOAD_PATH + directoryName;
		
		// 디렉토리 만들기
		File directory = new File(filePath);
		if (directory.mkdir() == false) {
			return null;
		}
		
		// 파일 업로드: byte 단위로 업로드 한다.
		try {
			byte[] bytes = file.getBytes();
			Path path = Paths.get(filePath + file.getOriginalFilename()); // TODO 파일명을 영어로 만들게
			Files.write(path, bytes); // 파일 업로드
			
			// 이미지 업로드 성공시 Path를 리턴한다.(WebMvcConfig에서 매핑한 이미지 path)
			// 예) http://localhost/images/marobiana_164567873651/sun.png
			return "/images/" + directoryName + file.getOriginalFilename(); // TODO 파일명은 Path랑 일치하게
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public void deleteFile(String imagePath) throws IOException {
		//  imagePath: /images/marobiana_1658476222233/20220629_140829.jpg
		// D:\\shinboram\\spring_project\\sns\\workspace\\images/ /images/marobiana_1658476222233/20220629_140829.jpg
		// 전체 경로와 imagePath간의 중복되는 /images/ 문자열을 제거한 후 실제 저장 경로를 찾는다.
		imagePath = imagePath.replace("/images/", ""); //   marobiana_1658476222233/20220629_140829.jpg
		Path path = Paths.get(FILE_UPLOAD_PATH + imagePath);
		if (Files.exists(path)) { // 이미지 파일이 있으면 삭제
			Files.delete(path);
		}
		
		// 디렉토리(폴더) 삭제
		path = path.getParent();
		if (Files.exists(path)) { // 폴더가 있으면 삭제
			Files.delete(path);
		}
	}
}
