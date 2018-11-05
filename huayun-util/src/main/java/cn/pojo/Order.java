package cn.pojo;

/**
 * 订单
 */
public class Order {

  private Integer oid;        //订单ID
  private Integer ouid;       //订单用户ID
  private String obianhao;    //订单编号
  private String otitle;      //订单标题
  private String odate;    //订单时间
  private Integer ostate;     //订单状态：1待付款，2待发货，3待收货，4已完成，5售后
  private Integer oxianshi;   //订单显示状态：0显示1隐藏
  private String opayment;    //订单支付方式
  private String ocoupon;     //优惠卷
  private String ofreight;    //运费
  private String ocontact;    //订购人联系方式
  private String omessage;    //订单留言
  private String otime;         //配送日期
  private String oremark;     //备注
  private Integer obuy;       //付款状态：0付款1未付款

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

  public String getObianhao() {
    return obianhao;
  }

  public void setObianhao(String obianhao) {
    this.obianhao = obianhao;
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

  public Integer getOxianshi() {
    return oxianshi;
  }

  public void setOxianshi(Integer oxianshi) {
    this.oxianshi = oxianshi;
  }

  public String getOpayment() {
    return opayment;
  }

  public void setOpayment(String opayment) {
    this.opayment = opayment;
  }

  public String getOcoupon() {
    return ocoupon;
  }

  public void setOcoupon(String ocoupon) {
    this.ocoupon = ocoupon;
  }

  public String getOfreight() {
    return ofreight;
  }

  public void setOfreight(String ofreight) {
    this.ofreight = ofreight;
  }

  public String getOcontact() {
    return ocontact;
  }

  public void setOcontact(String ocontact) {
    this.ocontact = ocontact;
  }

  public String getOmessage() {
    return omessage;
  }

  public void setOmessage(String omessage) {
    this.omessage = omessage;
  }

  public String getOtime() {
    return otime;
  }

  public void setOtime(String otime) {
    this.otime = otime;
  }

  public String getOremark() {
    return oremark;
  }

  public void setOremark(String oremark) {
    this.oremark = oremark;
  }

  public Integer getObuy() {
    return obuy;
  }

  public void setObuy(Integer obuy) {
    this.obuy = obuy;
  }
}