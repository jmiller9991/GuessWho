import java.awt.*;
import javax.swing.*;

public class TxtHorzBoxLabel extends JPanel {
	JLabel label;
	JTextField tField;
	
	TxtHorzBoxLabel(String labelText, int fieldSize)
	{
		label = new JLabel(labelText);
		tField = new JTextField(fieldSize);
		setLayout(new GridLayout(1, 2));
		add(label);
		add(tField);
		label.setVisible(true);
		tField.setVisible(true);
	}
	
	//sets the color of the label
	public void setLabelColor(Color c)
	{
		label.setForeground(c);
		revalidate();
		repaint();
	}
	
	//sets font of label
	public void setLabelFont(Font f)
	{
		label.setFont(f);
		revalidate();
		repaint();
	}
	
	//sets the fg of text field
	public void setTxtBoxForeground(Color c)
	{
		tField.setForeground(c);
		revalidate();
		repaint();
	}
	
	//sets bg of text field
	public void setTxtBoxBackground(Color c)
	{
		tField.setBackground(c);
		revalidate();
		repaint();
	}
	
	//gets the text from text field
	public String getFieldText()
	{
		return tField.getText();
	}
	
	//adds text to field
	public void setTxtFieldText(String x)
	{
		tField.setText(x);
		revalidate();
		repaint();
	}
	
	//clears text field
	public void clear()
	{
		tField.setText(null); 
	}
}
