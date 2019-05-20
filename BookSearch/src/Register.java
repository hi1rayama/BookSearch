import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Register extends JPanel implements ActionListener {//図書データの保存の画面作成し、データを保存するクラス
	private JButton button1, btn;
	private JTextField txt1, txt2, txt3, txt4, txt5;
	public Boolean[] hantei = new Boolean[10];
	public int c = 0, d = 0;
	public int sum;

	Frame mf;
	String str;

	public Register(Frame m, String s) {//図書データ保存画面の作成
		mf = m;
		str = s;
		this.setName(s);
		this.setLayout(null);
		this.setSize(600, 300);

		btn = new JButton("Start画面に戻る");
		btn.setBounds(260, 230, 130, 20);



		JLabel lb1 = new JLabel("タイトル：");
		lb1.setBounds(30, 70, 80, 20);

		txt1 = new JTextField();
		txt1.setBounds(100, 70, 450, 20);

		JLabel lb2 = new JLabel("著者　　：");
		lb2.setBounds(30, 100, 80, 20);

		txt2 = new JTextField();
		txt2.setBounds(100, 100, 450, 20);

		JLabel lb3 = new JLabel("出版社　：");
		lb3.setBounds(30, 130, 80, 20);

		txt3 = new JTextField();
		txt3.setBounds(100, 130, 450, 20);

		JLabel lb4 = new JLabel("出版年　：");
		lb4.setBounds(30, 160, 80, 20);

		txt4 = new JTextField();
		txt4.setBounds(100, 160, 450, 20);

		JLabel lb5 = new JLabel("ＩＳＢＮ：");
		lb5.setBounds(30, 190, 80, 20);

		txt5 = new JTextField();
		txt5.setBounds(100, 190, 450, 20);

		button1 = new JButton("登録する");
		button1.setBounds(120, 230, 130, 20);
		this.add(lb1);
		this.add(txt1);
		this.add(button1);
		this.add(lb2);
		this.add(lb3);
		this.add(txt2);
		this.add(lb4);
		this.add(txt3);
		this.add(lb5);
		this.add(txt4);
		this.add(txt5);
		this.add(btn);
		button1.addActionListener(this);
		btn.addActionListener(this);

	}



	public void pc() {//STARTパネルにチェンジするメソッド
		mf.PanelChange((JPanel) this, mf.PanelNames[0], "START");
	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == btn) {//このボタンが押されたらSTART画面に戻る
			pc();
			setNull();
		} else if (e.getSource() == button1) {//登録ボタンが押されたら、入力されたデータを読み取り保存する
			String title, author, publisher, pyear, isbn;
			title = txt1.getText();
			author = txt2.getText();
			publisher = txt3.getText();
			pyear = txt4.getText();
			isbn = txt5.getText();
			if (title.equals("") || author.equals("") || publisher.equals("") || pyear.equals("") || isbn.equals("")) {
				//未入力があるとエラーを出す
				Frame.ShowWindow("error");//エラーの画面を呼び出す

			} else {//全項目入力されていれば、保存する
				BookDB.write(title, author, publisher, pyear, isbn);

				setNull();
				Frame.ShowWindow("register");//登録できたことをユーザーに伝える


			}

		}

	}
	public void setNull() {
		//それぞれのテキストの値を空白にする
		txt1.setText(null);
		txt2.setText(null);
		txt3.setText(null);
		txt4.setText(null);
		txt5.setText(null);

	}
}