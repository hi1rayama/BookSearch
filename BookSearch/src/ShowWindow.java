import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ShowWindow extends JPanel {//エラーや確認のパネル作成を行うクラス
	private JButton btn;
	private JLabel label;

	Frame ef;

	public ShowWindow(Frame m, String str) {
		ef = m;
		this.setLayout(null);
		this.setSize(300, 200);
		if (str == "error") {
			//エラーが出た時に表示する
			label = new JLabel("データが入力されていません");
			label.setBounds(50, 10, 250, 100);
		} else if (str == "register") {
			//登録が完了した時に表示する
			label = new JLabel("登録完了しました");
			label.setBounds(100, 10, 250, 100);
		} else if (str == "no") {
			//検索結果が見つからなかった時に表示する
			label = new JLabel("一致するものが見つかりませんでした");
			label.setBounds(30, 10, 250, 100);

		} else if (str == "delite") {
			//データを消去した時に表示する
			label = new JLabel("このデータを消去しました。");
			label.setBounds(80, 10, 250, 100);

		}

		label.setFont(new Font("ＭＳ ゴシック", Font.BOLD, 14));//フォントの設定
		btn = new JButton("OK");
		btn.setBounds(50, 100, 200, 40);
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//OKボタンが呼ばれたらこのウィンドウを閉じる
				ef.setVisible(false);
			}
		});
		this.add(btn);
		this.add(label);

	}
}
