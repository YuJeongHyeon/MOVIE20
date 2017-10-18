package com.kosta.movie20.controller.movie;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kosta.movie20.controller.common.Controller;
import com.kosta.movie20.model.dao.MasterDAO;
import com.kosta.movie20.model.vo.MovieVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class UploadController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
	//Workspace 업로드 경로 : 개발시 경로 
		String workspacePath="C:\\java-kosta\\MOVIE20\\Movie20_ver2\\WebContent\\img";
	//WAS 업로드 경로 : 개발완료후에는 이 경로로 변경 
	//	String savePath = request.getServletContext().getRealPath("upload");		 
	//	System.out.println(savePath);
		// 파일 크기 10MB로 제한
		int sizeLimit = 1024*1024*10;		 
		MultipartRequest multi = new MultipartRequest(request, workspacePath, sizeLimit, "utf-8", new DefaultFileRenamePolicy());
		System.out.println(multi.getParameter("command"));
		// 전송받은 데이터가 파일일 경우 getFilesystemName()으로 파일 이름을 받아올 수 있다.
		String title = multi.getParameter("title");
		String playdate = multi.getParameter("playdate");
		String character = multi.getParameter("character");
		String director = multi.getParameter("director");
		String genre = multi.getParameter("genre");
		String summary = multi.getParameter("summary");
		String runtime = multi.getParameter("runtime");
		String viewingcheck = multi.getParameter("viewingcheck");
		int grade = Integer.parseInt(multi.getParameter("grade"));
		String picture = multi.getFilesystemName("picture");
		String id = multi.getParameter("id");
		
		MovieVO movievo=new MovieVO();
		movievo.setTitle(title);
		movievo.setPlaydate(playdate);
		movievo.setCharacter(character);
		movievo.setDirector(director);
		movievo.setGenre(genre);
		movievo.setSummary(summary);
		movievo.setRuntime(runtime);
		movievo.setViewingcheck(viewingcheck);
		movievo.setGrade(grade);
		movievo.setPicture(picture);
		movievo.setMasterId(id);
		
		MasterDAO.getInstance().movieRegister(movievo);
		request.setAttribute("movieRegvo", movievo);
		return "/movie/fileupload.jsp";
	}
}
