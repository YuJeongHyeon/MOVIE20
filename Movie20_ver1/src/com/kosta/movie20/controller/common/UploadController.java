package com.kosta.movie20.controller.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kosta.movie20.model.vo.MovieVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;


public class UploadController implements Controller {
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
	//Workspace 업로드 경로 : 개발시 경로 
		String workspacePath="C:\\java-kosta\\web2-workspace\\model2-fileupload-inst\\WebContent\\upload\\";
	//WAS 업로드 경로 : 개발완료후에는 이 경로로 변경 
//		String savePath = request.getServletContext().getRealPath("upload");		 
	//	System.out.println(savePath);
		// 파일 크기 10MB로 제한
		int sizeLimit = 1024*1024*10;		 
		//                      ↓ request 객체,               ↓ 저장될 서버 경로,   ↓ 파일 최대 크기, ↓ 인코딩 방식,       ↓ 같은 이름의 중복파일명 방지 처리
		// new MultipartRequest(HttpServletRequest request, String saveDirectory, int maxPostSize, String encoding,      FileRenamePolicy policy)
		// 아래와 같이 MultipartRequest를 생성만 해주면 파일이 업로드 된다.(파일 자체의 업로드 완료)	
		MultipartRequest multi = new MultipartRequest(request, workspacePath, sizeLimit, "utf-8", new DefaultFileRenamePolicy());
//		MultipartRequest multi = new MultipartRequest(request, savePath, sizeLimit, "utf-8", new DefaultFileRenamePolicy());
		// MultipartRequest로 전송받은 데이터를 불러온다.
		// enctype을 "multipart/form-data"로 선언하고 submit한 데이터들은 request객체가 아닌 MultipartRequest객체로 불러와야 한다.
		System.out.println(multi.getParameter("command"));//만약 현 웹어플리케이션에서 업로드 서비스가 여러개라고 하면 command 를 이용해 조건처리해야 한다 
		MovieVO mvo=new MovieVO();
	//--	mvo.setName(multi.getParameter("name"));
	//--	mvo.setMaker(multi.getParameter("maker"));
		// 전송받은 데이터가 파일일 경우 getFilesystemName()으로 파일 이름을 받아올 수 있다.
		String fileName = multi.getFilesystemName("picture");
		mvo.setPicture(fileName);
		System.out.println("db insert전 mvo:"+mvo);
	//--	ProductDAO.getInstance().registerProduct(pvo);
		System.out.println("db insert후 pvo:"+mvo);
		request.setAttribute("pvo", mvo);
	//--	return "redirect:DispatcherServlet?command=DetailProduct&pno="+mvo.getPno();
		return "";
	}
}





