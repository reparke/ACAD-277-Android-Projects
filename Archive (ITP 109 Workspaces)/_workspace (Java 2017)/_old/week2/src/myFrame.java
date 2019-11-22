import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class myFrame extends JFrame implements ActionListener {

	final int BASE_PRICE = 7;
	final int CHEESE_PRICE = 1;
	final int AVOCADO_PRICE = 1;
	final int BACON_PRICE = 2;
	int totalPrice = BASE_PRICE;

	JLabel lblInfo = new JLabel("Burger Base price is $" + BASE_PRICE);
	JCheckBox chkAvocado = new JCheckBox("Avocado (+ $" + AVOCADO_PRICE + ")");
	JCheckBox chkCheese = new JCheckBox("Cheese (+ $" + CHEESE_PRICE + ")");
	JCheckBox chkBacon = new JCheckBox("Bacon (+ $" + BACON_PRICE + ")");

	JLabel lblPrice = new JLabel("Final cost is ");
	JTextField txtPrice = new JTextField(4);
	JButton btn1 = new JButton("Calculate");

	public myFrame()
	{
		setSize(170, 400);
		setLayout(new FlowLayout());
		add(lblInfo);
		add(chkAvocado);
		add(chkCheese);
		add(chkBacon);
		add(btn1);
		add(lblPrice);
		add(txtPrice);
		
		btn1.addActionListener(this);


		txtPrice.setText("$" + totalPrice);
		txtPrice.setEditable(false);
	}

	public void actionPerformed(ActionEvent evt){
		totalPrice = BASE_PRICE;
		if (chkAvocado.isSelected() == true)
			totalPrice+=AVOCADO_PRICE;
		


		if (chkCheese.isSelected() == true)
			totalPrice+=CHEESE_PRICE;
		
		


		if (chkBacon.isSelected() == true)
			totalPrice+=BACON_PRICE;
		
		
		

		txtPrice.setText("$" + totalPrice);



	}

}

//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.*;
//
//public class myFrame extends JFrame implements ActionListener, ItemListener {
//	JLabel lbl1 = new JLabel("Toppings:");
//	JCheckBox chk1 = new JCheckBox("jalapenos");
//	JCheckBox chk2 = new JCheckBox("tofu");
//	JCheckBox chk3 = new JCheckBox("sausage");
//	
//	JLabel lbl2 = new JLabel("Size:");
//	JRadioButton rdb1 = new JRadioButton("Small");
//	JRadioButton rdb2 = new JRadioButton("Medium");
//	JRadioButton rdb3 = new JRadioButton("Large");
//	
//	JButton btn1 = new JButton("Order");
//	JTextField txt1 = new JTextField(20);
//
//	public myFrame() {
//		super();
//
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setSize(400, 400);
//
//		
//		setLayout(new GridLayout(3, 4));
//		add(lbl1);
//		add(chk1);
//		add(chk2);
//		add(chk3);
//		add(lbl2);
//		add(rdb1);
//		add(rdb2);
//		add(rdb3);
//		add(btn1);
//		add(txt1);
//		
//		btn1.addActionListener(this);
//		
//		setVisible(true);
//	}
//
//	public void actionPerformed (ActionEvent evt) {
//		String msg = "You ordered a ";
//		
//		if (rdb1.isSelected() == true)
//			msg += "small";
//		else if (rdb2.isSelected() == true)
//			msg += "medium";
//		else
//			msg += "large";
//		
//		msg += " pizza with ";
//		
//		if (chk1.isSelected() == true)
//			msg += "jalapenos,";	//we can use literal strings
//		if (chk2.isSelected()== true)
//			msg += chk2.getText() + ",";	//or we can read the text
//		if (chk3.isSelected() == true)
//			msg += "sausage";
//		
//		txt1.setText(msg);
//		System.out.println("FOO");
//	}
//	
//	public void itemStateChanged(ItemEvent evt) {
//
//		int select = evt.getStateChange();
//
//		if (evt.getItem() == chk1)	{
//			if (select == ItemEvent.SELECTED) {
//				chk1.setText("Lots of Jalapenos");
//			}
//			else if (select == ItemEvent.DESELECTED) {
//				chk1.setText("No Jalapenos");
//			}
//		}
//	}
//}