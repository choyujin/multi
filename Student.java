import java.util.Scanner;

public class Student {

	public static void main(String[] args) {
		Student st = new Student();
		st.StudentMenu();
	}
	
	public static void StudentMenu(){
		String selectedMenuItem;
		Scanner MenuItemScan = new Scanner(System.in);
		
		System.out.println("|-----------------------------|\n");
		System.out.println("|----------�л� ���� �޴�----------|\n");
		System.out.println("| 1. å �˻��ϱ�                               |\n");
		System.out.println("| 2. ���� ��Ȳ                                 |\n");
		System.out.println("|-----------------------------|\n");
		System.out.println(" �޴��� �����ϼ���: ");
		
		selectedMenuItem = MenuItemScan.nextLine();
		
		switch(selectedMenuItem){
		case "1":
			search();
			break;
		case "2":
			checkOut();
			break;
		default:
			System.out.println("�������� �ʴ� �޴� ��ȣ�Դϴ�.");
			break;		
		}
		
		MenuItemScan.close();	
	}
	
	private static void search(){
		Scanner scnbook = new Scanner(System.in);
		 System.out.print("å�� �˻��Ͻ÷��� å ������ �Ϻθ� �Է����ּ���. �޴��� �ٽ� ���ư���� ���ϸ� ���� 1�� �����ּ���");
		 String back = scnbook.nextLine();
		 //å ������ ������ ��� �˻����� ����
		 switch(back){
		 case "1":
			 StudentMenu();
			 break;
		default:
			System.out.println("�������� �ʴ� �޴���ȣ�Դϴ�.");
			break;
			 
		 }	 
	}
	
	private static void checkOut(){
		Scanner scncheck = new Scanner(System.in);
		 System.out.print("������ å�� ����Դϴ�. �ݳ��� ���Ͻø� �ش� å�� ��ȣ�� �����ּ���.");
		 String checkbooknu = scncheck.nextLine();
		 switch(checkbooknu){
		 case "1":
			 break;
		default:
			System.out.println("�������� �ʴ� �޴���ȣ�Դϴ�.");
			break;
			 
		 }	 
	}
	
	

}
