package ui.enums;

public enum CompanyPages {
    ABOUT_AS("About Us"),
    NEWSROOM("Newsroom"),
    PARTNERSHIP("Partnerships"),
    INTEGRATIONS("Integrations"),
    CAREERS("Careers"),
    CONTACT_US("Contact Us");

    private final String value;

    CompanyPages(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
