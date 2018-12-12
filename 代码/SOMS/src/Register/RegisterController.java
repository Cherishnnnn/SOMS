package Register;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

import Login.Login;
import Sql.*;

public class RegisterController{
	public RegisterController() {
		// TODO Auto-generated constructor stub
	}
	@FXML
	private Button login,register;
	@FXML
	private TextField account;
	@FXML
	private PasswordField password,rpassword;
	@FXML
	private RadioButton rbpatient,rbdoctor;
    @FXML
    private Label tips;
    @FXML
    private ToggleGroup group;
    
	public void to_Login() throws Exception {
		Login l=new Login();
		l.showWindow();
		login.getScene().getWindow().hide(); 
	}
	
	@FXML
	public void to_Register() throws Exception{
		if(account.getText().isEmpty())
		{
			tips.setText("�˺Ų���Ϊ��");
			return ;
		}
	  else if(password.getText().isEmpty())
		{
			tips.setText("���벻��Ϊ��");
			return ;
		}
	  else if(rpassword.getText().isEmpty())
	  {
		  tips.setText("����д�ظ�����");
		  return ;
	  }
	  else if(!password.getText().equals(rpassword.getText()))
     {
		  tips.setText("������д�����벻һ��");
		  return ;
     }
	 else if(group.getSelectedToggle() == rbpatient)
	 {
		 if(Register_sql.Check_account(account.getText(), "patient"))
			tips.setText("���˺��ѱ�ע��");
		 else {
			 Register_sql.Register(account.getText(), password.getText(), "patient");
			 tips.setText("ע��ɹ�");
		 }
	 }
	 else if(group.getSelectedToggle() == rbdoctor)
	 {
		 if(Register_sql.Check_account(account.getText(), "doctor"))
			tips.setText("���˺��ѱ�ע��");
		 else 
			 {
			 Register_sql.Register(account.getText(), password.getText(), "doctor");
			 tips.setText("ע��ɹ�");
			 }
	 }
	 else tips.setText("��ѡ�����");
	}
  }