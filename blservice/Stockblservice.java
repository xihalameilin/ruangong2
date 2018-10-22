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
	 * ���ص���Ŀ����Ϣ
	 */
	public List<StockChangeVO> showStock() throws RemoteException;
	/*
	 * ����ָ��ʱ����ڵĿ����Ϣ
	 */
	public List<StockChangeVO> showStock(String start,String end) throws RemoteException;
	/*
	 * /�鿴��Ӫ���̱�֮���͵�
	 */
	public List<StockGrantOrderVO> BussinessCourseStockGrantOrder(String begin,String end) throws RemoteException;
	/*
	 * /�鿴��Ӫ���̱�֮����
	 */
	public List<StockLossOrderVO> BussinessCourseStockLossOrder(String begin,String end) throws RemoteException;
	/*
	 * /�鿴��Ӫ���̱�֮���絥
	 */
	public List<StockOverflowOrderVO> BussinessCourseStockOverflowOrder(String begin,String end) throws RemoteException;
	/*
	 * /���֮������͵���
	 */
	public ResultMessage RedDashStockGrantOrder(StockGrantOrderVO StockGrantOrder)throws RemoteException;
	/*
	 * /���֮��汨��
	 */
	public ResultMessage RedDashStockLossOrder(StockLossOrderVO StockLossOrder)throws RemoteException;
	/*
	 * /���֮��汨�絥
	 */
	public ResultMessage RedDashStockOverflowOrder(StockOverflowOrderVO StockOverflowOrder)throws RemoteException;
	/*
	 * ����������͵�
	 */
	public ResultMessage createNewStockGrantOrder(StockGrantOrderVO VO) throws RemoteException;
	/*
	 * ������汨�絥
	 */
	public ResultMessage createNewStockOverflowOrder(StockOverflowOrderVO VO) throws RemoteException;
	/*
	 * ������汨��
	 */
	public ResultMessage createNewStockLossOrder(StockLossOrderVO VO) throws RemoteException;
	/*
	 * ������汨����
	 */
	public ResultMessage createNewStockAlarmOrder(StockAlarmOrderVO VO) throws RemoteException;
	/*
	 * �鿴���͵�
	 */
	public List<StockGrantOrderVO> queryStockGrantOrder()throws RemoteException;
	/*
	 * �鿴����
	 */
	public List<StockLossOrderVO> queryStockLossOrder()throws RemoteException;
	/*
	 * �鿴���絥
	 */
	public List<StockOverflowOrderVO> queryStockOverflowOrder()throws RemoteException;
	/*
	 * �鿴������
	 */
	public List<StockAlarmOrderVO> queryStockAlarmOrder()throws RemoteException;
	/*
	 * ����ݸ������͵�
	 */
	public ResultMessage draftStockGrantOrder(StockGrantOrderVO VO)throws RemoteException;
	/*
	 * ����ݸ��汨�絥
	 */
	public ResultMessage draftStockOverflowOrder(StockOverflowOrderVO VO)throws RemoteException;
	/*
	 * ����ݸ��汨��
	 */
	public ResultMessage draftStockLossOrder(StockLossOrderVO VO)throws RemoteException;
	/*
	 * ��������̵�excel
	 */
	public ResultMessage exportStockExcel(List<GoodsVO> p,String path)throws RemoteException;
	/*
	 * �鿴�ݸ������͵�
	 */
	public List<StockGrantOrderVO> querydraftStockGrantOrder()throws RemoteException;
	/*
	 * �鿴�ݸ��汨�絥
	 */
	public List<StockOverflowOrderVO> querydraftStockOverflowOrder()throws RemoteException;
	/*
	 * �鿴�ݸ��汨��
	 */
	public List<StockLossOrderVO> querydraftStockLossOrder()throws RemoteException;
	/*
	 * ������Ӫ���̱�֮���͵�
	 */
	public ResultMessage exportStockGrantOrderExcel(List<StockGrantOrderVO> p,String path)throws RemoteException;
	/*
	 * ������Ӫ�����֮����
	 */
	public ResultMessage exportStockLossOrderExcel(List<StockLossOrderVO> p,String path)throws RemoteException;
	/*
	 * ������Ӫ�����֮���絥
	 */
	public ResultMessage exportStockOverflowOrderExcel(List<StockOverflowOrderVO> p,String path)throws RemoteException;
	/*
	 * �Ŀ��
	 */
	public ResultMessage changestock(int goodnumber,int change)throws RemoteException;
	/*
	 * ���ݱ�Ų鱨��
	 */
	public StockLossOrderVO queryStockLossOrderByNumber(String number)throws RemoteException;
	/*
	 * ���ݱ�Ų鱨�絥
	 */
	public StockOverflowOrderVO queryStockOverflowOrderByNumber(String number)throws RemoteException;
	/*
	 * ���ݱ�Ų����͵�
	 */
	public StockGrantOrderVO queryStockGrantOrderByNumber(String number)throws RemoteException;
	/*
	 * ���±���״̬
	 */
	public ResultMessage updateStockLossOrderState(String number,int state)throws RemoteException;
	/*
	 * ���±��絥״̬
	 */
	public ResultMessage updateStockOverflowOrderState(String number,int state)throws RemoteException;
	/*
	 * �������͵�״̬
	 */
	public ResultMessage updateStockGrantOrderState(String number,int state)throws RemoteException;
	/*
	 * ���±�����״̬
	 */
	public ResultMessage updateStockAlarmOrderState(String number,int state)throws RemoteException;
	
	/*
     * ��������¼
     */
	public ResultMessage addStockInVO(StockInVO s)throws RemoteException;
	/*
	 * ���������¼
	 */
	public ResultMessage addStockOutVO(StockOutVO s)throws RemoteException;
	/*
	 * �������ۼ�¼
	 */
	public ResultMessage addStockSalesChangeVO(StockSalesChangeVO s)throws RemoteException;
	/*
	 * ����������¼
	 */
	public ResultMessage addStockPurchaseChangeVO(StockPurchaseChangeVO s)throws RemoteException;
	/*
	 * �õ���汨�𵥱��
	 */
	public String getStockLossOrderNumber()throws RemoteException;
	/*
	 * �õ���汨�絥���
	 */
	public String getStockOverflowOrderNumber()throws RemoteException;
	/*
	 * �õ���汨�������
	 */
	public String getStockAlarmOrderNumber()throws RemoteException;
	/*
	 * �õ�������͵����
	 */
	public String getStockGrantOrderNumber()throws RemoteException;
	/*
	 * �����Ʒ����
	 */
	public void checkDangerNumber(int number)throws RemoteException;
	/*
	 * ���ر�����Ʒ����
	 */
	public List<GoodsVO>  queryDangerGoods ()throws RemoteException;



	


	
}
