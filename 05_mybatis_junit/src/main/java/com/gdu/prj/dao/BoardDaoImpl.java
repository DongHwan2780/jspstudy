package com.gdu.prj.dao;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.gdu.prj.dto.BoardDto;

public class BoardDaoImpl implements BoardDao {

  // SqlSession(Connection / PreparedStatement / ResultSet 처리) 만드는 SqlSessionFactory
  private SqlSessionFactory factory = null;
  
  private static BoardDao boardDao = new BoardDaoImpl();
  
  private BoardDaoImpl()
  {
    // mybatis-config.xml 파일을 이용한 SqlSessionFactory 객체 생성
    
    try {
      String resource = "com/gdu/prj/config/mybatis-config.xml";
      InputStream in = Resources.getResourceAsStream(resource);
      factory = new SqlSessionFactoryBuilder().build(in);
      
      
      
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  public static BoardDao getInstance()
  {
    return boardDao;
  }
  
  @Override
  public int insertBoard(BoardDto board) {
    SqlSession sqlSession = factory.openSession(false);  // autoCommit을 하지 않는다.
    int insertCount = sqlSession.insert("com.gdu.prj.dao.board_t.insertBoard", board);
    if(insertCount == 1) {
      sqlSession.commit();
    }
    sqlSession.close();
    return insertCount;
  }

  @Override
  public int updateBoard(BoardDto board) {
    SqlSession ss = factory.openSession(false);
    int updateCount = ss.insert("com.gdu.prj.dao.board_t.updateBoard", board);
    if(updateCount == 1)
      ss.commit();
    
    ss.close();
    return updateCount;
  }

  @Override
  public int deleteBoard(int boardnum) {
    SqlSession ss = factory.openSession(false);
    int deleteCount = ss.insert("com.gdu.prj.dao.board_t.deleteBoard", boardnum);
    
    if(deleteCount == 1)
      ss.commit();
    
    ss.close();
    return deleteCount;
  }

  @Override
  public List<BoardDto> selectBoardList(Map<String, Object> params) {
    SqlSession ss = factory.openSession();
    List<BoardDto> boardList = ss.selectList("com.gdu.prj.dao.board_t.selectBoardList", params);
    
    ss.close();
    return boardList;
  }

  @Override
  public int getBoardCount() {
    
    return 0;
  }

  @Override
  public BoardDto selectBoardByNo(int boardnum) {
    
    return null;
  }

}
