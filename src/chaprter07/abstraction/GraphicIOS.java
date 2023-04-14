package chaprter07.abstraction;

public class GraphicIOS {
	
	private String name;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public void draw_textBox() {
		System.out.println("텍스트 상자를 그린다");


	}
	public void draw_submitButton() {
		System.out.println("전송버튼을 그린다");
	}

}
