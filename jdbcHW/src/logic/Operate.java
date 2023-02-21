package logic;

import java.util.Scanner;

import bean.Hospital;
import dao.DBOperation;

public class Operate {
public static void main(String[] args) {
	int v =10;
	Scanner obj =new Scanner(System.in);
	Hospital h = new Hospital();
	System.out.println("Press 1 to insert\npress 2 to update \n press 3 to delete \n press  4 to view  ");
	v = obj.nextInt();
	
	switch (v) {
	case 1:System.out.println("Enter ID");
	h.setId(obj.nextInt());
	System.out.println("Enter name");
	h.setName(obj.nextLine()+obj.next());
	System.out.println("Enter Age");
	h.setAge(obj.nextInt());
	System.out.println("Enter ward no.");
	h.setWard(obj.nextInt());
	System.out.println("Enter Doctor nam e");
	h.setDoctor(obj.next());
	System.out.println("Enter Admit date");
	h.setAdmit_date(obj.next());
	DBOperation.insert(h);
	break;
	
case 2:System.out.println("Enter ID");
h.setId(obj.nextInt());
System.out.println("Enter name");
h.setName(obj.nextLine()+obj.next());
System.out.println("Enter Age");
h.setAge(obj.nextInt());
System.out.println("Enter ward no.");
h.setWard(obj.nextInt());
System.out.println("Enter Doctor name");
h.setDoctor(obj.next());
System.out.println("Enter Admit date");
h.setAdmit_date(obj.next());
DBOperation.update(h);
break;
	
case 3 :  System.out.println("Enter id");
DBOperation.delete(obj.nextInt());
break;

case 4 : DBOperation.view();
break;
default: System.out.println("Please enter valid number");
	
	}
}
}
