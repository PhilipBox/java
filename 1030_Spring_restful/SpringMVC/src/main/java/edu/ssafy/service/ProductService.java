package edu.ssafy.service;

import java.util.List;

import edu.ssafy.dto.ProductDTO;


public interface ProductService {
	public int insert(String pnum, String pname, String price);
	public int update(String pnum, String pname, String price);
	public int delete(String pnum);
	public ProductDTO selectOne(String num);
	public List<ProductDTO> selectList();
}
