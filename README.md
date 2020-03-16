# Practical of Advanced Java

## Index


1.  Create chat application using TCP & UDP protocol. Connection on both sides should end if  any one of them types ‘bye’. Implement this on localhost as well as on multiple devices.				
2.	Write a network program in which client send a text file to server and server returns number of characters, lines, words and sentences of that file to client using TCP & UDP.				
3.	Implement any one sorting algorithm using TCP/UDP on Server application. Client sends numbers to the server, server sorts them and passes back to the client.				

4.	Implement Concurrent TCP Server programming in which more than one client can connect and communicate with Server for sending the string and server returns the reverse of string to each client.
5.	Write a JDBC program to perform all CRUD operations on data stored in student table containing the columns for roll number, name and result in percentage using Statement and Updatable ResultSet.

6.	Create a Menu driven program in JDBC for the information given below. Implement it using:
    1.	Prepared Statement
    2.	Callable Statement

    Create following Table schema:
    1.	Employee_Detail (employee_number number NOT NULL Primary key, employee_name varchar2(50) NOT NULL, department_id number, salary number, department_name varchar2(50) NOT NULL).
    2.	Emp_Personal_detail (employee_number number as foreign key, emp_designation varchar2(20), basic_salary number, allowance number, hiredate date, phone_number varchar2(20), email varchar2(25), photo as blob, resume as clob, emp_address varchar2(100)).
      •	Display all the Records from the both tables by employee_number.

      •	Insert Record into the Table. (Hint: - create stored procedure insertdata() in PL/SQL to insert all the field in both tables. Call the procedure from java application when using Callable Statement).

      •	Update The existing record by asking employee_number) (HINT: - Take Updable Resultset)

      •	Delete Record by asking employee_number)) (Hint: - Take Updable Resultset)Program should handle SQLException and SqlWarning.

7.	Write a JDBC program for transaction management for practical no. 5 or 6. Use checkpoints, commit and rollback features.

8. Following  
    1.	Write a servlet to display age of a person by asking his/her date of birth.

    2.	Write a Servlet Program to Print Today’s Date and time using refresh header.
    (Hint: - page should auto refresh)

9.    Write a servlet which accepts 10+ numbers using the post  method as well as get method and displays the arithmetic mean, geometric mean and harmonic mean of those numbers.

10. Following
 1. Write a servlet to store your personal details as a cookie and then display it by reading from the cookie.

 2.	Write a Servlet that uses cookies to store the number of times a user has visited the page.
