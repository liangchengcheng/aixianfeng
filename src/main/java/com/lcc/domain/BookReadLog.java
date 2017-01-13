package com.lcc.domain;

import java.util.Date;

/**
 * Created by lcc on 2017/1/13.
 */
public class BookReadLog {

    private Long id;

    private Integer bookId;

    private String ipAddress;

    private Date createTime;

    private Integer type;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress == null ? null : ipAddress.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public enum BookReadType {
        TYPE_READ(1),

        TYPE_LIKE(2),

        TYPE_THUMB(3);

        private Integer id;

        BookReadType(Integer id){
            this.id = id;
        }

        public Integer getId(){
            return id;
        }
    }
}
