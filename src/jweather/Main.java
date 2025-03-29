package jweather;

public class Main {
    public static void main(String[] args) {
        MainView gui = new MainView("JWeather 1.0");
        Model model = new Model();
        Controller controller = new Controller(gui, model);

        // Test run - output console
        controller.getWeatherData();
        controller.displayWeatherData();
    }
}
