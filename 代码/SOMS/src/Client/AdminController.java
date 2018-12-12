package Client;

import Sql.Admin_sql;
import Sql.Register_sql;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;


public class AdminController{
	public AdminController() {
		// TODO Auto-generated constructor stub
	}
	
	@FXML
	private RadioButton madmin,patient,doctor;
    @FXML
    private TextField username,password;
    @FXML
    private Label tip;
    @FXML
    private ToggleGroup group;
    
    public void Action1() throws Exception{
            if(username.getText().isEmpty())
            	tip.setText("����д�û���");
            else if(group.getSelectedToggle() != patient && group.getSelectedToggle() != doctor && group.getSelectedToggle() != madmin)
            	tip.setText("��ѡ�����");
            else if(group.getSelectedToggle() == patient && Register_sql.Check_account(username.getText(), "patient"))    
	              password.setText(Admin_sql.getpassword(username.getText()));       
            else if(group.getSelectedToggle() == doctor && Register_sql.Check_account(username.getText(), "doctor"))
            	  password.setText(Admin_sql.getpassword(username.getText()));
            else if(group.getSelectedToggle() == madmin && Register_sql.Check_account(username.getText(), "madmin"))
            	  password.setText(Admin_sql.getpassword(username.getText()));
            else  {tip.setText("�û�������������ѡ�����");return;}
         tip.setText("��ѯ�ɹ�");       
    }
    
    public void Action2() throws Exception{
        if(username.getText().isEmpty())
        	{tip.setText("����д�û���");return;}
        else if(group.getSelectedToggle() != patient && group.getSelectedToggle() != doctor && group.getSelectedToggle() != madmin)
        	{tip.setText("��ѡ�����");return ;}
        else if(group.getSelectedToggle() == patient && Register_sql.Check_account(username.getText(), "patient"))    
              Admin_sql.setpassword(username.getText(),password.getText());       
        else if(group.getSelectedToggle() == doctor && Register_sql.Check_account(username.getText(), "doctor"))
        	   Admin_sql.setpassword(username.getText(),password.getText());       
        else if(group.getSelectedToggle() == madmin && Register_sql.Check_account(username.getText(), "madmin"))
        	   Admin_sql.setpassword(username.getText(),password.getText());       
        else  {tip.setText("�û�������������ѡ�����");return ;}
        
        tip.setText("�޸ĳɹ�");
       }
    
    public void Action3() throws Exception{
        if(username.getText().isEmpty())
        	{tip.setText("����д�û���");return;}
        else if(password.getText().isEmpty())
            {tip.setText("����д����");return;} 
        else if(group.getSelectedToggle() != patient && group.getSelectedToggle() != doctor && group.getSelectedToggle() != madmin)
        	{tip.setText("��ѡ�����");return ;}
        else if(group.getSelectedToggle() == patient && !Register_sql.Check_account(username.getText(), "patient"))    
                Register_sql.Register(username.getText(),password.getText(),"patient");       
        else if(group.getSelectedToggle() == doctor && !Register_sql.Check_account(username.getText(), "doctor"))
        	 Register_sql.Register(username.getText(),password.getText(),"doctor");      
        else if(group.getSelectedToggle() == madmin && !Register_sql.Check_account(username.getText(), "madmin"))
        	 Register_sql.Register(username.getText(),password.getText(),"madmin");     
        else  {tip.setText("�û�������������ѡ�����");return ;}
        
        tip.setText("��ӳɹ�");
       }
    
    public void Action4() throws Exception{
        if(username.getText().isEmpty())
        	{tip.setText("����д�û���");return;}
        else{
          Admin_sql.delete(username.getText());
            tip.setText("ɾ���ɹ�");
         }
      }
}