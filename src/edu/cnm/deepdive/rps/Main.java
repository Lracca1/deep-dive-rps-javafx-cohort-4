package edu.cnm.deepdive.rps;

import edu.cnm.deepdive.rps.controller.Controller;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

  public static final String RESOURCES_DIR = "resources";
  public static final String ICON_RESOURCE = RESOURCES_DIR + "/rainbow.png";
  public static final String LAYOUT_RESOURCE = RESOURCES_DIR + "/main.fxml";
  public static final String RESOURCE_BUNDLE_BASE_NAME = RESOURCES_DIR + "/ui-strings";
  public static final String WINDOW_TITLE_KEY = "window_title";

  private Controller controller;

  @Override
  public void start(Stage stage) throws Exception {
    ClassLoader classLoader = getClass().getClassLoader();
    ResourceBundle bundle = ResourceBundle.getBundle(RESOURCE_BUNDLE_BASE_NAME);
    FXMLLoader fxmlLoader = new FXMLLoader(classLoader.getResource(LAYOUT_RESOURCE), bundle);
    Parent root = fxmlLoader.load();
    controller = fxmlLoader.getController();
    Scene scene = new Scene(root);
    stage.setTitle(bundle.getString(WINDOW_TITLE_KEY));
    stage.getIcons().add(new Image(classLoader.getResourceAsStream(ICON_RESOURCE)));
    stage.setResizable(false);
    stage.setScene(scene);
    stage.show();
  }

  public void stop() throws Exception {
    controller.stop(null);
    super.stop();
  }

}
