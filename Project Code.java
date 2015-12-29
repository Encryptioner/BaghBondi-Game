//Submission Date : 7/12/2015

/*
*Course No : CSE 2100
*Project Name : Baghbondi Game
*Language : Java

*Project accomplished by : 
        Mir Mursalin Hossain
        Roll No : 133047
        2nd year,3rd Semister
        Dept of CSE,RUET

*Guided by : 
        Md. Arafat Hossain
        Assistant Professor, Dept of CSE,RUET
        and
        Dr. Md. Ali Hossain
        Lecturer, Dept of CSE,RUET
*/

package BaghBondi_Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BaghBondi_1 implements ActionListener {
    
    final String VERSION = "1.0";
    JFrame window = new JFrame("BaghBondi " + VERSION);
    
    JMenuBar mnuMain = new JMenuBar();
    JMenuItem mnuNewGame = new JMenuItem("New Game"),
        mnuInstruction = new JMenuItem("Instructions"),
        mnuAbout = new JMenuItem("About"),
        mnuExit = new JMenuItem("Exit");
    
    JButton btn1v1 = new JButton("Player vs Player"),
        btn1vCPU = new JButton("Player vs CPU"),
        btnBack = new JButton("<--back");
    JButton btn[] = new JButton[14];
    
    JPanel pnlNewGame = new JPanel(),
    pnlNorth = new JPanel(),
    pnlSouth = new JPanel(),
    pnlTop = new JPanel(),
    pnlBottom = new JPanel();
    
    final int X = 400, Y = 600, color = 190;
    final int a=40,b=40,c=X/2,d=(Y-2*b)/2,p=50,q=20,m=p/2,n=q/2;
    
    int[] x={a, c, X-a, (c+a)/2-10, c, (c+X-a)/2+10, c, (c+a)/2-10, c, (c+X-a)/2+10, a, c, X-a};
    int[] y={b, b, b, (d+b)/2-10, (d+b)/2-10, (d+b)/2-10, d, (d+Y-3*b)/2+10, (d+Y-3*b)/2+10, (d+Y-3*b)/2+10, Y-b-2*b, Y-b-2*b, Y-b-2*b};
    
    JPanel pnlgame=new JPanel()
        {
            protected void paintComponent(Graphics g)
            {
                super.paintComponent(g);
                
                g.drawLine(x[0],y[0],x[2],y[2]);
                g.drawLine(x[3],y[3],x[5],y[5]);
                g.drawLine(x[7],y[7],x[9],y[9]);
                g.drawLine(x[10],y[10],x[12],y[12]);
                
                g.drawLine(x[0],y[0],x[12],y[12]);
                g.drawLine(x[10],y[10],x[2],y[2]);
                g.drawLine(x[1],y[1],x[11],y[11]);
        }
        };
    private ImageIcon usIcon=new ImageIcon("G:\\Administrator\\My_Codes\\Java Files\\NetBeans\\Different_Projects\\src\\BaghBondi_Game\\6.JPG");
    JLabel icon = new JLabel(usIcon);
    JLabel lblTitle = new JLabel(" BaghBondi ");
    JTextArea txtMessage = new JTextArea();
    JTextArea txtNotification = new JTextArea();
    boolean inGame = false,s=false,t=false,u=false,v=false,inGame2=false;
    boolean win = false;
    boolean btnEmptyClicked = false;
    
    String msg="";
    int turn = 0,tiger=4,count=7,prei;
    
    public BaghBondi_1()
    {
        window.setSize(X, Y);
        window.setLocation(450, 120);
        window.setResizable(false);
        window.setLayout(new BorderLayout());
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Setting Panel layouts and properties
        pnlNewGame.setLayout(new GridLayout(2, 1, 0, 0));//(4, 1, 2, 6)) e h vgap,hgap er jonno last er ta dekha jai na, (3, 2, 0, 0)) te 6 ta content add kora lagbe
        pnlNorth.setLayout(new FlowLayout(FlowLayout.CENTER));
        pnlSouth.setLayout(new FlowLayout(FlowLayout.CENTER));

        pnlNorth.setBackground(new Color(color, color, color));//Menubar Jekhane ase
        pnlSouth.setBackground(new Color(color, color, color));//1st window te menubar bade purotai, baki window te majhe

        pnlTop.setBackground(new Color(color, color, color));//Menubar er niche
        pnlBottom.setBackground(new Color(color, color, color));

        pnlTop.setLayout(new FlowLayout(FlowLayout.CENTER));
        pnlBottom.setLayout(new FlowLayout(FlowLayout.CENTER));
        pnlNewGame.setBackground(Color.ORANGE);

        //Adding menu items to menu bar
        mnuMain.add(mnuNewGame);
        mnuMain.add(mnuInstruction);
        mnuMain.add(mnuAbout);
        mnuMain.add(mnuExit);//---->Menu Bar Complete

        //Adding buttons to NewGame panel
        pnlNewGame.add(btn1v1);
        pnlNewGame.add(btn1vCPU);        

        //Adding Action Listener to all the Buttons and Menu Items
        mnuNewGame.addActionListener(this);
        mnuExit.addActionListener(this);
        mnuInstruction.addActionListener(this);
        mnuAbout.addActionListener(this);
        btn1v1.addActionListener(this);
        btn1vCPU.addActionListener(this);
        btnBack.addActionListener(this);
        
        //Game_Panel();
        pnlgame.setLayout(null);
        pnlgame.setBackground(new Color(color+p, color+p, color+p));
        for(int i=0; i<13; i++) {
            btn[i] = new JButton("");
            btn[i].setEnabled(false);
            btn[i].setBackground(new Color(220, 220, 220));
            if(i==4)
            {
                btn[i].setText("00");
                btn[i].setBackground(Color.YELLOW);
            }
            if(i==6) {btn[6].setEnabled(true);}
            if(i>=6)
            {
                btn[i].setText("11");
                btn[i].setBackground(Color.GREEN);
            }            
            btn[i].addActionListener(this);
            
        }
        btn[0].setBounds(x[0]-m,y[0]-n,p,q); 
        btn[1].setBounds(x[1]-m,y[1]-n,p,q);
        btn[2].setBounds(x[2]-m,y[2]-n,p,q);
        
        btn[3].setBounds(x[3]-m,y[3]-n,p,q);        
        btn[4].setBounds(x[4]-m,y[4]-n,p,q);
        btn[5].setBounds(x[5]-m,y[5]-n,p,q);
        
        btn[6].setBounds(x[6]-m,y[6]-n,p,q);
        btn[7].setBounds(x[7]-m,y[7]-n,p,q);
        btn[8].setBounds(x[8]-m,y[8]-n,p,q);
        btn[9].setBounds(x[9]-m,y[9]-n,p,q);
        
        btn[10].setBounds(x[10]-m,y[10]-n,p,q);       
        btn[11].setBounds(x[11]-m,y[11]-n,p,q);
        btn[12].setBounds(x[12]-m,y[12]-n,p,q);
        
        for(int i=0; i<13; i++) {
            pnlgame.add(btn[i]);
        }
        
        //Adding everything needed to pnlNorth and pnlSouth
        pnlNorth.add(mnuMain);
        pnlSouth.add(lblTitle);//Only seen in first window
        pnlSouth.add(icon);

        //Adding to window and Showing window
        window.add(pnlNorth, BorderLayout.NORTH);
        window.add(pnlSouth, BorderLayout.CENTER);
        window.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent click) {
        Object source = click.getSource();
        if(inGame){        
            mainLogic(source);
        }   
        if(source == mnuNewGame) {
            clearPanelSouth();            
            pnlSouth.setLayout(new GridLayout(2, 1, 0, 0));
            pnlTop.add(pnlNewGame);
            pnlBottom.add(btnBack);
            pnlSouth.add(pnlTop);
            pnlSouth.add(pnlBottom);
            inGame=true;
        }
        else if(source == btn1v1) {
            if(inGame2) {
                int option = JOptionPane.showConfirmDialog(null, "If you start a new game," +
                "your current game will be lost." + "\n" +
                "Press YES for New Game and NO to continue Current Game.",
                "Quit Game?" ,JOptionPane.YES_NO_OPTION);
                    if(option == JOptionPane.YES_OPTION) {
                    clearPanelSouth();                    
                    turn=0;
                    msg="       Men's Turn.        ";
                    win=false;
                    pnlgame.removeAll();
                    //Game_Panel();     
                    
                    //pnlgame.repaint();
                    //pnlgame.revalidate();
                    //pnlgame.setLayout(null);
                    //pnlgame.setBackground(new Color(color, color, color));
                    /*for(int i=0; i<13; i++) {
                        btn[i] = new JButton("");
                        btn[i].setEnabled(false);
                        btn[i].setBackground(new Color(220, 220, 220));
                        if(i==4)
                        {
                            btn[i].setText("00");
                            btn[i].setBackground(Color.YELLOW);
                        }
                        if(i==6) {btn[6].setEnabled(true);}
                        if(i>=6)
                        {
                            btn[i].setText("11");
                            btn[i].setBackground(Color.GREEN);
                        }            
                        btn[i].addActionListener(this);
            
                    }
                    for(int i=0; i<13; i++) {
                        pnlgame.add(btn[i]);
                    }*/
                    //pnlgame.updateUI();
                    //pnlgame.revalidate();
                    showGame();
                    //System.out.println("inGame==true && inGame2==true and yes");  
                    }
                    else
                    {
                        clearPanelSouth();
                        showGame();
                        //System.out.println("inGame==true && inGame2==true and no");
                    }
            }
            if(!inGame2) {
                clearPanelSouth();               
                turn=0;
                msg="       Men's Turn.        ";
                win=false;
                inGame2=true;
                //System.out.println("inGame==true && inGame2==false");
                showGame();
            }
        }
        else if(source == btn1vCPU) {
            JOptionPane.showMessageDialog(null, "Coming Soon!!");
        }
        else if(source == mnuExit) {
            int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?",
            "Exit Game" ,JOptionPane.YES_NO_OPTION);
                if(option == JOptionPane.YES_OPTION)
                System.exit(0);
        }
        else if(source == mnuInstruction || source == mnuAbout) {
            clearPanelSouth();
            
            String message = "";
            txtMessage.setBackground(new Color(color, color, color));
                if(source == mnuInstruction) {
                    message = "Instructions:\n\n" +
                    "If you act as Tiger :\n   Your goal is to eat man such as u have to jump on a position \n   to b position when there is only one position between a and b. \n   When You are not eating you can move only a single distance \n   empty position. You have to careful about getting trapped by \n   human and then u will have no position to move.\n"
                            + "\nIf you act as Man :\n   Your goal is to trap tiger without getting eaten by it.\n";
                }
                else {
                    message = "About:\n\n" +
                    "Title: BaghBondi \n" +
                    "Author: Ankur_RUET_13 \n" +
                    "Description: Project on CSE 2100 \n"+
                    "Version: " + VERSION + "\n";
                }
            txtMessage.setEditable(false);
            txtMessage.setText(message);
            pnlSouth.setLayout(new BorderLayout());
            pnlTop.add(txtMessage);
            pnlBottom.add(btnBack);
            pnlSouth.add(pnlTop,BorderLayout.CENTER);
            pnlSouth.add(pnlBottom,BorderLayout.SOUTH);
        }
        else if(source == btnBack) {           
                clearPanelSouth();
                pnlSouth.setLayout(new FlowLayout(FlowLayout.CENTER));
                pnlNorth.setVisible(true);
                pnlSouth.add(lblTitle);
                pnlSouth.add(icon);
        }
        pnlSouth.setVisible(false);//
        pnlSouth.setVisible(true);
    }
    
    public void clearPanelSouth() { //Removes all the possible panels that pnlSouth, pnlTop, pnlBottom could have.
        pnlSouth.remove(lblTitle);
        pnlSouth.remove(icon);
        pnlSouth.remove(pnlTop);
        pnlSouth.remove(pnlBottom);
        pnlSouth.remove(pnlgame);
        pnlTop.remove(pnlNewGame);
        pnlTop.remove(txtMessage);
        pnlBottom.remove(txtNotification);
        pnlBottom.remove(btnBack);        
    }
    
    public void showGame() {       
        pnlSouth.setLayout(new BorderLayout());
        pnlNorth.setVisible(true);
        txtNotification.setEditable(false);
        txtNotification.setText(msg);       
        pnlBottom.add(txtNotification);
        pnlBottom.add(btnBack);
        pnlSouth.add(pnlgame,BorderLayout.CENTER);
        pnlSouth.add(pnlBottom,BorderLayout.SOUTH);
    }
    
    public void mainLogic(Object source){
        int tie=0,tye=0;
        for(int i=0; i<13; i++)
        {
            if(source==btn[i])
            {                
                if(turn%2==0)
                {
                    if(!s)
                    {
                    if(source == btn[0] && ( btn[1].getText().isEmpty() || btn[3].getText().isEmpty() ))
                    {
                        for(int j=0; j<13; j++)
                        {
                            btn[j].setEnabled(false);
                            if( (j==1||j==3) && (btn[j].getText().isEmpty() ))
                            {
                                btn[j].setEnabled(true);
                            }
                        }
                    }
                    if(source == btn[1] && ( btn[0].getText().isEmpty() || btn[2].getText().isEmpty() || btn[4].getText().isEmpty() ))
                    {
                        for(int j=0; j<13; j++)
                        {
                            btn[j].setEnabled(false);
                            if( (j==0||j==2||j==4) && (btn[j].getText().isEmpty() ))
                            {
                                btn[j].setEnabled(true);
                            }
                        }
                    }
                    if(source == btn[2] && ( btn[1].getText().isEmpty() || btn[5].getText().isEmpty() ))
                    {
                        for(int j=0; j<13; j++)
                        {
                            btn[j].setEnabled(false);
                            if( (j==1||j==5) && (btn[j].getText().isEmpty()) )
                            {
                                btn[j].setEnabled(true);
                            }
                        }
                    }
                    if(source == btn[3] && ( btn[0].getText().isEmpty() || btn[4].getText().isEmpty() || btn[6].getText().isEmpty() ))
                    {
                        for(int j=0; j<13; j++)
                        {
                            btn[j].setEnabled(false);
                            if( (j==0||j==4||j==6) && (btn[j].getText().isEmpty()) )
                            {
                                btn[j].setEnabled(true);
                            }
                        }
                    }
                    if(source == btn[4] && ( btn[1].getText().isEmpty() || btn[3].getText().isEmpty() || btn[5].getText().isEmpty() || btn[6].getText().isEmpty() ))
                    {
                        for(int j=0; j<13; j++)
                        {
                            btn[j].setEnabled(false);
                            if( (j==1||j==3||j==5 ||j==6) && (btn[j].getText().isEmpty()) )
                            {
                                btn[j].setEnabled(true);
                            }
                        }
                    }
                    if(source == btn[5] && ( btn[2].getText().isEmpty() || btn[4].getText().isEmpty() || btn[6].getText().isEmpty() ))
                    {
                        for(int j=0; j<13; j++)
                        {
                            btn[j].setEnabled(false);
                            if( (j==2||j==4||j==6) && (btn[j].getText().isEmpty()) )
                            {
                                btn[j].setEnabled(true);
                            }
                        }
                    }
                    if(source == btn[6] && ( btn[3].getText().isEmpty() || btn[4].getText().isEmpty() || btn[5].getText().isEmpty() || btn[7].getText().isEmpty() || btn[8].getText().isEmpty() || btn[9].getText().isEmpty() ))
                    {
                        for(int j=0; j<13; j++)
                        {
                            btn[j].setEnabled(false);
                            if( (j==3||j==4||j==5||j==7||j==8||j==9) && (btn[j].getText().isEmpty()) )
                            {
                                btn[j].setEnabled(true);
                            }
                        }
                    }
                    if(source == btn[7] && ( btn[6].getText().isEmpty() || btn[8].getText().isEmpty() || btn[10].getText().isEmpty() ))
                    {
                        for(int j=0; j<13; j++)
                        {
                            btn[j].setEnabled(false);
                            if( (j==6||j==8||j==10) && (btn[j].getText().isEmpty()) )
                            {
                                btn[j].setEnabled(true);
                            }
                        }
                    }
                    if(source == btn[8] && ( btn[6].getText().isEmpty() || btn[7].getText().isEmpty() || btn[9].getText().isEmpty() || btn[11].getText().isEmpty() ))
                    {
                        for(int j=0; j<13; j++)
                        {
                            btn[j].setEnabled(false);
                            if( (j==6||j==7||j==9 ||j==11) && (btn[j].getText().isEmpty()) )
                            {
                                btn[j].setEnabled(true);
                            }
                        }
                    }
                    if(source == btn[9] && ( btn[6].getText().isEmpty() || btn[8].getText().isEmpty() || btn[12].getText().isEmpty() ))
                    {
                        for(int j=0; j<13; j++)
                        {
                            btn[j].setEnabled(false);
                            if( (j==6||j==8||j==12) && (btn[j].getText().isEmpty()) )
                            {
                                btn[j].setEnabled(true);
                            }
                        }
                    }
                    if(source == btn[10] && ( btn[7].getText().isEmpty() || btn[11].getText().isEmpty() ))
                    {
                        for(int j=0; j<13; j++)
                        {
                            btn[j].setEnabled(false);
                            if( (j==7||j==11) && (btn[j].getText().isEmpty()) )
                            {
                                btn[j].setEnabled(true);
                            }
                        }
                    }
                    if(source == btn[11] && ( btn[8].getText().isEmpty() || btn[10].getText().isEmpty() || btn[12].getText().isEmpty() ))
                    {
                        for(int j=0; j<13; j++)
                        {
                            btn[j].setEnabled(false);
                            if( (j==8||j==10||j==12) && (btn[j].getText().isEmpty()) )
                            {
                                btn[j].setEnabled(true);
                            }
                        }
                    }
                    if(source == btn[12] && ( btn[9].getText().isEmpty() || btn[11].getText().isEmpty() ))
                    {
                        for(int j=0; j<13; j++)
                        {
                            btn[j].setEnabled(false);
                            if( (j==9||j==11) && (btn[j].getText().isEmpty()) )
                            {
                                btn[j].setEnabled(true);
                            }
                        }                        
                    }
                    prei=i;
                    t=true;
                    btn[prei].setBackground(Color.WHITE);                    
                    }
                    if(s)
                    {
                        btn[prei].setBackground(new Color(220, 220, 220));
                        btn[prei].setText("");
                        btn[i].setText("11");
                        btn[i].setBackground(Color.GREEN);
                        for(int j=0; j<13; j++)
                        {
                            btn[j].setEnabled(false);
                        }
                        btn[tiger].setEnabled(true);
                        turn++;
                        msg="       Tiger's Turn.        ";
                        t=false;
                        s=false;
                    }
                    if(t)
                    {
                        s=true;
                    }                    
                }
                else
                {                    
                    if(!u)
                    {                    
                    if(source == btn[0] && ( btn[1].getText().isEmpty() || btn[3].getText().isEmpty() || btn[2].getText().isEmpty() || btn[6].getText().isEmpty() ))
                    {
                        for(int j=0; j<13; j++)
                        {
                            btn[j].setEnabled(false);
                            if( (j==1||j==3) && (btn[j].getText().isEmpty()) )
                            {
                                btn[j].setEnabled(true);
                            }
                        }
                        if(!btn[1].getText().isEmpty() && btn[2].getText().isEmpty()) {btn[2].setEnabled(true);}
                        if(!btn[3].getText().isEmpty() && btn[6].getText().isEmpty()) {btn[6].setEnabled(true);}
                    }
                    if(source == btn[1] && ( btn[0].getText().isEmpty() || btn[2].getText().isEmpty() || btn[4].getText().isEmpty() || btn[6].getText().isEmpty() ))
                    {
                        for(int j=0; j<13; j++)
                        {
                            btn[j].setEnabled(false);
                            if( (j==0 || j==2 || j==4) && (btn[j].getText().isEmpty()) )
                            {
                                btn[j].setEnabled(true);
                            }
                        }
                        if(!btn[4].getText().isEmpty() && btn[6].getText().isEmpty()) {btn[6].setEnabled(true);}                        
                    }
                    if(source == btn[2] && ( btn[1].getText().isEmpty() || btn[5].getText().isEmpty() || btn[0].getText().isEmpty() || btn[6].getText().isEmpty() ))
                    {
                        for(int j=0; j<13; j++)
                        {
                            btn[j].setEnabled(false);
                            if( (j==1||j==5) && (btn[j].getText().isEmpty()) )
                            {
                                btn[j].setEnabled(true);
                            }
                        }
                        if(!btn[1].getText().isEmpty() && btn[0].getText().isEmpty()) {btn[0].setEnabled(true);}
                        if(!btn[5].getText().isEmpty() && btn[6].getText().isEmpty()) {btn[6].setEnabled(true);}
                    }
                    if(source == btn[3] && ( btn[0].getText().isEmpty() || btn[4].getText().isEmpty() || btn[6].getText().isEmpty() || btn[5].getText().isEmpty() || btn[9].getText().isEmpty() ))
                    {
                        for(int j=0; j<13; j++)
                        {
                            btn[j].setEnabled(false);
                            if( (j==0||j==4||j==6) && (btn[j].getText().isEmpty()) )
                            {
                                btn[j].setEnabled(true);
                            }
                        }
                        if(!btn[4].getText().isEmpty() && btn[5].getText().isEmpty()) {btn[5].setEnabled(true);}
                        if(!btn[6].getText().isEmpty() && btn[9].getText().isEmpty()) {btn[9].setEnabled(true);}
                    }
                    if(source == btn[4] && ( btn[1].getText().isEmpty() || btn[3].getText().isEmpty() || btn[5].getText().isEmpty() || btn[6].getText().isEmpty() || btn[8].getText().isEmpty() ))
                    {
                        for(int j=0; j<13; j++)
                        {
                            btn[j].setEnabled(false);
                            if( (j==1||j==3||j==5||j==6) && (btn[j].getText().isEmpty()) )
                            {
                                btn[j].setEnabled(true);
                            }
                        }
                        if(!btn[6].getText().isEmpty() && btn[8].getText().isEmpty()) {btn[8].setEnabled(true);}
                    }
                    if(source == btn[5] && ( btn[2].getText().isEmpty() || btn[4].getText().isEmpty() || btn[6].getText().isEmpty() || btn[3].getText().isEmpty() || btn[7].getText().isEmpty() ))
                    {
                        for(int j=0; j<13; j++)
                        {
                            btn[j].setEnabled(false);
                            if( (j==2||j==4||j==6) && (btn[j].getText().isEmpty()) )
                            {
                                btn[j].setEnabled(true);
                            }
                        }
                        if(!btn[4].getText().isEmpty() && btn[3].getText().isEmpty()) {btn[3].setEnabled(true);}
                        if(!btn[6].getText().isEmpty() && btn[7].getText().isEmpty()) {btn[7].setEnabled(true);}
                    }
                    if(source == btn[6] && ( btn[3].getText().isEmpty() || btn[4].getText().isEmpty() || btn[5].getText().isEmpty() || btn[7].getText().isEmpty() || btn[8].getText().isEmpty() || btn[9].getText().isEmpty() || btn[0].getText().isEmpty() || btn[1].getText().isEmpty() || btn[2].getText().isEmpty() || btn[10].getText().isEmpty() || btn[11].getText().isEmpty() || btn[12].getText().isEmpty()))
                    {
                        for(int j=0; j<13; j++)
                        {
                            btn[j].setEnabled(false);
                            if( (j==3||j==4||j==5||j==7 || j==8||j==9 ) && (btn[j].getText().isEmpty()) )
                            {
                                btn[j].setEnabled(true);
                            }
                        }
                        if(!btn[3].getText().isEmpty() && btn[0].getText().isEmpty()) {btn[0].setEnabled(true);}                        
                        if(!btn[4].getText().isEmpty() && btn[1].getText().isEmpty()) {btn[1].setEnabled(true);}                        
                        if(!btn[5].getText().isEmpty() && btn[2].getText().isEmpty()) {btn[2].setEnabled(true);}                
                        if(!btn[7].getText().isEmpty() && btn[10].getText().isEmpty()) {btn[10].setEnabled(true);}                        
                        if(!btn[8].getText().isEmpty() && btn[11].getText().isEmpty()) {btn[11].setEnabled(true);}                
                        if(!btn[9].getText().isEmpty() && btn[12].getText().isEmpty()) {btn[12].setEnabled(true);}                                               
                    }
                    if(source == btn[7] && ( btn[6].getText().isEmpty() || btn[8].getText().isEmpty() || btn[10].getText().isEmpty() || btn[5].getText().isEmpty() || btn[9].getText().isEmpty() ))
                    {
                        for(int j=0; j<13; j++)
                        {
                            btn[j].setEnabled(false);
                            if( (j==6||j==8||j==10) && (btn[j].getText().isEmpty()) )
                            {
                                btn[j].setEnabled(true);
                            }
                        }
                        if(!btn[6].getText().isEmpty() && btn[5].getText().isEmpty()) {btn[5].setEnabled(true);}
                        if(!btn[8].getText().isEmpty() && btn[9].getText().isEmpty()) {btn[9].setEnabled(true);}
                    }
                    if(source == btn[8] && ( btn[6].getText().isEmpty() || btn[7].getText().isEmpty() || btn[9].getText().isEmpty() || btn[11].getText().isEmpty() || btn[4].getText().isEmpty() ))
                    {
                        for(int j=0; j<13; j++)
                        {
                            btn[j].setEnabled(false);
                            if( (j==6||j==7||j==9||j==11) && (btn[j].getText().isEmpty()) )
                            {
                                btn[j].setEnabled(true);                                
                            }
                        }
                        if(!btn[6].getText().isEmpty() && btn[4].getText().isEmpty()) {btn[4].setEnabled(true);}
                    }
                    if(source == btn[9] && ( btn[6].getText().isEmpty() || btn[8].getText().isEmpty() || btn[12].getText().isEmpty() || btn[3].getText().isEmpty() || btn[7].getText().isEmpty() ))
                    {
                        for(int j=0; j<13; j++)
                        {
                            btn[j].setEnabled(false);
                            if( (j==6||j==8||j==12) && (btn[j].getText().isEmpty()) )
                            {
                                btn[j].setEnabled(true);
                            }
                        }
                        if(!btn[6].getText().isEmpty() && btn[3].getText().isEmpty()) {btn[3].setEnabled(true);}
                        if(!btn[8].getText().isEmpty() && btn[7].getText().isEmpty()) {btn[7].setEnabled(true);}
                    }
                    if(source == btn[10] && ( btn[7].getText().isEmpty() || btn[11].getText().isEmpty() || btn[6].getText().isEmpty() || btn[12].getText().isEmpty() ))
                    {
                        for(int j=0; j<13; j++)
                        {
                            btn[j].setEnabled(false);
                            if( (j==7||j==11) && (btn[j].getText().isEmpty()) )
                            {
                                btn[j].setEnabled(true);
                            }
                        }
                        if(!btn[7].getText().isEmpty() && btn[6].getText().isEmpty()) {btn[6].setEnabled(true);}
                        if(!btn[11].getText().isEmpty() && btn[12].getText().isEmpty()) {btn[12].setEnabled(true);}
                    }
                    if(source == btn[11] && ( btn[8].getText().isEmpty() || btn[10].getText().isEmpty() || btn[12].getText().isEmpty() || btn[6].getText().isEmpty() ))
                    {
                        for(int j=0; j<13; j++)
                        {
                            btn[j].setEnabled(false);
                            if( (j==8||j==10||j==12) && (btn[j].getText().isEmpty()) )
                            {
                                btn[j].setEnabled(true);
                            }
                        }
                        if(!btn[8].getText().isEmpty() && btn[6].getText().isEmpty()) {btn[6].setEnabled(true);}    
                    }
                    if(source == btn[12] && ( btn[9].getText().isEmpty() || btn[11].getText().isEmpty() || btn[6].getText().isEmpty() || btn[10].getText().isEmpty() ))
                    {
                        for(int j=0; j<13; j++)
                        {
                            btn[j].setEnabled(false);
                            if( (j==9||j==11) && (btn[j].getText().isEmpty()) )
                            {
                                btn[j].setEnabled(true);
                            }
                        }
                        if(!btn[9].getText().isEmpty() && btn[6].getText().isEmpty()) {btn[6].setEnabled(true);}
                        if(!btn[11].getText().isEmpty() && btn[10].getText().isEmpty()) {btn[10].setEnabled(true);}                        
                    }
                    v=true;
                    prei=i;
                    btn[i].setBackground(Color.WHITE);
                    btn[tiger].setEnabled(false);
                    }
                    if(u)
                    {
                        btn[prei].setBackground(new Color(220, 220, 220));
                        btn[prei].setText("");
                        btn[i].setText("00");
                        btn[i].setBackground(Color.YELLOW);
                        tiger=i;
                        for(int j=0; j<13; j++)
                        {
                            btn[j].setEnabled(false);
                            if(!btn[j].getText().isEmpty())
                            {
                                btn[j].setEnabled(true);
                            }
                        }                        
                        if(prei==0 && (i==2 || i==6) )
                        {
                            if(i==2) {btn[1].setText("");btn[1].setBackground(new Color(220, 220, 220));}
                            if(i==6) {btn[3].setText("");btn[6].setBackground(new Color(220, 220, 220));}
                            count--;
                        }
                        if(prei==1 && (i==6) )
                        {
                            if(i==6) {btn[4].setText("");btn[4].setBackground(new Color(220, 220, 220));}
                            count--;
                        }
                        if(prei==2 && (i==0 || i==6) )
                        {
                            if(i==0) {btn[1].setText("");btn[1].setBackground(new Color(220, 220, 220));}
                            if(i==6) {btn[5].setText("");btn[5].setBackground(new Color(220, 220, 220));}
                            count--;
                        }
                        if(prei==3 && (i==5 || i==9) )
                        {
                            if(i==5) {btn[4].setText("");btn[4].setBackground(new Color(220, 220, 220));}
                            if(i==9) {btn[6].setText("");btn[6].setBackground(new Color(220, 220, 220));}
                            count--;
                        }
                        if(prei==4 && (i==8) )
                        {
                            if(i==8) {btn[6].setText("");btn[6].setBackground(new Color(220, 220, 220));}
                            count--;
                        }
                        if(prei==5 && (i==3 || i==7) )
                        {
                            if(i==3) {btn[4].setText("");btn[4].setBackground(new Color(220, 220, 220));}
                            if(i==7) {btn[6].setText("");btn[6].setBackground(new Color(220, 220, 220));}
                            count--;
                        }
                        if(prei==6 && (i==0 || i==1 || i==2 || i==10 || i==11 || i==12) )
                        {
                            if(i==0) {btn[3].setText("");btn[3].setBackground(new Color(220, 220, 220));}
                            if(i==1) {btn[4].setText("");btn[4].setBackground(new Color(220, 220, 220));}
                            if(i==2) {btn[5].setText("");btn[5].setBackground(new Color(220, 220, 220));}
                            if(i==10) {btn[7].setText("");btn[7].setBackground(new Color(220, 220, 220));}
                            if(i==11) {btn[8].setText("");btn[8].setBackground(new Color(220, 220, 220));}
                            if(i==12) {btn[9].setText("");btn[9].setBackground(new Color(220, 220, 220));}
                            count--;
                        }
                        if(prei==7 && (i==5 || i==9) )
                        {
                            if(i==5) {btn[6].setText("");btn[6].setBackground(new Color(220, 220, 220));}
                            if(i==9) {btn[8].setText("");btn[8].setBackground(new Color(220, 220, 220));}
                            count--;
                        }
                        if(prei==8 && (i==4) )
                        {
                            if(i==4) {btn[6].setText("");btn[6].setBackground(new Color(220, 220, 220));}
                            count--;
                        }
                        if(prei==9 && (i==3 || i==7) )
                        {
                            if(i==3) {btn[6].setText("");btn[6].setBackground(new Color(220, 220, 220));}
                            if(i==7) {btn[8].setText("");btn[8].setBackground(new Color(220, 220, 220));}
                            count--;
                        }
                        if(prei==10 && (i==6 || i==12) )
                        {
                            if(i==6) {btn[7].setText("");btn[7].setBackground(new Color(220, 220, 220));}
                            if(i==12) {btn[11].setText("");btn[11].setBackground(new Color(220, 220, 220));}
                            count--;
                        }
                        if(prei==11 && (i==6) )
                        {
                            if(i==6) {btn[8].setText("");btn[8].setBackground(new Color(220, 220, 220));}
                            count--;
                        }
                        if(prei==12 && (i==6 || i==10) )
                        {
                            if(i==6) {btn[9].setText("");btn[9].setBackground(new Color(220, 220, 220));}
                            if(i==10) {btn[11].setText("");btn[11].setBackground(new Color(220, 220, 220));}
                            count--;
                        }
                        if(!btn[1].getText().isEmpty() && !btn[3].getText().isEmpty()) {btn[0].setEnabled(false);}
                        if(!btn[0].getText().isEmpty() && !btn[2].getText().isEmpty() && !btn[4].getText().isEmpty()) {btn[1].setEnabled(false);}
                        if(!btn[1].getText().isEmpty() && !btn[5].getText().isEmpty()) {btn[2].setEnabled(false);}
                        
                        if(!btn[0].getText().isEmpty() && !btn[4].getText().isEmpty() && !btn[6].getText().isEmpty()) {btn[3].setEnabled(false);}
                        if(!btn[1].getText().isEmpty() && !btn[3].getText().isEmpty() && !btn[5].getText().isEmpty() && !btn[6].getText().isEmpty()) {btn[4].setEnabled(false);}
                        if(!btn[2].getText().isEmpty() && !btn[4].getText().isEmpty() && !btn[6].getText().isEmpty()) {btn[5].setEnabled(false);}
                        
                        if(!btn[3].getText().isEmpty() && !btn[4].getText().isEmpty() && !btn[5].getText().isEmpty() && !btn[7].getText().isEmpty() && btn[8].getText().isEmpty() && btn[9].getText().isEmpty()) {btn[6].setEnabled(false);}
                        if(!btn[6].getText().isEmpty() && !btn[8].getText().isEmpty() && !btn[10].getText().isEmpty()) {btn[7].setEnabled(false);}
                        if(!btn[6].getText().isEmpty() && !btn[7].getText().isEmpty() && !btn[9].getText().isEmpty() && !btn[11].getText().isEmpty()) {btn[8].setEnabled(false);}
                        if(!btn[6].getText().isEmpty() && !btn[8].getText().isEmpty() && !btn[12].getText().isEmpty()) {btn[9].setEnabled(false);}
                        
                        if(!btn[7].getText().isEmpty() && !btn[11].getText().isEmpty()) {btn[10].setEnabled(false);}
                        if(!btn[8].getText().isEmpty() && !btn[10].getText().isEmpty() && !btn[12].getText().isEmpty()) {btn[11].setEnabled(false);}
                        if(!btn[9].getText().isEmpty() && !btn[11].getText().isEmpty()) {btn[12].setEnabled(false);}
                        btn[tiger].setEnabled(false);                       
                        for(int j=0; j<13; j++)
                        {
                        if(!btn[j].getText().isEmpty()) {tie++;                    
                            if(!btn[j].isEnabled()) {tye++;}
                        }            
                        }                        
                        turn++;
                        msg="       Men's Turn.        ";
                        u=false;
                        v=false;
                    }
                    if(v)
                    {
                        u=true;
                    }                    
                }
            }
            if(i==12 && !btn[0].isEnabled() && !btn[1].isEnabled() && !btn[2].isEnabled() && !btn[3].isEnabled() && !btn[4].isEnabled() && !btn[5].isEnabled() && !btn[6].isEnabled() && !btn[7].isEnabled() && !btn[8].isEnabled() && !btn[9].isEnabled() && !btn[10].isEnabled() && !btn[11].isEnabled() && !btn[12].isEnabled() )
            {
                btn[tiger].setBackground(Color.RED);
                JOptionPane.showMessageDialog(null, "                Congrates!!   Men Won!!!\nTiger is traped. Better luck for next time.");
                inGame=false;
                win=true;
            }  
        }
        txtNotification.setText(msg);        
        if(count<4)
        {
            for(int j=0; j<13; j++)
            {
                btn[j].setEnabled(false);
            }
            JOptionPane.showMessageDialog(null, "                           Congrates!!   Tiger Won!!!\nThis number of men are not enough to trap Tiger. Better luck next time.");
            inGame=false;
            win=true;
        }
        if(tie!=0 && tie==tye)
        {
            JOptionPane.showMessageDialog(null,"                        Match Tie!!\nThere is no possible move for both men and tiger.");
            inGame=false;
            win=true;
        }          
    }
    
    public static void main(String[] args) 
    {
        new BaghBondi_1(); // Calling the class construtor.
    }    
}
