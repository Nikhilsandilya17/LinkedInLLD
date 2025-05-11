package model;

public class Notification {
    private NotificationType notificationType;
    private String notificationMessage;

    public Notification(NotificationType notificationType, String notificationMessage) {
        this.notificationMessage = notificationMessage;
        this.notificationType = notificationType;
    }

    @Override
    public String toString() {
        return "Notification{" +
                "notificationType=" + notificationType +
                ", notificationMessage='" + notificationMessage + '\'' +
                '}';
    }
}
