package Chatting;

// Chatting_Transaction class 에 좀 더 깔끔하게 데이터를 업로드 할 수 있도록 해주는 class

public class Chatting_TransactionBuilder {
	 private Chatting_Transaction t;
	public Chatting_TransactionBuilder(Chatting_Transaction t){
		 this.t = t;
	 }

	public Chatting_TransactionBuilder id(String id){
		t.setid(id);
		return this;
	}

	public Chatting_TransactionBuilder password(String password){
		t.setPassword(password);
		return this;
	}

	public Chatting_TransactionBuilder cCharac(String cCharac){
		t.setcCharac(cCharac);
		return this;
	}

	public Chatting_TransactionBuilder cGender(String cGender){
		t.setcGender(cGender);
		return this;
	}

	public Chatting_Transaction transaction(){
		return t;
	}
}

