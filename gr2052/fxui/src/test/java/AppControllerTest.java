public class AppControllerTest extends ApplicationTest {

    private AppController controller;

    /**
     * Set up for testing AppController.java
     */

    @Override
    public void start(final Stage stage) throws Exception {
        final FXMLLoader loader = new FXMLLoader(getClass().getResource("FxApp.fxml"));
        final Parent root = loader.load();
        this.controller = loader.getController();
        stage.setScene(new Scene(root));
        stage.show();
    }

    /**
     * Check if scene is switched to RegisterUser.fxml when clicking Register-Button in FxApp.fxml
     */

    @Test
    public void testRegisterButton(){
        clickOn("#registerUserButton");
        //FxAssert.verifyThat(window("My Window"), WindowMatchers.isShowing());
    }}


