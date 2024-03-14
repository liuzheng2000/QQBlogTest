package run.qingyun.event; /**
 * Copyright 2024 json.cn
 */

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Date;

/**
 * Auto-generated: 2024-03-10 9:7:6
 * 记事本 具体文件
 * @author json.cn (i@json.cn)
 * @website http://www.json.cn/
 */
@Getter
@Setter
public class Posts {

    // 序列号
    private int id;
    // 标题
    private String title;
    // 副标题
    private String subtitle;
    // 类别
    private String category;
    // 固定
    private int pinned;
    // 文件地址？a
    private String file;
    // 标签种类
    private List<String> tags;
    // 时间
    private Date date;
    // Url地址
    private String url_name;
    // 文本内容
    private String content;

}