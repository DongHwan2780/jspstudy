package com.gdu.prj.utils;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class MyPageUtils {

  private int total;    // 전체 게시글 수(DB에서 구한다)
  private int display;    // 한 페이지를 표시할 페이지의 개수(요청 파라미터로 받는다)
  private int page;   // 현재 페이지 번호(요청 파라미터로 받는다)
  private int begin;    // 한 페이지에 표시할 게시글의 시작 번호(계산)
  private int end;    // 한 페이지에 표시할 게시글의 종료 번호(계산)
  
  private int totalPage;    // 전체 페이지 개수
  private int pagePerBlock = 10;    // 한 블록에 표시할 페이지 링크의 개수(임의 결정)
  private int beginPage;    // 한 블록에 표시할 페이지 링크의 시작 번호(계산)
  private int endPage;    // 한 블록에 표시할 페이지 링크의 종료 번호(계산)
  
  public void setPaging(int total, int display, int page)
  {
    this.total= total;  
    this.display = display;
    this.page = page;
    
    begin = (page - 1) * display + 1;
    end = begin + display - 1;
    
    totalPage = (int)Math.ceil((double)(total / display));
    beginPage = ((page - 1) / pagePerBlock) * pagePerBlock + 1;
    endPage = Math.min(totalPage, beginPage + pagePerBlock - 1);
  }
  
  public String getPaging(String url, String sort, int display) 
  {
    StringBuilder sb = new StringBuilder();
    
    if(beginPage == 1)
      sb.append("<div class=\"dont-click\">&lt;</div>");
    else
      sb.append("<div><a href=\"" + url + "?page=" + (beginPage - 1) + "&sort="+ sort +"&display=" + display +"\"> &lt;</a></div>");
    
    for(int i = beginPage; i <= endPage; i++)
    {
      if(i == page)
        sb.append("<div><a class=\"current-page\" href=\"" + url + "?page=" + i + "&sort=" + sort + "&display=" + display + "\">" + i + "</a></div>");
      else
        sb.append("<div><a href=\"" + url + "?page=" + i + "&sort=" + sort + "&display=" + display + "\">" + i + "</a></div>");
    }
    
    
    if(endPage == totalPage)
      sb.append("<div class=\"dont-click\">&gt;</div>");
    else
      sb.append("<div><a href=\"" + url + "?page=" + (endPage + 1) + "&sort=" + sort +"&display=" + display + "\"> &gt;</a></div>");
    
    
    return sb.toString();
  }
}
