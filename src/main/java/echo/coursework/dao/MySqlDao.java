package echo.coursework.dao;

import echo.coursework.model.entity.Answer;
import echo.coursework.model.entity.Question;
import echo.coursework.model.entity.users.RegUser;
import echo.coursework.model.entity.users.User;

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

    public boolean checkUser(String name, String password) {
        boolean res = false;
        try {
            String query = "SELECT * FROM qaecho.user WHERE name = \"" + name + "\" AND password = \"" + password + "\";";
            System.out.println(query);
            rs = executeSqlQuery(query);
            if (rs.next()) {
                res = true;
            }
        }
        catch (SQLException ex){
            sqlExceptionInfo(ex);
        }
        finally {
            closeRsAndStmt();
        }
        return res;
    }

    public User addUser(String name, String password) {
        try {
            String query = "INSERT INTO qaecho.user (`name`, `password`, `rating`) VALUES (\"" + name + "\", \"" + password + "\", \"0\");";
            System.out.println(query);
            int rowsAffected = stmt.executeUpdate(query);
            if (rowsAffected > 0) {
                return getUser(name);
            }
        }
        catch (SQLException ex){
            sqlExceptionInfo(ex);
        }
        finally {
            closeRsAndStmt();
        }
        return null;
    }

    public User getUser(String name) {
        User user = null;
        try {
            String query = "SELECT * FROM qaecho.user WHERE name = \"" + name + "\";";
            System.out.println(query);
            rs = executeSqlQuery(query);
            if (rs.next()) {
                user = new RegUser(rs.getInt("id"), rs.getString("name"), rs.getString("password"), rs.getInt("rating"));
            }
        }
        catch (SQLException ex){
            sqlExceptionInfo(ex);
        }
        finally {
            closeRsAndStmt();
        }
        return user;
    }

    public List<Question> searchQuestionsByTitle(String text) {
        ArrayList<Question> questions = new ArrayList<Question>(1);
        Question question;
        try {
            String query = "SELECT * FROM qaecho.question WHERE title REGEXP \"" + text + "\"";
            System.out.println(query);
            rs = executeSqlQuery(query);
            while(rs.next()) {
                question = new Question(rs.getInt("id"), rs.getString("title"), rs.getString("text"), rs.getInt("user_id"), rs.getInt("topic_id"));
                questions.add(question);
            }
        } catch(SQLException ex) {
            sqlExceptionInfo(ex);
        } finally {
            closeRsAndStmt();
        }
        return questions;
    }

    public ArrayList<Question> getLastQuestions(int amount) {
        ArrayList<Question> questions = new ArrayList<Question>(amount);
        Question question;
        try {
            String query = "SELECT * FROM qaecho.question ORDER BY id DESC LIMIT " + amount;
            rs = executeSqlQuery(query);
            while (rs.next()) {
                question = new Question(rs.getInt("id"), rs.getString("title"), rs.getString("text"), rs.getInt("user_id"), rs.getInt("topic_id"));
                questions.add(question);
            }
        }
        catch (SQLException ex){
            sqlExceptionInfo(ex);
        }
        finally {
            closeRsAndStmt();
        }
        return questions;
    }

    // todo change or delete
    public ArrayList<Question> getPopularQuestions(int amount) {
        ArrayList<Question> questions = new ArrayList<Question>(amount);
        /*Question question;
        try {
            String query = "SELECT * FROM qaecho.question LIMIT " + amount;
            rs = executeSqlQuery(query);
            while (rs.next()) {
                question = new Question(rs.getInt("id"), rs.getString("title"), rs.getString("text"), rs.getInt("user_id"), rs.getInt("topic_id"));
                questions.add(question);
            }
        }
        catch (SQLException ex){
            sqlExceptionInfo(ex);
        }
        finally {
            closeRsAndStmt();
        }*/
        return questions;
    }

    public ArrayList<Answer> getAnswers(int questionId) {
        ArrayList<Answer> answers = new ArrayList<Answer>(5);
        Answer answer;
        try {
            String query = "SELECT answer_id FROM qaecho.questions_answers_id WHERE question_id = " + questionId;
            System.out.println(query);
            rs = executeSqlQuery(query);
            List<Integer> answersId = new ArrayList<Integer>();
            while (rs.next()) {
                answersId.add(rs.getInt("answer_id"));
            }
            if (answersId.size() != 0) {
                closeRsAndStmt();
                String answersIdStr = "";
                for(Integer answerId : answersId) {
                    answersIdStr += answerId + ", ";
                }
                if (answersIdStr.length() > 1) {
                    answersIdStr = answersIdStr.substring(0, answersIdStr.length() - 2);
                }
                query = "SELECT * FROM qaecho.answer WHERE id IN (" + answersIdStr + ")";
                System.out.println(query);
                rs = executeSqlQuery(query);
                while (rs.next()) {
                    answer = new Answer(rs.getInt("id"), rs.getString("text"), rs.getInt("user_id"));
                    answers.add(answer);
                }
            }
        }
        catch (SQLException ex){
            sqlExceptionInfo(ex);
        }
        finally {
            closeRsAndStmt();
        }
        return answers;
    }

    private ResultSet executeSqlQuery(String query) {
        ResultSet res = null;
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
            res = stmt.getResultSet();
        } catch (SQLException ex) {
            System.out.println("Exception in sql query");
            sqlExceptionInfo(ex);
        }
        return res;
    }

    private void closeRsAndStmt() {
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

    private void sqlExceptionInfo(SQLException ex) {
        System.out.println("SQLException: " + ex.getMessage());
        System.out.println("SQLState: " + ex.getSQLState());
        System.out.println("VendorError: " + ex.getErrorCode());
    }
}
