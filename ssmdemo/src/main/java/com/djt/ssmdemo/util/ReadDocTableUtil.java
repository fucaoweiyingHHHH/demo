package com.djt.ssmdemo.util;


import org.apache.poi.xwpf.usermodel.*;

import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPr;
import org.springframework.util.StringUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * @author DongJianTing
 * @Date 2019-06-11
 *
 */
public class ReadDocTableUtil {
    public static void main(String[] args) {
        XWPFDocument document = null;
        try {
            document = new XWPFDocument(new FileInputStream("D:/Table.docx"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 获取所有表格
        List<XWPFTable> tables = document.getTables();
        for (XWPFTable table : tables) {
            // 获取表格的行
            List<XWPFTableRow> rows = table.getRows();
            for (int i = 0; i < rows.size(); i++) {
                List<String> rowsData = getTableRow(i, rows);
                for (int j = 0; j < rowsData.size(); j++) {
                    if (!StringUtils.isEmpty(rowsData.get(j))) {
                        System.err.println(rowsData.get(j));
                    }
                }
            }
        }
    }
    private static List<String> getTableRow(int tableCell, List<XWPFTableRow> tableRowsDataList){
        if(tableRowsDataList.size()>=tableCell){
            XWPFTableRow rows= tableRowsDataList.get(tableCell);
            List<String> files=new ArrayList<>();
            for (XWPFTableCell cell  :rows.getTableCells()) {
                CTTcPr tt = cell.getCTTc().getTcPr();
                if(tt.getVMerge()!=null){
                    System.out.println(tableCell);
                    if (tt.getVMerge().getVal() != null && "restart".equals(tt.getVMerge().getVal().toString())) {

                    }
                }
                files.add(cell.getText());
            }
            return files;
        }
        return null;
    }
}
