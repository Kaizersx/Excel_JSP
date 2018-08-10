
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.apache.poi.ss.usermodel.CellType.NUMERIC;
import static org.apache.poi.ss.usermodel.CellType.STRING;


public class Excel {

    public ArrayList<Map<String,Integer>>valuesInteraction() throws IOException {

        ArrayList<Map<String,Integer>>result=new ArrayList<>();

        Map<String, Integer> interactions = new HashMap<>();
        Map<String, Integer> values = new HashMap<>();
        File file = new File("C:\\TestJava\\test2.xls");
        HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(file));
        HSSFSheet sheet = workbook.getSheetAt(0);
        for (int r = 1; r < sheet.getLastRowNum() + 1; r++) {
            StringBuilder data = new StringBuilder();
            HSSFRow row = sheet.getRow(r);
            for (int c = 0; c < row.getLastCellNum(); c++) {
                CellType cellType = row.getCell(c).getCellTypeEnum();
                if (cellType == STRING) {
                    data.append(row.getCell(c).getStringCellValue());
                    data.append(" ");
                }
                if (cellType == NUMERIC) {
                    data.append(row.getCell(c).getNumericCellValue());
                    data.append(" ");
                }
            }
            String[] str = data.toString().split(" ");
            if (interactions.get(str[0]) == null) {
                interactions.put(str[0], Math.round(Float.parseFloat(str[1])));
            } else {
                interactions.put(str[0], Math.round(Float.parseFloat(str[1]) + interactions.get(str[0])));
            }

            if (values.get(str[0]) == null) {
                values.put(str[0], Math.round(1.0f));
            } else {
                values.put(str[0], Math.round(1.0f + values.get(str[0])));
            }
        }
        workbook.close();

        result.add(values);
        result.add(interactions);

        return result;

    }
}








