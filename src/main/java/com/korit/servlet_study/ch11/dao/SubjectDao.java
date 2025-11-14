package com.korit.servlet_study.ch11.dao;

import com.korit.servlet_study.ch11.entity.Subject;
import com.korit.servlet_study.ch11.util.DBConnectionMgr;
import lombok.RequiredArgsConstructor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class SubjectDao {
    private final DBConnectionMgr mgr;

    public int insert(Subject subject) {
        Connection con = null;
        PreparedStatement ps = null;
        int result = 0;

        try {
            con = mgr.getConnection();
            String sql = """
                    INSERT INTO subject_tb
                    (subject_code, subject_name, department_id)
                    VALUES (?, ?, ?)
                    """;
            ps = con.prepareStatement(sql);
            ps.setString(1, subject.getSubjectCode());
            ps.setString(2, subject.getSubjectName());
            ps.setInt(3, subject.getDepartmentId());

            result = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            mgr.freeConnection(con, ps);
        }

        return result;
    }

    public List<Subject> findAll() {
        List<Subject> subjects = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = mgr.getConnection();
            String sql = """
                    SELECT subject_id, subject_code, subject_name, department_id
                    FROM subject_tb
                    ORDER BY subject_id
                    """;
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Subject subject = Subject.builder()
                        .subjectId(rs.getInt("subject_id"))
                        .subjectCode(rs.getString("subject_code"))
                        .subjectName(rs.getString("subject_name"))
                        .departmentId(rs.getInt("department_id"))
                        .build();
                subjects.add(subject);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            mgr.freeConnection(con, ps, rs);
        }

        return subjects;
    }
}
