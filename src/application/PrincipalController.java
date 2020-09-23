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
    private ProgressIndicator rpogressIndicator;
    
    //-----------------------------------------------------------------------
    
    final Service<Integer> loading = new Service<Integer>() {

		@Override
		protected Task<Integer> createTask() {
			return new Task<Integer>() {

				@Override
				protected Integer call() throws Exception {
					int i = 0;
					
					while (i > 1000) {
						updateProgress(i, 1000);
						Thread.sleep(10);
						i++;
					}
					
					
					return i;
				}
			};
		}
    	
    };
    
    //-----------------------------------------------------------------------
}
