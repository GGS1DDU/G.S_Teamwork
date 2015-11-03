package ELMS.businesslogic.LogBL;

import java.util.ArrayList;

import ELMS.businesslogicService.LogBlService;
import ELMS.vo.LogVO;

public class LogBl_driver {
public  LogBl_driver(LogBlService sl){
	
	LogVO vo=new LogVO("0000", "2015-06-22", "查询余额", "ZHhittta");
	if(sl.buildLog(vo)) System.out.println("新增系统日志！");
    
	LogVO vo1=sl.inquiry("0001");
    System.out.println(vo1.getId()+" "+vo1.getTime()+" "+vo1.getCategory()+" "+vo1.getName());
    
    ArrayList<LogVO> as=sl.inquiryAll();
    for(int i=0;i<as.size();i++)
    	 System.out.println(((LogVO) as.get(i)).getId()+" "+((LogVO) as.get(i)).getTime()+" "+((LogVO) as.get(i)).getCategory()+" "+((LogVO) as.get(i)).getName());
}
}
