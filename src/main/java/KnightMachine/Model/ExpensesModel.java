package KnightMachine.Model;



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
	public Float getExpense_amnt() {
		return Expense_amnt;
	}
	public void setExpense_amnt(Float expense_amnt) {
		Expense_amnt = expense_amnt;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	Float Expense_amnt;
    String date;
}
