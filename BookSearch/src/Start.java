import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Start extends JPanel implements ActionListener{//メインパネルであるSTART画面を作成し、ユーザーの依頼を受け処理を行う
    JButton btn,btn2,btn4;
    Frame mf;
    String str;
    public Start(Frame m,String s){//START画面の作成とボタンが押された時の処理を行う
        mf = m;
        str = s;
        this.setName("START");
        this.setLayout(null);
        this.setSize(600, 300);
        btn = new JButton("検索");
        btn.setBounds(40, 100, 150, 40);

        this.add(btn);

        btn2 = new JButton("登録");
        btn2.setBounds(210, 100, 150, 40);

        this.add(btn2);


        btn4 = new JButton("終了");
        btn4.setBounds(380, 100, 150, 40);
        this.add(btn4);
    	btn.addActionListener(this);
    	btn2.addActionListener(this);
    	btn4.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {

    	if (e.getSource() == btn) {
    		//検索画面に移動する
            pc(mf.PanelNames[1],"検索");
    	}else if(e.getSource()==btn2){
    		//登録画面に移動する
            pc(mf.PanelNames[2],"登録");

    	}
    	else if(e.getSource()==btn4) {
    		//このボタンが押されたらこのアプリケーションを終了する
            System.exit(0);
    	}






    }
    public void pc(String str,String title){//与えられた引数に応じて画面変更を行う
        mf.PanelChange((JPanel)this, str,title);
    }
}
