package org.galapagos.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.galapagos.domain.BoardVO;

public interface BoardMapper {
	
	// @Select("select * from tbl_board")
	public List<BoardVO> getList();
	
	public void insert(BoardVO board);  // insert 후에 bno를 알수 없음
	
	public void insertSelectKey(BoardVO board); // insert후에 bno를 추출
	
	public BoardVO read(Long bno);
	
	public int delete(Long bno);
	
	public int update(BoardVO board);
}
