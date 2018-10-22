package blservice;

import java.util.List;

import utility.ResultMessage;

import java.rmi.Remote;
import java.rmi.RemoteException;

import vo.GoodsCombinationPromotionVO;
import vo.GoodsListVO;
import vo.LevelPromotionVO;
import vo.TotalPromotionVO;

public interface Promotionblservice extends Remote{
	/*
	 * �ƶ���Բ�ͬ�û������۲���
	 */
	public ResultMessage strategyForUser(LevelPromotionVO a) throws RemoteException;
	/*
	 * �ƶ��ؼ۰� 
	 */
	public ResultMessage strategyForPackage(TotalPromotionVO a) throws RemoteException;
	/*
	 * ��Բ�ͬ�ܼ۵����۲���
	 */
	public ResultMessage strategyForPrice(GoodsCombinationPromotionVO a) throws RemoteException;
	/*
	 * �ܼ۴���
	 */
	public TotalPromotionVO getdiscountbytotalpromotion(double price)throws RemoteException;
	/*
	 * ��ϴ���
	 */
	public double getdiscountbygoodscombinationpromotion(List<GoodsListVO> a)throws RemoteException;
	/*
	 * �ȼ�����
	 */
	public LevelPromotionVO getdiscountbylevelpromotion(String name)throws RemoteException;
}

