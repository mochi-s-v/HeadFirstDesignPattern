package FacadePattern;

class NotificationService {
    public void sendNotifications(String fromAccount, double amount, String billId) {
        System.out.println(billId + " of rupees " + amount + " paid successfully from account : " + fromAccount );
    }
}