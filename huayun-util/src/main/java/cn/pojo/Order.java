package cn.pojo;

/**
 * 订单
 */
public class Order {

  private Integer oid;    //订单ID
  private Integer ouid;   //订单用户ID
  private Integer ogid;   //订单商品ID
  private String obianhao;  //订单编号
  private String otitle;   //订单名称
  private String odate;    //订单时间
  private Integer ostate;   //订单状态：1待付款2待发货3待收货4待评价5已完成
  private Integer oxianshi; //订单显示0显示1隐藏

  public Integer getOid() {
    return oid;
  }

  public void setOid(Integer oid) {
    this.oid = oid;
  }

  public Integer getOuid() {
    return ouid;
  }

  public void setOuid(Integer ouid) {
    this.ouid = ouid;
  }

  public Integer getOgid() {
    return ogid;
  }

  public void setOgid(Integer ogid) {
    this.ogid = ogid;
  }

  public String getOtitle() {
    return otitle;
  }

  public void setOtitle(String otitle) {
    this.otitle = otitle;
  }

  public String getOdate() {
    return odate;
  }

  public void setOdate(String odate) {
    this.odate = odate;
  }

  public Integer getOstate() {
    return ostate;
  }

  public void setOstate(Integer ostate) {
    this.ostate = ostate;
  }

  public String getObianhao() {
    return obianhao;
  }

  public void setObianhao(String obianhao) {
    this.obianhao = obianhao;
  }

  public Integer getOxianshi() {
    return oxianshi;
  }

  public void setOxianshi(Integer oxianshi) {
    this.oxianshi = oxianshi;
  }
}
