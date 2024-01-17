package org.zerok.jdbcex.controller;

import com.sun.jna.platform.win32.WinBase;
import com.sun.org.apache.bcel.internal.generic.IOR;
import lombok.extern.java.Log;
import org.zerok.jdbcex.dto.MemberDTO;
import org.zerok.jdbcex.service.MemberService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
@Log
public class LoginController extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("login get...");
        req.getRequestDispatcher("/WEB-INF/todo/login.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException {
        log.info("login post...");

        String mid = req.getParameter("mid");
        String mpw = req.getParameter("mpw");

        try{
            MemberDTO memberDTO = MemberService.INSTANCE.login(mid,mpw);
            HttpSession session = req.getSession();
            session.setAttribute("loginInfo", memberDTO);
            resp.sendRedirect("/todo/list");
        }catch (Exception e){
            resp.sendRedirect("/login?result=error");
        }



    }
}
