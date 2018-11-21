/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Component;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author folko
 */
public class JSliderOnJOptionPane {

    public JSliderOnJOptionPane() {
    }
    
  public int[] mJSliderOnJOptionPane(JFrame parent) {
    //JFrame parent = new JFrame();

    JOptionPane optionPane = new JOptionPane();
    JSlider slider = getSlider(optionPane);
    JSlider slider2 = getSlider(optionPane);
    
    Object complex[] = {"Veberte rok od: ", slider ,"Veberte rok do: ", slider2};
    
    optionPane.setMessage(complex); //new Object[] { "Veberte rok od: ", slider }
    optionPane.setMessageType(JOptionPane.QUESTION_MESSAGE);
    optionPane.setOptionType(JOptionPane.OK_CANCEL_OPTION);
    
    JDialog dialog = optionPane.createDialog(parent, "Vyber roku");
    dialog.setLocationRelativeTo(parent);
    
    dialog.setVisible(true);
    
    System.out.println("Input: " + optionPane.getInputValue());
    int i =slider.getValue();
    int d = slider2.getValue();
    return new int[]{slider.getValue(),slider2.getValue()};
  }

  static JSlider getSlider(final JOptionPane optionPane) {
    JSlider slider = new JSlider();
    slider.setMinimum(1998);
    slider.setMaximum(2018);
    slider.setMajorTickSpacing(5);
    slider.setMinorTickSpacing(1);
    slider.setPaintTicks(true);
    slider.setPaintLabels(true);
    ChangeListener changeListener = new ChangeListener() {
      public void stateChanged(ChangeEvent changeEvent) {
        JSlider theSlider = (JSlider) changeEvent.getSource();
        if (!theSlider.getValueIsAdjusting()) {
          optionPane.setInputValue(new Integer(theSlider.getValue()));
        }
      }
    };
    slider.addChangeListener(changeListener);
    return slider;
  }

}
