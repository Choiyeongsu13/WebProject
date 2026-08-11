package com.mnu.exArtist.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mnu.exArtist.model.ArtDAO;
import com.mnu.exArtist.model.artistDTO;

@WebServlet("/artist_list")
public class MemberListServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public MemberListServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArtDAO dao = ArtDAO.getInstance();
        
//        SimpleDateFormat sdf1= new SimpleDateFormat("yyyymmdd");
//        SimpleDateFormat sdf2= new SimpleDateFormat("yyyy년mm월dd일");
//        try {
//        String today="20260811"; //문자열
//        Date date= sdf1.parse(today);
//        String date2=sdf2.format(date);
//        System.out.println(date2);
//        
//        }catch(Exception e) {
//        	e.printStackTrace();
//        }
        List<artistDTO> list = dao.artistList();

    
        request.setAttribute("list", list);

   
        RequestDispatcher rd = request.getRequestDispatcher("/list.jsp");
        rd.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        doGet(request, response);
    }
}