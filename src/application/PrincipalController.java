package application;

import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;

public class PrincipalController {
	

    @FXML
    private Button employeeBtt;

    @FXML
    private Button customerBtt;

    @FXML
    private ProgressBar progressBar;

    @FXML
    private ProgressIndicator progressIndicator;
    
    //-----------------------------------------------------------------------
    
    final Service<Integer> loading = new Service<Integer>() {

		@Override
		protected Task<Integer> createTask() {
			return new Task<Integer>() {

				@Override
				protected Integer call() throws Exception {
					int i;
				
					for (i = 0; i < 1000; i++) {
						updateProgress(i, 1000);
						Thread.sleep(5);
					}
					enableBtt(true);
					return i;
				}
			};
		}
    	
    };
  //-----------------------------------------------------------------------
    
    void progressStart() {
    	progressBar.progressProperty().bind(loading.progressProperty());
    	progressIndicator.progressProperty().bind(loading.progressProperty());
    	
    	loading.start();
    }
    
    void enableBtt(boolean value) {
    	employeeBtt.setDisable(!value);
    	customerBtt.setDisable(!value);
    }
}
