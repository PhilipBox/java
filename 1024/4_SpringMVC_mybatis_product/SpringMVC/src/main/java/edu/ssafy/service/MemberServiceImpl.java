package edu.ssafy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.ssafy.dto.MemDTO;
import edu.ssafy.exception.MyException;
import edu.ssafy.repository.MemberRepository;

@Service("MemberServiceImpl")
public class MemberServiceImpl implements MemberService {

	@Autowired
	@Qualifier("MemberMybatisRepositoryImpl")
	MemberRepository repo;

	@Override
	@Transactional
	public void insert(String num, String pw, String name, String tel) throws MyException {
		repo.insert(new MemDTO(num,pw,name,tel));
	}

	@Override
	@Transactional
	public void update(String num, String pw, String name, String tel) {
		repo.update(new MemDTO(num,pw, name,tel));
	}

	@Override
	@Transactional
	public void delete(String num) {
		repo.delete(num);
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
