package hello;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javafx.fxml.FXMLLoader;

@Component
public class SpringFxmlLoader {

	@Autowired
	private ApplicationContext applicationContext;

	@Autowired
	private SpringFxmlBuilderFactory builderFactory;

	public <T> T load(URL location) throws IOException {
		return load(location, null, null, null);
	}

	public <T> T load(URL location, ResourceBundle resources) throws IOException {
		return load(location, resources, null, null);
	}

	public <T> T load(URL location, Object controller) throws IOException {
		return load(location, null, controller, null);
	}

	public <T> T load(URL location, ResourceBundle resources, Object controller) throws IOException {
		return load(location, resources, controller, null);
	}

	public <T> T load(URL location, Object controller, Object root) throws IOException {
		return load(location, null, controller, root);
	}

	public <T> T load(URL location, ResourceBundle resources, Object controller, Object root) throws IOException {
		FXMLLoader loader = getFXMLLoader();
		loader.setLocation(location);
		loader.setResources(resources);
		loader.setController(controller);
		loader.setRoot(root);
		return loader.load();
	}

	public FXMLLoader getFXMLLoader() {
		FXMLLoader loader = new FXMLLoader();
		loader.setBuilderFactory(builderFactory);
		loader.setControllerFactory(applicationContext::getBean);
		return loader;
	}

}
