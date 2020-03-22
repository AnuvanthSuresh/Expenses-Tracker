package Kightmachine.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;


import KnightMachine.Model.ExpensesModel;

public class DBresources {
	
	DAO con = new DAO();

	// add new expense
	// mm-dd-yyyy
	public boolean addExpense(String Expense, Date date, Float price ) {
		
		try {
			Connection db = con.getConnection();
			String Query = "insert into et_main values("+Expense+","+date+","+price+");";
			Statement st = db.createStatement();
			st.executeUpdate(Query);
			return true;
		}
		catch (Exception e) {
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
	
			   model.setDate(expenses.getString("date"));
			   model.setExpense(expenses.getString("expense"));
			   model.setExpense_amnt(expenses.getFloat("cost"));

			   expense.add(model);
			   
		   }
		}
		catch (Exception e) {
        System.out.println("Exception retireving Expenses");
        e.printStackTrace();
		}
		return expense;
	}
}
