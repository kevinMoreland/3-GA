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
	String operation = "";
	String operand = "0";
	Double prevResult = 0.0;
	boolean resultFound = false;
	
	@Override
	public void start(Stage stage) throws Exception{
		stage.setTitle("Calculator");
		GridPane grid = new GridPane();
		final Text actiontarget = new Text();
		
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));
		grid.getColumnConstraints().add(new ColumnConstraints(55)); 
		grid.getColumnConstraints().add(new ColumnConstraints(55)); 
		grid.getColumnConstraints().add(new ColumnConstraints(55)); 
		grid.getColumnConstraints().add(new ColumnConstraints(55)); 
		grid.getColumnConstraints().add(new ColumnConstraints(55)); 
		grid.getColumnConstraints().add(new ColumnConstraints(55)); 
		
		
		
		
		Button addButton = new Button("+");
		addButton.setOnAction(new EventHandler<ActionEvent>() {
			 
		    @Override
		    public void handle(ActionEvent e) {	
		    	operation = "+";
	        	actiontarget.setText(actiontarget.getText() + operation);
	        	if(!resultFound) {
	        		prevResult = Double.valueOf(operand);
	        		operand = "0";
	        	}
		    }
		});
		grid.add(addButton, 0, 0);
		
		Button subButton = new Button("-");
		subButton.setOnAction(new EventHandler<ActionEvent>() {
			 
		    @Override
		    public void handle(ActionEvent e) {		        
		    	operation = "-";
	        	actiontarget.setText(actiontarget.getText() + operation);
	        	if(!resultFound) {
	        		prevResult = Double.valueOf(operand);
	        		operand = "0";
	        	}
		    }
		});
		grid.add(subButton, 1, 0);
		
		Button multButton = new Button("*");
		multButton.setOnAction(new EventHandler<ActionEvent>() {
			 
		    @Override
		    public void handle(ActionEvent e) {		        
		    	operation = "*";
	        	actiontarget.setText(actiontarget.getText() + operation);
	        	if(!resultFound) {
	        		prevResult = Double.valueOf(operand);
	        		operand = "0";
	        	}
		    }
		});
		grid.add(multButton, 2, 0);
		
		Button divideButton = new Button("/");
		divideButton.setOnAction(new EventHandler<ActionEvent>() {
			 
		    @Override
		    public void handle(ActionEvent e) {		        
		    	operation = "/";
	        	actiontarget.setText(actiontarget.getText() + operation);
	        	if(!resultFound) {
	        		prevResult = Double.valueOf(operand);
	        		operand = "0";
	        	}
		    }
		});
		grid.add(divideButton, 3, 0);
		
		Button powerButton = new Button("^");
		powerButton.setOnAction(new EventHandler<ActionEvent>() {
			 
		    @Override
		    public void handle(ActionEvent e) {		        
		        
		    	operation = "^";
	        	actiontarget.setText(actiontarget.getText() + operation);
	        	if(!resultFound) {
	        		prevResult = Double.valueOf(operand);
	        		operand = "0";
	        	}
		    }
		});
		grid.add(powerButton, 4, 0);
		
		Button logButton = new Button("log");
		logButton.setOnAction(new EventHandler<ActionEvent>() {
			 
		    @Override
		    public void handle(ActionEvent e) {	
		    	double valueUsed;
		    	if(resultFound) {
		    		valueUsed = prevResult;
			    	
		    	}
		    	else {
		    		valueUsed = Double.valueOf(operand);
		    	}
		    	if(valueUsed < 0) {
		    		actiontarget.setText("Bad log argument");
		    	}
		    	else
		    	{
		    		prevResult = Math.log10(valueUsed);
		        	actiontarget.setText(prevResult + " ");
		    	}
		    	operand = "0";
		    	resultFound = true;
		    }
		});
		grid.add(logButton, 5, 0);
		
		Button num0 = new Button("0");
		num0.setOnAction(new EventHandler<ActionEvent>() {
			 
		    @Override
		    public void handle(ActionEvent e) {	
		    	operand += "0";
		    	actiontarget.setText(actiontarget.getText() + "0");
		        
		    }
		});
		grid.add(num0, 0, 1);
		
		Button num1 = new Button("1");
		num1.setOnAction(new EventHandler<ActionEvent>() {
			 
		    @Override
		    public void handle(ActionEvent e) {		        
		    	operand += "1";
		    	actiontarget.setText(actiontarget.getText() + "1");
		        
		    }
		});
		grid.add(num1, 1, 1);
		
		Button num2 = new Button("2");
		num2.setOnAction(new EventHandler<ActionEvent>() {
			 
		    @Override
		    public void handle(ActionEvent e) {		        
		        
		    	operand += "2";
		    	actiontarget.setText(actiontarget.getText() + "2");
		    }
		});
		grid.add(num2, 2, 1);
		
		Button num3 = new Button("3");
		num3.setOnAction(new EventHandler<ActionEvent>() {
			 
		    @Override
		    public void handle(ActionEvent e) {		        
		        
		    	operand += "3";
		    	actiontarget.setText(actiontarget.getText() + "3");
		    }
		});
		grid.add(num3, 3, 1);
		
		Button num4 = new Button("4");
		num4.setOnAction(new EventHandler<ActionEvent>() {
			 
		    @Override
		    public void handle(ActionEvent e) {		        
		        
		    	operand += "4";
		    	actiontarget.setText(actiontarget.getText() + "4");
		    }
		});
		grid.add(num4, 4, 1);
		
		Button num5 = new Button("5");
		num5.setOnAction(new EventHandler<ActionEvent>() {
			 
		    @Override
		    public void handle(ActionEvent e) {		        
		    	operand += "5";
		    	actiontarget.setText(actiontarget.getText() + "5");
		        
		    }
		});
		grid.add(num5, 5, 1);
		
		Button num6 = new Button("6");
		num6.setOnAction(new EventHandler<ActionEvent>() {
			 
		    @Override
		    public void handle(ActionEvent e) {		        
		        
		    	operand += "6";
		    	actiontarget.setText(actiontarget.getText() + "6");
		    }
		});
		grid.add(num6, 0, 2);
		
		Button num7 = new Button("7");
		num7.setOnAction(new EventHandler<ActionEvent>() {
			 
		    @Override
		    public void handle(ActionEvent e) {		        
		        
		    	operand += "7";
		    	actiontarget.setText(actiontarget.getText() + "7");
		    }
		});
		grid.add(num7, 1, 2);
		
		Button num8 = new Button("8");
		num8.setOnAction(new EventHandler<ActionEvent>() {
			 
		    @Override
		    public void handle(ActionEvent e) {		        
		        
		    	operand += "8";
		    	actiontarget.setText(actiontarget.getText() + "8");
		    }
		});
		grid.add(num8, 2, 2);
		
		Button num9 = new Button("9");
		num9.setOnAction(new EventHandler<ActionEvent>() {
			 
		    @Override
		    public void handle(ActionEvent e) {		        
		    	operand += "9";
		    	actiontarget.setText(actiontarget.getText() + "9");
		        
		    }
		});
		grid.add(num9, 3, 2);
		
		
		
        grid.add(actiontarget, 0, 6);
        
        
		Button enterBtn = new Button("=");
		enterBtn.setOnAction(new EventHandler<ActionEvent>() {
			 
		    @Override
		    public void handle(ActionEvent e) {		        
		        ScriptEngineManager mgr = new ScriptEngineManager();
		        ScriptEngine engine = mgr.getEngineByName("JavaScript");
		        
		        double operandValue = Double.valueOf(operand);
		        System.out.println("op value: " + operandValue);
		        
		        switch(operation) {
		        	case "+":
		        		prevResult = prevResult + operandValue;
		        		actiontarget.setText(prevResult + "");
		        	break;
		        	case "-":
		        		prevResult = prevResult - operandValue;
		        		actiontarget.setText(prevResult + "");
		        	break;
		        	case "/":
		        		if(operand == "0") {
		        			actiontarget.setText("can't divide by 0");
		        		}
		        		else {
		        			prevResult = prevResult / operandValue;
			        		actiontarget.setText(prevResult + "");
		        		}
		        		
		        	break;
		        	case "*":
		        		prevResult = prevResult * operandValue;
		        		actiontarget.setText(prevResult + "");
		        	break;
		        	case "^":
		        		prevResult = Math.pow(prevResult, operandValue);
		        		actiontarget.setText(prevResult + "");
		        	break;
		        	default:
		        		actiontarget.setText("Operation must be: +,/,-,*,^,or log");
		        	break;
		     
		        }
		        operand = "0";
		        resultFound = true;
		    }
		});
		grid.add(enterBtn, 4, 0);
		
		Button clearButton = new Button("clear");
		clearButton.setOnAction(new EventHandler<ActionEvent>() {
			 
		    @Override
		    public void handle(ActionEvent e) {		        
		    	operand = "0";
		    	prevResult = 0.0;
		    	resultFound = false;
		    	actiontarget.setText("");
		        
		    }
		});
		grid.add(clearButton, 0, 4);
		
		Scene scene = new Scene(grid, 400, 350);
		stage.setScene(scene);
		stage.show();
	}
	

}
