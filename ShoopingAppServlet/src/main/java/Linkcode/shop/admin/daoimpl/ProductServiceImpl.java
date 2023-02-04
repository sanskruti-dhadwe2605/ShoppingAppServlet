package Linkcode.shop.admin.daoimpl;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import Linkcode.shop.admin.model.Product;
import Linkcode.shop.admin.service.ProductService;
import Linkcode.shop.connection.ShopDb;

public class ProductServiceImpl implements ProductService{

	@Override
	public String createProduct(List<Product> lst) {
		String str="";
		Connection con=ShopDb.getConnection();
		Product prod=lst.get(0);
		int i=0;
		PreparedStatement pstate;
		try {
			pstate = con.prepareStatement("insert into product values(?,?,?,?)");
			pstate.setInt(1, prod.getProdId());
			pstate.setString(2, prod.getProdName());
			pstate.setDouble(3, prod.getProdPrice());
			pstate.setInt(4, prod.getProdQty());
			i=pstate.executeUpdate();
			if(i>0) {
				str="valid";
			}
		} catch (SQLException e) {
			str=e.getMessage();
			e.printStackTrace();
		}

		return str;
	}

	@Override
	public List<Product> retriveProduct(int ProdId) {
		String str="";
		Connection con=ShopDb.getConnection();
		int i=0;
		List<Product> prodlst=null;
		PreparedStatement pstate;
		try {
			pstate = con.prepareStatement("select * from product where prodId=?");
			pstate.setInt(1, ProdId);
			ResultSet rs=pstate.executeQuery();
			if(rs.next()) {
				prodlst=new ArrayList<Product>();
				Product prod=new Product(rs.getInt(1),rs.getString(2), rs.getFloat(3), rs.getInt(4));
				prodlst.add(prod);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return prodlst;
	}

	@Override
	public boolean deleteProduct(String prodName) {
		Connection con=ShopDb.getConnection();
		int i=0;
		List<Product> prodlst=null;
		PreparedStatement pstate;
		try {
			pstate = con.prepareStatement("delete * from product where prodId=?");
			
			ResultSet rs=pstate.executeQuery();
			if(rs.next()) {
				prodlst=new ArrayList<Product>();
				Product prod=new Product(rs.getInt(1),rs.getString(2), rs.getFloat(3), rs.getInt(4));
				prodlst.remove(prod);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		return false;
		
	}
	public boolean deleteproduct(int prodId) {
		Connection con=ShopDb.getConnection();
		int i=0;
		List<Product> prodlst=null;
		PreparedStatement pstate;
		
		return false;
	}
	

	@Override
	public List<Product> getAllProduct() {
		List<Product> prodlst=new LinkedList<Product>();
		Connection con=ShopDb.getConnection();
		String str="select * from product";
		ResultSet rs;
		try {
			Statement pstate=con.createStatement();
			rs = pstate.executeQuery(str);
			prodlst=new ArrayList<Product>();
			while(rs.next()) {
				Product prod=new Product(rs.getInt(1),rs.getString(2),rs.getFloat(3),rs.getInt(4));
				prodlst.add(prod);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}




		return prodlst;
	}

	public String UpdateProductPrice(int prodId, double prodPrice) {
		// TODO Auto-generated method stub
		return null;
	}

}
