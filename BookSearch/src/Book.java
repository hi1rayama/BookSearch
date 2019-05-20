
public class Book {//図書データ（タイトル、著者、出版社、出版年、ISBN）を表現するクラス
	private String title;
	private String author;
	private String publisher;
	private String pyear;
	private String isbn;
	private String all;

	Book(String t,String a,String p,String y,String i,String all) {//図書データの保存をする
		this.title=t;
		this.author=a;
		this.publisher=p;
		this.pyear=y;
		this.isbn=i;
		this.all=all;

	}

	//それぞれの図書データを送る
	public String getTitle() {
		return this.title;
	}

	public String getAuthor() {
		return this.author;
	}
	public String getPublisher() {
		return this.publisher;
	}
	public String getPyear() {
		return this.pyear;
	}
	public String getIsbn() {
		return this.isbn;
	}
	public String getAll() {
		return (this.all);
	}

}



