package ELMS.businesslogic.StorageBL;

import java.util.ArrayList;

import ELMS.businesslogicService.StorageBlService;
import ELMS.vo.StorageVO;

public class StorageBl_driver {
public StorageBl_driver(StorageBlService ss){

	
	ArrayList<StorageVO> al=new ArrayList<StorageVO>();
	StorageVO vo=new StorageVO("0006", "航运区", "S3R4S23","0000012543","2015-05-22", "2015-05-23", "出库", "南京");
	al.add(vo);
	for(int i=0;i<(ss.init(al)).size();i++)
		System.out.println((ss.init(al)).get(i).getId()+" "+(ss.init(al)).get(i).getArea()+" " +(ss.init(al)).get(i).getSeat()+" "
	                        +(ss.init(al)).get(i).getOrder()+" "+(ss.init(al)).get(i).getTimeIn()+
				      " "+(ss.init(al)).get(i).getTimeOut()+" "+(ss.init(al)).get(i).getState()+" "+(ss.init(al)).get(i).getName());
	
	if(ss.storage_inChoose("航运区")) System.out.println("该货物可以被放置在航运区");
	
	StorageVO vo1=new StorageVO("0023", "航运区", "S5R8S13","0000012345","2015-10-21", "2015-10-23", "出库", "南京");
	StorageVO sd=ss.storage_inRecord(vo1);
	System.out.println(sd.getId()+" "+sd.getArea()+" "+sd.getSeat()+" "+sd.getOrder()+" "+sd.getTimeIn()+" "+sd.getTimeOut()+" "+sd.getState()+" "+sd.getName());
	
	if(ss.storage_out("0007"))  System.out.println("该商品成功出库");
	
	ArrayList<StorageVO> al1=ss.inquiryByTime("2015-05-22", "2015-05-26", "南京");
	for(int i=0;i<al1.size();i++) System.out.println(al1.get(i).getId()+" "+al1.get(i).getArea()+" "+al1.get(i).getSeat()+" "+al1.get(i).getOrder()+
			" "+al1.get(i).getTimeIn()+" "+al1.get(i).getTimeOut()+" "+al1.get(i).getState()+" "+al1.get(i).getName());
	
	ArrayList<StorageVO> al2=ss.inquiryAll("北京");
	for(int i=0;i<al2.size();i++) System.out.println(al2.get(i).getId()+" "+al2.get(i).getArea()+" "+al2.get(i).getSeat()+" "+al2.get(i).getOrder()+
			" "+al2.get(i).getTimeIn()+" "+al2.get(i).getTimeOut()+" "+al2.get(i).getState()+" "+al2.get(i).getName());
	
	StorageVO sv=ss.inquiry("0068");
	System.out.println(sv.getId()+" "+sv.getArea()+" "+sv.getSeat()+" "+sv.getOrder()+" "+sv.getTimeIn()+" "+sv.getTimeOut()+" "+sv.getState()+" "+sv.getName());

	ss.endStoreOpt();
			}
}
