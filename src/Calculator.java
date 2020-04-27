import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptException;

public class Calculator extends Application{
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage stage) throws Exception{
		stage.setTitle("Calculator");
		GridPane grid = new GridPane();
	    grid.getColumnConstraints().add(new ColumnConstraints(100)); 
	    grid.getColumnConstraints().add(new ColumnConstraints(100)); 
	    grid.getColumnConstraints().add(new ColumnConstraints(100)); 
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));
		
		Label title = new Label("1st operand\n(or log base)");
		grid.add(title, 0, 0);
		
		Label title2 = new Label("operator\n(*,/,+,-,^,log)");
		grid.add(title2, 1, 0);
		
		Label title3 = new Label("2nd operand\n(or log argument)");
		grid.add(title3, 2, 0);
		
		TextField firstOperand = new TextField();
		grid.add(firstOperand, 0, 1);
		
		TextField operation = new TextField();
		grid.add(operation, 1, 1);
		
		TextField secondOperand = new TextField();
		grid.add(secondOperand, 2, 1);
		
		final Text actiontarget = new Text();
        grid.add(actiontarget, 0, 6);
        
        
		Button enterBtn = new Button("Calculate");
		enterBtn.setOnAction(new EventHandler<ActionEvent>() {
			 
		    @Override
		    public void handle(ActionEvent e) {		        
		        ScriptEngineManager mgr = new ScriptEngineManager();
		        ScriptEngine engine = mgr.getEngineByName("JavaScript");
		        actiontarget.setText(secondOperand.getText() + " " + firstOperand.getText());
		        
		        double firstNum, secondNum;
		        try {
		        	firstNum = Double.valueOf(firstOperand.getText());
		        	secondNum = Double.valueOf(secondOperand.getText());
		        }
		        catch(NumberFormatException exception) {
		        	actiontarget.setText("Operands must be numbers");
		        	return;
		        }
		        
		        switch(operation.getText()) {
		        	case "+":
		        		actiontarget.setText(firstNum + secondNum + "");
		        	break;
		        	case "-":
		        		actiontarget.setText(firstNum - secondNum + "");
		        	break;
		        	case "/":
		        		if(secondNum == 0) {
		        			actiontarget.setText("can't divide by 0");
		        		}
		        		else {
		        			actiontarget.setText(firstNum / secondNum + "");
		        		}
		        		
		        	break;
		        	case "*":
		        		actiontarget.setText(firstNum * secondNum + "");
		        	break;
		        	case "^":
		        		actiontarget.setText(Math.pow(firstNum, secondNum) + "");
		        	break;
		        	case "log":
		        		if(firstNum <= 1) {
		        			actiontarget.setText("Bad log base value");
		        		}
		        		else
		        		{
		        			actiontarget.setText(Math.log10(firstNum)/Math.log10(secondNum) +"");
		        		}
		        	break;
		        	default:
		        		actiontarget.setText("Operation must be: +,/,-,*,^,or log");
		        	break;
		     
		        }
		    }
		});
		grid.add(enterBtn, 0, 2);
		
		Scene scene = new Scene(grid, 400, 350);
		stage.setScene(scene);
		stage.show();
	}
	

}
