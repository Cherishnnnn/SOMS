package Client;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import Sql.Patient_sql;


public class Patient_modifyController{
	
	public Patient_modifyController() {
		// TODO Auto-generated constructor stub
	}
	@FXML
	private Button ok;
	@FXML
	private RadioButton male,female;
	@FXML
	private TextField age,tel;
	@FXML   
	private PasswordField password;
    @FXML
    private Label username,tips;
    @FXML
    private ToggleGroup group;
   
    public void OK_Action() throws Exception
    {
    	if(password.getText().isEmpty())
    	{
    		tips.setText("���벻��Ϊ��");
    		return ;
    	}
    	else if(group.getSelectedToggle() == null)
    	{
    		tips.setText("��ѡ���Ա�");
    		return ;
    	}
    	else if(age.getText().isEmpty())
    	{
    		tips.setText("����д����");
    		return ;
    	}
    	else if(tel.getText().isEmpty())
    	{
    		tips.setText("����д�绰");
    	}
    	else {
    		  if(group.getSelectedToggle() == male)
    	      Patient_sql.Insert_patient(username.getText(),password.getText(),"��",age.getText(),tel.getText());	
    		  else
    	      Patient_sql.Insert_patient(username.getText(),password.getText(),"Ů",age.getText(),tel.getText());
    		  ok.getScene().getWindow().hide();
    	}
    }
    
    
   
}