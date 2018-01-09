package com.moyansz.scalescan.po;

public class Holoentgoods {
    private Integer hgoodsid;

    private Integer huserid;

    private String uuid;

    private String hgoodsname;

    private String hgoodssize;

    private String hgoodspic;

    private Float hsaleprice;

    private Float hwholesaleprice;

    public Integer getHgoodsid() {
        return hgoodsid;
    }

    public void setHgoodsid(Integer hgoodsid) {
        this.hgoodsid = hgoodsid;
    }

    public Integer getHuserid() {
        return huserid;
    }

    public void setHuserid(Integer huserid) {
        this.huserid = huserid;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid == null ? null : uuid.trim();
    }

    public String getHgoodsname() {
        return hgoodsname;
    }

    public void setHgoodsname(String hgoodsname) {
        this.hgoodsname = hgoodsname == null ? null : hgoodsname.trim();
    }

    public String getHgoodssize() {
        return hgoodssize;
    }

    public void setHgoodssize(String hgoodssize) {
        this.hgoodssize = hgoodssize == null ? null : hgoodssize.trim();
    }

    public String getHgoodspic() {
        return hgoodspic;
    }

    public void setHgoodspic(String hgoodspic) {
        this.hgoodspic = hgoodspic == null ? null : hgoodspic.trim();
    }

    public Float getHsaleprice() {
        return hsaleprice;
    }

    public void setHsaleprice(Float hsaleprice) {
        this.hsaleprice = hsaleprice;
    }

    public Float getHwholesaleprice() {
        return hwholesaleprice;
    }

    public void setHwholesaleprice(Float hwholesaleprice) {
        this.hwholesaleprice = hwholesaleprice;
    }
}