package blservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import utility.ResultMessage;
import vo.GoodsVO;

public interface Goodsblservice extends Remote{
	/*
	 * 新增商品
	 */
	public ResultMessage addGoods(GoodsVO VO) throws RemoteException;
	/*
	 * 删除商品
	 */
	public ResultMessage removeGoods(GoodsVO VO) throws RemoteException;
	/*
	 * 修改商品(进价，售价)
	 */
	public ResultMessage updateGoods(GoodsVO a,double pricein,double price) throws RemoteException;
	/*
	 * 根据关键字返回商品信息
	 */
	public List<GoodsVO> searchGoods(String number) throws RemoteException;
	/*
	 * 计算商品编号
	 */
	public int getgoodsnumber()throws RemoteException;
	/*
	 * 查询商品集合
	 */
	public List<GoodsVO> query()throws RemoteException;
	/*
	 * 根据编号返回商品信息
	 */
	public GoodsVO searchGoodsbynumber(int number) throws RemoteException;
	/*
	 * 根据名称返回商品信息
	 */
	public List<GoodsVO> searchGoodsbyname(String name) throws RemoteException;
}
