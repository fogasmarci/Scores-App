package com.example.scoresapp.dtos;

import com.example.scoresapp.models.TeamStats;

import java.util.List;

public class TableDTOList {
  private List<TableDataDTO> tableDTOList;

  public TableDTOList(List<TableDataDTO> tableDTOList) {
    this.tableDTOList = tableDTOList;
  }

  public List<TableDataDTO> getTableDTOList() {
    return tableDTOList;
  }
}
