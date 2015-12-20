package elms.presentation.managerui.freight.freighthelper;

import java.awt.Dimension;
import java.util.ArrayList;

import elms.po.FreightStrategyPO;
import elms.presentation.uihelper.ListPanel;
import elms.vo.FreightStrategyVO;

public class FreightListPanel extends ListPanel {

	public FreightListPanel(Dimension d) {
		super(d);
		// TODO 自动生成的构造函数存根
		String[] menu = { "      城市1      ", "      城市2      ",
				"      距离      ", "    标准运费单价      ", "    调整因子    " };
		addMenu(menu);
		addTag("运费策略");

	
	}

	protected String getOutput(FreightStrategyVO vo) {
		String s = "               " + vo.getCity1()
				+ "                        " + vo.getCity2()
				+ "                      " + vo.getDistance()
				+ "                        " + vo.getStandardPrice()
				+ "                             " + vo.getCoefficient() + "  ";
		return s;
	}

	public void appendText(ArrayList<FreightStrategyVO> freight) {
		if(freight==null){
			return;
		}
		for (int i = 0; i < freight.size(); i++) {
			text.append(getOutput(freight.get(i)));
		}

	}

}
