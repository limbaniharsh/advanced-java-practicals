import java.io.*;
import java.sql.*;
import java.util.*;


class prac6 {
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
                    con.close();
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
        CallableStatement pr = cn.prepareCall("{ call insert_personal_data(?,?,?,?,?,?,?,?,?,?) }");
        Scanner in = new Scanner(System.in);
        System.out.print("Enter Emp. No.:");
        int no = in.nextInt();
        in.nextLine();
        System.out.print("Enter Emp. Designation: ");
        String desi = in.nextLine();
        System.out.print("Enter Basic Salary: ");
        int b_salary = in.nextInt();
        System.out.print("Enter Emp. Allowance: ");
        int allo = in.nextInt();
        in.nextLine();
        System.out.println("Enter Hire Data(yyyy-mm-dd):");
        String date = in.nextLine();
        System.out.print("Enter Mobile Number: ");
        int mob = in.nextInt();
        in.nextLine();
        System.out.print("Enter Email: ");
        String mail = in.nextLine();
        System.out.print("Enter Address: ");
        String add = in.nextLine();
        System.out.println("Enter path of photo: ");
        String photo = in.nextLine();
        System.out.println("Enter resume path: ");
        String resume = in.nextLine();
        FileInputStream ph = new FileInputStream(photo);
        FileReader re = new FileReader(resume);
        pr.setInt(1, no);
        pr.setString(2, desi);
        pr.setInt(3, b_salary);
        pr.setInt(4, allo);
        pr.setString(5, date);
        pr.setInt(6, mob);
        pr.setString(7, mail);
        pr.setString(10, add);
        pr.setBinaryStream(8, ph, ph.available());
        pr.setCharacterStream(9, re);
        int i = pr.executeUpdate();
        System.out.println("Data is Updated.");
    }

    public void showData() throws Exception {
        PreparedStatement pr = cn.prepareStatement("select * from emp_personal_detail");
        ResultSet rs = pr.executeQuery();
        System.out.println("Emp_number" + "\tEmp_Desig" + "\tBasic_salary" + "\tAllowance" + "\tHireDate"
                + "\tPhone" + "\t\tEmail\t" + "\tAddress");
        while (rs.next()) {
            System.out.println(rs.getInt(1) + "\t\t" + rs.getString(2) + "\t\t" + rs.getInt(3) + "\t\t" + rs.getInt(4)
                    + "\t\t" + rs.getString(5)+ "\t" + rs.getInt(6) + "\t"
                    +rs.getString(7) +"\t" + rs.getString(10));
        }
    }

    public void deleteData() throws Exception {
        PreparedStatement pr = cn.prepareStatement("delete from emp_personal_detail where employee_number=?");
        Scanner in = new Scanner(System.in);
        System.out.print("Enter Emp No.:");
        int no = in.nextInt();
        pr.setInt(1, no);
        int i = pr.executeUpdate();
        System.out.println("Delete complited.");
    }

    public void updateRow() throws Exception {
        PreparedStatement pr = cn.prepareStatement(
                "update emp_personal_detail set employee_designation=?,basic_salary=?, allowance=?, hiredate=?, phone_number=?, email=?,photo=?, resume=?,emp_address=? where employee_number=?");
        Scanner in = new Scanner(System.in);
        System.out.print("Enter Emp. No.:");
        int no = in.nextInt();
        in.nextLine();
        System.out.print("Enter Emp. Designation: ");
        String desi = in.nextLine();
        System.out.print("Enter Basic Salary: ");
        int b_salary = in.nextInt();
        System.out.print("Enter Emp. Allowance: ");
        int allo = in.nextInt();
        in.nextLine();
        System.out.println("Enter Hire Data(yyyy-mm-dd):");
        String date = in.nextLine();
        System.out.print("Enter Mobile Number: ");
        int mob = in.nextInt();
        in.nextLine();
        System.out.print("Enter Email: ");
        String mail = in.nextLine();
        System.out.print("Enter Address: ");
        String add = in.nextLine();
        System.out.println("Enter path of photo: ");
        String photo = in.nextLine();
        System.out.println("Enter resume path: ");
        String resume = in.nextLine();
        FileInputStream ph = new FileInputStream(photo);
        FileReader re = new FileReader(resume);
        pr.setInt(10, no);
        pr.setString(1, desi);
        pr.setInt(2, b_salary);
        pr.setInt(3, allo);
        pr.setString(4, date);
        pr.setInt(5, mob);
        pr.setString(6, mail);
        pr.setString(9, add);
        pr.setBinaryStream(7, ph, ph.available());
        pr.setCharacterStream(8, re);
        int i = pr.executeUpdate();
        System.out.println("Update complited.");
    }

}