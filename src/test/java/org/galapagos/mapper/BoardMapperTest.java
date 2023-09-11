package org.galapagos.mapper;

import static org.junit.Assert.*;

import java.util.List;

import org.galapagos.config.RootConfig;
import org.galapagos.domain.BoardVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { RootConfig.class })
@Log4j
public class BoardMapperTest {

	@Autowired
	private BoardMapper mapper;

	@Test
	public void testGetList() {
		List<BoardVO> list = mapper.getList();
		for (BoardVO b : list) {
			log.info(b);
		}
	}

	//@Test
	public void testInsert() {

		BoardVO board = new BoardVO();
		board.setTitle("새로 작성하는 글");
		board.setContent("새로 작성하는 내용");
		board.setWriter("newbie");

		mapper.insert(board);

		log.info(board);
	}

	//@Test
	public void testInsertSelectKey() {

		BoardVO board = new BoardVO();
		board.setTitle("새로 작성하는 글");
		board.setContent("새로 작성하는 내용");
		board.setWriter("newbie");

		mapper.insertSelectKey(board);

		log.info(board);
	}

	//@Test
	public void testRead() {
		// 존재하는 게시물 번호로 테스트
		
		BoardVO board = mapper.read(3L);
		
		log.info(board);
	}
	
	//@Test
	public void testDelete() {
		
		log.info("DELETE COUNT: " + mapper.delete(4L));
	}
	
	//@Test
	public void testUpdate() {
		
		BoardVO board = new BoardVO();
		board.setBno(3L);
		board.setTitle("바껴라 얍");
		board.setContent("내껄들어봐바확실한어나더");
		board.setWriter("user12");
		
		int count = mapper.update(board);
		
		log.info("UPDATE COUNT: " + count);
	}


}
