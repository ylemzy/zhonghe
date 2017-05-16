package application.uil;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/5/16.
 */

public class CsvWriter {

    private static final String NEW_LINE_SEPARATOR = "\n";

    private static CSVFormat csvFileFormat = CSVFormat.DEFAULT.withRecordSeparator(NEW_LINE_SEPARATOR);

    private static final Logger LOGGER = LoggerFactory.getLogger(CsvWriter.class);

    /* 最大条数，如果超过总条数，就重新建立一个StringBuffer,这样保证内存够用。*/
    private static final long MAX_LINE = 1000;

    private CSVPrinter csvFilePrinter;
    private StringBuffer appendable;
    private String[] headers = {
            "客户名称", "产品类型", "用户状态", "帐户余额", "可用预付金", "专款专用帐户余额"
    };

    private long line = 0;

    public CsvWriter() {
        appendable = new StringBuffer();

        try {
            csvFilePrinter = new CSVPrinter(appendable, csvFileFormat);
        } catch (IOException e) {
            LOGGER.error("getPrinter", e);
        }
        writeHeader();
    }

    private void writeHeader() {
        Collection<String> headerData = new ArrayList<>();
        for (String header : headers) {
            headerData.add(header);
        }
        write(headerData);
    }

    public void write(Collection<String> data) {
        try {
            csvFilePrinter.printRecord(data);
            /*line++;
            if (line == MAX_LINE) {
                line = 0;
                appendable = new StringBuffer();
                csvFilePrinter = new CSVPrinter(appendable, csvFileFormat);
            }*/
            //   LOGGER.info("Cvs print Record {}", JsonHelper.toJsonString(data));
        } catch (IOException e) {
            LOGGER.error("write Collection String", e);
        }
    }

    public void close() {
        try {
            csvFilePrinter.flush();
            csvFilePrinter.close();
        } catch (IOException e) {
            LOGGER.error("close", e);
        }
    }

    public String content() {
        return appendable.toString();
    }

    public StringBuffer contentBuffer() {
        return appendable;
    }


    public void write2LocalFile(String filename) {
        try {
            if (!filename.endsWith(".csv")) {
                filename += ".csv";
            }
            File newFile = new File(filename);
            if (newFile.exists())// 存在，则删除
                if (!newFile.delete())// 删除成功则创建
                {
                    System.err.println("删除文件" + newFile + "失败");
                }
            if (newFile.createNewFile()) {// 创建成功，则写入文件内容
                PrintWriter p = new PrintWriter(new FileOutputStream(newFile
                        .getAbsolutePath()));
                p.write(appendable.toString());
                p.close();
            } else {
                System.err.println("创建文件：" + newFile + "失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
