package com.kh.myBatis.board.model.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.kh.myBatis.board.model.vo.Board;
import com.kh.myBatis.board.model.vo.Reply;
import com.kh.myBatis.common.vo.PageInfo;

public class BoardDao {

	public int selectListCount(SqlSession sqlSession) {
		return sqlSession.selectOne("boardMapper.selectListCount");
		
	}

	public ArrayList<Board> selectList(SqlSession sqlSession, PageInfo pi){
		//마이바티스에서는 페이징처리를 위해 rowBounds라는 클래스를 제공한다.
		/* offset : 몇개의 게시글을 건너뛰고 조회할건지에 대한 값
		 * 
		 * currentPage : 1         1~5        0        5
		 * currentPage : 2         6~10       5        5
		 * currentPage : 3         11~15      10       5
		 * ...
		 *  
		 */
		
		int offset = (pi.getCurrentPage()-1) * pi.getBoardLimit();
		int limit = pi.getBoardLimit();

		RowBounds rowBounds = new RowBounds(offset, limit);
		
		return (ArrayList)sqlSession.selectList("boardMapper.selectList", null, rowBounds);
		
	}
	
	public int selectSearchCount(SqlSession sqlSession, HashMap<String, String> map) { //동적sql
		// condition 값에 따라 sql문이 달라져야함 
		// if condition == writer -> sql문 where절 WHERE WRITER = XXX
		// if condition == title -> sql문 where절 WHERE TITLE = XXX
		// if condition == content -> sql문 where절 WHERE CONTENT = XXX
		
		
		return sqlSession.selectOne("boardMapper.selectSearchCount", map); 
	}
	
	public ArrayList<Board> selectSearchList(SqlSession sqlSession, HashMap<String,String> map, PageInfo pi){
		int offset = (pi.getCurrentPage()-1) * pi.getBoardLimit();
		int limit = pi.getBoardLimit();
		
		RowBounds rowBounds = new RowBounds(offset, limit);
		return (ArrayList)sqlSession.selectList("boardMapper.selectSearchList", map, rowBounds);
		
	}
	
	public int increaseCount(SqlSession sqlSession, int boardNo) {
		return sqlSession.update("boardMapper.increaseCount", boardNo);
		//dml 처리된 행수 리턴
	}
	
	public Board selectBoard(SqlSession sqlSession, int boardNo) {
		return (Board)sqlSession.selectOne("boardMapper.selectBoard", boardNo);
	}
	
	public ArrayList<Reply> selectReplyList(SqlSession sqlSession, int boardNo){
		return (ArrayList)sqlSession.selectList("boardMapper.selectReplyList", boardNo);
	}
	
}
