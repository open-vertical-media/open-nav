package openverticalmedia.opennav.sdk.task;

public interface TimelyInterface {
    String name();
    int sort();
    int minutes();
    void run();
}
