package com.gdu.prj.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class BoardDto {
  private int board_no;
  private String title, contents;
  private Date modified_at, created_at;
}
