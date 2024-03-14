package run.qingyun.event; /**
 * Copyright 2024 json.cn
 */

import lombok.Getter;
import lombok.Setter;

import java.util.List;


/**
 * Auto-generated: 2024-03-10 9:7:6
 *
 * 记事本 JSON 文件
 * @author json.cn (i@json.cn)
 * @website http://www.json.cn/
 */

@Setter
@Getter
public class NotepadJson {
    // 标签 主题
    private List<List<Object>> tags;
    // 类别
    private List<List<Object>> categories;
    // 置顶
    private List<Integer> pins;
    // 帖子
    private List<Posts> posts;



}