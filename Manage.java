import java.util.Scanner;

public class Manage {
	public static void main(String[] args) {
		Manage mg = new Manage();
		mg.Manage();       
    }
	
	public static void Manage() {
		Scanner scn = new Scanner(System.in);
        
        System.out.println("-------Menu------------");
        System.out.println("1. å ���");
        System.out.println("2. å �˻�");
        System.out.println("3. å ����");
        System.out.println("4. å ���� ������Ʈ");
        System.out.println("-----------------------");
        System.out.print("�޴��� �����ϼ��� => ");
        
        int menu = scn.nextInt();

        switch (menu) {
        case 1:
        	Register();
            break;
        case 2:
        	Search();
            break;
        case 3:
        	Delete();
            break;
        case 4:
        	Update();
            break;
        default:
            System.out.println("�������� �ʴ� �޴� ��ȣ�Դϴ�.");
            break;
        }       
	}

	private static void Register() {
		Scanner scn2 = new Scanner(System.in);
		
        System.out.print("menu�� ���ư��� ������ 1�� �Է��ϼ��� => ");
        
        int rg = scn2.nextInt();
        switch (rg) {
        case 1:
        	Manage();
            break;
        default:
            System.out.println("�߸��� �Է��Դϴ�.");
            break;
        }	
	}
	
	private static void Search() {
		Scanner scn3 = new Scanner(System.in);
		
        System.out.print("menu�� ���ư��� ������ 1�� �Է��ϼ��� => ");
        
        int sear = scn3.nextInt();
        switch (sear) {
        case 1:
        	Manage();
            break;
        default:
            System.out.println("�߸��� �Է��Դϴ�.");
            break;
        }		
	}
	
	private static void Delete() {
		Scanner scn4 = new Scanner(System.in);
		
        System.out.print("menu�� ���ư��� ������ 1�� �Է��ϼ��� => ");
        
        int del = scn4.nextInt();
        switch (del) {
        case 1:
        	Manage();
            break;
        default:
            System.out.println("�߸��� �Է��Դϴ�.");
            break;
        }		
	}
	
	private static void Update() {
		Scanner scn5 = new Scanner(System.in);
		
        System.out.print("menu�� ���ư��� ������ 1�� �Է��ϼ��� => ");
        
        int up = scn5.nextInt();
        switch (up) {
        case 1:
        	Manage();
            break;
        default:
            System.out.println("�߸��� �Է��Դϴ�.");
            break;
        }		
	}

}
