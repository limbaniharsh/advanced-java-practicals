import java.sql.*;
import java.util.*;

class prac6{
    public static void main(String[] args) throws Exception {
        Connection con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/harsh", "root", "");
        OperationOnEmp op = new OperationOnEmp(con);
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("Choose one Option: ");
            System.out.println("1. For Add Data ");
            System.out.println("2. For Delete Data ");
            System.out.println("3. For Update Data ");
            System.out.println("4. For show All Data ");
            System.out.println("5. For Exit ");
            System.out.print("Enter option No.: ");
            int o = in.nextInt();
            System.out.println("--------------------------------------------------------------");
            switch (o) {
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
                    op.showData();
                    break;

                
                case 5:
                    System.exit(0);
                    break;

                default:
                    System.out.println("enter valid option.");
            }
            System.out.println("--------------------------------------------------------------");

        }
        
    }
}

class OperationOnEmp {
    Connection cn;

    OperationOnEmp(Connection c) {
        cn = c;
    }

    public void addData() throws Exception {
        CallableStatement pr = cn.prepareCall("{ call insertdata(?,?,?,?,?) }");
        Scanner in = new Scanner(System.in);
        System.out.print("Enter Emp. No.:");
        int no = in.nextInt();
        in.nextLine();
        System.out.print("Enter Emp. Name: ");
        String name = in.nextLine();
        System.out.print("Enter Department id: ");
        int d_id = in.nextInt();
        System.out.print("Enter Emp. Salary: ");
        int salary = in.nextInt();
        in.nextLine();
        System.out.print("Enter Department Name: ");
        String d_name = in.nextLine();
        pr.setInt(1, no);
        pr.setString(2, name);
        pr.setInt(3, d_id);
        pr.setInt(4, salary);
        pr.setString(5, d_name);
        int i = pr.executeUpdate();
        System.out.println("Data is Updated.");
    }

    public void showData() throws Exception {
        PreparedStatement pr = cn.prepareStatement("select * from employee_detail");
        ResultSet rs = pr.executeQuery();
        System.out.println("Emp_number" + "\tEmp_Name" + "\tDepartment_id"+ "\tSalary"+ "\tDepartment_Name");
        while (rs.next()) {
            System.out.println(rs.getInt(1) + "\t\t" + rs.getString(2) + "\t\t" + rs.getInt(3) + "\t\t" + rs.getInt(4) + "\t\t"
                    + rs.getString(5));
        }
    }

    public void deleteData() throws Exception {
        PreparedStatement pr = cn.prepareStatement("delete from employee_detail where employee_number=?");
        Scanner in = new Scanner(System.in);
        System.out.print("Enter Emp No.:");
        int no = in.nextInt();
        pr.setInt(1, no);
        int i = pr.executeUpdate();
        System.out.println("Delete complited.");
    }

    

    public void updateRow() throws Exception {
        PreparedStatement pr = cn.prepareStatement("update employee_detail set employee_name=?,department_id=?, salary=?, department_name=? where employee_number=?");
        Scanner in = new Scanner(System.in);
        System.out.print("Enter Emp. No.:");
        int no = in.nextInt();
        in.nextLine();
        System.out.print("Enter Emp. Name: ");
        String name = in.nextLine();
        System.out.print("Enter Department id: ");
        int d_id = in.nextInt();
        System.out.print("Enter Emp. Salary: ");
        int salary = in.nextInt();
        in.nextLine();
        System.out.print("Enter Department Name: ");
        String d_name = in.nextLine();
        pr.setInt(5, no);
        pr.setString(1, name);
        pr.setInt(2, d_id);
        pr.setInt(3, salary);
        pr.setString(4, d_name);
        int i = pr.executeUpdate();
        System.out.println("Update complited.");
    }

}