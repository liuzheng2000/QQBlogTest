package run.qingyun.event;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 统计文件和名字
 * name
 * count
 */
@Setter
@Getter
public class FileNameAndCount {

    private List<List<Object>> FileNameAndCounts;
}
