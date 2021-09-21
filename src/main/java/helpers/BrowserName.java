package helpers;

public enum BrowserName {
    CHROME("chrome"),
    FIREFOX("firefox"),
    EDGE("edge");

    private final String name;

    BrowserName(String browserName) {
        name = browserName;
    }

    public String getName() {
        return name;
    }
}
