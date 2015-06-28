package dahampasala;

import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Thilanka Bowala <Thilanka Bowala at GIGABYTE>
 */
public class DBOperations {

    String url = "jdbc:mysql://localhost:3306/daham_pasala";
    String username = "root";
    String password = "";
    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs;

    boolean addStudent(Student student) {
        try {
            java.util.Date utilDateDOB = student.getDateOfBirth();
            java.sql.Date sqlDateDOB = new java.sql.Date(utilDateDOB.getTime());
            java.util.Date utilDateReg = student.getRegisteredDate();
            java.sql.Date sqlDateReg = new java.sql.Date(utilDateReg.getTime());

            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "INSERT INTO StudentDetails VALUES (?,?,?,?,?,?,?,?)";

            pst = (PreparedStatement) con.prepareStatement(query);

            pst.setInt(1, student.getRegID());
            pst.setString(2, student.getFirstName());
            pst.setString(3, student.getLastName());
            pst.setDate(4, sqlDateDOB);
            pst.setString(5, student.getAddress());
            pst.setString(6, student.getGender());
            pst.setString(7, student.getAdmissionClass());
            pst.setDate(8, sqlDateReg);

            pst.executeUpdate();

            return true;

        } catch (Exception ex) {
            Logger.getLogger(DBOperations.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (Exception ex) {
                Logger.getLogger(DBOperations.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    ArrayList<Student> getStudent() {
        try {
            ArrayList<Student> list = new ArrayList<Student>();

            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "SELECT * FROM StudentDetails";

            pst = (PreparedStatement) con.prepareStatement(query);

            rs = pst.executeQuery();

            while (rs.next()) {
                Student s = new Student();
                s.setRegID(rs.getInt(1));
                s.setFirstName(rs.getString(2));
                s.setLastName(rs.getString(3));
                s.setDateOfBirth(rs.getDate(4));
                s.setAddress(rs.getString(5));
                s.setGender(rs.getString(6));
                s.setAdmissionClass(rs.getString(7));
                s.setRegisteredDate(rs.getDate(8));
                list.add(s);
            }

            return list;

        } catch (Exception ex) {
            Logger.getLogger(DBOperations.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (Exception ex) {
                Logger.getLogger(DBOperations.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public boolean updateStudent(Student student) {
        try {
            java.util.Date utilDateDOB = student.getDateOfBirth();
            java.sql.Date sqlDateDOB = new java.sql.Date(utilDateDOB.getTime());
            java.util.Date utilDateReg = student.getRegisteredDate();
            java.sql.Date sqlDateReg = new java.sql.Date(utilDateReg.getTime());

            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "UPDATE StudentDetails SET firstName='" + student.getFirstName() + "', lastName='" + student.getLastName() + "', dob='" + sqlDateDOB + "', address='" + student.getAddress() + "', gender='" + student.getGender() + "', admissionClass='" + student.getAdmissionClass() + "', registeredDate='" + sqlDateReg + "' WHERE regId=" + student.getRegID();

            pst = (PreparedStatement) con.prepareStatement(query);
            pst.executeUpdate();

            return true;
        } catch (Exception ex) {
            Logger.getLogger(DBOperations.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (Exception ex) {
                Logger.getLogger(DBOperations.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public boolean deleteStudent(Student student) {
        try {
            java.util.Date utilDateDOB = student.getDateOfBirth();
            java.sql.Date sqlDateDOB = new java.sql.Date(utilDateDOB.getTime());
            java.util.Date utilDateReg = student.getRegisteredDate();
            java.sql.Date sqlDateReg = new java.sql.Date(utilDateReg.getTime());

            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "DELETE FROM StudentDetails WHERE regId=" + student.getRegID();

            pst = (PreparedStatement) con.prepareStatement(query);
            pst.execute();

            return true;
        } catch (Exception ex) {
            Logger.getLogger(DBOperations.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (Exception ex) {
                Logger.getLogger(DBOperations.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    int checkLogin(String user, String pswd) {
        try {
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "SELECT username, password FROM employeedetails";
            pst = (PreparedStatement) con.prepareStatement(query);
            rs = pst.executeQuery();

            while (rs.next()) {
                if (user.equals(rs.getString(1)) && pswd.equals(rs.getString(2))) {
                    return 1;
                }
            }
            return 0;
        } catch (Exception e) {
            return 2;
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (Exception ex) {
                Logger.getLogger(DBOperations.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
