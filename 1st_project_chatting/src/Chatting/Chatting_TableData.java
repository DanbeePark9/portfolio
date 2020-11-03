package Chatting;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.table.AbstractTableModel;

public class Chatting_TableData extends AbstractTableModel{
	private List<Chatting_Transaction> list;
	public Chatting_TableData(){
		updateList();
	}

	public void updateList(){
		list = new ArrayList<>();
		try{			
			Scanner sc = new Scanner(new File("./clientData.csv"));
			for(int i = 0; sc.hasNextLine();i++){
				String[] data = sc.nextLine().split(",");
				if(i != 0){
					Chatting_Transaction t = new Chatting_Transaction();
					Chatting_TransactionBuilder tb = new Chatting_TransactionBuilder(t);
					t = tb
							.id(data[0])
							.password(data[1])
							.cCharac(data[2])
							.cGender(data[3])
							.transaction();
					list.add(t);
				}
				
			}

		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	// id pass È®ÀÎ¿ë
	public int idCheck( String id, String pass ) {
		for(Chatting_Transaction t : list){
			if((t.getid().equals(id) == true) && (t.getPassword().equals(pass) == true)) {
					return 1;
			}
		}
		return 0;
	}

	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getRowCount() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public Object getValueAt(int row, int cell) {
		// TODO Auto-generated method stub
		return null;
	}

}




