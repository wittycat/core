#! /bin/bash
name=chenxun #姓名
age=26 #年龄
echo $name,$age 岁
echo HOME=$HOME
echo PWD=$PWD
echo USER=$USER
echo UID=$UID
echo SHELL=$SHELL
echo ---------------------------
if [ $UID -ne 0 ]; then
 echo 你是普通用户
else
 echo 你是root用户
# 创建完成后修改权限 ：chmod a+x xx.sh