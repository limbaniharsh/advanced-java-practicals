import java.sql.*;
import java.util.*;


class test{
    public static void main(String args[]) throws Exception {
        Connection con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/harsh","root","");
        Operation op = new Operation(con);
        Scanner in = new Scanner(System.in);
    while(true){
        System.out.println("Choose one Option: ");
        System.out.println("1. For Add Data ");
        System.out.println("2. For Delete Data ");
        System.out.println("3. For Update Data ");
        System.out.println("4. For Show Data Row ");
        System.out.println("5. For show All Data ");
        System.out.println("6. For Exit ");
        System.out.print("Enter option No.: ");
        int o = in.nextInt();
        System.out.println("--------------------------------------------------------------");
        switch(o)
        {
            case 1:
            op.addData();
            break;
            
            case 2:
            op.deleteData();
            break;

            case 3:
            op.updateRow();
            break;

            case 4:
            op.showRow();
            break;

            case 5:
            op.showData();
            break;

            case 6:
            System.exit(0);
            break;

            default:
            System.out.println("enter valid option.");
        }
        System.out.println("--------------------------------------------------------------");

    }




    }
}

class Operation{
    Connection cn;
    Operation(Connection c){
        cn=c;
    }

    public void addData() throws Exception{
        PreparedStatement pr = cn.prepareStatement("insert into student values(?,?,?)");
        Scanner in = new Scanner(System.in);
        System.out.print("Enter Roll No.:");
        int r = in.nextInt();
        in.nextLine();
        System.out.print("Enter Name: ");
        String n= in.nextLine();
        System.out.print("Enter result: ");
        int result = in.nextInt();
        pr.setInt(1, r);
        pr.setString(2, n);
        pr.setInt(3, result);
        int i = pr.executeUpdate();
        System.out.println("Data is Updated.");
    }

    public void showData() throws Exception{
        PreparedStatement pr = cn.prepareStatement("select * from student");
        ResultSet rs =  pr.executeQuery();
        System.out.println("Roll_no"+"\tName"+"\tResult");
        while(rs.next()){
            System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getInt(3));
        }
    }
    public void deleteData() throws Exception{
        PreparedStatement pr = cn.prepareStatement("delete from student where rollno=?");
        Scanner in = new Scanner(System.in);
        System.out.print("Enter Roll No.:");
        int roll = in.nextInt();
        pr.setInt(1, roll);
        int i = pr.executeUpdate();
        System.out.println("Delete complited.");
    }
    
    public void showRow() throws Exception {
        PreparedStatement pr = cn.prepareStatement("select * from student where rollno=?");
        Scanner in = new Scanner(System.in);
        System.out.print("Enter Roll No.:");
        int roll = in.nextInt();
        pr.setInt(1, roll);
        ResultSet rs = pr.executeQuery();
        System.out.println("Roll_no" + "\tName" + "\tResult");
        while (rs.next()) {
            System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getInt(3));
        }
    }

    public void updateRow() throws Exception{
        PreparedStatement pr = cn.prepareStatement("update student set name=?,result=? where rollno=?");
        Scanner in = new Scanner(System.in);
        System.out.print("Enter Roll No.:");
        int roll = in.nextInt();
        in.nextLine();
        System.out.print("Enter Name: ");
        String name = in.nextLine();
        System.out.print("Enter result: ");
        int result = in.nextInt();
        
        pr.setString(1, name);
        pr.setInt(2, result);
        pr.setInt(3, roll);
        int i = pr.executeUpdate();
        System.out.println("Update complited.");
        
    }
    
}