package edu.ssafy.boot.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.ssafy.boot.dto.MemDTO;
import edu.ssafy.boot.exception.MyException;
import edu.ssafy.boot.repository.MemberRepository;


@Service("MemberServiceImpl")
public class MemberServiceImpl implements MemberService {

	@Autowired
	@Qualifier("MemberMybatisRepositoryImpl")
	MemberRepository repo;

	@Override
	@Transactional
	public int insert(String num, String pw, String name, String tel) throws MyException {
		return repo.insert(new MemDTO(num,pw,name,tel));
	}

	@Override
	@Transactional
	public int update(String num, String pw, String name, String tel) {
		return repo.update(new MemDTO(num,pw, name,tel));
	}

	@Override
	@Transactional
	public int delete(String num) {
		return repo.delete(num);
	}

	@Override
	@Transactional
	public MemDTO selectOne(String num) {
		return repo.selectOne(num);
	}

	@Override
	@Transactional
	public List<MemDTO> selectList() {
		return repo.selectList();
	}

	@Override
	@Transactional
	public boolean login(String id, String pw) {
		return repo.login(id, pw);
	}

}
