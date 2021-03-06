package elms.businesslogic_service.storageblservice;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import elms.businesslogic.storagebl.StorageCapacity;
import elms.vo.StorageVO;


public interface StorageBlService {
	/*
	 * 判断该编号订单是否已经有入库记录
	 */
	public boolean orderhasIN(String s) throws IOException;
	
	/*
	 * 从记录中删除该条库存记录
	 */
	public void delete(StorageVO vo) throws IOException;
	
	/*
	 * 初始化现有的库存记录  
	 */
	public void init() throws  IOException;
	
	/*
	 * 判断该编号订单能否入库
	 */
	public int storage_inChoose(String area,StorageCapacity center) throws IOException;
	
	/*
	 * 将新的库存VO 转化入库
	 */
	public StorageVO storage_inRecord(StorageVO vo) throws IOException;
	
	/*
	 * 将选定订单号的库存项出库
	 */
	public boolean storage_out(String orderID,String center) throws IOException;
	
	/*
	 * 按照选定时间查询库存信息
	 */
	public ArrayList<StorageVO> inquiryByTime(String time1, String time2, String center) throws  IOException;
	
	/*
	 * 查询某个中转中心的库存
	 */
	public ArrayList<StorageVO> inquiryAll(String center) throws IOException;
	
	/*
	 * 对单条记录的查询
	 */
	public StorageVO inquiry(String id) throws IOException;
	
	/*
	 * 对选定库存记录导出Excel表格形式
	 */
	public void paint(List<StorageVO> temp,String s) throws IOException;
	
	/*
	 * 结束对库存的操作
	 */
	public void endStoreOpt();
}
