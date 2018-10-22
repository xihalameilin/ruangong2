package vo;

import java.io.Serializable;
import java.util.List;

	/*
	 * ������
	 */
public class PurchaseOrderVO implements Serializable{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		/*
		 * �Ƿ�����
		 */
		private int ischeck;
		/*
		 * ����
		 */
		private String date;
		
		/*
		 * ���
		 */
		private String number;
		/*
		 * ��Ӧ��
		 */
		private String provider;
		/*
		 * �ֿ�
		 */
		private String warehouse;
		/*
		 * ����Ա
		 */
		private String operator;
		/*
		 * ��ע
		 */
		private String comment;
		/*
		 * �ܶ�ϼ�
		 */
		private double total;
		/*
		 * ��Ʒ�б�
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
