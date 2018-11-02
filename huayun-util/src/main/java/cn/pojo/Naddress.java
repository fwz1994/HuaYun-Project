package cn.pojo;

/**
 * 收货地址
 */
public class Naddress {

  private Integer nid;        //收货地址ID
  private Integer nuid;       //用户ID
  private String nname;       //用户姓名
  private String nphone;      //用户手机号
  private String nsheng;      //省份
  private String nshi;        //市
  private String nqu;         //区
  private String ndetail;     //详细地址
  private Integer npostcode;  //邮政编号
  private Integer nxianshi;   //地址显示状态

  public Integer getNid() {
    return nid;
  }

  public void setNid(Integer nid) {
    this.nid = nid;
  }

  public Integer getNuid() {
    return nuid;
  }

  public void setNuid(Integer nuid) {
    this.nuid = nuid;
  }

  public String getNname() {
    return nname;
  }

  public void setNname(String nname) {
    this.nname = nname;
  }

  public String getNphone() {
    return nphone;
  }

  public void setNphone(String nphone) {
    this.nphone = nphone;
  }

  public String getNsheng() {
    return nsheng;
  }

  public void setNsheng(String nsheng) {
    this.nsheng = nsheng;
  }

  public String getNshi() {
    return nshi;
  }

  public void setNshi(String nshi) {
    this.nshi = nshi;
  }

  public String getNqu() {
    return nqu;
  }

  public void setNqu(String nqu) {
    this.nqu = nqu;
  }

  public String getNdetail() {
    return ndetail;
  }

  public void setNdetail(String ndetail) {
    this.ndetail = ndetail;
  }

  public Integer getNpostcode() {
    return npostcode;
  }

  public void setNpostcode(Integer npostcode) {
    this.npostcode = npostcode;
  }

  public Integer getNxianshi() {
    return nxianshi;
  }

  public void setNxianshi(Integer nxianshi) {
    this.nxianshi = nxianshi;
  }
}
