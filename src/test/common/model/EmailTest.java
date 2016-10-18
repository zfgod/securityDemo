package common.model;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * author: zf
 * Date: 2016/10/18  9:58
 * Description:
 */
public class EmailTest {
    public static void main(String[] args) {

    }
    @Test
    public void sendEmail() throws Exception {
        String userName = "fgodmakeit@163.com"; // 发件人邮箱
        String password = ""; // 发件人密码 :配置smtp服务时的授权码,第三方使用ssl登录时也是使用授权码
        String smtpHost = "smtp.163.com"; // 邮件服务器
//        teqxlxbwztdpijbb

        String to = "649561678@qq.com"; //收件人，多个收件人以半角逗号分隔
        String cc = "1248409549@qq.com,1372821998@qq.com"; //抄送，多个抄送以半角逗号分隔,告知收件人你把邮件同时发送给了谁
        String subject = "新主题测试"; // 主题
        String body = "内容简述"; // 正文，可以用html格式的哟
        List<String> attachments = Arrays.asList("E:\\usr\\1.jpg", "E:\\usr\\a.jnt"); // 附件的路径，多个附件也不怕

        Email email = Email.entity(smtpHost, userName, password, to, cc, subject, body, null);

        email.sendTo(); // 发送收件人！
    }
}