package vo;

import java.io.Serializable;
import java.util.List;

public class LevelPromotionVO implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    private int level;
	
	private double zherang;
	/*
	 * ´ú½ðÈ¯
	 */
	private double voucher;
	
	private String begintime;
	
	private String endtime;
	
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

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public double getZherang() {
		return zherang;
	}

	public void setZherang(double zherang) {
		this.zherang = zherang;
	}

	public double getVoucher() {
		return voucher;
	}

	public void setVoucher(double voucher) {
		this.voucher = voucher;
	}

}
