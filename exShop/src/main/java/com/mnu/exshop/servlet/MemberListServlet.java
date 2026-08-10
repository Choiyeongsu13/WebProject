package com.mnu.exshop.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mnu.exshop.model.MemberDTO;
import com.mnu.exshop.model.ShopDAO;

@WebServlet("/member_list")
public class MemberListServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public MemberListServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ShopDAO dao = ShopDAO.getInstance();
        
        // 1. DB에서 회원 목록 조회
        List<MemberDTO> list = dao.memberList();
        
        // 2. request 영역에 회원 목록 저장
        request.setAttribute("list", list);
        
        // 3. JSP 페이지로 포워딩 (회원목록 JSP 파일명이 list.jsp 일 경우)
        RequestDispatcher rd = request.getRequestDispatcher("/member_list.jsp");
        rd.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 인코딩 설정을 doGet 호출보다 먼저 수행
        request.setCharacterEncoding("UTF-8");
        doGet(request, response);
    }
}