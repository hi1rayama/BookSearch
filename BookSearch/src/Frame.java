import javax.swing.JFrame;
import javax.swing.JPanel;

public class Frame extends JFrame {//フレーム（ウィンドウ）を作成するためのクラス
	public String[] PanelNames = { "start", "searchBook", "register" };//パネルの名前
	Start start = new Start(this, PanelNames[0]);
	SearchBook search = new SearchBook(this, PanelNames[1]);
	Register register = new Register(this, PanelNames[2]);

	public Frame() {	//パネルを追加し、全てのパネルを非表示にする

		this.add(start);
		start.setVisible(false);
		this.add(search);
		search.setVisible(false);
		this.add(register);
		register.setVisible(false);
	}


	public static void main(String[] args) {
		//スタート画面を表示したいのでスタート画面のパネルを表示する


		Frame mf = new Frame();
		mf.setTitle("Start");
		mf.setBounds(10, 10, 600, 300);
		mf.setDefaultCloseOperation(EXIT_ON_CLOSE);
		mf.start.setVisible(true);
		mf.setVisible(true);

	}

	public void PanelChange(JPanel jp, String str, String title) {
		//

		this.setTitle(title);
		String name = jp.getName();
		if (name == PanelNames[0]) {

			start = (Start) jp;
		}
		start.setVisible(false);

		if (name == "SearchBook") {

			search = (SearchBook) jp;
		}
		search.setVisible(false);

		if (name == PanelNames[2])
			register = (Register) jp;
		register.setVisible(false);

		if (str == PanelNames[0])
			start.setVisible(true);

		if (str == PanelNames[1])
			search.setVisible(true);

		if (str == PanelNames[2])
			register.setVisible(true);

	}

	public static void ShowWindow(String str) {
		//エラーや確認のためのウィンドウを表示する
		Frame win = new Frame();
		win.setBounds(10, 10, 300, 200);
		win.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);//バツボタンを押しても消えないようにする
		win.setVisible(true);
		win.setTitle(str);
		ShowWindow showwindow = new ShowWindow(win, str);
		win.add(showwindow);
		showwindow.setVisible(true);
	}

}
