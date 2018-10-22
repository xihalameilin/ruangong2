package blservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import utility.ResultMessage;
import vo.GoodsVO;
import vo.StockAlarmOrderVO;
import vo.StockChangeVO;
import vo.StockGrantOrderVO;
import vo.StockInVO;
import vo.StockLossOrderVO;
import vo.StockOutVO;
import vo.StockOverflowOrderVO;
import vo.StockPurchaseChangeVO;
import vo.StockSalesChangeVO;

public interface Stockblservice extends Remote{
	/*
	 * 返回当天的库存信息
	 */
	public List<StockChangeVO> showStock() throws RemoteException;
	/*
	 * 返回指定时间段内的库存信息
	 */
	public List<StockChangeVO> showStock(String start,String end) throws RemoteException;
	/*
	 * /查看经营历程表之赠送单
	 */
	public List<StockGrantOrderVO> BussinessCourseStockGrantOrder(String begin,String end) throws RemoteException;
	/*
	 * /查看经营历程表之报损单
	 */
	public List<StockLossOrderVO> BussinessCourseStockLossOrder(String begin,String end) throws RemoteException;
	/*
	 * /查看经营历程表之报溢单
	 */
	public List<StockOverflowOrderVO> BussinessCourseStockOverflowOrder(String begin,String end) throws RemoteException;
	/*
	 * /红冲之库存赠送单单
	 */
	public ResultMessage RedDashStockGrantOrder(StockGrantOrderVO StockGrantOrder)throws RemoteException;
	/*
	 * /红冲之库存报损单
	 */
	public ResultMessage RedDashStockLossOrder(StockLossOrderVO StockLossOrder)throws RemoteException;
	/*
	 * /红冲之库存报溢单
	 */
	public ResultMessage RedDashStockOverflowOrder(StockOverflowOrderVO StockOverflowOrder)throws RemoteException;
	/*
	 * 新增库存赠送单
	 */
	public ResultMessage createNewStockGrantOrder(StockGrantOrderVO VO) throws RemoteException;
	/*
	 * 新增库存报溢单
	 */
	public ResultMessage createNewStockOverflowOrder(StockOverflowOrderVO VO) throws RemoteException;
	/*
	 * 新增库存报损单
	 */
	public ResultMessage createNewStockLossOrder(StockLossOrderVO VO) throws RemoteException;
	/*
	 * 新增库存报警单
	 */
	public ResultMessage createNewStockAlarmOrder(StockAlarmOrderVO VO) throws RemoteException;
	/*
	 * 查看赠送单
	 */
	public List<StockGrantOrderVO> queryStockGrantOrder()throws RemoteException;
	/*
	 * 查看报损单
	 */
	public List<StockLossOrderVO> queryStockLossOrder()throws RemoteException;
	/*
	 * 查看报溢单
	 */
	public List<StockOverflowOrderVO> queryStockOverflowOrder()throws RemoteException;
	/*
	 * 查看报警单
	 */
	public List<StockAlarmOrderVO> queryStockAlarmOrder()throws RemoteException;
	/*
	 * 保存草稿库存赠送单
	 */
	public ResultMessage draftStockGrantOrder(StockGrantOrderVO VO)throws RemoteException;
	/*
	 * 保存草稿库存报溢单
	 */
	public ResultMessage draftStockOverflowOrder(StockOverflowOrderVO VO)throws RemoteException;
	/*
	 * 保存草稿库存报损单
	 */
	public ResultMessage draftStockLossOrder(StockLossOrderVO VO)throws RemoteException;
	/*
	 * 导出库存盘点excel
	 */
	public ResultMessage exportStockExcel(List<GoodsVO> p,String path)throws RemoteException;
	/*
	 * 查看草稿库存赠送单
	 */
	public List<StockGrantOrderVO> querydraftStockGrantOrder()throws RemoteException;
	/*
	 * 查看草稿库存报溢单
	 */
	public List<StockOverflowOrderVO> querydraftStockOverflowOrder()throws RemoteException;
	/*
	 * 查看草稿库存报损单
	 */
	public List<StockLossOrderVO> querydraftStockLossOrder()throws RemoteException;
	/*
	 * 导出经营历程表之赠送单
	 */
	public ResultMessage exportStockGrantOrderExcel(List<StockGrantOrderVO> p,String path)throws RemoteException;
	/*
	 * 导出经营情况表之报损单
	 */
	public ResultMessage exportStockLossOrderExcel(List<StockLossOrderVO> p,String path)throws RemoteException;
	/*
	 * 导出经营情况表之报溢单
	 */
	public ResultMessage exportStockOverflowOrderExcel(List<StockOverflowOrderVO> p,String path)throws RemoteException;
	/*
	 * 改库存
	 */
	public ResultMessage changestock(int goodnumber,int change)throws RemoteException;
	/*
	 * 根据编号查报损单
	 */
	public StockLossOrderVO queryStockLossOrderByNumber(String number)throws RemoteException;
	/*
	 * 根据编号查报溢单
	 */
	public StockOverflowOrderVO queryStockOverflowOrderByNumber(String number)throws RemoteException;
	/*
	 * 根据编号查赠送单
	 */
	public StockGrantOrderVO queryStockGrantOrderByNumber(String number)throws RemoteException;
	/*
	 * 更新报损单状态
	 */
	public ResultMessage updateStockLossOrderState(String number,int state)throws RemoteException;
	/*
	 * 更新报溢单状态
	 */
	public ResultMessage updateStockOverflowOrderState(String number,int state)throws RemoteException;
	/*
	 * 更新赠送单状态
	 */
	public ResultMessage updateStockGrantOrderState(String number,int state)throws RemoteException;
	/*
	 * 更新报警单状态
	 */
	public ResultMessage updateStockAlarmOrderState(String number,int state)throws RemoteException;
	
	/*
     * 新增入库记录
     */
	public ResultMessage addStockInVO(StockInVO s)throws RemoteException;
	/*
	 * 新增出库记录
	 */
	public ResultMessage addStockOutVO(StockOutVO s)throws RemoteException;
	/*
	 * 新增销售记录
	 */
	public ResultMessage addStockSalesChangeVO(StockSalesChangeVO s)throws RemoteException;
	/*
	 * 新增进货记录
	 */
	public ResultMessage addStockPurchaseChangeVO(StockPurchaseChangeVO s)throws RemoteException;
	/*
	 * 得到库存报损单编号
	 */
	public String getStockLossOrderNumber()throws RemoteException;
	/*
	 * 得到库存报溢单编号
	 */
	public String getStockOverflowOrderNumber()throws RemoteException;
	/*
	 * 得到库存报警单编号
	 */
	public String getStockAlarmOrderNumber()throws RemoteException;
	/*
	 * 得到库存赠送单编号
	 */
	public String getStockGrantOrderNumber()throws RemoteException;
	/*
	 * 检查商品报警
	 */
	public void checkDangerNumber(int number)throws RemoteException;
	/*
	 * 返回报警商品集合
	 */
	public List<GoodsVO>  queryDangerGoods ()throws RemoteException;



	


	
}
