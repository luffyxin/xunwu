package com.xin.xunwu.entity;

import javax.persistence.*;

@Table(name = "`support_address`")
public class SupportAddress {
    @Id
    @Column(name = "`id`")
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    @Column(name = "`belong_to`")
    private String belongTo;

    @Column(name = "`en_name`")
    private String enName;

    @Column(name = "`cn_name`")
    private String cnName;

    @Column(name = "`level`")
    private String level;

    @Column(name = "`baidu_map_lng`")
    private Double baiduMapLng;

    @Column(name = "`baidu_map_lat`")
    private Double baiduMapLat;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return belong_to
     */
    public String getBelongTo() {
        return belongTo;
    }

    /**
     * @param belongTo
     */
    public void setBelongTo(String belongTo) {
        this.belongTo = belongTo;
    }

    /**
     * @return en_name
     */
    public String getEnName() {
        return enName;
    }

    /**
     * @param enName
     */
    public void setEnName(String enName) {
        this.enName = enName;
    }

    /**
     * @return cn_name
     */
    public String getCnName() {
        return cnName;
    }

    /**
     * @param cnName
     */
    public void setCnName(String cnName) {
        this.cnName = cnName;
    }

    /**
     * @return level
     */
    public String getLevel() {
        return level;
    }

    /**
     * @param level
     */
    public void setLevel(String level) {
        this.level = level;
    }

    /**
     * @return baidu_map_lng
     */
    public Double getBaiduMapLng() {
        return baiduMapLng;
    }

    /**
     * @param baiduMapLng
     */
    public void setBaiduMapLng(Double baiduMapLng) {
        this.baiduMapLng = baiduMapLng;
    }

    /**
     * @return baidu_map_lat
     */
    public Double getBaiduMapLat() {
        return baiduMapLat;
    }

    /**
     * @param baiduMapLat
     */
    public void setBaiduMapLat(Double baiduMapLat) {
        this.baiduMapLat = baiduMapLat;
    }
}