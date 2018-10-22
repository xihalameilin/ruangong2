package vo;

import java.io.Serializable;
import java.util.List;

public class TotalPromotionVO implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String begintime;
	
	private String endtime;
	
	private double standardprice;
	/*
	 * ´ú½ðÈ¯
	 */
	private double voucher;
	
    private List<GoodsListVO> everylist;
	
	
	
	
	
	public List<GoodsListVO> getEverylist() {
		return everylist;
	}
	public void setEverylist(List<GoodsListVO> everylist) {
		this.everylist = everylist;
	}
	public String getBegintime() {
		return begintime;
	}
	public void setBegintime(String begintime) {
		this.begintime = begintime;
	}
	public String getEndtime() {
		return endtime;
	}
	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}
	public double getStandardprice() {
		return standardprice;
	}
	public void setStandardprice(double standardprice) {
		this.standardprice = standardprice;
	}
	public double getVoucher() {
		return voucher;
	}
	public void setVoucher(double voucher) {
		this.voucher = voucher;
	}
	

}
