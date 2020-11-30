public class PersonalData{
    private String name;
    private String address;
    private String NIP;
    private String bankAccountNumber;


    public PersonalData(){
        this("untitled", "untitled", "0000000000", "00000000000000000000000000");
    }
    public PersonalData(String name, String address, String NIP, String bankAccountNumber) {
        if(NIP.length() == 10 && bankAccountNumber.length() == 26 && isOnlyDigits(NIP) && isOnlyDigits(bankAccountNumber)) {
            this.name = name;
            this.address = address;
            this.NIP = NIP;
            this.bankAccountNumber = bankAccountNumber;
        }
    }
    public PersonalData(PersonalData data) {
        this.name = data.getName();
        this.address = data.getAddress();
        this.NIP = data.getNIP();
        this.bankAccountNumber = data.getBankAccountNumber();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNIP() {
        return NIP;
    }

    public void setNIP(String NIP) {
        if(NIP.length() == 10 && isOnlyDigits(NIP)) {
            this.NIP = NIP;
        }
    }

    public String getBankAccountNumber() {
        return bankAccountNumber;
    }

    public void setBankAccountNumber(String bankAccountNumber) {
        if(bankAccountNumber.length() == 26 && isOnlyDigits(bankAccountNumber)) {
            this.bankAccountNumber = bankAccountNumber;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    private boolean isOnlyDigits(String data){
        if (data.matches("[0-9]+")){
            return true;
        } else {
            return false;
        }
    }
}
