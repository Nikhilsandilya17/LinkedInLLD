import model.*;

import java.time.LocalDateTime;
import java.util.*;

public class LinkedinService {
    private static LinkedinService instance;
    private Map<String, User> users;
    private Map<User, Set<User>> connections;
    private Map<String, JobPosting> jobPostings;
    NotificationFactory notificationFactory = new NotificationFactory();

    public static LinkedinService getInstance() {
        if (instance == null) {
            instance = new LinkedinService();
        }
        return instance;
    }

    protected LinkedinService() {
        users = new HashMap<>();
        connections = new HashMap<>();
        jobPostings = new HashMap<>();
    }

    public void registerUser(User user){
        users.put(user.getEmail(), user);
        System.out.println("User Registered Successfully: "+ user.toString());
    }

    public void sendMessage(User sender, User receiver){
        Message message = new Message(UUID.randomUUID().toString(), "Hello, I am sending you a message", sender, receiver, LocalDateTime.now());
        sender.getMessages().add(message);
        sendNotification(receiver, NotificationType.MESSAGE);
        System.out.println("Message: " + message.getContent() + " sent successfully from: " + sender.getName() + " to: " + receiver.getName());
    }
    private void acceptConnectionRequest(User fromUser, User toUser){
        connections.get(fromUser).add(toUser);
        connections.get(toUser).add(fromUser);
        
    }

    public void sendConnectionRequest(User fromUser, User toUser){
        connections.putIfAbsent(fromUser, new HashSet<>());
        connections.putIfAbsent(toUser, new HashSet<>());
        sendNotification(toUser, NotificationType.CONNECTION_REQUEST);
        acceptConnectionRequest(fromUser, toUser);
        System.out.println("Connection Request sent successfully from: " + fromUser.getName() + " to: " + toUser.getName());
    }

    private void sendNotification(User user, NotificationType notificationType){
        Notification notification = notificationFactory.getNotification(notificationType);
        user.getNotifications().add(notification);
    }

    public void addEducation(User user, Education education){
        UserProfile userProfile = getUserProfile(user);
        userProfile.getEducation().add(education);
        System.out.println("Education added successfully to user: " + user.getName());
    }
    
    public void addExperience(User user, Experience experience){
        UserProfile userProfile = getUserProfile(user);
        userProfile.getExperience().add(experience);
        System.out.println("Experience added successfully to user: " + user.getName());
    }
    
    public void addSkills(User user, Skill skill){
        UserProfile userProfile = getUserProfile(user);
        userProfile.getSkills().add(skill);
        System.out.println("Skills added successfully to user: " + user.getName());
    }

    private UserProfile getUserProfile(User user){
        return user.getUserProfile();
    }

    public void viewConnections(User user) {
        Set<User> userConnections = connections.getOrDefault(user, new HashSet<>());
        System.out.println("Connections for user " + user.getName() + ":");
        for (User connection : userConnections) {
            System.out.println(connection.getName());
        }
    }
    
    public void postJob(JobPosting jobPosting){
        jobPostings.put(jobPosting.getId(), jobPosting);
        createNotifications(users);
    }

    private void createNotifications(Map<String, User> users) {
        for (User user : users.values()) {
            Notification notification = new Notification(NotificationType.JOB_POSTING, "Job posting notification");
            user.getNotifications().add(notification);
        }
    }

    public void searchJob(String jobTitle) {
        for (JobPosting job : jobPostings.values()) {
            if (job.getJobTitle().contains(jobTitle)) {
                System.out.println("Job found with title: " + jobTitle + " at " + job.getCompany() + ", " + job.getLocation());
            }
        }
    }

    public void getAllNotifications(User user){
        List<Notification> notifications = user.getNotifications();
        for(Notification notification: notifications){
            System.out.println(notification.toString());
        }
    }
}
