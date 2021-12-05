module Concurrente {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	
	opens Controller to javafx.graphics, javafx.fxml;
}
