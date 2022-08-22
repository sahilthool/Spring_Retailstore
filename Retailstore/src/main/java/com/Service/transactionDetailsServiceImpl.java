package com.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.Bean.Cart;
import com.Bean.Item;
import com.Bean.Transaction;
import com.Bean.Transaction_Details;
import com.Persistence.AllitemDao;
import com.Persistence.Allitemdaoimpl;
import com.Persistence.TransactionDao;
import com.Persistence.TransactionDetailsDaoImpl;
import com.Persistence.transactionDaoImpl;
import com.Persistence.helper.TransactionDetailsRowMapper;
import com.Persistence.helper.TransactionRowMapper;
@Service
public class transactionDetailsServiceImpl implements transactionDetailsService {

	private TransactionDetailsDaoImpl td;
	@Autowired
	public void setTd(TransactionDetailsDaoImpl td) {
		this.td = td;
	}
	 
	private TransactionDao transactionDao;
	
	@Autowired
	public void setTransactionDao(TransactionDao transactionDao) {
		this.transactionDao = transactionDao;
	}
	
	private AllitemDao aa;

	@Autowired
	public void setAllitemDao(AllitemDao aa) {
		this.aa= aa;
	}
	

	 private JdbcTemplate jdbcTemplate;

		@Autowired
		public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
			this.jdbcTemplate = jdbcTemplate;
		}
		
		private Allitemdaoimpl itemdao;

		@Autowired
		public void setItemdao(Allitemdaoimpl itemdao) {
			this.itemdao = itemdao;
		}

	@Override
	public boolean addToCart(Cart cart) {
		
		Transaction_Details transaction_Details=null;
		
		int custid = cart.getCustomer_id();
		int item_id= cart.getItem_Id();
		int quantity = cart.getQuantity();
		
		int transactionId = transactionDao.getTransactionId(custid);
		
		Item item = aa.searchItem(item_id);
		
		if(item.getItem_Quantity() >= quantity && quantity > 0) {
			transaction_Details = new Transaction_Details(transactionId, item_id, quantity);
			td.addtransactionDetail(transaction_Details);
			aa.updateQuantity(item_id, quantity);
			return true;
		}
		return false;
		
//		try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/retailstore", "root",
//				"wiley");
//				PreparedStatement preparedStatement = connection
//						.prepareStatement("SELECT * FROM transaction where customer_Id=?");) {
//
//			preparedStatement.setInt(1,custid);
//
//			ResultSet resultSet = preparedStatement.executeQuery();
//			
//			
//			Allitemdaoimpl itemdao=new Allitemdaoimpl();
//			Item item=itemdao.searchItem(item_id);
//			if(item.getItem_Quantity()>=quantity && quantity>0)
//			{
//
//			if (resultSet.next()) {
//				int transaction_id = resultSet.getInt("transaction_Id");
//				transaction=new Transaction_Details(transaction_id,item_id,quantity);
//				td.addtransactionDetail(transaction);
//			}
//			itemdao.updateQuantity(item_id, quantity);
//			       return true;
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//			return false;
		String query="SELECT * FROM Transaction where customer_Id=?";
		Transaction t= (Transaction) jdbcTemplate.query(query, new TransactionRowMapper(),custid);
			Item item=itemdao.searchItem(item_id);
			if(item.getItem_Quantity()>=quantity && quantity>0)
			{
				int transaction_id = t.getTransaction_ID();
				transaction=new Transaction_Details(transaction_id,item_id,quantity);
				td.addtransactionDetail(transaction);
			itemdao.updateQuantity(item_id, quantity);
			       return true;
			}
			return false;
	}

	@Override
	public void showalltransactionDetails() {
		td.showalltransactionDetails();
		
	}

	@Override
	public boolean addtransactionDetail(Transaction_Details trans_details) {
		return td.addtransactionDetail(trans_details);
	}

	@Override
	public boolean deletetransactionDetail(int id) {
		return td.deletetransactionDetail(id);
	}

	@Override
	public List<Transaction_Details> searchTransactionDetails(int transid) {
		return td.searchTransactionDetails(transid);
	}

	@Override
	public boolean deleteitemfromcart(int item_id) {
	    return td.deleteitemfromcart(item_id);
	}

	@Override
	public boolean updateitemquantity(int item_id, int quantity) {
		return td.updateitemquantity(item_id, quantity);
	}

	
}
