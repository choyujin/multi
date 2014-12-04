package dbtest2;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MainMenu {
	
	public static Connection makeConnection(){
        String url = "jdbc:mysql://localhost:3307/booktest";
        String id = "root";
        String pw = "gina1768";
        Connection con = null;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("����̹� ���� ���� ... �����ͺ��̽��� �������Դϴ�.");
            con = DriverManager.getConnection(url, id, pw);
            System.out.println("�����ͺ��̽� ���� ����");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        return con;
    }
    public static void main(String[] args) {
    	MainMenu menu = new MainMenu();
		menu.MainMenu();
        // TODO Auto-generated method stub
        
        
    }
    private void MainMenu() {
		String selectedMenuItem;
		Scanner MenuItemScan = new Scanner(System.in);
		
		System.out.println("|-----------------------------|\n");
		System.out.println("| ������ ���� ���� ���α׷�   |\n");
		System.out.println("|-----------------------------|\n");
		System.out.println("| 1. �α���                   |\n");
		System.out.println("| 2. �����ϱ�                 |\n");
		System.out.println("|-----------------------------|\n");
		System.out.println("�޴��� �����ϼ���: ");
		
		selectedMenuItem = MenuItemScan.nextLine();
		
		switch(selectedMenuItem){
		case "1":
			login();
			break;
		case "2":
			registerStudent();
			break;
		default:
			System.out.println("�������� �ʴ� �޴� ��ȣ�Դϴ�.");
			break;		
		}
		
		MenuItemScan.close();		
	}

	private void login(){
		String id = null;
		String password = null;
		Scanner logindatascan = new Scanner(System.in);
		
		System.out.println("���̵�� ��й�ȣ�� �Է����ּ���\n");
		System.out.println("ID: ");
		id = logindatascan.nextLine();
		System.out.println("Password: ");
		password = logindatascan.nextLine();
		
		System.out.println("id: " + id +  "  password: " + password);
		
		goBackMenu();
		
		logindatascan.close();				
	}
	
	private void registerStudent(){
		String id;
		String password;
		String name;
		String major;		
		Scanner registerdatascan = new Scanner(System.in);
		
		System.out.println("���ο� �л� ���� �����ϱ�\n���̵�� �й����� �Է����ּ���.\n");
		System.out.println("ID: ");
		id = registerdatascan.next();
		System.out.println("Password: ");
		password = registerdatascan.next();
		System.out.println("Name: ");
		name = registerdatascan.next();
		System.out.println("Major: ");
		major = registerdatascan.next();
		
		System.out.println(id+ " " + password + "  " + name + " " + major + "  ");
		try {
            // 1. ���� ��ü �����
            Connection con = makeConnection();// ���� �� ������ try�� �ۿ� ������ makeConnection()�� ������ ������
            // Connection con�� �����ϰ�. �Ʒ����� con.createStatement()���� ����� con�� ������ ���� ���� �� �ִ�!!(����)
            // 2. statment ��ü �����
            Statement stmt = con.createStatement();
            // 3. ResultSet �����
            String sql1 = "select * from student_db";
            ResultSet rs = stmt.executeQuery(sql1);//���ν��� ������ sql. �������� �ٲٴ� ������ ���
            // 4. ������ �����ϱ�.
            while(rs.next()){
                String st_id = rs.getString("studentid");
                String st_pw = rs.getString("studentpw");
                String st_name = rs.getString("studentname");
                String st_major = rs.getString("studentmajor");
                
                
                System.out.println(st_id+"\t"+st_pw+"\t"+st_name+"\t"+st_major);
            }
            
            String sql2 = "Insert into student_db values('"+id+"','"+password+"','"+name+"','"+major+"')";
            stmt.execute(sql2);
            rs = stmt.executeQuery(sql1);
            while(rs.next()){
                String st_id = rs.getString("studentid");
                String st_pw = rs.getString("studentpw");
                String st_name = rs.getString("studentname");
                String st_major = rs.getString("studentmajor");
                
                System.out.println(st_id+"\t"+st_pw+"\t"+st_name+"\t"+st_major);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
				
		goBackMenu();
		
		registerdatascan.close();
	}
	
	private void goBackMenu(){
		int selectedMenu;
		Scanner goMenuscan = new Scanner(System.in);
		
		System.out.println("\n\n���� �޴��� ���ư��ðڽ��ϱ�? ���Ͻø� 1�� �Է����ּ���.");
		selectedMenu = goMenuscan.nextInt();
		if(selectedMenu == 1){
			MainMenu.main(null);
		}
		else
			System.out.println("1�� �ƴմϴ�."); //���ϱ�
	}

}
