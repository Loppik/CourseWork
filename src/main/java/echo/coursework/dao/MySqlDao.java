package echo.coursework.dao;

import echo.coursework.model.entity.Answer;
import echo.coursework.model.entity.Question;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySqlDao extends Dao {
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;

    public MySqlDao() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/qaecho",
                    "root", "1234");
        } catch(SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Question> getLastQuestions(int amount) {
        ArrayList<Question> questions = new ArrayList<Question>(amount);
        Question question;
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM qaecho.question LIMIT " + amount);
            rs = stmt.getResultSet();
            while (rs.next()) {
                question = new Question(rs.getInt("id"), rs.getString("title"), rs.getString("text"), rs.getInt("user_id"));
                questions.add(question);
            }
        }
        catch (SQLException ex){
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException sqlEx) { } // ignore
                rs = null;
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException sqlEx) { } // ignore

                stmt = null;
            }
        }
        return questions;
    }

    public ArrayList<Question> getPopularQuestions(int amount) {
        ArrayList<Question> questions = new ArrayList<Question>(amount);
        Question question;
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM qaecho.question LIMIT " + amount);
            rs = stmt.getResultSet();
            while (rs.next()) {
                question = new Question(rs.getInt("id"), rs.getString("title"), rs.getString("text"), rs.getInt("user_id"));
                questions.add(question);
            }
        }
        catch (SQLException ex){
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException sqlEx) { } // ignore
                rs = null;
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException sqlEx) { } // ignore

                stmt = null;
            }
        }
        return questions;
    }

    public ArrayList<Answer> getAnswers(int questionId) {
        ArrayList<Answer> answers = new ArrayList<Answer>(5);
        Answer answer;
        try {
            stmt = conn.createStatement();
            String request = "SELECT answer_id FROM qaecho.questions_answers_id WHERE question_id = " + questionId;
            System.out.println(request);
            rs = stmt.executeQuery(request);
            rs = stmt.getResultSet();
            List<Integer> answersId = new ArrayList<Integer>();
            while (rs.next()) {
                answersId.add(rs.getInt("answer_id"));
            }
            rs.close();
            stmt.close();
            stmt = conn.createStatement();
            String answersIdStr = "";
            for(Integer answerId : answersId) {
                answersIdStr += answerId + ", ";
            }
            if (answersIdStr.length() > 1) {
                answersIdStr = answersIdStr.substring(0, answersIdStr.length() - 2);
            }
            request = "SELECT * FROM qaecho.answer WHERE id IN (" + answersIdStr + ")";
            System.out.println(request);
            rs = stmt.executeQuery(request);
            rs = stmt.getResultSet();
            while (rs.next()) {
                answer = new Answer(rs.getInt("id"), rs.getString("text"), rs.getInt("user_id"));
                answers.add(answer);
            }
        }
        catch (SQLException ex){
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException sqlEx) { } // ignore
                rs = null;
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException sqlEx) { } // ignore

                stmt = null;
            }
        }
        return answers;
    }
}
