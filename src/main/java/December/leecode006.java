package December;

import java.io.CharArrayWriter;
import java.util.ArrayList;
import java.util.List;

public class leecode006 {
    // z字形变换
    public String convert(String s, int numRows) {
        if (numRows < 2) return s;
        List<StringBuilder> rows = new ArrayList<>();
        for(int i=0;i<numRows;i++){
            rows.add(new StringBuilder());
        }
        int curRow = 0;
        int flag = -1;
        for(char c :s.toCharArray()){
            rows.get(curRow).append(c);
            if(curRow ==0 || curRow ==numRows-1){
                //变向
                flag = -flag;
            }
            curRow +=flag;
        }
        StringBuilder res = new StringBuilder();
        for(StringBuilder row : rows) res.append(row);
        return res.toString();
    }
}
