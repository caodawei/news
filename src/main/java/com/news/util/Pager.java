package com.news.util;

public class Pager {
    private int currentPage;
    private int pageSize;
    private int totalRecores;
    private int totalPages;

    public Pager(int currentPage, int pageSize, int totalRecores) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.totalRecores = totalRecores;
        totalPages=(int)Math.ceil(totalRecores*1.0/pageSize);
    }

    /**
     * 得到第一页的页码
     * @return
     */
    public int getFirstPage(){
        return 1;
    }
    /**
     * 得到下一页的页码
     * @return
     */
    public int getNextPage(){
        return currentPage<totalPages?currentPage+1:totalPages;
    }
    /**
     * 得到上一页的页码
     * @return
     */
    public int getPreviousPage(){
        return currentPage>1?currentPage-1:1;
    }
    /**
     * 得到最后一页的页码
     * @return
     */
    public int getLastPage(){
        return totalPages;
    }

    /**
     * 当前页码
     * @return
     */
    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    /**
     * 第页记录数
     * @return
     */
    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    /**
     * 总记录数
     * @return
     */
    public int getTotalRecores() {
        return totalRecores;
    }

    public void setTotalRecores(int totalRecores) {
        this.totalRecores = totalRecores;
    }

    /**
     * 总页数
     * @return
     */
    public int getTotalPages() {
        return totalPages;
    }


}
