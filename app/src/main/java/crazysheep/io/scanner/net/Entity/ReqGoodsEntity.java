package crazysheep.io.scanner.net.Entity;

/**
 * Created by Bing on 2016/12/12.
 */

public class ReqGoodsEntity {
    private String keyword;
    private int page;
    private int pageSize;

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
