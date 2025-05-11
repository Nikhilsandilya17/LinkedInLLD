import model.*;

public class LinkedinDemo {
    public static void main(String[] args) {

        LinkedinService linkedinService = LinkedinService.getInstance();
        User user1 = new User("Nikhil", "Nikhil-Email", "Nikhil-Password");
        linkedinService.registerUser(user1);
        User user2  = new User("Sandy", "Sandy-Email", "Sandy-Password");
        linkedinService.registerUser(user2);

        UserProfile userProfile = new UserProfile();
        userProfile.setSummary("Hi, I am a SDE");
        user1.setUserProfile(userProfile);

        Education education = new Education("Bachelor's Degree", "University of BLR", "BLR");
        linkedinService.addEducation(user1, education);
        Experience experience = new Experience("Company", "Position", "Duration", "Description");
        linkedinService.addExperience(user1, experience);
        Skill skill = new Skill("Java");
        linkedinService.addSkills(user1, skill);

        linkedinService.sendConnectionRequest(user1, user2);
        linkedinService.viewConnections(user1);

        linkedinService.postJob(new JobPosting("1", "Software Developer", "Company1", "Location1"));
        linkedinService.postJob(new JobPosting("2", "Software Engineer", "Company2", "Location2"));

        linkedinService.searchJob("Software");

        linkedinService.sendMessage(user1, user2);

        linkedinService.getAllNotifications(user1);



    }


}
