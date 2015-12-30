package elms.presentation;

import java.awt.Color;
import java.awt.Font;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.plaf.metal.MetalComboBoxUI;
import javax.swing.plaf.synth.SynthComboBoxUI;

@SuppressWarnings("serial")
public class MyComboBox extends JComboBox {

	Font f = new Font("微软雅黑",1,12);
	
	public MyComboBox(ComboBoxModel aModel) {
		super(aModel);
	}

	public MyComboBox(final Object items[]) {
	        super(items);
	        
	        setFont(f);
	    }

	public MyComboBox(Vector<?> items) {
		super(items);
	}

	public MyComboBox() {
		super();
	}

	@Override
	public void updateUI() {
		setUI(new MyComboBoxUI());
	}

	class MyComboBoxUI extends MetalComboBoxUI {

		@Override
		public void configureArrowButton() {
			super.configureArrowButton();
			if (arrowButton != null) {
				arrowButton.setBackground(Color.white);
//				arrowButton.setBorder(BorderFactory.createEmptyBorder(3, 3, 3,
//						3));
			}
		}
	}

}
