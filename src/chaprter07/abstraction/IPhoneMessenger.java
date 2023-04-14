package chaprter07.abstraction;

import java.security.PublicKey;

public class IPhoneMessenger extends GraphicIOS implements Messenger {


	
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "iPone";
	}

	@Override
	public void setMessage(String msg) {
		// TODO Auto-generated method stub
		System.out.println("iPone에서 메세지를 설정합니다. : msg");
	}
		
	public void clearMessage() {
		System.out.println("좌우로 흔들어 문자열을 지웁니다.");
	}


}
