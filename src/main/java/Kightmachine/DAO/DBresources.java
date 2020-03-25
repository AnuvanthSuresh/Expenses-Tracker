package Kightmachine.DAO;

import java.sql.Connection;
import java.util.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import KnightMachine.Model.ExpensesModel;

public class DBresources {
	
	DAO con = new DAO();

	// add new expense
	// mm-dd-yyyy
	public boolean addExpense(String Expense, Date date, String price ) {
		SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy");  
		String newdate = formatter.format(date);
		try {
			Connection db = con.getConnection();
			String Query = "insert into et_main values('"+newdate+"','"+Expense+"',"+price+");";
			System.out.println(Query);
			Statement st = db.createStatement();
			st.executeUpdate(Query);
			System.out.println("Expense added succesfully");
			return true;
			
		}
		catch (Exception e) {
			System.out.println("Expense adding failed");
			e.printStackTrace();
			return false;
		}
		
	}
	
	// Retrieve expenses
	public ArrayList<ExpensesModel> getAllExpense(){
		
		ExpensesModel model = new ExpensesModel();
		ArrayList<ExpensesModel> expense = new ArrayList<ExpensesModel>();
		
		try {
			Connection db = con.getConnection();
			String Query = "select * from et_main ";
			Statement st = db.createStatement();
			ResultSet expenses = st.executeQuery(Query);
		   while (expenses.next()) {
	
			   model.setDate(expenses.getDate("date"));
			   model.setExpense(expenses.getString("expense"));
			   model.setExpense_amnt(expenses.getString("cost"));

			   expense.add(model);
			   System.out.println("Expense retrieval succesfully"); 
		   }
		}
		catch (Exception e) {
        System.out.println("Exception retireving Expenses");
        e.printStackTrace();
		}
		return expense;
	}

	// Returns expenses on date
	
	public ArrayList<ExpensesModel> getExpense(Date date) {
		ExpensesModel model = new ExpensesModel();
		ArrayList<ExpensesModel> expense = new ArrayList<ExpensesModel>();
		SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy");  
		String newdate = formatter.format(date);
		try {
			Connection db = con.getConnection();
			String Query = "select * from et_main where date='"+newdate+"';";
			System.out.println(Query);
			Statement st = db.createStatement();
			ResultSet expenses = st.executeQuery(Query);
		   while (expenses.next()) {
	
			   model.setDate(expenses.getDate("date"));
			   model.setExpense(expenses.getString("expense"));
			   model.setExpense_amnt(expenses.getString("cost"));
 System.out.println(expenses.getString("expense"));
			   expense.add(model);
			  
		   }
		   System.out.println("Expense retrieval date succesfully");
		}
		catch (Exception e) {
        System.out.println("Exception retireving Expenses");
        e.printStackTrace();
		}
		return expense;
	}

	
}
