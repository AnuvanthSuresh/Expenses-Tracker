package KnightMachine.ExpenseTracker;


import java.util.ArrayList;


import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import Kightmachine.DAO.DBresources;
import KnightMachine.Model.ExpensesModel;

@Path("Expenses")
public class ExpensesResources {

	@POST
	@Path("AddExpense")
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public ExpensesModel addExpenseModel(ExpensesModel expensesM) {
		DBresources db = new DBresources();
		Boolean status = db.addExpense(expensesM.getExpense(),expensesM.getDate(),expensesM.getExpense_amnt());

		
		if(status) {
			return expensesM;
		}
		else {
			return expensesM;
		}
		
	}
	
	@GET
	@Path("AllExpenses")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public ArrayList<ExpensesModel> ExpensesResource(){
		
		DBresources res = new DBresources();
		ArrayList<ExpensesModel> exp = new ArrayList<ExpensesModel>();
		
		exp = res.getAllExpense();
		
		return exp;
		
	}
	
	@GET
	@Path("Expense/date")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public ArrayList<ExpensesModel> ExpenseResource(){
		
		DBresources res = new DBresources();
		ArrayList<ExpensesModel> exp = new ArrayList<ExpensesModel>();
		ExpensesModel expenseM= new ExpensesModel();
		exp = res.getExpense(expenseM.getDate());
	
		for(ExpensesModel em : exp) {
			
			System.out.print(em.getDate());
			System.out.print(em.getExpense());
			System.out.print(em.getExpense_amnt());
			System.out.println();
		}
		
		return exp;
		
	}
}
