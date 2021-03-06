package elms.presentation.managerui.aduit;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.TableColumnModel;

import elms.businesslogic.invoicebl.ArrivalListBL;
import elms.businesslogic.invoicebl.IncomeListBL;
import elms.businesslogic.invoicebl.LoadingListBL;
import elms.businesslogic.invoicebl.LoadingListZZBL;
import elms.businesslogic.invoicebl.RecivalListBL;
import elms.businesslogic.invoicebl.SendingListBL;
import elms.businesslogic.invoicebl.TransferListBL;
import elms.businesslogic.managerbl.Audit;
import elms.businesslogic.storagebl.Storage;
import elms.presentation.storageui.Storage_editStorage;
import elms.presentation.storageui.TableModel;
import elms.presentation.uihelper.MyPanel;
import elms.vo.ArrivalListVO;
import elms.vo.IncomeListVO;
import elms.vo.InvoiceVO;
import elms.vo.LoadingListVO;
import elms.vo.LoadingListZZVO;
import elms.vo.RecivalListVO;
import elms.vo.SendingListVO;
import elms.vo.StorageVO;
import elms.vo.TransferListVO;

public class aduit_main extends JPanel {
	static Toolkit kit = Toolkit.getDefaultToolkit();
	static Dimension screenSize = kit.getScreenSize();
	static int screenWidth = (int) screenSize.getWidth();
	static int screenHeight = (int) screenSize.getHeight();
	JTextArea text;
	JComboBox<String> jcb;
	public static TableModel model;
	public static JTable table;
	ArrayList<InvoiceVO> arr;
	static ArrayList<ArrivalListVO> arr1;
	static ArrayList<IncomeListVO> arr2;
	static ArrayList<LoadingListVO> arr3;
	static ArrayList<LoadingListZZVO> arr4;
	static ArrayList<RecivalListVO> arr5;
	static ArrayList<SendingListVO> arr6;
	static ArrayList<TransferListVO> arr7;

	// public static void main(String[] args) throws IOException {
	// JFrame f=new JFrame();
	// JPanel j=new MyPanel("inbg.jpg");
	// f.setBounds(screenWidth/6,screenHeight/8,screenWidth*2/3,screenHeight*3/4);
	// f.setLayout(null);
	// f.setVisible(true);
	// f.add(j);
	// j.setBounds(0, 0, f.getWidth(), f.getHeight());
	// j.setLayout(null);
	// aduit_main s=new aduit_main();
	// j.add(s);
	// s.setBounds(200, 0, screenWidth*2/3-200, screenHeight*3/4);
	// }

	public aduit_main(Dimension d){
		double w = screenWidth * 2 / 3 - 200;
		double h = screenHeight * 3 / 4;
		setLayout(null);
		setOpaque(false);
		setVisible(true);
		setSize(d.width,d.height);
		
			try {
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			} catch (ClassNotFoundException e2) {
				// TODO 自动生成的 catch 块
				e2.printStackTrace();
			} catch (InstantiationException e2) {
				// TODO 自动生成的 catch 块
				e2.printStackTrace();
			} catch (IllegalAccessException e2) {
				// TODO 自动生成的 catch 块
				e2.printStackTrace();
			} catch (UnsupportedLookAndFeelException e2) {
				// TODO 自动生成的 catch 块
				e2.printStackTrace();
			}
		

		String[] title_name = { "ID", "单据类型", "制表人" };
		model = new TableModel(title_name);
		table = new JTable(model);
		table.setBackground(Color.white);
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				if (e.getClickCount() == 2) {
					if (table.getSelectedColumn() != -1) {

						String s = (String) model.getValueAt(
								table.getSelectedRow(), 0);
						String c = (String) model.getValueAt(
								table.getSelectedRow(), 1);

						if (c.equals("到达单")) {
							ArrivalListBL al = new ArrivalListBL();
							try {
								new aduit_arrivallist(al.inquiry(s));
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}

						} else if (c.equals("营业厅收入单")) {
							IncomeListBL il = new IncomeListBL();
							try {
								new aduit_incomelist(il.inquiry(s));
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}

						} else if (c.equals("营业厅装车单")) {
							LoadingListBL ll = new LoadingListBL();
							try {
								new aduit_loadinglist(ll.inquiry(s));
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}

						} else if (c.equals("中转中心装车单")) {
							LoadingListZZBL zc = new LoadingListZZBL();
							try {
								new aduit_loadinglistzz(zc.inquiry(s));
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}

						} else if (c.equals("中转中心接收单")) {
							RecivalListBL rl = new RecivalListBL();
							try {
								new aduit_recivallist(rl.inquiry(s));
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}

						} else if (c.equals("快递员派件单")) {
							SendingListBL sl = new SendingListBL();
							try {
								new aduit_sendinglist(sl.inquiry(s));
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}

						} else {
							TransferListBL tl = new TransferListBL();
							try {
								new aduit_transferlist(tl.inquiry(s));
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}

						}

					}
				}
			}

		});

		JScrollPane scrollpane = new JScrollPane(table);
		add(scrollpane);
		scrollpane.setBounds(0, 0, (int) w, (int) (2 * h / 3 - 70));
		scrollpane.setOpaque(false);
		scrollpane.getViewport().setOpaque(false);

		jcb = new JComboBox<String>();
		jcb.addItem("所有单据");
		jcb.addItem("到达单");
		jcb.addItem("营业厅收入单");
		jcb.addItem("营业厅装车单");
		jcb.addItem("中转中心装车单");
		jcb.addItem("中转中心接收单");
		jcb.addItem("快递员派件单");
		jcb.addItem("中转中心中转单");
		jcb.setBackground(Color.white);
		jcb.setFont(new Font("楷体", Font.CENTER_BASELINE, 12));
		jcb.setOpaque(false);

		add(jcb);
		jcb.setBounds((int) (3 * w / 4 + 40), (int) (2 * h / 3 - 70), 120, 25);
		jcb.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				setrows();
			}

		});

		JPanel jp = new JPanel();
		jp.setLayout(null);
		jp.setVisible(true);
		jp.setOpaque(false);
		add(jp);
		jp.setBounds(0, (int) (2 * h / 3), (int) w, 60);

		JButton dxsp = new JButton("单项审批");
		JButton yjsp = new JButton("一键审批");
		jp.add(dxsp);
		jp.add(yjsp);
		dxsp.setBounds((int) (w / 5), 20, 100, 30);
		yjsp.setBounds((int) (3 * w / 5), 20, 100, 30);

		dxsp.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				new aduit_single();
			}

		});

		try {
			yjsp.addActionListener(new ActionListener() {
				Audit audit = new Audit();

				public void actionPerformed(ActionEvent arg0) {
					boolean temp = true;
					int a = jcb.getSelectedIndex();
					switch (a) {
					case 0: {
						temp = false;
						for (InvoiceVO vo : arr) {
							String id = vo.getID();
							String s = id.substring(0, 2);
							if (s.equals("al"))
								try {
									audit.audit_arrivallist(id);
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							else if (s.equals("il"))
								try {
									audit.audit_IncomeList(id);
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							else if (s.equals("ll"))
								try {
									audit.audit_LoadingList(id);
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							else if (s.equals("zc"))
								try {
									audit.audit_LoadingListZZ(id);
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							else if (s.equals("rl"))
								try {
									audit.audit_RecivalList(id);
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							else if (s.equals("sl"))
								try {
									audit.audit_sendinglist(id);
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							else
								try {
									audit.audit_TransferList(id);
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
						}
						break;
					}
					case 1: {
						temp = false;
						for (ArrivalListVO vo : arr1)
							try {
								audit.audit_arrivallist(vo.getID());
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						break;
					}
					case 2: {
						temp = false;
						for (IncomeListVO vo : arr2)
							try {
								audit.audit_IncomeList(vo.getID());
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						break;
					}
					case 3: {
						temp = false;
						for (LoadingListVO vo : arr3)
							try {
								audit.audit_LoadingList(vo.getID());
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						break;
					}
					case 4: {
						temp = false;
						for (LoadingListZZVO vo : arr4)
							try {
								audit.audit_LoadingListZZ(vo.getID());
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						break;
					}
					case 5: {
						temp = false;
						for (RecivalListVO vo : arr5)
							try {
								audit.audit_RecivalList(vo.getID());
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						break;
					}
					case 6: {
						temp = false;
						for (SendingListVO vo : arr6)
							try {
								audit.audit_sendinglist(vo.getID());
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						break;
					}
					case 7: {
						temp = false;
						for (TransferListVO vo : arr7)
							try {
								audit.audit_TransferList(vo.getID());
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						break;
					}
					}
					JOptionPane.showMessageDialog(null, jcb.getSelectedItem()
							.toString() + " 已完成审批!");
					setrows();
				}

			});
		} catch (IOException e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		}

		final JLabel time = new JLabel();
		time.setFont(new Font("Serif", Font.BOLD, 15));
		add(time);
		time.setBounds(this.getWidth() / 3 + 30, this.getHeight() - 55, 200, 30);
		Timer timer = new Timer(100, new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				SimpleDateFormat sdf = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss");
				time.setText(sdf.format(new Date()));
			}
		});
		timer.start();

	}

	private void setrows() {
		// TODO Auto-generated method stub
		int a = jcb.getSelectedIndex();
		model.removeAllRows(model.getRowCount());
		Audit aduit;
		try {
			aduit = new Audit();
			switch (a) {
			case 0: {
				String[] title_name = { "ID", "订单类型", "制表人" };
				model = new TableModel(title_name);
				table.setModel(model);
				arr = new ArrayList<InvoiceVO>();
				arr.addAll(aduit.getnoaudit_arrivallist());
				arr.addAll(aduit.getnoaudit_IncomeList());
				arr.addAll(aduit.getnoaudit_LoadingList());
				arr.addAll(aduit.getnoaudit_LoadingListZZ());
				arr.addAll(aduit.getnoaudit_RecivalList());
				arr.addAll(aduit.getnoaudit_sendinglist());
				arr.addAll(aduit.getnoaudit_TransferList());
				for (InvoiceVO vo : arr)
					model.addRow(model.changeRow_Inv(vo));
				break;
			}
			case 1: {
				String[] title_name = { "ID", "订单类型", "制表人", "中转单编号", "到达时间",
						"所属营业厅", "出发地", "到达状态" };
				model = new TableModel(title_name);
				table.setModel(model);
				arr1 = aduit.getnoaudit_arrivallist();
				for (ArrivalListVO vo : arr1)
					model.addRow(model.changeRow_Arl(vo));
				break;
			}
			case 2: {
				String[] title_name = { "ID", "订单类型", "制表人", "订单条形号码", "收款时间",
						"所属营业厅", "快递员", "邮费" };
				model = new TableModel(title_name);
				table.setModel(model);
				arr2 = aduit.getnoaudit_IncomeList();
				for (IncomeListVO vo : arr2)
					model.addRow(model.changeRow_Icl(vo));
				break;
			}
			case 3: {
				String[] title_name = { "ID", "订单类型", "制表人", "订单条形号码", "装车时间",
						"所属营业厅", "汽运编号", "押运员", "监装员", "本营业厅编号", "车辆代号", "运费" };
				model = new TableModel(title_name);
				table.setModel(model);
				arr3 = new ArrayList<LoadingListVO>();
				arr3 = aduit.getnoaudit_LoadingList();
				for (LoadingListVO vo : arr3)
					model.addRow(model.changeRow_Lol(vo));
				break;
			}
			case 4: {
				String[] title_name = { "ID", "订单类型", "制表人", "订单条形号码", "装车时间",
						"所属中转中心", "汽运编号", "押运员", "监装员", "到达地", "车辆代号", "运费" };
				model = new TableModel(title_name);
				table.setModel(model);
				arr4 = aduit.getnoaudit_LoadingListZZ();
				for (LoadingListZZVO vo : arr4)
					model.addRow(model.changeRow_Lolzz(vo));
				break;
			}
			case 5: {
				String[] title_name = { "ID", "订单类型", "制表人", "中转单编号", "装车时间",
						"所属中转中心", "出发地", "货物到达状态", "中转中心" };
				model = new TableModel(title_name);
				table.setModel(model);
				arr5 = aduit.getnoaudit_RecivalList();
				for (RecivalListVO vo : arr5)
					model.addRow(model.changeRow_Rcl(vo));
				break;
			}
			case 6: {
				String[] title_name = { "ID", "订单类型", "制表人", "订单编号", "派送时间",
						"所属营业厅", "送件快递员" };
				model = new TableModel(title_name);
				table.setModel(model);
				arr6 = aduit.getnoaudit_sendinglist();
				for (SendingListVO vo : arr6)
					model.addRow(model.changeRow_Sdl(vo));
				break;
			}
			case 7: {
				String[] title_name = { "ID", "订单类型", "制表人", "托运订单", "装车时间",
						"所属中转中心", "航班号/车次号", "监装员", "出发地", "货柜号", "到达地", "运费" };
				model = new TableModel(title_name);
				table.setModel(model);
				arr7 = aduit.getnoaudit_TransferList();
				for (TransferListVO vo : arr7)
					model.addRow(model.changeRow_Trl(vo));
				break;
			}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		table.updateUI();
	}

}
