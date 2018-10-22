package vo;

import java.io.Serializable;
import java.util.List;

public class GoodsCombinationPromotionVO implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

private String begintime;
	
	private String endtime;
	
	private double jiangjia;
	
	/*
	 * 商品组合的集合（number？）
	 */
	private List<GoodsListVO> list;
	
	


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

	public double getJiangjia() {
		return jiangjia;
	}

	public void setJiangjia(double jiangjia) {
		this.jiangjia = jiangjia;
	}

	public List<GoodsListVO> getList() {
		return list;
	}

	public void setList(List<GoodsListVO> list) {
		this.list = list;
	}

	

	
	

}
