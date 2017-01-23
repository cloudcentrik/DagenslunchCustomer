package net.cloudcentrik.dagenslunchcustomer;

/**
 * Created by ismail on 23/01/17.
 */

public class People {
    private String fullName;
    private String jobTitle;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public People(String fullName, String jobTitle) {
        this.fullName = fullName;
        this.jobTitle = jobTitle;
    }

    @Override
    public String toString() {
        return "People{" +
                "fullName='" + fullName + '\'' +
                ", jobTitle='" + jobTitle + '\'' +
                '}';
    }
}
