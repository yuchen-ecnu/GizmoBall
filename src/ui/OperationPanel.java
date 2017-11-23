package ui;

import constant.Constant;
import listener.OperationListener;
import utils.ImageUtils;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OperationPanel extends JPanel implements ActionListener{

    private OperationListener listener;

    private JButton btnAdvanceSquare;
    private JButton btnStick;
    private JButton btnLeftFlipper;
    private JButton btnRightFlipper;
    private JButton btnAbsorber;
    private JButton btnCircle;
    private JButton btnTriangle;
    private JButton btnTrapezoid;
    private JButton btnSquare;
    private JButton btnBall;
    private JButton btnRotation;
    private JButton btnDel;
    private JButton btnPlay;
    private JButton btnDonate;
    private JButton btnPause;
    private JSpinner bodySize;

    public OperationPanel(OperationListener listener){
        this.listener = listener;

        this.setBackground(Color.WHITE);
        this.setBounds(633, 10, 191, 610);
        this.setLayout(null);

        JPanel advanceCompPanel = new JPanel();
        advanceCompPanel.setBackground(Color.WHITE);
        advanceCompPanel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Advance Component", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
        advanceCompPanel.setBounds(10, 184, 160, 171);
        this.add(advanceCompPanel);
        advanceCompPanel.setLayout(null);

        btnAdvanceSquare = new JButton("");
        btnAdvanceSquare.setBorder(new LineBorder(Color.LIGHT_GRAY));
        btnAdvanceSquare.setContentAreaFilled(false);
        btnAdvanceSquare.setOpaque(false);
        btnAdvanceSquare.setBackground(Color.WHITE);
        btnAdvanceSquare.setBounds(31, 21, 40, 40);
        btnAdvanceSquare.setIcon(ImageUtils.getImage("stick_square.png", 30, 30));
        btnAdvanceSquare.addActionListener(this);
        advanceCompPanel.add(btnAdvanceSquare);

        btnStick = new JButton("");
        btnStick.setBorder(new LineBorder(Color.LIGHT_GRAY));
        btnStick.setContentAreaFilled(false);
        btnStick.setOpaque(false);
        btnStick.setBackground(Color.WHITE);
        btnStick.setBounds(95, 21, 40, 40);
        btnStick.setIcon(ImageUtils.getImage("stick.png", 30, 30));
        btnStick.addActionListener(this);
        advanceCompPanel.add(btnStick);

        btnLeftFlipper = new JButton("");
        btnLeftFlipper.setToolTipText("left board");
        btnLeftFlipper.setBorder(new LineBorder(Color.LIGHT_GRAY));
        btnLeftFlipper.setContentAreaFilled(false);
        btnLeftFlipper.setOpaque(false);
        btnLeftFlipper.setBackground(Color.WHITE);
        btnLeftFlipper.setBounds(31, 71, 40, 40);
        btnLeftFlipper.setIcon(ImageUtils.getImage("left_flipper.png", 30, 30));
        btnLeftFlipper.addActionListener(this);
        advanceCompPanel.add(btnLeftFlipper);

        btnRightFlipper = new JButton("");
        btnRightFlipper.setBorder(new LineBorder(Color.LIGHT_GRAY));
        btnRightFlipper.setContentAreaFilled(false);
        btnRightFlipper.setOpaque(false);
        btnRightFlipper.setBackground(Color.WHITE);
        btnRightFlipper.setBounds(95, 71, 40, 40);
        btnRightFlipper.setIcon(ImageUtils.getImage("right_flipper.png", 30, 30));
        btnRightFlipper.addActionListener(this);
        advanceCompPanel.add(btnRightFlipper);

        btnAbsorber = new JButton("");
        btnAbsorber.setToolTipText("Absorber,used to recycle balls");
        btnAbsorber.setBorder(new LineBorder(Color.LIGHT_GRAY));
        btnAbsorber.setContentAreaFilled(false);
        btnAbsorber.setOpaque(false);
        btnAbsorber.setBackground(Color.WHITE);
        btnAbsorber.setBounds(31, 121, 40, 40);
        btnAbsorber.setIcon(ImageUtils.getImage("absorber.png", 30, 30));
        btnAbsorber.addActionListener(this);
        advanceCompPanel.add(btnAbsorber);

        JButton button_10 = new JButton("");
        button_10.setBorder(new LineBorder(Color.LIGHT_GRAY));
        button_10.setContentAreaFilled(false);
        button_10.setOpaque(false);
        button_10.setBackground(Color.WHITE);
        button_10.setBounds(95, 121, 40, 40);
        advanceCompPanel.add(button_10);

        JPanel basicCompoPanel = new JPanel();
        basicCompoPanel.setBorder(new TitledBorder(null, "Basic Component", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        basicCompoPanel.setBackground(Color.WHITE);
        basicCompoPanel.setBounds(10, 10, 160, 171);
        this.add(basicCompoPanel);
        basicCompoPanel.setLayout(null);

        btnCircle = new JButton("");
        btnCircle.setBorder(new LineBorder(Color.LIGHT_GRAY));
        btnCircle.setContentAreaFilled(false);
        btnCircle.setOpaque(false);
        btnCircle.setBackground(Color.WHITE);
        btnCircle.setBounds(28, 20, 40, 40);
        btnCircle.setIcon(ImageUtils.getImage("circle.png", 30, 30));
        btnCircle.addActionListener(this);
        basicCompoPanel.add(btnCircle);

        btnTriangle = new JButton("");
        btnTriangle.setBorder(new LineBorder(Color.LIGHT_GRAY));
        btnTriangle.setContentAreaFilled(false);
        btnTriangle.setOpaque(false);
        btnTriangle.setBackground(Color.WHITE);
        btnTriangle.setBounds(92, 20, 40, 40);
        btnTriangle.setIcon(ImageUtils.getImage("triangle.png", 30, 30));
        btnTriangle.addActionListener(this);
        basicCompoPanel.add(btnTriangle);

        btnTrapezoid = new JButton("");
        btnTrapezoid.setBorder(new LineBorder(Color.LIGHT_GRAY));
        btnTrapezoid.setContentAreaFilled(false);
        btnTrapezoid.setOpaque(false);
        btnTrapezoid.setBackground(Color.WHITE);
        btnTrapezoid.setBounds(92, 70, 40, 40);
        btnTrapezoid.setIcon(ImageUtils.getImage("trapezoid.png", 30, 30));
        btnTrapezoid.addActionListener(this);
        basicCompoPanel.add(btnTrapezoid);

        btnSquare = new JButton("");
        btnSquare.setBorder(new LineBorder(Color.LIGHT_GRAY));
        btnSquare.setContentAreaFilled(false);
        btnSquare.setOpaque(false);
        btnSquare.setBackground(Color.WHITE);
        btnSquare.setBounds(28, 70, 40, 40);
        btnSquare.setIcon(ImageUtils.getImage("square.png", 30, 30));
        btnSquare.addActionListener(this);
        basicCompoPanel.add(btnSquare);

        btnBall = new JButton("");
        btnBall.setBorder(new LineBorder(Color.LIGHT_GRAY));
        btnBall.setContentAreaFilled(false);
        btnBall.setOpaque(false);
        btnBall.setBackground(Color.WHITE);
        btnBall.setBounds(28, 120, 40, 40);
        btnBall.setIcon(ImageUtils.getImage("ball.png", 30, 30));
        btnBall.addActionListener(this);
        basicCompoPanel.add(btnBall);

        JButton button_8 = new JButton("");
        button_8.setBorder(new LineBorder(Color.LIGHT_GRAY));
        button_8.setContentAreaFilled(false);
        button_8.setOpaque(false);
        button_8.setBackground(Color.WHITE);
        button_8.setBounds(92, 120, 40, 40);
        basicCompoPanel.add(button_8);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Operation", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
        panel.setBackground(Color.WHITE);
        panel.setBounds(10, 365, 160, 235);
        this.add(panel);

        btnRotation = new JButton();
        btnRotation.setOpaque(false);
        btnRotation.setContentAreaFilled(false);
        btnRotation.setBorder(new LineBorder(Color.LIGHT_GRAY));
        btnRotation.setBackground(Color.WHITE);
        btnRotation.setBounds(29, 53, 40, 40);
        btnRotation.setIcon(ImageUtils.getImage("rotation.png", 30, 30));
        btnRotation.addActionListener(this);
        panel.add(btnRotation);

        btnDel = new JButton();
        btnDel.setOpaque(false);
        btnDel.setContentAreaFilled(false);
        btnDel.setBorder(new LineBorder(Color.LIGHT_GRAY));
        btnDel.setBackground(Color.WHITE);
        btnDel.setBounds(89, 53, 40, 40);
        btnDel.setIcon(ImageUtils.getImage("delete.png", 30, 30));
        btnDel.addActionListener(this);
        panel.add(btnDel);

        btnPlay = new JButton("Play");
        btnPlay.setOpaque(false);
        btnPlay.setContentAreaFilled(false);
        btnPlay.setBorder(new LineBorder(Color.LIGHT_GRAY));
        btnPlay.setBackground(Color.WHITE);
        btnPlay.setBounds(29, 103, 100, 30);
        btnPlay.setIcon(ImageUtils.getImage("start.png", 20, 20));
        btnPlay.addActionListener(this);
        btnPlay.setEnabled(true);
        panel.add(btnPlay);

        btnDonate = new JButton("Donate");
        btnDonate.setBounds(29, 183, 100, 28);
        btnDonate.setIcon(ImageUtils.getImage("donate.png", 20, 20));
        btnDonate.addActionListener(this);
        panel.add(btnDonate);
        btnDonate.setOpaque(false);
        btnDonate.setContentAreaFilled(false);
        btnDonate.setBorder(new LineBorder(Color.LIGHT_GRAY));
        btnDonate.setBackground(Color.WHITE);

        btnPause = new JButton("Pause");
        btnPause.setOpaque(false);
        btnPause.setContentAreaFilled(false);
        btnPause.setBorder(new LineBorder(Color.LIGHT_GRAY));
        btnPause.setBackground(Color.WHITE);
        btnPause.setBounds(29, 143, 100, 28);
        btnPause.setIcon(ImageUtils.getImage("pause.png", 20, 20));
        btnPause.addActionListener(this);
        btnPause.setEnabled(false);
        panel.add(btnPause);

        bodySize = new JSpinner();
        bodySize.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
        bodySize.setBounds(69, 21, 60, 22);
        JSpinner.NumberEditor editor = new JSpinner.NumberEditor(bodySize, "0");
        bodySize.setEditor(editor);
        JFormattedTextField textField = ((JSpinner.NumberEditor) bodySize.getEditor()).getTextField();
        textField.setEditable(true);
        DefaultFormatterFactory factory = (DefaultFormatterFactory) textField .getFormatterFactory();
        NumberFormatter formatter = (NumberFormatter) factory.getDefaultFormatter();
        formatter.setAllowsInvalid(false);
        panel.add(bodySize);

        JLabel lblSize = new JLabel("Size:");
        lblSize.setBounds(29, 24, 40, 15);
        panel.add(lblSize);
    }


    public int getComponentSize(){
        return (int) bodySize.getValue();
    }

    /**
     * 点击监听
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton curBtn = (JButton) e.getSource();
        if(curBtn== btnAdvanceSquare){
            listener.onItemChoose(Constant.COMPONENT_ADVANCED_SQUARE);
        }else if(curBtn==btnStick){
            listener.onItemChoose(Constant.COMPONENT_ELASTIC_PLATE);
        }else if(curBtn==btnLeftFlipper){
            listener.onItemChoose(Constant.COMPONENT_LEFT_BAFFLE);
        }else if(curBtn==btnCircle){
            listener.onItemChoose(Constant.COMPONENT_CIRCLE);
        }else if(curBtn==btnRightFlipper){
            listener.onItemChoose(Constant.COMPONENT_RIGHT_BAFFLE);
        }else if(curBtn==btnAbsorber){
            listener.onItemChoose(Constant.COMPONENT_ABSORBER);
        }else if(curBtn==btnTriangle){
            listener.onItemChoose(Constant.COMPONENT_TRIANGLE);
        }else if(curBtn==btnTrapezoid){
            listener.onItemChoose(Constant.COMPONENT_TRAPEZOID);
        }else if(curBtn==btnSquare){
            listener.onItemChoose(Constant.COMPONENT_SQUARE);
        }else if(curBtn==btnBall){
            listener.onItemChoose(Constant.COMPONENT_BALL);
        }else if(curBtn==btnRotation){
            listener.onItemChoose(Constant.OPERATION_ROTATION);
        }else if(curBtn==btnDel){
            listener.onItemChoose(Constant.OPERATION_DELETE);
        }else if(curBtn==btnPlay){
            btnPlay.setEnabled(false);
            btnPause.setEnabled(true);
            listener.onOperationClicked(Constant.OPERATION_PLAY);
        }else if(curBtn==btnPause){
            btnPlay.setEnabled(true);
            btnPause.setEnabled(false);
            listener.onOperationClicked(Constant.OPERATION_PAUSE);
        }else if(curBtn==btnDonate){
            DonateDialog dialog = new DonateDialog();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        }
    }
}
