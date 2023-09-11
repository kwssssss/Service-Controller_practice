package org.galapagos.service;

import java.util.List;

import org.galapagos.domain.BoardVO;
import org.galapagos.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service // 이거 빠트려서 autowired 안되는 경우가 많음, 빈등록 기능
@AllArgsConstructor
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardMapper mapper; // 생성자의 매개변수로 주입

	@Override
	public void register(BoardVO board) {

		log.info("register.............." + board);

		mapper.insertSelectKey(board);
	}

	@Override
	public BoardVO get(Long bno) {

		log.info("get..............." + bno);

		return mapper.read(bno);

	}

	@Override
	public boolean modify(BoardVO board) {

		log.info("modify.........." + board);

		return mapper.update(board) == 1;
	}

	@Override
	public boolean remove(Long bno) {
		log.info("remove...." + bno);
		
		return mapper.delete(bno) == 1;
	}

	@Override
	public List<BoardVO> getList() {
		
		log.info("getList.......................");
		
		return mapper.getList();
	}

}
