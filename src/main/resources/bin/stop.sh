#!/bin/sh
#
# kill cloud service
#
###EOF

prog=service_demo

pid=`ps ax|grep $prog | grep java | grep -v grep|awk '{print $1}'`
if [ ! "$pid" ];then
  echo "$prog is not running"
else
  echo -e "kill $prog : $pid"
  kill -9 $pid
fi

exit 0
