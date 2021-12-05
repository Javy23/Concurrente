package Controller;

import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.util.Duration;
import javafx.animation.Interpolator;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.concurrent.Task;

public class SampleController implements Initializable{
	
	@FXML
	ImageView imgVertical;
	@FXML
	ImageView imgHorizontal;
	@FXML
	Circle v1;
	@FXML
	Circle a1;
	@FXML
	Circle r1;
	@FXML
	Circle v2;
	@FXML
	Circle a2;
	@FXML
	Circle r2;
	
	TranslateTransition t = new TranslateTransition();
	TranslateTransition t2 = new TranslateTransition();

	HashMap<String, String> on = new HashMap<>();
	HashMap<String, String> off = new HashMap<>();
	
	@Override
	public void initialize(URL url, ResourceBundle rb) 
	{
		imgVertical.setImage(new Image("file:src/Files/V.gif", 150,150,false,true,true));
		imgVertical.setFitWidth(150);
		imgVertical.setFitHeight(150);
		
		imgHorizontal.setImage(new Image("file:src/Files/H.gif", 250,250,false,true,true));
		imgHorizontal.setFitWidth(250);
		imgHorizontal.setFitHeight(250);
		
		on.put("green","#15ff00");
		on.put("yellow","#ffc300");
		on.put("red","#ff0000");
		
		off.put("green","#064a00");
		off.put("yellow","#654f00");
		off.put("red","#5b0000");
		
		v1.setFill(Paint.valueOf(on.get("green")));
		r2.setFill(Paint.valueOf(on.get("red")));
		

		
		 t.setNode(imgVertical);
		 t2.setNode(imgHorizontal);
		 

		 
		Task<Void> task = new Task<Void>() {
	    @Override public Void call() {
	         
	    while (true) {
	    	try {
	    		
	    		
	    		 Platform.runLater(new Runnable() {
                     @Override public void run() {
                    	 
                    	 t.setFromX(0);
                		 t.setFromY(0);
                		
                		 t.setToX(0);
                		 t.setToY(800);
                		 t.setDuration(new Duration(12000));
                	     t.setInterpolator(Interpolator.LINEAR);
                	     t.play();   
                     }
                 });
	    		 
	    		 semaphore1();
	    		 
	    		 Platform.runLater(new Runnable() {
                     @Override public void run() {
                    	 
                    	 	t2.setFromX(0);
                    	 	t2.setFromY(0);
                    	 	 t2.setToX(900);
                    		 t2.setToY(0);
                    		 t2.setDuration(new Duration(10500));
                    	     t2.setInterpolator(Interpolator.LINEAR);
                    	     t2.play();
                    	 
                			 t.stop();
                			 t.setFromX(0);
                			 t.setFromY(-300);
                			 t.setToX(0);
                    		 t.setToY(0);
                    		 t.setDuration(new Duration(5000));
                    	     t.setInterpolator(Interpolator.LINEAR);
                			 t.play();  
      
                     }
                 });
	    		 semaphore2();
	    		 
	    		 Platform.runLater(new Runnable() {
                     @Override public void run() {
                    	 
                			 t2.stop();
                			 t2.setFromX(-500);
                			 t2.setFromY(0);
                			 t2.setToX(0);
                    		 t2.setToY(0);
                    		 t2.setDuration(new Duration(5000));
                    	     t2.setInterpolator(Interpolator.LINEAR);
                			 t2.play();  
    
                     }
                 });
	    		 
        		
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	
			
		}
	           
	    }
	};
	
	
		
		
		new Thread(task).start();
	
	}
	
	public int semaphore(int contador) 
	{
		try {
			
            
			switch(contador)
	        {
	            case 0:
	            	
	            	Thread.sleep(6000);
	            	   	v1.setFill(Paint.valueOf(off.get("green")));
		                a1.setFill(Paint.valueOf(on.get("yellow")));
		                Thread.sleep(2000);
		                a1.setFill(Paint.valueOf(off.get("yellow")));
		                r1.setFill(Paint.valueOf(on.get("red")));
		                r2.setFill(Paint.valueOf(off.get("red")));
		                v2.setFill(Paint.valueOf(on.get("green")));
		                contador=1;
	                break;
	            case 1:
	            	Thread.sleep(6000);
	            	v2.setFill(Paint.valueOf(off.get("green")));
	                a2.setFill(Paint.valueOf(on.get("yellow")));
	                Thread.sleep(2000);
	                a2.setFill(Paint.valueOf(off.get("yellow")));
	                r2.setFill(Paint.valueOf(on.get("red")));
	                r1.setFill(Paint.valueOf(off.get("red")));
	                v1.setFill(Paint.valueOf(on.get("green")));
	            	contador=0;
	    
	                break;
	        }

		
           
    } catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
		
		return contador;
	}
	
	
	private void semaphore1() {
		
		try {
	            Thread.sleep(7000);
	            v1.setFill(Paint.valueOf(off.get("green")));
		        a1.setFill(Paint.valueOf(on.get("yellow")));
		        Thread.sleep(2500);
		        a1.setFill(Paint.valueOf(off.get("yellow")));
		        r1.setFill(Paint.valueOf(on.get("red")));
		        r2.setFill(Paint.valueOf(off.get("red")));
		        v2.setFill(Paint.valueOf(on.get("green")));
		          
    } catch (InterruptedException e) 
	{
		e.printStackTrace();
	}
	}
	
private void semaphore2() {
		
		try {
			
				Thread.sleep(7000);
				v2.setFill(Paint.valueOf(off.get("green")));
				a2.setFill(Paint.valueOf(on.get("yellow")));
				Thread.sleep(2500);
				a2.setFill(Paint.valueOf(off.get("yellow")));
				r2.setFill(Paint.valueOf(on.get("red")));
				r1.setFill(Paint.valueOf(off.get("red")));
				v1.setFill(Paint.valueOf(on.get("green")));
        	   
    } catch (InterruptedException e) 
	{
		e.printStackTrace();
	}
	}
	
}
