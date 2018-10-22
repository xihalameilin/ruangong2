package blservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import utility.ResultMessage;
import vo.GoodsVO;

public interface GoodsClassificationblservice extends Remote{
	/*
	 * 返回商品分类信息
	 */
	public String getGoodsClassification()  throws RemoteException;
	/*
	 * 返回商品持久化对象
	 */
	public List<GoodsVO> getGoodsList() throws RemoteException;
	/*
	 * 新增商品分类
	 */
	public ResultMessage addClassification(String parent_classification,String son_classificatioin) throws RemoteException;
	/*
	 * 删除商品分类
	 */
	public ResultMessage removeClassification(String classification) throws RemoteException;
	/*
	 * 修改商品分类
	 */
	public ResultMessage updateClassification(String old_classification,String new_classification) throws RemoteException;
    /*
     * 计算分类编号
     */
	public int getGoodsClassificationNumber()throws RemoteException;
	/*
	 * 得到父分类下子分类
	 */
	public List<String>getson (String name)throws RemoteException;
	/*
	 * 得到所有子节点
	 */
	public List<String> getAllSonClassification() throws RemoteException;
	/*
	 * 修改节点是否有效
	 */
    public boolean isValidClassification(String classification)throws RemoteException;
 

}
