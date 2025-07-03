package vn.edu.eiu.lab1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class Main {
    public static void main(String[] args) {
        Connection conn = null;
        //Sử dụng các class cung cấp sẵn có trong thư viên JDBC (có trong JAVA SDK)
        //JDBC sẽ tự động kết nối với MySQL JDBC Server (MySQL connector/java)
        try {
            String url = "jdbc:mysql://localhost:3306/cse456";

            //Đối với Java mới thì Driver sẽ được tự động dò tìm trong URL mà ko cần lệnh này.
            //Class.forName("com.mysql.cj.jdbc.Driver");

            conn = DriverManager.getConnection(url,"root","123456789");
            System.out.println("Connected to database successfully");

            //Sau khi kết nối thành công thì tiếp tục thực hiện truy vấn bằng SQL
            //Tạo Class PreparedStatement để thực hiện câu truy vấn.
            PreparedStatement pstmt = conn.prepareStatement("select * from lab1_student");

            ResultSet rs = pstmt.executeQuery();
//            while (rs.next()) {
//                System.out.print(rs.getString(1));
//                System.out.print(rs.getString(2));
//                System.out.print(rs.getString(3));
//                System.out.print(rs.getString(4));
//                System.out.println(rs.getString(5));
//            }
            while (rs.next()) {
                String code = rs.getString("id");
                String name = rs.getString("first_name");
                String Credits = rs.getString("last_name");
                int yearOfBirth = rs.getInt("year_of_birth");
                double gpa = rs.getDouble("gpa");
                System.out.println(code + "|" + name + "|" + Credits + "|" + yearOfBirth + "|" + gpa);
//                System.out.printf("|%10s|%-40s|%2d|%4d|\n",code,name,Credits,StudyHours);

            }
            conn.close();

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}