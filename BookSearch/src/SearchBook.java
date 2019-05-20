import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SearchBook extends JPanel implements ActionListener {//検索画面を作成し、ユーザの操作に応じてBookDBに依頼を行う
	private JButton button1, button2, button3, button5, btn;
	private JTextField txt1, txt2, txt3, txt4, txt5, txt6;
	public Boolean[] hantei = new Boolean[100];//指定された文字列が入っていた場合true,入っていない場合はfalseを格納する配列。添え字時はBookDBの配列Bookに対応している
	public int c = 0, d = 0, p = 0;
	BookDB inst = new BookDB();

	Frame mf;
	String str;

	public SearchBook(Frame m, String s) {//検索画面のパーツの作成や配置を行う処理
		mf = m;
		str = s;
		this.setName(s);
		this.setLayout(null);
		this.setSize(600, 300);

		btn = new JButton("Start画面に戻る");
		btn.setBounds(240, 230, 130, 20);
		JLabel lb1 = new JLabel("検索語　：");
		lb1.setBounds(30, 10, 80, 20);

		txt1 = new JTextField(null);
		txt1.setBounds(100, 10, 300, 20);

		button1 = new JButton("検索");
		button1.setBounds(410, 10, 80, 20);

		JLabel lb2 = new JLabel("結果　　：");
		lb2.setBounds(30, 40, 80, 20);

		JLabel lb3 = new JLabel("タイトル：");
		lb3.setBounds(30, 70, 80, 20);

		txt2 = new JTextField();
		txt2.setBounds(100, 70, 450, 20);

		JLabel lb4 = new JLabel("著者　　：");
		lb4.setBounds(30, 100, 80, 20);

		txt3 = new JTextField();
		txt3.setBounds(100, 100, 450, 20);

		JLabel lb5 = new JLabel("出版社　：");
		lb5.setBounds(30, 130, 80, 20);

		txt4 = new JTextField();
		txt4.setBounds(100, 130, 450, 20);

		JLabel lb6 = new JLabel("出版年　：");
		lb6.setBounds(30, 160, 80, 20);

		txt5 = new JTextField();
		txt5.setBounds(100, 160, 450, 20);

		JLabel lb7 = new JLabel("ＩＳＢＮ：");
		lb7.setBounds(30, 190, 80, 20);

		txt6 = new JTextField();
		txt6.setBounds(100, 190, 450, 20);

		button2 = new JButton("<");
		button2.setBounds(120, 230, 50, 20);

		button3 = new JButton(">");
		button3.setBounds(180, 230, 50, 20);
		button5 = new JButton("このデータを消去");
		button5.setBounds(380, 230, 130, 20);

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
		this.add(lb6);
		this.add(txt5);
		this.add(lb7);
		this.add(txt6);
		this.add(button2);
		this.add(button3);
		this.add(btn);
		this.add(button5);
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		button5.addActionListener(this);
		btn.addActionListener(this);

		reset();

	}

	public void actionPerformed(ActionEvent e) {
		inst=new BookDB();
		int flag = 0;
		int i = 0;
		if (e.getSource() == btn) {//ボタンが押されたら出力された結果を空白にし、Start画面に戻る
			setNull();
			pc();
			reset();
		} else if (e.getSource() == button1) {//検索ボタンが押された時の処理


			String gStr = txt1.getText();//gStrにtxt１の値を格納
			reset();
			while (true) {

				if (inst.search(gStr, i) == -3) {//全ての図書データが読み込まれたら処理を終了する
					if (flag == 0) {
						Frame.ShowWindow("no");//全ての図書データが読み込まれ、該当する図書データがなかった場合、”見つからない”というWindowを表示
					}
					break;
				} else if (inst.search(gStr, i) == -2) {
					//文字を入力しないで検索ボタンが押された場合、何も表示させず、処理を終了
					setNull();

					break;
				} else if (inst.search(gStr, i) != -1 && flag != 0) {
					//指定された文字列を含む図書データが2番目以降に見つかった場合、Book[i]も指定された文字列を含む図書データがあるため配列s[i]をtrueにする
					hantei[i] = true;
					flag++;
					i++;
				} else if (inst.search(gStr, i) != -1 && flag == 0) {
					//指定された文字列を含む図書データが最初に見つかった場合、そのデータをそれぞれ表示する
					setText(i);
					c = i;
					hantei[i] = true;//Book[i]に指定された文字列を含む図書データがあるため、s[i]をtrueにする
					flag++;
					p = i;

					i++;
				} else {
					i++;
				}
			}

		}

		else if (e.getSource() == button2) {//”<”ボタンが押された時の処理

			for (int j = (d - 1); 0 <= j; j--) {

				if (hantei[j] == true) {
					//j番に格納されている図書データに指定された文字列を含んでいたら、そのデータをそれぞれ表示する
					setText(j);
					d = j;
					c = j;
					p = j;

					break;
				}

			}

		} else if (e.getSource() == button3) {//”>”ボタンが押された時の処理

			for (int j = (c + 1); j < hantei.length; j++) {
				//j番に格納されている図書データが指定された文字列を含んでいたら、そのデータをそれぞれ表示する
				if (hantei[j] == true) {
					setText(j);
					c = j;
					d = j;
					p = j;

					break;
				}

			}

		} else if (e.getSource() == button5) {
			//現在表示されているデータをファイルから消去する処理
			String title, author, publisher, pyear, isbn;
			//それぞれのデータを取得
			title = txt1.getText();
			author = txt2.getText();
			publisher = txt3.getText();
			pyear = txt4.getText();
			isbn = txt5.getText();
			if (title.equals("") || author.equals("") || publisher.equals("") || pyear.equals("") || isbn.equals("")) {
				//必要なデータが消されていればエラーを表示
				Frame.ShowWindow("error");

			} else {
				//データの消去
				BookDB.delite(p);
				//テキストボックスの初期化
				setNull();
				reset();
				Frame.ShowWindow("delite");
				c = 0;
				d = 0;
				p = 0;
			}
		}

	}

	public void reset() {
		//指定された文字列を含む図書データを判断するための配列の初期化
		for (int j = 0; j < hantei.length; j++) {
			hantei[j] = false;
		}

	}

	public void setText(int num) {
		//指定された番地の図書データを表示する
		txt2.setText(inst.a[num].getTitle());
		txt3.setText(inst.a[num].getAuthor());
		txt4.setText(inst.a[num].getPublisher());
		txt5.setText(inst.a[num].getPyear());
		txt6.setText(inst.a[num].getIsbn());

	}

	public void setNull() {
		//それぞれのテキストの値を空白にする
		txt6.setText("");
		txt2.setText("");
		txt3.setText("");
		txt4.setText("");
		txt5.setText("");

	}

	public void pc() {//スタート画面にパネルを変える
		mf.PanelChange((JPanel) this, mf.PanelNames[0], "Start");
	}

}
