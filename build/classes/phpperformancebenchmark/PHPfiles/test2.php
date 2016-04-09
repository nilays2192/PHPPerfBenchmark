<?php require('config.php');$time_taken = array();$i = 0;$start = microtime(true);$start1=$start + $min_time;while(microtime(true) <= $start1 || $i <= $min_testcases){if($i > 100000) break;$check = microtime(true);$value=array("abc","pqr","xyz");
$name="name";
$valueAry = array();
$name1=explode("]", $name);
$valueAry=array_fill_keys($name1,$value);


//please do not include any print echo statements here.
$time_taken[$i]=microtime(true) - $check;$i++;}$i--;$average1 = (array_sum($time_taken) / count($time_taken))*1000000;$result=Array($average1,$i,phpversion());print_r($i.'-'.$average1.'-'.phpversion().'Time taken=='.((microtime(true)-$start)/1000000)).'seconds';$file=$PATH.'results/test2'.phpversion().'.txt';$j=0;foreach($time_taken as $write1){ $time_taken[$j]=$write1.',';$j++;}file_put_contents($file,$time_taken);?>
