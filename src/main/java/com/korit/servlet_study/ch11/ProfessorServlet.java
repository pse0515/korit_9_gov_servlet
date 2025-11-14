package com.korit.servlet_study.ch11;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.korit.servlet_study.ch11.dao.DepartmentDao;
import com.korit.servlet_study.ch11.dao.ProfessorDao;
import com.korit.servlet_study.ch11.entity.Department;
import com.korit.servlet_study.ch11.entity.Professor;
import com.korit.servlet_study.ch11.service.DepartmentService;
import com.korit.servlet_study.ch11.service.ProfessorService;
import com.korit.servlet_study.ch11.util.DBConnectionMgr;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/professors")
public class ProfessorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String q = req.getParameter("q");
        ProfessorService  professorService = new ProfessorService();
        List<Professor> professors = professorService.getProfessors(q);

    }
}






