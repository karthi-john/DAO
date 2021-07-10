import java.sql.*;


public class DAO_retrive{
    public static void main(String[] args) {
        StudentDAO dao=new StudentDAO();
        Student s1=dao.getname(3);
        System.out.println(s1.getname());
    }
}
class StudentDAO{


    public Student getname(int no){
        Student s=new Student();
        s.setrollno(no);
        String url="jdbc:mysql://localhost:3306/karthi";
        String user="root";
        String password="karthi@2308";
        String query="select Name from sample where No="+no;
        try{

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection(url, user, password);
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(query);
            rs.next();
            String name=rs.getString(1);
            s.setname(name);
            
        }
        catch(Exception e){
            System.out.println(e);
        }
        return s;
    }
}
class Student{
    private int rollno;
    private String name;
    public void setrollno(int no){
        this.rollno=no;

     }
     public void setname(String name){
         this.name=name;
     }
     public int getrollno(){
         return this.rollno;
     }
     public String getname(){
         return this.name;
     }
}