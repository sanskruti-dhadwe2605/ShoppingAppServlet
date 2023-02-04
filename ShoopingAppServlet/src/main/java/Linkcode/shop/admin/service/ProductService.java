package Linkcode.shop.admin.service;

import java.util.List;

import Linkcode.shop.admin.model.*;
public interface ProductService {
	String createProduct(List<Product> lst);
	List<Product> retriveProduct(int ProdId);
	boolean deleteProduct(String prodName);
	boolean deleteproduct(int prodId);
	List<Product> getAllProduct();

}
