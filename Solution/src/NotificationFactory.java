import model.Notification;
import model.NotificationType;

public class NotificationFactory {
    public Notification getNotification(NotificationType notificationType) {
        return switch (notificationType) {
            case CONNECTION_REQUEST -> new Notification(NotificationType.CONNECTION_REQUEST, "Connection request");
            case MESSAGE -> new Notification(NotificationType.MESSAGE, "Message");
            case JOB_POSTING -> new Notification(NotificationType.JOB_POSTING, "Job posting");
            default -> null;
        };
    }
}