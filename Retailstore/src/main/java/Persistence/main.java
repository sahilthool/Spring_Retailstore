package Persistence;

import Service.allitemServiceImpl;

public class main {
		public static void main(String args[])
		{
			TransactionDetailsDaoImpl t=new TransactionDetailsDaoImpl();
			System.out.println("Transaction Details:");
			t.showalltransactionDetails();
			CustomerDaoImp c=new CustomerDaoImp();
			System.out.println("Customer:");
			c.showCustomer();
			transactionDaoImpl t1=new transactionDaoImpl();
			System.out.println("Transaction:");
			t1.showalltransactions();
			Allitemdaoimpl it = new Allitemdaoimpl();
			System.out.println("Items:");
			it.showallitem();
		}

	}



