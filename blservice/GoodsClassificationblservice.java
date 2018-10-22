package blservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import utility.ResultMessage;
import vo.GoodsVO;

public interface GoodsClassificationblservice extends Remote{
	/*
	 * ������Ʒ������Ϣ
	 */
	public String getGoodsClassification()  throws RemoteException;
	/*
	 * ������Ʒ�־û�����
	 */
	public List<GoodsVO> getGoodsList() throws RemoteException;
	/*
	 * ������Ʒ����
	 */
	public ResultMessage addClassification(String parent_classification,String son_classificatioin) throws RemoteException;
	/*
	 * ɾ����Ʒ����
	 */
	public ResultMessage removeClassification(String classification) throws RemoteException;
	/*
	 * �޸���Ʒ����
	 */
	public ResultMessage updateClassification(String old_classification,String new_classification) throws RemoteException;
    /*
     * ���������
     */
	public int getGoodsClassificationNumber()throws RemoteException;
	/*
	 * �õ����������ӷ���
	 */
	public List<String>getson (String name)throws RemoteException;
	/*
	 * �õ������ӽڵ�
	 */
	public List<String> getAllSonClassification() throws RemoteException;
	/*
	 * �޸Ľڵ��Ƿ���Ч
	 */
    public boolean isValidClassification(String classification)throws RemoteException;
 

}
