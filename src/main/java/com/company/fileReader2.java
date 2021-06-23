package com.company;


import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class fileReader2  {
    private List<String> lines = new ArrayList<>();
    public String[] arr = new String[10];

    public void extract() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Scanner in = new Scanner(System.in);
        String path = in.nextLine();
        File f = new File(path);
        BufferedReader fin = new BufferedReader(new FileReader(f));

        String name;
        String line;
        System.out.println("Print File " + f.getName() + "? y/n");
        name = br.readLine();

        if (name.equals("y"))
            while ((line = fin.readLine()) != null) {
                StringTokenizer tokenizer = new StringTokenizer(line, "=");
                if (!(line.startsWith("="))) {
                    tokenizer.nextToken();
                }
                String host = tokenizer.nextToken();
                lines.add(host);
            }
//        System.out.println(lines);
        arr = lines.toArray(new String[10]);
        sftp_host = arr[0];
        sftp_port = arr[1];
        sftp_user = arr[2];
        sftp_password = arr[3];
        sftp_remote_dir = arr[4];
        local_dir = arr[5];
        sql_url = arr[6];
        sql_username = arr[7];
        sql_password = arr[8];
        sql_database = arr[9];




    }
    String sftp_host;
//    public void print(){
//        System.out.println(sftp_host);
//
//    }
    String sftp_port;
    String sftp_user;
    String sftp_password;
    String sftp_remote_dir;
    String local_dir;
    String sql_url;
    String sql_username;
    String sql_password;
    String sql_database;
}
