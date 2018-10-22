package blservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import utility.ResultMessage;
import vo.GoodsVO;

public interface Goodsblservice extends Remote{
	/*
	 * ������Ʒ
	 */
	public ResultMessage addGoods(GoodsVO VO) throws RemoteException;
	/*
	 * ɾ����Ʒ
	 */
	public ResultMessage removeGoods(GoodsVO VO) throws RemoteException;
	/*
	 * �޸���Ʒ(���ۣ��ۼ�)
	 */
	public ResultMessage updateGoods(GoodsVO a,double pricein,double price) throws RemoteException;
	/*
	 * ���ݹؼ��ַ�����Ʒ��Ϣ
	 */
	public List<GoodsVO> searchGoods(String number) throws RemoteException;
	/*
	 * ������Ʒ���
	 */
	public int getgoodsnumber()throws RemoteException;
	/*
	 * ��ѯ��Ʒ����
	 */
	public List<GoodsVO> query()throws RemoteException;
	/*
	 * ���ݱ�ŷ�����Ʒ��Ϣ
	 */
	public GoodsVO searchGoodsbynumber(int number) throws RemoteException;
	/*
	 * �������Ʒ�����Ʒ��Ϣ
	 */
	public List<GoodsVO> searchGoodsbyname(String name) throws RemoteException;
}
