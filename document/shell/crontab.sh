#! /bin/bash
#使用
#crontable -e 写入
#*/1 * * * *  /home/chenxun/shell/crontab.sh >>/home/chenxun/shell/tab.txt
now=$(date +%Y-%m-%d~%H:%M:%S)
echo 当前时间: $now
