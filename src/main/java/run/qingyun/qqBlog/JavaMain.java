package run.qingyun.qqBlog;


import net.mamoe.mirai.Bot;
import net.mamoe.mirai.BotFactory;
import net.mamoe.mirai.auth.BotAuthorization;
import net.mamoe.mirai.utils.BotConfiguration;

public class JavaMain {
    public static void main(String[] args) {
        // 使用java-mirai-qrcode-0.1.jar里的获取验证码bot方法登录
        // 会自动弹出弹窗，扫码即可登录成功
        Bot bot = BotFactory.INSTANCE.newBot(2582169579L, BotAuthorization.byQRCode(), configuration -> {
            configuration.setProtocol(BotConfiguration.MiraiProtocol.ANDROID_WATCH);
        });
        bot.login();
    }
}