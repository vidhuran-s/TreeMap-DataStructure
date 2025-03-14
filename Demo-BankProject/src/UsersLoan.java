public class UsersLoan {
    static VTree<Long, Long> loans = new VTree<>();
    static VTree<Long, Boolean> haveLoans = new VTree<>();
    static VTree<Long, String> loanNameTree = new VTree<>();
    static VTree<Long, Integer> loanAmountTree = new VTree<>();
    static VTree<Long, Integer> dueAmountTree = new VTree<>();
    static VTree<Long, String> loanStartDateTree = new VTree<>();
    static VTree<Long, String> loanEndDateTree = new VTree<>();

    static Long[] userIds = {1736862250415L, 1736862250416L, 1736862250418L, 1736862250419L, 1736862250420L, 1736862250421L, 1736862250422L, 1736862250423L, 1736862250424L, 1736862250425L, 1736862250426L, 1736862250427L, 1736862250428L, 1736862250430L, 1736862250431L, 1736862250432L, 1736862250433L, 1736862250434L, 1736862250435L, 1736862250436L, 1736862250437L, 1736862250438L, 1736862250439L, 1736862250440L, 1736862250441L};
    static Long[] loanIds = {1736881372294L, 1736881372295L, 1736881372296L, 1736881372297L, 1736881372298L, 1736881372299L, 1736881372300L, 1736881372301L, 1736881372302L, 1736881372303L, 1736881372305L, 1736881372306L, 1736881372307L, 1736881372308L, 1736881372309L, 1736881372310L, 1736881372311L, 1736881372312L, 1736881372313L, 1736881372314L, 1736881372315L, 1736881372316L, 1736881372317L, 1736881372318L, 1736881372320L};
    static Boolean[] haveLoan = {true, false, true, false, true, true, true, false, true, true, false, true, true, true, false, true, true, true, true, false, true, true, true, false, true};
    static String[] loanNames = {"Home Loan", "Personal Loan", "Car Loan", "Gold Loan", "Business Loan", "Education Loan", "Personal Loan", "Car Loan", "Gold Loan", "Home Loan", "Business Loan", "Education Loan", "Personal Loan", "Gold Loan", "Home Loan", "Business Loan", "Car Loan", "Education Loan", "Gold Loan", "Personal Loan", "Business Loan", "Car Loan", "Home Loan", "Education Loan", "Personal Loan"};
    static Integer[] loanAmount = {5000000, 500000, 800000, 300000, 10000000, 1500000, 450000, 700000, 350000, 6200000, 12000000, 1800000, 400000, 280000, 5500000, 11500000, 750000, 2000000, 320000, 550000, 9800000, 880000, 6000000, 1900000, 500000};
    static Integer[] dueAmount = {20000, 4000, 8000, 2000, 120000, 20000, 2000, 4000, 3200, 24000, 100000, 12000, 2800, 1600, 32000, 60000, 4000, 16000, 2400, 3200, 80000, 6000, 36000, 8000, 4000};
    static String[] loanStartDate = {"2020-06-10", "2021-08-15", "2022-04-22", "2020-12-05", "2021-02-01", "2021-09-20", "2020-11-17", "2021-02-10", "2020-07-25", "2022-05-12", "2021-10-09", "2022-02-03", "2021-06-14", "2020-09-30", "2021-12-05", "2020-08-18", "2021-05-27", "2022-03-14", "2020-01-01", "2021-07-21", "2022-01-08", "2021-04-03", "2022-09-19", "2020-10-07", "2021-01-14"};
    static String[] loanEndDate = {"2025-06-10", "2026-08-15", "2027-04-22", "2025-12-05", "2026-02-01", "2026-09-20", "2025-11-17", "2026-02-10", "2025-07-25", "2027-05-12", "2026-10-09", "2027-02-03", "2026-06-14", "2025-09-30", "2026-12-05", "2025-08-18", "2026-05-27", "2027-03-14", "2025-01-01", "2026-07-21", "2027-01-08", "2026-04-03", "2027-09-19", "2025-10-07", "2026-01-14"};
    static public void loadUserLoans() {
        loans.insertBulk(userIds, loanIds);
    }

    static public void loadHaveLoans() {
        haveLoans.insertBulk(userIds, haveLoan);
    }

    static public void loadLoanNames() {
        loanNameTree.insertBulk(userIds, loanNames);
    }

    static public void loadLoanAmount() {
        loanAmountTree.insertBulk(userIds, loanAmount);
    }

    static public void loadDueAmount() {
        dueAmountTree.insertBulk(userIds, dueAmount);
    }

    static public void loadLoanStartDate() {
        loanStartDateTree.insertBulk(userIds, loanStartDate);
    }

    static public void loadLoanEnddate() {
        loanEndDateTree.insertBulk(userIds, loanEndDate);
    }

    static public boolean foundUserLoan(long userId) {
        loadHaveLoans();
        loadUserLoans();
        boolean contain = haveLoans.contain(userId);
        if (contain) {
            VEntry<Long, Boolean> haveLoanDetails = haveLoans.get(userId);
            if (haveLoanDetails.getValue()) {
//                UserMenuDetails.LoanMenu();
                return true;
            }
            else {
                UserDetails.loadUserNames();
                VEntry<Long, String> userNameDetails = UserDetails.users.get(userId);
                System.out.println(userNameDetails.value + " doesn't have any loans");
                return false;
            }
        }
        else {
            System.out.println("No user found");
            return false;
        }
    }

    static public void foundLoanName(long userId) {
        loadLoanNames();
        VEntry<Long, String> loanNameEntries = loanNameTree.get(userId);
        System.out.println("Loan Category - " + loanNameEntries.getValue());
    }

    static public void foundLoanAmount(long userId) {
        loadLoanAmount();
        VEntry<Long, Integer> loanAmountEntries = loanAmountTree.get(userId);
        System.out.println("Loan Amount - " + loanAmountEntries.getValue());
    }

    static public void foundDueAmount(long userId) {
        loadDueAmount();
        VEntry<Long, Integer> dueAmountEntries = dueAmountTree.get(userId);
        System.out.println("Due Amount - " + dueAmountEntries.getValue());
    }

    static public void foundLoanStartDate(long userId) {
        loadLoanStartDate();
        VEntry<Long, String> loanStartDateEntries = loanStartDateTree.get(userId);
        System.out.println("Loan Start Date - " + loanStartDateEntries.getValue());
    }

    static public void foundLoanEndDate(long userId) {
        loadLoanEnddate();
        VEntry<Long, String> loanEndDateEntries = loanEndDateTree.get(userId);
        System.out.println("Loan End Date - " + loanEndDateEntries.getValue());
    }

    static public void foundCompleteLoanInfo(long userId) {
        System.out.println("\nComplete Loan Information\n");
        UserDetails.foundName(userId);
        foundLoanName(userId);
        foundLoanAmount(userId);
        foundDueAmount(userId);
        foundLoanStartDate(userId);
        foundLoanEndDate(userId);
        System.out.println("\n");
    }



}
