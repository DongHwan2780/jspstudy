package com.gdu.prj.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.gdu.prj.common.ActionForward;
import com.gdu.prj.dao.BoardDao;
import com.gdu.prj.dao.BoardDaoImpl;
import com.gdu.prj.dto.BoardDto;
import com.gdu.prj.utils.MyPageUtils;

import jakarta.servlet.http.HttpServletRequest;

/*
 * view - filter - controller - service - dao - db
 * */

public class BoardServiceImpl implements BoardService {

  // service 는 dao를 호출
  private BoardDao boardDao = BoardDaoImpl.getInstance();
  
  // 목록 보기는 MyPageUtils 객체가 필요
  private MyPageUtils mpu = new MyPageUtils();
  
  @Override
  public ActionForward addBoard(HttpServletRequest request) {
    String title = request.getParameter("title");
    String contents = request.getParameter("contents");
    BoardDto board = BoardDto.builder()
          .title(title)
          .contents(contents).build();
    
    int insertCount = boardDao.insertBoard(board);
    
    
    // redirect 경로는 URLMapping 으로 작성한다
    String view = null;
    if(insertCount == 1)
      view = request.getContextPath() + "/board/list.brd";
    else if(insertCount == 0)
      view = request.getContextPath() + "/main.brd";
    
    // insert 이후 이동은 redirect
    return new ActionForward(view, true);
  }

  @Override
  public ActionForward getBoardList(HttpServletRequest request) {
    int total = boardDao.getBoardCount();

    // 한 페이지 당 게시글 개수
    Optional<String> optDisplay = Optional.ofNullable(request.getParameter("display"));
    int display = Integer.parseInt(optDisplay.orElse("10"));
    
    // 현재 페이지 번호
    Optional<String> optPage = Optional.ofNullable(request.getParameter("page"));
    int page = Integer.parseInt(optPage.orElse("1"));
    
    Optional<String> optSort = Optional.ofNullable(request.getParameter("sort"));
    String sort = optSort.orElse("DESC");
    
    // 페이징 처리에 필요한
    mpu.setPaging(total, display, page);
    
    // 목록을 가져올 때 필요한 변수를 Map 에 저장함
    Map<String, Object> params = Map.of("begin", mpu.getBegin(), "end", mpu.getEnd(), "sort", sort);
    
    // 목록 가져오기
    List<BoardDto> boardList = boardDao.selectBoardList(params);
    
    
    // 페이지 링크 가져오기
    String paging = mpu.getPaging(request.getRequestURI(), sort, display);
    
    request.setAttribute("boardCount", total);
    request.setAttribute("boardList", boardList);
    request.setAttribute("paging", paging);
    request.setAttribute("display", display);
    request.setAttribute("sort", sort);
    
    return new ActionForward("/board/list.jsp", false);
  }

  @Override
  public ActionForward getBoardByNo(HttpServletRequest request) {
    Optional<String> opt = Optional.ofNullable(request.getParameter("board_no"));
    int boardNum = Integer.parseInt(opt.orElse("0"));
    BoardDto board = boardDao.selectBoardByNo(boardNum);
    String view = null;
    if(board != null)
    {
      view = "/board/detail.jsp";
      request.setAttribute("board", board);
    }
    else
    {
      view = "/index.jsp";
    }
    return new ActionForward(view, false);
  }

  @Override
  public ActionForward editBoard(HttpServletRequest request) {
    int boardNum = 0;
    String nullCheck = request.getParameter("board_no");
    String view = null;
    if(!nullCheck.isEmpty())
    {
      boardNum = Integer.parseInt(request.getParameter("board_no"));
    }
    
    BoardDto board = boardDao.selectBoardByNo(boardNum);
    if(board != null)
    {
      view = "/board/edit.jsp";
      request.setAttribute("board", board);
    }
    else
    {
      view = "/index.jsp";
    }
    return new ActionForward(view, false);
  }

  @Override
  public ActionForward modifyBoard(HttpServletRequest request) {
    int boardNum = Integer.parseInt(request.getParameter("board_no"));
    String title = request.getParameter("title");
    String contents = request.getParameter("contents");
    
    BoardDto board = BoardDto.builder()
          .title(title)
          .contents(contents)
          .board_no(boardNum).build();
    
    int updateCount = boardDao.updateBoard(board);
    String view = null;
    if(updateCount == 1)
      view = request.getContextPath() + "/board/detail.brd?board_no=" + boardNum;
    else if(updateCount == 0)
      view = request.getContextPath() + "/main.brd";
    
    return new ActionForward(view, true);
  }

  @Override
  public ActionForward removeBoard(HttpServletRequest request) {
    int boardNum = 0;
    String nullCheck = request.getParameter("board_no");
    if(!nullCheck.isEmpty())
    {
      boardNum = Integer.parseInt(request.getParameter("board_no"));
    }
    
    int deleteCount = boardDao.deleteBoard(boardNum);
    String view = null;
    
    if(deleteCount == 1)
      view = request.getContextPath() + "/board/list.brd";      
    else if(deleteCount == 0)
      view = request.getContextPath() + "/main.brd";
    
    return new ActionForward(view, true);
  }
  
  @Override
  public ActionForward removeBoards(HttpServletRequest request) {
    
    String param = request.getParameter("param");
    int deleteCount = boardDao.deleteBoards(param);
    String view = null;
    if(deleteCount == 0) {
      view = request.getContextPath() + "/main.brd";
    } else {
      view = request.getContextPath() + "/board/list.brd";
    }
    return new ActionForward(view, true);
  }
}
