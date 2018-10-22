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
	 * 制定针对不同用户的销售策略
	 */
	public ResultMessage strategyForUser(LevelPromotionVO a) throws RemoteException;
	/*
	 * 制定特价包 
	 */
	public ResultMessage strategyForPackage(TotalPromotionVO a) throws RemoteException;
	/*
	 * 针对不同总价的销售策略
	 */
	public ResultMessage strategyForPrice(GoodsCombinationPromotionVO a) throws RemoteException;
	/*
	 * 总价促销
	 */
	public TotalPromotionVO getdiscountbytotalpromotion(double price)throws RemoteException;
	/*
	 * 组合促销
	 */
	public double getdiscountbygoodscombinationpromotion(List<GoodsListVO> a)throws RemoteException;
	/*
	 * 等级促销
	 */
	public LevelPromotionVO getdiscountbylevelpromotion(String name)throws RemoteException;
}

