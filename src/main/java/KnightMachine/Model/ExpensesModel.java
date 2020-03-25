package KnightMachine.Model;



import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ExpensesModel {
	
	String Expense;
	public String getExpense() {
		return Expense;
	}
	public void setExpense(String expense) {
		Expense = expense;
	}
	public String getExpense_amnt() {
		return Expense_amnt;
	}
	public void setExpense_amnt(String expense_amnt) {
		Expense_amnt = expense_amnt;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	String Expense_amnt;
    Date date;
}
