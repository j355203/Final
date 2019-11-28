package finalProject.eeit10904.utils;

import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CsvUtils {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static byte[] exportCSV(LinkedHashMap<String, String> headers, List<LinkedHashMap<String, Object>> exportData) {

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        BufferedWriter bw = null;

        try {
            // 編碼big5，處理excel開啟csv的時候會出現的標題中文亂碼
        	bw = new BufferedWriter(new OutputStreamWriter(baos, "big5"));
            // 寫入csv檔案的標題列
            Map.Entry propertyEntry = null;
            for (Iterator<Map.Entry<String, String>> propertyIterator = headers.entrySet().iterator(); propertyIterator.hasNext();) {
                propertyEntry = propertyIterator.next();
                bw.write(propertyEntry.getValue().toString());
                if (propertyIterator.hasNext()) {
                	bw.write(",");
                }
            }
            bw.newLine();
            // 寫入檔案內容
            LinkedHashMap row = null;
            for (Iterator<LinkedHashMap<String, Object>> iterator = exportData.iterator(); iterator.hasNext(); ) {
                row = iterator.next();
                for (Iterator<Map.Entry> propertyIterator = row.entrySet().iterator(); propertyIterator.hasNext(); ) {
                    propertyEntry = propertyIterator.next();
                    bw.write(propertyEntry.getValue().toString());
                    if (propertyIterator.hasNext()) {
                    	bw.write(",");
                    }
                }
                if (iterator.hasNext()) {
                	bw.newLine();
                }
            }
            // 清理緩衝區
            bw.flush();
        } catch (IOException e) {
        	e.printStackTrace();
        } finally {
            // 釋放資源
            if (bw != null) {
                try {
                	bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return baos.toByteArray();
    }
}
