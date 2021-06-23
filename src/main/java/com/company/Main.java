package com.company;


public class Main {

    public static void main(String[] args) throws Exception {
        fileReader2 data =new  fileReader2();
        data.extract();

        String sql_username = data.sql_username;
        String sql_password = data.sftp_password;
        String sql_url = data.sql_url;
        String sftp_username = data.sftp_user;
        String sftp_remoteHost = data.sftp_host;
        String sftp_password = data.sftp_password;
        String remoteDir = data.sftp_remote_dir;
        String localDir = data.local_dir;

        copySftp download = new copySftp();

        download.downloadFile(sftp_username,sftp_remoteHost,sftp_password,remoteDir,localDir );

        connectSql connect = new connectSql();


        connect.connection(sql_url, sql_username, sql_password);



    }
}
