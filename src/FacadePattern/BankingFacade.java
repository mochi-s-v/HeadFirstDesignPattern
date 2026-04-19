package FacadePattern;

class BankingFacade {
    private AccountService accountService;
    private NotificationService notificationService;
    private BillPaymentService billPaymentService;

    public BankingFacade() {
        this.accountService = new AccountService();
        this.notificationService = new NotificationService();
        this.billPaymentService = new BillPaymentService();
    }

    public void payBill(String accountId, String billId, double amount) {
        accountService.getAccountDetails(accountId);
        billPaymentService.payBill(accountId, billId, amount);
        notificationService.sendNotifications(accountId, amount, billId);
    }
}