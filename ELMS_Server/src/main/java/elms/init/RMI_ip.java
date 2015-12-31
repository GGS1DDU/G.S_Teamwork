package elms.init;

import javax.swing.JOptionPane;

public class RMI_ip  {
private static String IP="172.26.67.11";
static boolean beSet=false;
	public static void setIP() {
		while(!beSet){
		String temp=JOptionPane.showInputDialog("请输入新的IP地址");
		if(temp.matches("\\d{3}.\\d{3}.\\d{3}.\\d{1}")){
			IP=temp;beSet=true;}
		else JOptionPane.showMessageDialog(null, "您输入的IP格式有误");		
	}}
	public static String getIP(){
		return IP;
	}

}
