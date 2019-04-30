package com.cuixx.es.common.web.page;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;

import java.util.List;

/**
 * 分页结果的封装(for Bootstrap Table)
 */
@Data
public class PageInfoBT<T> {
    // 结果集
    private List<T> rows;

    // 总数
    private long total;

    public PageInfoBT(Page<T> page) {
        this.rows = page.getRecords();
        this.total = page.getTotal();
    }
}
