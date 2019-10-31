package edu.ssafy.boot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import edu.ssafy.boot.dto.ProductDTO;
import edu.ssafy.boot.service.ProductService;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping("/api")
public class RestProductController {
	private static final Logger logger = LoggerFactory.getLogger(RestProductController.class);

	@Autowired
	@Qualifier("ProductServiceImpl")
	ProductService pser;

	@PostMapping("/productregister")
	@ApiOperation(value = "product 등록 서비스")
	public ResponseEntity<Map<String, Object>> productRegister(@RequestBody ProductDTO dto) {
		ResponseEntity<Map<String, Object>> resEntity = null;
		try {
			int insert = pser.insert(dto.getId(), dto.getName(), dto.getPrice(), dto.getInfo());
			Map<String, Object> msg = new HashMap<String, Object>();
			msg.put("resmsg", "상품 등록 성공");
			msg.put("resvalue", insert);
			resEntity = new ResponseEntity<Map<String, Object>>(msg, HttpStatus.OK);
		} catch (RuntimeException e) {
			Map<String, Object> msg = new HashMap<String, Object>();
			msg.put("resmsg", "상품 등록 실패");
			resEntity = new ResponseEntity<Map<String, Object>>(msg, HttpStatus.OK);
		}
		return resEntity;
	}

	@GetMapping("/productlist")
	@ApiOperation(value = "product 전체목록 조회 서비스", response = List.class)
	public @ResponseBody ResponseEntity<Map<String, Object>> productList() {
		ResponseEntity<Map<String, Object>> resEntity = null;
		List<ProductDTO> plist = null;
		try {
			plist = pser.selectList();
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("resmsg", "상품 전체 조회 성공");
			map.put("resvalue", plist);
			resEntity = new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
		} catch (RuntimeException e) {
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("resmsg", "상품 전체 조회 실패");
			resEntity = new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
		}
		return resEntity;
	}	

	@GetMapping("/productview/{id}")
	@ApiOperation(value = "id를 받아 product를 조회하는 서비스", response = ProductDTO.class)
	public @ResponseBody ResponseEntity<Map<String, Object>> productView(@PathVariable("id") String pnum) {
		ResponseEntity<Map<String, Object>> resEntity = null;
		ProductDTO product = null;
		try {
			product = pser.selectOne(pnum);
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("resmsg", "상품 조회 성공");
			map.put("resvalue", product);
			resEntity = new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
		} catch (RuntimeException e) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("resmsg", "상품 조회 실패");
			resEntity = new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
		}
		return resEntity;
	}

	@DeleteMapping("/productdelete/{id}")
	@ApiOperation(value = "id을 받아 product를 삭제하는 서비스")
	public @ResponseBody ResponseEntity<Map<String, Object>> productDelete(@PathVariable("id") String id) {
		ResponseEntity<Map<String, Object>> resEntity = null;
		try {
			int delete = pser.delete(id);
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("resmsg", "상품 삭제 성공");
			map.put("resvalue", delete);
			resEntity = new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
		} catch (RuntimeException e) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("resmsg", "상품 삭제 실패");
			resEntity = new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
		}
		return resEntity;
	}

	@PutMapping("/productupdate/{id}")
	@ApiOperation(value = "id을 받아 product 정보를 수정하는 서비스")
	public @ResponseBody ResponseEntity<Map<String, Object>> productUpdate(@RequestBody ProductDTO dto) {
		ResponseEntity<Map<String, Object>> resEntity = null;
		try {
			int update = pser.update(dto.getId(), dto.getName(), dto.getPrice(), dto.getInfo());
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("resmsg", "상품정보 수정 성공");
			map.put("resvalue", update);
			resEntity = new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
		} catch (RuntimeException e) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("resmsg", "상품정보 수정 실패");
			resEntity = new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
		}
		return resEntity;
	}
}
