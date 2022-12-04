package HW22;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View extends JFrame {
    private JButton[][] buttons = new JButton[4][4];
    private JPanel rootPanel = new JPanel();
    private static JTextField input = new JTextField();
    private static Model modelInstance = Model.getInstance();

    public  View(){
        super("calculator");
        try{

            this.setBounds(100,100,500,500);
            this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

            Container container = this.getContentPane();
            container.setLayout(new GridLayout(5,1,2,2));
            input.addActionListener(new TextFieldEventListener());
            container.add(input);
            container = addButtons(container);
        } catch (RuntimeException e){
            JDialog dialog = createDialog(e.getMessage());
            dialog.setVisible(true);
        }

    }
    public Container addButtons(Container container){
        String[][] Signs = {
                {"7", "8", "9", "/"},
                {"4","5","6","*"},
                {"1","2","3","-"},
                {"0",".","+","="}
        };
        for(int i = 0; i < 4; i++){
            JPanel temporaryPanel = new JPanel();
            for(int j = 0; j < 4; j++){

                buttons[i][j] = new JButton(Signs[i][j]);
                buttons[i][j].setPreferredSize(new Dimension(100,100));
                if(i!=3 || j!=3){
                    buttons[i][j].addActionListener(new ButtonEventListener());
                } else {
                    buttons[i][j].addActionListener(new EqualsButtonEventListener());
                }

                temporaryPanel.add(buttons[i][j]);
            }
            container.add(temporaryPanel);
        }
        return container;
    }
    public static void main(String[] args){
        View app = new View();
        app.setVisible(true);
    }
    public static void setInput(){
        View.input.setText(View.modelInstance.getResult());
    }
    public static String getInput(){
        return View.input.getText();
    }
    public static void mutateInput(String el){
        View.input.setText(View.input.getText() + el);
    }
    public JDialog createDialog(String message){
        JDialog dialog = new JDialog(this,"Ошибка",true);
        dialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        dialog.setSize(300, 300);
        JPanel jp = new JPanel();
        jp.add(new JTextField(message));
        dialog.add(jp);
        return dialog;
    }
}
class ButtonEventListener implements ActionListener{

    public void actionPerformed(ActionEvent e){
        String action = e.getActionCommand();
        View.mutateInput(action);

        Controller.addSignOrNumberToRuntimeStack(action);
    }
}
class TextFieldEventListener implements ActionListener{
    public void actionPerformed(ActionEvent e){
        String text = View.getInput();
        View.mutateInput(text);
        Controller.addSignOrNumberToRuntimeStack(text);
    }
}
class EqualsButtonEventListener implements ActionListener{

    public void actionPerformed(ActionEvent e){

        Controller.calculateResult();
        View.setInput();
    }
}