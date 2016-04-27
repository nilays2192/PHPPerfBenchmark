
#Introduction
This repository contains our ongoing work on PHP performance measurement benchmark. To calculate precise performance of PHP code snippet we used K-means clustering algorithm. For every input code, system generates almost 35000 to 100000 test cases and derives execution time for each test case in all PHP versions. K-means algorithm will help to classify uncertainty in the results. 
User will get results in .pdf format. We have used [JFreeChart](http://www.jfree.org/jfreechart/) API to visualize performance stats.
#Project configuration
PHP performance benchmark is mostly useful to identify precise execution time of PHP code snippet. Download requirements to configure this project is below:
*	Java JDK version 1.8, available from the [Java Download](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
*	NetBeans IDE 7.1.2 or pulse [NetBeans download](https://netbeans.org/downloads/)
*	PHP versions (as specially windows version), Min one version required but 2 or more versions will able to visualize clear picture. [Download PHP](http://php.net/downloads.php)
*	This project requires various JAR files to get execute. We have already placed required JAR files into JAR folder. 

##Changes in Config file:
If you are downloading or importing this project for the first time few things need to be changed as per your system.

```
public static int num=3; //number of compiler versions need to test
public static String PATH="C:/Users/Nilay/Documents/NetBeansProjects/PHPPerformanceBenchmark/src/phpperformancebenchmark/";
public static String[] versions={"5.5.12","5.6.13","7.0.1"};
 public static String[] path={"F:/projects/php-5.6.13-nts-Win32-VC11-x86/php.exe",
                               "F:/projects/php-7.0.1-nts-Win32-VC14-x64/php.exe",
                            "C:/wamp/bin/php/php5.5.12/php.exe"};
```
The num variable stands for number of PHP versions. (If you are dealing with just one PHP version then 1 should be placed over there). String PATH supposed to be changed with respective path of your system. (It is mandatory to give full path because it used in as command prompt arguments.) 
Path array points to location of PHP versions path. And versions array points to string name of PHP version respectively. 

###Note:
How many PHP versions considered during analysis process is defined in ‘num’ integer variable. 
###Results:
Previous execution results is placed in PHPPerfBenchmark/src/phpperformancebenchmark/results/PDFfiles/ 




