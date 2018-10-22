package vo;

import java.io.Serializable;
import java.util.List;

	/*
	 * 进货单
	 */
public class PurchaseOrderVO implements Serializable{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		/*
		 * 是否审批
		 */
		private int ischeck;
		/*
		 * 日期
		 */
		private String date;
		
		/*
		 * 编号
		 */
		private String number;
		/*
		 * 供应商
		 */
		private String provider;
		/*
		 * 仓库
		 */
		private String warehouse;
		/*
		 * 操作员
		 */
		private String operator;
		/*
		 * 备注
		 */
		private String comment;
		/*
		 * 总额合计
		 */
		private double total;
		/*
		 * 商品列表
		 */
		private List<GoodsListVO> list;
		
				
		public PurchaseOrderVO(){}

		public int getIscheck() {
			return ischeck;
		}

		public void setIscheck(int ischeck) {
			this.ischeck = ischeck;
		}

		public String getDate() {
			return date;
		}

		public void setDate(String date) {
			this.date = date;
		}

		public String getNumber() {
			return number;
		}

		public void setNumber(String number) {
			this.number = number;
		}

		public String getProvider() {
			return provider;
		}

		public void setProvider(String provider) {
			this.provider = provider;
		}

		public String getWarehouse() {
			return warehouse;
		}

		public void setWarehouse(String warehouse) {
			this.warehouse = warehouse;
		}

		public String getOperator() {
			return operator;
		}

		public void setOperator(String operator) {
			this.operator = operator;
		}

		public String getComment() {
			return comment;
		}

		public void setComment(String comment) {
			this.comment = comment;
		}

		public double getTotal() {
			return total;
		}

		public void setTotal(double total) {
			this.total = total;
		}

		public List<GoodsListVO> getList() {
			return list;
		}

		public void setList(List<GoodsListVO> list) {
			this.list = list;
		}		
		
}
