package com.company;

import com.jcraft.jsch.*;

public class copySftp {

        public void downloadFile(String username, String host, String password, String remoteDir, String localDir) {
            JSch jsch = new JSch();
            Session session = null;
            try {
                session = jsch.getSession(username, host, 22);
                session.setConfig("StrictHostKeyChecking", "no");
                session.setPassword(password);
                session.connect();

                Channel channel = session.openChannel("sftp");
                channel.connect();
                ChannelSftp sftpChannel = (ChannelSftp) channel;
                sftpChannel.get(remoteDir, localDir);
                sftpChannel.exit();
                session.disconnect();
            } catch (JSchException | SftpException e) {
                e.printStackTrace();
            }
        }
}

