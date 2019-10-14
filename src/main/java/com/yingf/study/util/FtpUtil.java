package com.yingf.study.util;

import org.apache.commons.net.ftp.FTPClient;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FtpUtil {

//ftpuser/imageftp
    public  static void ftpUpload() throws IOException {
        //1、连接ftp服务器
        FTPClient ftpClient = new FTPClient();
        ftpClient.connect("10.252.21.206",21);
        //登陆ftp服务器
        ftpClient.login("ftpuser","imageftp");
        //读取本地的文件，要上传的文件
         FileInputStream inputStream = new FileInputStream(new File("E:/Jsource/FilePath/222.jpg"));
         //上传到指定的目录
        ftpClient.changeWorkingDirectory("/home/ftpuser/images");
        //指定文件类型
        ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
        //文件在远程服务器上面的名字
        ftpClient.storeFile("test1.jpg",inputStream);
        //退出登陆
        ftpClient.logout();
    }

    public static void main(String[] args) throws IOException {
        ftpUpload();
    }

   /* //1、连接ftp服务器
　　FTPClient ftpClient = new FTPClient();
　　ftpClient.connect("192.168.113.129", 21);
　　//2、登录ftp服务器
        　　ftpClient.login("ftpuser", "wangxiaodong1");
　　//3、读取本地文件（获取本地文件的地址后，用于之后的上传）
        　　FileInputStream inputStream = new FileInputStream(new File("D:\\document\\test\\天猫图片\\微信图片_20181106230112.jpg"));
　　//4、上传文件
        　　//1）指定上传目录
        　　ftpClient.changeWorkingDirectory("/home/ftpuser/www");
　　//2）指定文件类型
        　　ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
　　//第一个参数：文件在远程服务器的名称
        　　//第二个参数：文件流
        　　ftpClient.storeFile("hello.jpg", inputStream);
　　//5、退出登录
        　　ftpClient.logout();*/

}
