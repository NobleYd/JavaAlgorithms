package tools;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URISyntaxException;

public class _EncodingTools {
    static String project_path;
    static String utf8 = "UTF-8";
    static String gbk = "GBK";
    static {
        try {
            project_path = _EncodingTools.class.getResource("/").toURI().getPath();
            project_path = project_path.replace("target/classes", "main/src/java");
            System.out.println(project_path);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    static void deal(String packagePath, String from, String to) throws IOException {
        String path = project_path + packagePath;
        File f = new File(path);
        if (f.isDirectory()) {
            for (File f0 : f.listFiles()) {
                if (f0.isFile())
                    dealFile(f0, from, to);
            }
        } else {
            System.out.println("Not directory.");
        }
    }

    static void dealFile(File file, String from, String to) throws IOException {
        System.out.println("Deal file: " + file.getPath());
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), from));
        StringBuffer content = new StringBuffer(System.lineSeparator());
        String tmp;
        while ((tmp = reader.readLine()) != null) {
            content.append(tmp + System.lineSeparator());
        }
        reader.close();
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), to));
        writer.write(content.toString());
        writer.flush();
        writer.close();
    }

    public static void main(String[] args) throws IOException {
        deal("", gbk, utf8);
    }
}