package com.jxy.store.util;

import java.util.ArrayList;
import java.util.List;

public class FileUtil {
    //上传的文件的大小限制   10M  默认的是字节单位
    final int AVATAR_MAX = 1024 * 1024 * 10;
    //上传的类型限制
    static final List<String> AVATAR_TYPE = new ArrayList<>();
    static {
        AVATAR_TYPE.add("images/jpeg");
        AVATAR_TYPE.add("images/png");
        AVATAR_TYPE.add("images/gif");
    }
}
