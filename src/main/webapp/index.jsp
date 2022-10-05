<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	// [ 표지페이지의 존재이유 ]
	// main.jsp를 보고싶다!
	// 목록데이터 등을 필요로하기때문에, M(DB)를 가져오기위한 C를 거칠수밖에없다!!!
	// 표지페이지 index.jsp는 C로 이동하여 목록데이터 등을 가져올수있도록 요청하는 역할!!!!!
	
	// ★ 실행 전 확인★
	// .sql 파일을 통해 테이블들을 생성 해줘야 크롤링 한 데이터들이 생성된다!
	
	// 테이블이 존재하지 않은 채로 실행시
	// 1) 메인 페이지에 음식 데이터들이 x
	// 2) 공지사항 페이지 에러 발생
	response.sendRedirect("main.do");

%>