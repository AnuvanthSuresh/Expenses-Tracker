package KnightMachine.ExpenseTracker;

import java.util.ArrayList;
import java.util.Date;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import Kightmachine.DAO.DBresources;
import KnightMachine.Model.ExpensesModel;

@Path("Expenses")
public class ExpensesResources {

	@PUT
	@Path("Add/{expense}/{date}/{price}")
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public boolean addExpenseModel(@PathParam("expense") String expenses, @PathParam("date") Date date,
			@PathParam("price") Float price) {
		DBresources db = new DBresources();
		Boolean status = db.addExpense(expenses, date, price);

		if(status) {
			return false;
		}
		else {
			return true;
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
}
