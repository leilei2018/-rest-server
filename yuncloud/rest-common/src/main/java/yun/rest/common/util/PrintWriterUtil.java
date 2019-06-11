package yun.rest.common.util;

import java.io.OutputStream;
import java.io.PrintWriter;

public class PrintWriterUtil {

    public static void writer(PrintWriter pw, String msg){
        pw.println(msg);
        pw.flush();
        pw.close();
    }
}
