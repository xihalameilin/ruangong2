package vo;

import java.io.Serializable;

public class GoodsVO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*
	 * ����
	 */
	String classification;
	/*
	 * ���
	 */
	int number;
	/*
	 *����
	 */
	String name;
	
	/*
	 * �ͺ�
	 */
	String type;
	/*
	 * ����
	 */
	 String pici;
	 /*
	  * ����
	  */
	 String pihao;
	 /*
	  * ��������
	  */
	 String chuchangriqi;
	/*
	 * �������
	 */
	 int stocknumber;
	/*
	 * ����
	 */
	double pricein;
	/*
	 * ���ۼ�
	 */
	double price;
	/*
	 * �������
	 */
	double latestpricein;
	/*
	 * ������ۼ�
	 */
	double latestpeice;
	/*
	 * ��������
	 */
	int dangernumber;
	
	public GoodsVO(){}
	
	public String getClassification() {
		return classification;
	}
	public void setClassification(String classification) {
		this.classification = classification;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPici() {
		return pici;
	}

	public void setPici(String pici) {
		this.pici = pici;
	}

	public String getPihao() {
		return pihao;
	}

	public void setPihao(String pihao) {
		this.pihao = pihao;
	}

	public String getChuchangriqi() {
		return chuchangriqi;
	}

	public void setChuchangriqi(String chuchangriqi) {
		this.chuchangriqi = chuchangriqi;
	}
	public int getStocknumber() {
		return stocknumber;
	}
	public void setStocknumber(int stocknumber) {
		this.stocknumber = stocknumber;
	}
	public double getPricein() {
		return pricein;
	}
	public void setPricein(double pricein) {
		this.pricein = pricein;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getLatestpricein() {
		return latestpricein;
	}
	public void setLatestpricein(double latestpricein) {
		this.latestpricein = latestpricein;
	}
	public double getLatestpeice() {
		return latestpeice;
	}
	public void setLatestpeice(double latestpeice) {
		this.latestpeice = latestpeice;
	}
	public int getDangernumber() {
		return dangernumber;
	}
	public void setDangernumber(int dangernumber) {
		this.dangernumber = dangernumber;
	}
	

}
