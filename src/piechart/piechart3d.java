/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package piechart;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfTemplate;
import com.itextpdf.text.pdf.PdfWriter;
import config.config;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.text.AttributedString;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Date;
import kmeans.kmeans;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.RectangleEdge;
import org.jfree.util.Rotation;
import perf.maxmin;

/**
 *
 * @author Nilay
 */
public class piechart3d {

    public void piechart(String filename, String resultFilename) {

        piechart3d p = new piechart3d();
        writeChartToPDF(p.generatePieChart(filename), 590, 360, resultFilename);

    }

    public JFreeChart generatePieChart(String filename) throws NullPointerException {

        double result[][] = kmeans_final(filename);
        DefaultPieDataset dataSet = new DefaultPieDataset();
        DecimalFormat df = new DecimalFormat("#.##");
        for (int i = 0; i < result.length; i++) {
            //  dataSet.setValue(result[i][0], "ExecutionTime", String.valueOf(result[i][1])+"-"+String.valueOf(result[i][2]));
            //dataSet.setValue(791, "Population", "1750 AD");
            dataSet.setValue(" Avg Execution time-" + String.valueOf(df.format(result[i][0])) + "micro-sec error \u00B1" + String.valueOf(df.format(result[i][2])) + " micro-sec", result[i][1]);
        }

        //   dataSet.setValue("Execution time-> 27.99 micro-sec with error-> 0.12 micro-sec",0.14393007615209483);
        //  dataSet.setValue("Execution time-29.32micro-sec with error-0.46",1.541360270065161);
        // dataSet.setValue("Execution time-34.2micro-sec with error-0.92",72.37327611022427);
        //dataSet.setValue("Execution time-59.13micro-sec with error-4.43",25.941433543558475);


        JFreeChart chart = ChartFactory.createPieChart3D(
                "Perofrmance of PHP code snippet", // chart title                   
                dataSet, // data 
                true, // include legend                   
                true,
                false);

        PiePlot3D plot = (PiePlot3D) chart.getPlot();
        plot.setStartAngle(280);
        plot.setForegroundAlpha(0.60f);
        plot.setDirection(Rotation.CLOCKWISE);
        plot.setInteriorGap(0.02);


        plot.setLabelGenerator(new CustomPieSectionLabelGenerator());
        TextTitle legendText = new TextTitle("Chart Description is below:");
        legendText.setPosition(RectangleEdge.BOTTOM);
        chart.addSubtitle(legendText);

        return chart;

    }

    public static void writeChartToPDF(JFreeChart chart, int width, int height, String fileName) {
        PdfWriter writer = null;

        Document document = new Document();

        try {
            writer = PdfWriter.getInstance(document, new FileOutputStream(
                    fileName));

             BufferedReader br = new BufferedReader(new FileReader(config.PATH + "/code.txt"));
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            String PHPcode = sb.toString();
            document.addAuthor("Nilay Shah");
            document.addCreationDate();
            document.addProducer();
            // document.addCreator(getClass().getName());
            document.addTitle("PHP Performance testing results");
            document.addKeywords("pdf, PHP performance, microsec, open source, PHP Performance Benchmark");
            document.setPageSize(PageSize.A4);

            document.open();
            document.add(new Paragraph("PHP code execution results has been generated by an open source project PHPPerformanceBenchmark."));
            document.add(new Paragraph("The results for code snippet is below:"));
            document.add(new Paragraph(PHPcode));
            document.add(new Paragraph("Created on " + new Date()));
            document.add(new Paragraph("To know more: https://github.com/nilays2192/PHPPerfBenchmark"));
            PdfContentByte contentByte = writer.getDirectContent();
            PdfTemplate template = contentByte.createTemplate(width, height);
            // Graphics2D graphics2d = template.createGraphics(width, height,
            //       new DefaultFontMapper());
            Graphics2D graphics2d = template.createGraphics(width, height);
            Rectangle2D rectangle2d = new Rectangle2D.Double(0, 0, width,
                    height);

            chart.draw(graphics2d, rectangle2d);

            graphics2d.dispose();
            contentByte.addTemplate(template, 0, 0);

        } catch (Exception  e) {
            e.printStackTrace();
        }
        document.close();
    }

    public class CustomPieSectionLabelGenerator implements PieSectionLabelGenerator {
        /*
         * other stuff...
         */

        @Override
        public String generateSectionLabel(PieDataset dataset, Comparable key) {
            StringBuilder label = new StringBuilder();
            DecimalFormat df = new DecimalFormat("#.##");
            label.append(df.format(dataset.getValue(key).doubleValue()));
            label.append(" % test-case");

            return label.toString();
        }

        @Override
        public AttributedString generateAttributedSectionLabel(PieDataset pd, Comparable cmprbl) {
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }

    public static double[][] kmeans_final(String filename) throws NullPointerException {
        String everything = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            everything = sb.toString();
            System.out.println(everything);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        String value[] = everything.split(",");

        int N = value.length - 2;
//int N=2279;
        System.out.println(N);
        int v;
        double arr[] = new double[N];
        try {
            for (v = 0; v < N; v++) {
                arr[v] = Double.parseDouble(value[v]) * 1000000;
            }


        } catch (Exception e1) {
        }
        Arrays.sort(arr);
        int cluster = 1;
        boolean flag = true;
        maxmin val = new maxmin();
        double clusters[][];
        double result[];
        kmeans k = new kmeans();
        double cluster_result[][] = new double[4][3];
        do {
            int counter = cluster++;
            System.gc();

            clusters = k.kmeans(arr, cluster);
            int br = 0;
            for (int i = 0; i <= counter; i++) {
                // br=0;
                result = val.avg(clusters[i]);
                double per = (100 * result[1]) / N;
                if (result[2] < 1 || per < 5.0) {
                    br++;

                }

                System.out.println("\navg of cluster-" + i + " is:" + result[0] + "number of values is:" + per + "% and average error is:" + result[2] + "micro sec");

            }
            System.out.println("\n \n Value of br is: " + br);
            if (br == cluster || cluster >= 4) {
                flag = false;

            } else {
                System.out.println("\n===System didn't generate optimum results with cluster-" + cluster + ".=====\n");
            }
        } while (flag && cluster < 6);
        System.out.println("====final result====");
        for (int i = 0; i < cluster; i++) {
            result = val.avg(clusters[i]);
            double per = (100 * result[1]) / N;
            System.out.println("\navg of cluster-" + i + " is:" + result[0] + " number of values is:" + per + "% and average error is:" + result[2] + "micro sec");
            cluster_result[i][0] = result[0];
            cluster_result[i][1] = per;
            cluster_result[i][2] = result[2];
        }
        return cluster_result;
    }
}
