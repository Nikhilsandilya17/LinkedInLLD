package model;

public class JobPosting {
    private String id;
    private String jobTitle;
    private String company;
    private String location;

    public JobPosting(String id, String jobTitle, String company, String location) {
        this.id = id;
        this.jobTitle = jobTitle;
        this.company = company;
        this.location = location;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
