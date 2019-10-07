package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
//import com.sun.rowset.JdbcRowSetImpl;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;

public class PatientBean {
	
	   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	   static final String DB_URL = "jdbc:mysql://localhost:3306/u5ms_db";
	   static final String DB_USER = "root";
	   static final String DB_PASS = "Temwan!25";
	   public List<Patient> mPatients = new ArrayList<Patient>();
	   private JdbcRowSet rowSet = null;
	   
	   public PatientBean() {
		      try {
		          //Class.forName(JDBC_DRIVER);
		          rowSet = RowSetProvider.newFactory().createJdbcRowSet();
		          rowSet.setUrl(DB_URL);
		          rowSet.setUsername(DB_USER);
		          rowSet.setPassword(DB_PASS);
		          rowSet.setCommand("SELECT * FROM t_patient");
		          rowSet.execute();
		   } catch (SQLException ex) {
		         
		         ex.printStackTrace();
		   } 
	   }
	   
	   
	   
	   public Patient create(Patient p) {
		   
		      try(Connection con = DriverManager.getConnection(DB_URL,DB_USER,DB_PASS)) {
			        String sqlQuery = "INSERT INTO u5ms_db.t_patient (parent_fullname, child_fullname ,email, phone, address, weight, height, vaccinations) VALUES (?,?,?,?,?,?,?,?)";
			       
			        PreparedStatement statement = con.prepareStatement(sqlQuery);
			        statement.setString(1, p.getParent_fullname());
			        statement.setString(2, p.getChild_fullname());
			        statement.setString(3, p.getEmail());
			        statement.setString(4, p.getPhone());
			        statement.setString(5, p.getAddress());
			        statement.setString(6, p.getWeight());
			        statement.setString(7, p.getHeight());
			        statement.setString(8, p.getVaccinations());
			        
			        int rowsInserted = statement.executeUpdate();
			        if(rowsInserted > 0) {
			        	return p;
			        }
			      } catch (SQLException ex) {
			         
			    	  try {
				            rowSet.rollback();
				            p = null;
				         } catch (SQLException e) {
			
				         }
				         ex.printStackTrace();
			      }
			      return p;
			   
		     /* try {
		         rowSet.moveToInsertRow();
		         //rowSet.updateInt("patientID", p.getPatientID());
		         rowSet.updateString("parent_fullname", p.getParent_fullname());
		         rowSet.updateString("child_fullname", p.getChild_fullname());
		         rowSet.updateString("email", p.getEmail());
		         rowSet.updateString("phone", p.getPhone());
		         rowSet.updateString("address", p.getAddress());
		         rowSet.insertRow();
		         rowSet.moveToCurrentRow();
		      } catch (SQLException ex) {
		         try {
		            rowSet.rollback();
		            p = null;
		         } catch (SQLException e) {
	
		         }
		         ex.printStackTrace();
		      }
		      return p; */
	   }

	   public Patient update(Patient p) {
		/*
		 * try { rowSet.updateString("parent_fullname", p.getParent_fullname());
		 * rowSet.updateString("child_fullname", p.getChild_fullname());
		 * rowSet.updateString("email", p.getEmail()); rowSet.updateString("phone",
		 * p.getPhone()); rowSet.updateString("address", p.getAddress());
		 * rowSet.updateString("weight", p.getWeight()); rowSet.updateString("height",
		 * p.getHeight()); rowSet.updateString("vaccinations", p.getVaccinations());
		 * rowSet.updateRow(); rowSet.moveToCurrentRow(); } catch (SQLException ex) {
		 * try { rowSet.rollback(); } catch (SQLException e) {
		 * 
		 * } ex.printStackTrace(); } return p;
		 */
		   try(Connection con = DriverManager.getConnection(DB_URL,DB_USER,DB_PASS)) {
		        String sqlQuery = "UPDATE u5ms_db.t_patient SET parent_fullname = ?, child_fullname = ?, email = ?, phone = ?, address = ?, weight = ?, height = ?, vaccinations = ? WHERE patientID = ?";
		    	  
		        PreparedStatement statement = con.prepareStatement(sqlQuery);
		        statement.setString(1, p.getParent_fullname());
		        statement.setString(2, p.getChild_fullname());
		        statement.setString(3, p.getEmail());
		        statement.setString(4, p.getPhone());
		        statement.setString(5, p.getAddress());
		        statement.setString(6, p.getWeight());
		        statement.setString(7, p.getHeight());
		        statement.setString(8, p.getVaccinations());
		        statement.setInt(9, p.getPatientID());
		        
		        int rowsInserted = statement.executeUpdate();
		        if(rowsInserted > 0) {
		        	return p;
		        }
		      } catch (SQLException ex) {
		         
		    	  try {
			            rowSet.rollback();
			            p = null;
			         } catch (SQLException e) {
		
			         }
			         ex.printStackTrace();
		      }
		      return p;
	   }
		   
		   

	   public void delete() {
	      try {
	         rowSet.moveToCurrentRow();
	         rowSet.deleteRow();
	      } catch (SQLException ex) {
	         try {
	            rowSet.rollback();
	         } catch (SQLException e) { }
	         ex.printStackTrace();
	      }

	   }
	   
	   

	   public Patient moveFirst() {
		   Patient p = new Patient();
	      try {
	         rowSet.first();
	         p.setPatientID(rowSet.getInt("patientID"));
	         p.setParent_fullname(rowSet.getString("parent_fullname"));
	         p.setChild_fullname(rowSet.getString("child_fullname"));
	         p.setEmail(rowSet.getString("email"));
	         p.setPhone(rowSet.getString("phone"));
	         p.setAddress(rowSet.getString("address"));
	         p.setWeight(rowSet.getString("weight"));
	         p.setHeight(rowSet.getString("height"));
	         p.setVaccinations(rowSet.getString("vaccinations"));
	         

	      } catch (SQLException ex) {
	         ex.printStackTrace();
	      }
	      return p;
	   }

		   public Patient moveLast() {
		      Patient p = new Patient();
		      try {
		         rowSet.last();
		         p.setPatientID(rowSet.getInt("patientID"));
		         p.setParent_fullname(rowSet.getString("parent_fullname"));
		         p.setChild_fullname(rowSet.getString("child_fullname"));
		         p.setEmail(rowSet.getString("email"));
		         p.setPhone(rowSet.getString("phone"));
		         p.setAddress(rowSet.getString("address"));
		         p.setWeight(rowSet.getString("weight"));
		         p.setHeight(rowSet.getString("height"));
		         p.setVaccinations(rowSet.getString("vaccinations"));

		      } catch (SQLException ex) {
		         ex.printStackTrace();
		      }
		      return p;
		   }

		   public Patient moveNext() {
		      Patient p = new Patient();
		      try {
		         if (rowSet.next() == false)
		            rowSet.previous();
		         p.setPatientID(rowSet.getInt("patientID"));
		         p.setParent_fullname(rowSet.getString("parent_fullname"));
		         p.setChild_fullname(rowSet.getString("child_fullname"));
		         p.setEmail(rowSet.getString("email"));
		         p.setPhone(rowSet.getString("phone"));
		         p.setAddress(rowSet.getString("address"));
		         p.setWeight(rowSet.getString("weight"));
		         p.setHeight(rowSet.getString("height"));
		         p.setVaccinations(rowSet.getString("vaccinations"));

		      } catch (SQLException ex) {
		         ex.printStackTrace();
		      }
		      return p;
		   }

		   public Patient movePrevious() {
		      Patient p = new Patient();
		      try {
		         if (rowSet.previous() == false)
		            rowSet.next();
		         p.setPatientID(rowSet.getInt("patientID"));
		         p.setParent_fullname(rowSet.getString("parent_fullname"));
		         p.setChild_fullname(rowSet.getString("child_fullname"));
		         p.setEmail(rowSet.getString("email"));
		         p.setPhone(rowSet.getString("phone"));
		         p.setAddress(rowSet.getString("address"));
		         p.setWeight(rowSet.getString("weight"));
		         p.setHeight(rowSet.getString("height"));
		         p.setVaccinations(rowSet.getString("vaccinations"));

		      } catch (SQLException ex) {
		         ex.printStackTrace();
		      }
		      return p;
		   }

		   public Patient getCurrent() {
		      Patient p = new Patient();
		      try {
		         rowSet.moveToCurrentRow();
		         p.setPatientID(rowSet.getInt("patientID"));
		         p.setParent_fullname(rowSet.getString("parent_fullname"));
		         p.setChild_fullname(rowSet.getString("child_fullname"));
		         p.setEmail(rowSet.getString("email"));
		         p.setPhone(rowSet.getString("phone"));
		         p.setAddress(rowSet.getString("address"));
		         p.setWeight(rowSet.getString("weight"));
		         p.setHeight(rowSet.getString("height"));
		         p.setVaccinations(rowSet.getString("vaccinations"));
		         
		      } catch (SQLException ex) {
		         ex.printStackTrace();
		      }
		      return p;
		   }
}
