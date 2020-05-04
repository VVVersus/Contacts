package contacts;

import java.time.LocalDate;
import java.util.Locale;

public class OrganizationContact extends Contact {
    private String orgName;
    private String address;

    public OrganizationContact(String orgName, String address, String number) {
        super(number);
        this.orgName = orgName;
        this.address = address;
        this.setPerson(false);
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return orgName;
    }

    @Override
    public String info() {
        return String.format("Organization name: %s\n" +
                "Address: %s\n" +
                "Number: %s\n" +
                "Time created: %s\n" +
                "Time last edit: %s", orgName, address, getNumber(), creationTime.withSecond(0).withNano(0), lastEditTime.withSecond(0).withNano(0));
    }

    @Override
    public String getFields() {
        return "(name, address, number)";
    }

    @Override
    public String getContactString() {
        return (this.orgName + " " + this.address + " " + this.number).toUpperCase(Locale.US);
    }

    @Override
    public boolean setField(String field, String value) {
        switch (field) {
            case "name":
                this.setOrgName(value);
                return true;
            case "address":
                this.setAddress(value);
                return true;
            case "number":
                this.setNumber(value);
                return true;
            default:
                return false;
        }
    }
}
