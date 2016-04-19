/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package phpperformancebenchmark;

import config.config;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import piechart.piechart3d;
import testing.tool.calculateresult;
import testing.tool.phpcreator;

/**
 *
 * @author Nilay
 */
public class PHPPerformanceBenchmark {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String PHPcode = "";
        String filename = "";
        config config = new config();
        try {

            BufferedReader br = new BufferedReader(new FileReader(config.PATH + "/code.txt"));
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            PHPcode = sb.toString();
            BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter code name to generaate result file: ");
            filename = br1.readLine();
            System.out.println("input code: " + filename + ":\n" + PHPcode);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        phpcreator file = new phpcreator();
        file.createfile(filename, PHPcode);
        calculateresult r = new calculateresult();
        for (int i = 0; i < config.num; i++) {
            r.result(filename, config.path[i]);
        }
        String ResultPath = config.PATH + "results/";
        piechart3d pdf = new piechart3d();
        for (int i = 0; i < config.num; i++) {
            String temp = filename + "_" +config.versions[i];
            pdf.piechart(ResultPath + temp + ".txt", ResultPath + "PDFfiles/" + temp + ".pdf");
            System.out.println(ResultPath + "PDFfiles/" + temp + ".pdf is generated successfully!");
        }

    }
}
