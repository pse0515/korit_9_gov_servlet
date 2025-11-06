package com.korit.servlet_study.ch08;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/ch08/boards")
public class BoardServlet extends HttpServlet {

    private static List<Board> boards = new ArrayList<>();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json; charset=UTF-8");
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");




        BufferedReader br = req.getReader();
        String json = "";

        while (true) {
            String str = br.readLine();
            if (str == null) {
                break;
            } json += str;
        }
        ObjectMapper mapper = new ObjectMapper();
        Board board = mapper.readValue(json, Board.class);

        boards.add(board);


        System.out.println(json);

        Response response = new Response();
        resp.getWriter().println("아무텍스트");

        mapper.writeValue(resp.getWriter(), response);

    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        ObjectMapper om = new ObjectMapper();
        om.writeValue(resp.getWriter(), boards);






    }

}

