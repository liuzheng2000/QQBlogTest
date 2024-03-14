package run.qingyun.CreateJsonFile;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import run.qingyun.event.FileNameAndCount;
import run.qingyun.event.NotepadJson;
import run.qingyun.event.Posts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 记事本JSON
 */
public class CreateNotepadJson {
    public static void main(String[] args) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        NotepadJson notepadJson = CreateNotepadJson();
        String TextJson = gson.toJson(notepadJson);
        System.out.println(TextJson);
    }


    //产生记事本JSON
    private static NotepadJson CreateNotepadJson(){
        NotepadJson notepadJson = new NotepadJson();


        List<List<Object>> TapsList = new ArrayList<>();

        List tapList = new <String>ArrayList();
        tapList.add("测试");
        tapList.add(2);
        TapsList.add(tapList);
        notepadJson.setTags(TapsList);
        notepadJson.setCategories(TapsList);
        notepadJson.setPins(Collections.singletonList(1));
        Posts post = CreatePostsText();
        Posts post1 = CreatePostsTextTwo();
        Posts post2 = CreatePostsTextThere();
        List<Posts> posts = new ArrayList<>();
        posts.add(post);
        posts.add(post1);
        posts.add(post2);
        notepadJson.setPosts(posts);
        return notepadJson;
    }


    // 文本类型测试
    private static Posts CreatePostsText(){
        Posts posts = new Posts();
        posts.setId(1);
        posts.setTitle("测试记事本");
        posts.setSubtitle("Test记事本");
        posts.setCategory("测试");
        posts.setPinned(1);
        posts.setFile("/content/posts/Test.md");
        List<String> TagsList = new ArrayList<>();
        TagsList.add("测试");
        posts.setTags(TagsList);
        posts.setUrl_name("/Index");
        posts.setContent( "按分类检索：\n\n<BlogIndex/>\n\n按主题检索：\n\n<BlogIndex mode=\"categories\"/>");
        return posts;
    }

    // 文本类型测试 （md 文档）
    private static Posts CreatePostsTextTwo(){
        Posts posts = new Posts();
        posts.setId(2);
        posts.setTitle("测试记事本222");
        posts.setSubtitle("Test记事本222");
        posts.setCategory("测试2342");
//        posts.setFile("/content/posts/Test.md");
        List<String> TagsList = new ArrayList<>();
        TagsList.add("测试7978");
        posts.setTags(TagsList);
        posts.setUrl_name("/Index/TextTwo");
        posts.setContent("欢迎欢迎！我是 UofT 的大一新生，这是我在宿舍折腾网络的一篇记录w\\n\\n## 1. 搭建 FRP 实现内网穿透\\n \\n\\n\\n## 2. OpenWRT 中继学校 WPA-EAP 网络实现远程重启\\n\\n搭建好内网穿透之后又遇到了新的问题——因为台式机服务器装的黑苹果配置不是很稳定，它有时候会整个屏幕绿掉，必须强制重启才行，应该是 kernel panic 吧。我不在宿舍的时候回宿舍重启又太麻烦了，如果可以远程重启...\\n\\n想起来之前摸鱼的时候看到向日葵有做过远程重启的设备，所以就去查了下，结果发现就只是一个智能插座，在主板上配置好插电自动开机就好啦。但是这又有一个问题——宿舍里所有的网络，无论是 UofT Wifi 还是 eduroam 还是有线以太网，都需要 WPA/WPA2/WPA3-Enterprise EAP PEAP MSCHAPv2 用户名+密码验证... 可是智能插座只支持简单的 WPA-PSK 密码验证。所以就需要一个可以连上外网、又可以开 WPA-PSK WiFi 的无线路由器了。\\n\\n刚开始，我想过几个不同的方案：\\n\\n### a. 用手机连 Wifi 开热点（失败）\\n\\n之前无意间发现了我的 Mi Mix2S (Android 11 EvolutionX) 可以边连 Wifi 边开热点，不知道是怎样实现的。所以我想，如果用旧的华为 Mate8 这样一边连着学校的 PEAP 一边开热点就可以了。但是开机之后，我发现 Mate8 的原生系统 Android 8 EMUI 8.0 并不支持同时连 Wifi 开热点。我听说用 VPN Hotspot 可以实现无线中继，下载试了下却发现没有 Root 就不能改 SSID 和密码，每次开的 SSID 和密码都是随机的。所以花了超级多精力解锁 BootLoader、刷 Magisk、然后发现 Root 之后也不能改无线中继的 SSID 和密码... 改完之后重开中继的 SSID 还是 DIRECT-{随机}-HUAWEI, 密码还是八位随机字符。不过还是试了下用智能插座连这个无限中继，只能赌无线中继不会重启、不会关机、不会被电源管理杀掉... \\n\\n结果是，在台式死机之前智能插座就先下线了，回宿舍看了一眼发现手机不知道为什么重启进 Recovery 了。失败失败（\\n\\n### b. 用手机连数据卡开热点（太贵了）\\n\\n然后想到如果可以再买一张手机卡只用来开热点就解决了嘛，但是发现这边不像国内那样 ￥10/mo 就能买一张卡，这边最便宜的流量卡要 CA$15/mo，换算出来要 ￥75/mo 了，够买一个路由器了（\\n\\n### c. 用路由器中继\\n\\n然后就是现在的解决方案啦，用路由器中继学校的 PEAP。首先要做的是买一个路由器，可是这边新的路由器也真的很贵，亚马逊上最便宜的 TP-Link AC750 要 $35 = ￥175... 所以去二手市场逛了逛，很幸运的看到了附近有人 $10 出路由器，一个 Netis WF2780 和一个小米路由 R4。\\n\\n首先试了 WF2780，但是它好像没接好 WAN 就完全不能用的样子，SYS 灯一直在闪，网线连上电脑也没办法获取到 IP，手动分配 IP 到 192.168.1.2 也进不去管理页面。可能是坏了吧，也可能这个路由器本来就是这样？不懂，下一个（\\n\\n然后试了 R4，可是用小米官方的固件，无限桥接模式并不能连上 PEAP 验证的 UofT Wifi 或者 eduroam，有线桥接模式把 WAN 口接上也提示识别错误。所以只能试试 OpenWRT 啦。\\n\\n### 1. 给小米路由 R4 刷 OpenWRT\\n\\n这里我跟了 https://www.wyr.me/post/619 这个教程，很轻松地就刷好了！\\n\\n在电脑上要做的事情：\\n\\n1. 网线连上路由器，登录管理后台（我是 http://192.168.31.1)\\n2. 复制管理后台登录之后 URL 里面的 stok 参数\\n3. 执行以下指令，输入路由器的 IP 和刚才复制的 stok\\n\\n```sh\\ngit clone https://github.com/acecilia/OpenWRTInvasion\\ncd OpenWRTInvasion\\npip3 install -r requirements.txt\\npython3 remote_command_execution_vulnerability.py\\n```\\n\\n然后就有 ssh 啦！接下来用了这个固件：https://github.com/ioiotor/mir4-ss，下载 [openwrt-ramips-mt7621-xiaomi_mir4-squashfs-kernel1.bin](https://github.com/ioiotor/mir4-ss/releases/download/V19.07.4/openwrt-ramips-mt7621-xiaomi_mir4-squashfs-kernel1.bin) 和 [openwrt-ramips-mt7621-xiaomi_mir4-squashfs-rootfs0.bin](https://github.com/ioiotor/mir4-ss/releases/download/V19.07.4/openwrt-ramips-mt7621-xiaomi_mir4-squashfs-rootfs0.bin)\\n\\n4. 在电脑上执行以下指令：\\n\\n```sh\\nmkdir temp\\ncd temp\\nwget https://github.com/ioiotor/mir4-ss/releases/download/V19.07.4/openwrt-ramips-mt7621-xiaomi_mir4-squashfs-kernel1.bin\\nwget https://github.com/ioiotor/mir4-ss/releases/download/V19.07.4/openwrt-ramips-mt7621-xiaomi_mir4-squashfs-rootfs0.bin\\npython3 -m http.server\\n```\\n\\n5. 登录进 SSH Shell 之后在路由器上执行指令：\\n\\n```sh\\ncd /tmp\\nwget http://{电脑 IP 地址}/openwrt-ramips-mt7621-xiaomi_mir4-squashfs-kernel1.bin\\nwget http://{电脑 IP 地址}/openwrt-ramips-mt7621-xiaomi_mir4-squashfs-rootfs0.bin\\nmtd write openwrt-ramips-mt7621-xiaomi_mir4-squashfs-kernel1.bin kernel1\\nmtd write openwrt-ramips-mt7621-xiaomi_mir4-squashfs-rootfs0.bin rootfs0\\nnvram set flag_try_sys1_failed=1\\nnvram commit\\nreboot\\n```\\n\\n然后就好啦，重启之后就是 OpenWRT 了（虽然默认没有开 WLAN，所以只能网线连到路由器）\\n\\n### 2. OpenWRT 连接到 PEAP 网络\\n\\n登录上管理页面，改完管理密码之后，我试了直接把 wlan0 改成 client mode 去连学校的网，但是发现这里也只支持密码验证的 WPA-PSK 而不支持用户名+密码的 WPA-EAP。然后查了一下发现只要把预装的 wpad-basic 换成完整的 wpa-cli + wpa-supplicant + hostapd 就可以了。但是还有一个问题就是我的路由器现在没有网，所以不能在线安装软件包。我的解决方案是用电脑先连上学校的 WIFI，再把电脑的网线连到路由器的 LAN 口上，然后在电脑上开桥接模式路由器就有网了！\\n\\n之后，ssh 进路由器，执行以下指令：\\n\\n```sh\\nopkg update\\nopkg remove wpad-basic\\nopkg install wpa-cli wpa-supplicant hostapd nano\\nreboot\\n```\\n\\n等重启好之后，管理页面里面 Wireless Security 那一栏的验证方式里面就有 WPA2-EAP 了！接下来把学校的验证信息填进去，然后保存就连上啦！UofT 的配置如下：\\n\\n```txt\\nEncryption : WPA2-EAP (strong security)\\nCipher     : auto\\nEAP-Method : PEAP\\n...\\nCertificate Constraaint (Domain) : radius.wireless.utoronto.ca\\n...\\nAuthentication : EAP-MSCHAPv2\\nIdentity       : 你的 UTORid\\nPassword       : 你的 UTORid 密码\\n```\\n\\n接下来把 WIFI 配置一下，让智能插座连上这个 WIFI 就好了！");
        return posts;
    }



    // 文本类型测试 （md 文档）
    private static Posts CreatePostsTextThere(){
        Posts posts = new Posts();
        posts.setId(2);
        posts.setTitle("测试记事本333");
        posts.setSubtitle("Test记事本333");
        posts.setCategory("测试2342");
//        posts.setFile("/content/posts/Test.md");
        List<String> TagsList = new ArrayList<>();
        TagsList.add("测试7978");
        posts.setTags(TagsList);
        posts.setUrl_name("/Index/TextThere");
        posts.setContent("1. 准备 Vmware Workstation\n" +
                "2. 下载 CentOS 7.9 iso 镜像 推荐地址\n" +
                "\n" +
                "[兰州大学镜像站](https://mirror.lzu.edu.cn/centos/7.9.2009/isos/x86_64/)\n" +
                "\n" +
                "3. 使用 Vmware Workstation 安装\n" +
                "\n" +
                "![image.png](https://cdn.nlark.com/yuque/0/2024/png/42913981/1709773407413-70b5135f-9d2c-4461-a409-35ddddf497fd.png#averageHue=%23f0f0ef&clientId=u0e4c37e3-cee0-4&from=paste&height=430&id=u28528779&originHeight=538&originWidth=563&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=21557&status=done&style=none&taskId=u393b4d3b-63d6-41cf-b0f7-1460a550618&title=&width=450.4)\n" +
                "\n" +
                "4. 安装完成界面\n" +
                "\n" +
                "![image.png](https://cdn.nlark.com/yuque/0/2024/png/42913981/1709773860366-079379b5-dc11-4950-bec6-76550d6b25dd.png#averageHue=%23e8e8e6&clientId=u0e4c37e3-cee0-4&from=paste&height=468&id=ucfa4f4b0&originHeight=585&originWidth=795&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=99002&status=done&style=none&taskId=u0f9264eb-9cd6-4f21-8c0a-bc83f19e841&title=&width=636)\n" +
                "\n" +
                "5. 进行远程连接 （使用Xshell） ip addr 查看Ip 地址 使用账户 密码登录\n" +
                "\n" +
                "![image.png](https://cdn.nlark.com/yuque/0/2024/png/42913981/1709774409125-19b7fdf2-6ec2-4419-a186-fbe872301aa8.png#averageHue=%23090705&clientId=u0e4c37e3-cee0-4&from=paste&height=262&id=ueeb36d6f&originHeight=327&originWidth=836&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=30891&status=done&style=none&taskId=u8a2089ba-73a5-449d-bf81-41732ec3a1b&title=&width=668.8)\n" +
                "![image.png](https://blog-qingyun.oss-cn-beijing.aliyuncs.com/content/generated/image.png)\n");
        return posts;
    }


}
